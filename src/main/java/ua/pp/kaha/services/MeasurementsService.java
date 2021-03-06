package ua.pp.kaha.services;

import ua.pp.kaha.anotations.Secured;
import ua.pp.kaha.domain.Measurement;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import ua.pp.kaha.anotations.Secured;

/**
 * Created by skokhanenko on 17.11.2016.
 */
@Path ("/service")
@Produces(MediaType.APPLICATION_JSON)
@Secured
public class MeasurementsService {
//    @Autowired
//    IMeasurementDAO measurementDAO;

//    @Autowired
//    IMeasurementDAO measurementDAO;

    @GET
    @Path("/measurements")
    public Response getMeasurements(@Context SecurityContext securityContext) throws Exception {
        String username = securityContext.getUserPrincipal().getName();
        List<Measurement> measurements = new ArrayList<>();//measurementDAO.getUserMeasurements(username);

        return Response.status(200).entity(measurements).build();
    }

    @POST
    @Path("/measurement")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> updateMeasurement(Measurement measurement) {
        Map<String,String> rs = new HashMap<String, String>();

        return rs;
    }

    @PUT
    @Path("/measurement")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> addMeasurement(Measurement newMeasurement) {
        Map<String, String> rs = new HashMap<String,String>();

        return rs;
    }

    @DELETE
    @Path("/measurement")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String,String> deleteMeasurement(Measurement newMeasurement) {
        Map<String,String> rs = new HashMap<String,String>();

        return rs;
    }

}
