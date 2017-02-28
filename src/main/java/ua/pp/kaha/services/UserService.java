package ua.pp.kaha.services;

import ua.pp.kaha.domain.Credentials;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by skokhanenko on 23.02.2017.
 */

@Path("/register")
public class UserService {
    @POST
    @Produces("application/json")
    @Consumes("application/json")
    public Response registerUser(Credentials credentials) {
        return null;
    }
}
