package ua.pp.kaha;

import ua.pp.kaha.model.Measurement;
import ua.pp.kaha.model.User;

import javax.persistence.*;
import javax.transaction.Transaction;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.*;

/**
 * Created by skokhanenko on 17.11.2016.
 */
@Path ("/")
public class Service {

    @GET
    @Path("/{user}/measurements")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@PathParam("user") String userName) throws Exception {
        List<Measurement> measurements = new ArrayList<Measurement>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();

        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name = :name", User.class);
        query.setParameter("name", userName);

        User user;
        try {
            user = query.getSingleResult();
            measurements = user.getMeasurements();
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        em.close();
        emf.close();

        return Response.status(200).entity(measurements).build();
    }

    @GET
    @Path("/put/measurement")
    @Produces(MediaType.APPLICATION_JSON)
    public Response putMeasurment() {
        Map<String, String> rs = new HashMap<String, String>();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-test");
        EntityManager em = emf.createEntityManager();



        User user = em.find(User.class, 0);
        user.addMeasurment(new Date(), 1,2);

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(user);
        tx.commit();

        em.close();
        emf.close();

        rs.put("result", "200");

        return Response.status(200).entity(rs).build();
    }
}
