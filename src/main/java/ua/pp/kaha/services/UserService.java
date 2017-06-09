package ua.pp.kaha.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ua.pp.kaha.dao.UserDAO;
import ua.pp.kaha.exception.CustomValidationException;
import ua.pp.kaha.model.Credentials;
import ua.pp.kaha.model.Token;
import ua.pp.kaha.model.User;
import ua.pp.kaha.utils.CommonUtils;
import ua.pp.kaha.utils.TokenUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by kaha on 15.02.2017.
 */

@Component
@Path("/user")
public class UserService {

    @Autowired
    private Key key;

    @Autowired
    private UserDAO userDao;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/authenticate")
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Response authenticateUser(Credentials credentials) {

        try {
            // Authenticate the user using the credentials provided
            authenticate(credentials);

            Date   expiryDate = getExpiryDate(86400);
            String JWTString  = TokenUtil.getJWTString(credentials.getEmail(), expiryDate, key);
            Token  token      = new Token();
            token.setAuthToken(JWTString);
            token.setExpires(expiryDate);

            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    @Path("/register")
    @Transactional
    public Response registerNewUser(User user) throws CustomValidationException{
        validateNewUser(user);


        userDao.register(user);

        return Response.ok().build();
    }

    private void authenticate(Credentials credentials) throws Exception {
        if (credentials == null ||
                credentials.getEmail() == null ||
                credentials.getPassword() == null ||
                !areCredentialsValid(credentials))
            throw new Exception("Incorrect username or password");
    }

    private void validateNewUser(User user) throws CustomValidationException {
        if (user == null)
            throw new CustomValidationException("Validation error");
        if (user.getEmail() == null)
            throw new CustomValidationException("Email could not be empty");
        if (user.getPassword() == null)
            throw new CustomValidationException("Password could not be empty");
        if (user.getName() == null)
            throw new CustomValidationException("UserName could not be empty");
        if (userDao.getUserByEmail(user.getEmail()) != null)
            throw new CustomValidationException("Email already exists");
    }

    private Date getExpiryDate(int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }


    private boolean areCredentialsValid(Credentials credentials) {
        User user = userDao.getUserByEmail(credentials.getEmail());
        return user != null && user.getPassword().equals(CommonUtils.getSHA256String(credentials.getPassword()));
    }

}

