package ua.pp.kaha.services;

import org.springframework.beans.factory.annotation.Autowired;
import ua.pp.kaha.EMFListener;
import ua.pp.kaha.domain.Credentials;
import ua.pp.kaha.domain.Token;
import ua.pp.kaha.domain.User;
import ua.pp.kaha.utils.TokenUtil;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.security.Key;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by kaha on 15.02.2017.
 */

@Path("/authentication")
public class AuthenticationService {

    @Autowired
    Key key;

    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response authenticateUser(Credentials credentials) {

        try {
            // Authenticate the user using the credentials provided
            authenticate(credentials);

            Date expiryDate = getExpiryDate(86400);
            String JWTString = TokenUtil.getJWTString(credentials.getEmail(), expiryDate, key);
            Token token = new Token();
            token.setAuthToken(JWTString);
            token.setExpires(expiryDate);

            return Response.ok(token).build();
        } catch (Exception e) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getMessage()).build();
        }
    }

    private void authenticate(Credentials credentials) throws Exception {
        // Authenticate against a database, LDAP, file or whatever
        // Throw an Exception if the credentials are invalid
        if (credentials == null || credentials.getEmail() == null || credentials.getPassword() == null)
            throw new Exception("Incorrect username or password");
        EntityManager em = EMFListener.createEntityManager();

        try {
            Query query = em.createQuery("SELECT u FROM User u WHERE email = :email");
            query.setParameter("email", credentials.getEmail());
            User user = (User) query.getSingleResult();
            if (!credentials.getPassword().equals(user.getPassword()))
                throw new Exception("User or password is incorrect");
        } catch (NoResultException e) {
            e.printStackTrace();
            throw new Exception("User not found");
        } finally {
            em.close();
        }

    }

    private Date getExpiryDate(int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MINUTE, minutes);
        return calendar.getTime();
    }
}

