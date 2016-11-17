package ua.pp.kaha;

import ua.pp.kaha.model.User;

import javax.persistence.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by skokhanenko on 17.11.2016.
 */
@Path ("/")
public class Service {

    @GET
    @Path("/{user}/measurements")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("user") String userName) {
        Map<String, String> rs = new HashMap();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1);

        rs.put("Jersey say", user.getName());

        em.close();
        emf.close();

        return Response.status(200).entity(rs).build();
    }


}
