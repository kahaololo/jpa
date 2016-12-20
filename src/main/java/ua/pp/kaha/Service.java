package ua.pp.kaha;

import ua.pp.kaha.model.Measurement;
import ua.pp.kaha.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by skokhanenko on 17.11.2016.
 */
@Path ("/")
@Produces(MediaType.APPLICATION_JSON)
public class Service {

    @GET
    @Path("/users/{userId}")
    public Response getMsg(@PathParam("userId") int userId) throws Exception {
        EntityManager em = EMFListener.createEntityManager();

        User user = null;
        try {
            user = em.find(User.class, userId);
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        em.close();

        return Response.status(200).entity(user).build();
    }

    @POST
    @Path("/measurements")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> updateMeasurements(Measurement measurement) {
        Map<String,String> rs = new HashMap<String, String>();
        EntityManager em = EMFListener.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.merge(measurement);
            tx.commit();
            rs.put("status", "ok");
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            rs.put("errMsg", e.toString());
        }

        em.close();
        return rs;
    }

    @PUT
    @Path("/measurements")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> addMeasurements(Measurement newMeasurement) {
        Map<String, String> rs = new HashMap<String,String>();

        EntityManager em = EMFListener.createEntityManager();
        Measurement measurement = em.find(Measurement.class, newMeasurement.getMeasurementId());

        if (measurement == null) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();

            try {
                em.persist(newMeasurement);
                tx.commit();
                rs.put("status", "ok");
            } catch (Exception e) {
                e.printStackTrace();
                tx.rollback();
                rs.put("errMsg", "fail during transaction");
            }

        } else {
            rs.put("errMsg", "measurement already exists");
        }

        em.close();
        return rs;
    }

    @DELETE
    @Path("/measurements")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> deleteMeasurements(Measurement newMeasurement) {
        Map<String,String> rs = new HashMap<String,String>();

        EntityManager em = EMFListener.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            em.remove( em.contains(newMeasurement) ? newMeasurement : em.merge(newMeasurement) );
            tx.commit();
            rs.put("status", "ok");
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            rs.put("errMsg", "fail during transaction");
        }

        em.close();
        return rs;
    }
}
