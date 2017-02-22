package ua.pp.kaha.services;

import ua.pp.kaha.EMFListener;
import ua.pp.kaha.anotations.Secured;
import ua.pp.kaha.domain.Measurement;
import ua.pp.kaha.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.HashMap;
import java.util.Map;

//import ua.pp.kaha.anotations.Secured;

/**
 * Created by skokhanenko on 17.11.2016.
 */
@Path ("/service")
@Produces(MediaType.APPLICATION_JSON)
@Secured
public class MeasurementsService {

    @GET
    @Path("/measurements")
    public Response getMeasurements(@Context SecurityContext securityContext) throws Exception {
        String username = securityContext.getUserPrincipal().getName();
        User user = null;

        EntityManager em = EMFListener.createEntityManager();
        try {
            user = em.createQuery(User.class, username);
        } catch (NoResultException e) {
            e.printStackTrace();
        }

        em.close();

        return Response.status(200).entity(user).build();
    }

    @POST
    @Path("/measurement")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> updateMeasurement(Measurement measurement) {
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
    @Path("/measurement")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> addMeasurement(Measurement newMeasurement) {
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
    @Path("/measurement")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> deleteMeasurement(Measurement newMeasurement) {
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
