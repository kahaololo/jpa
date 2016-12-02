package ua.pp.kaha;

import ua.pp.kaha.model.Measurement;
import ua.pp.kaha.model.User;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by skokhanenko on 17.11.2016.
 */
@Path ("/")
public class Service {

    @GET
    @Path("/measurements")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMsg(@QueryParam("user") String userName) throws Exception {
        List<Measurement> measurements = new ArrayList<Measurement>();
        EntityManager em = EMFListener.createEntityManager();

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

        return Response.status(200).entity(measurements).build();
    }

//    @GET
//    @Path("/put/measurement")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response putMeasurement() {
//        Map<String, String> rs = new HashMap<String, String>();
//
//        EntityManager em = EMFListener.createEntityManager();
//
//        User user = em.find(User.class, 1);
//        Query query = em.createQuery("SELECT max(m.measurementId.date) FROM Measurement m WHERE m.measurementId.userId = :userId");
//        query.setParameter("userId", user.getId());
//        Date maxDate = (Date) query.getSingleResult();
//        Date nextDate = new Date(maxDate.getTime() + (1000 * 60 * 60 * 24));
//        int weight = ThreadLocalRandom.current().nextInt(80, 100);
//        int waist = ThreadLocalRandom.current().nextInt(80, 90);
//        user.addMeasurment(nextDate, weight, waist);
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        em.merge(user);
//        tx.commit();
//
//        em.close();
//
//        rs.put("result", "200");
//
//        return Response.status(200).entity(rs).build();
//    }

    @POST
    @Path("/measurements")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public void addMeasurements(
            @FormParam("user") String user,
            @FormParam("measurement") Object measurement
    ) {


        Map<String, String> rs = new HashMap<String, String>();

//        EntityManager em = EMFListener.createEntityManager();
//
//        User user = em.find(User.class, 1);
//        Query query = em.createQuery("SELECT max(m.measurementId.date) FROM Measurement m WHERE m.measurementId.userId = :userId");
//        query.setParameter("userId", user.getId());
//        Date maxDate = (Date) query.getSingleResult();
//        Date nextDate = new Date(maxDate.getTime() + (1000 * 60 * 60 * 24));
//        int weight = ThreadLocalRandom.current().nextInt(80, 100);
//        int waist = ThreadLocalRandom.current().nextInt(80, 90);
//        user.addMeasurment(nextDate, weight, waist);
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//        em.merge(user);
//        tx.commit();
//
//        em.close();

    }
}
