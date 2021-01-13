package restServices;

import models.Seminar;
import services.SeminarService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Date;
import java.util.List;

//@RolesAllowed("ADMIN")
@Path("/seminar")
public class SeminarRestService extends RestService {
    SeminarService seminarService = null;

    public SeminarRestService() {
        this.seminarService = new SeminarService();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getSeminar(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(seminarService.findSeminar(id)).build();
    }

    @GET
    @Path("/all")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getSeminar(@HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response
                .status(200)
                .entity(seminarService.findAllSeminars())
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateSeminar(
            @PathParam("id") int id,
            @QueryParam("name") String name,
            @QueryParam("shortName") String shortName,
            @QueryParam("seminarDate") long seminarDate,
            @QueryParam("seminarTime") long seminarTime,
            @QueryParam("duration") int duration,
            @QueryParam("price") int price,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Seminar seminar = seminarService.findSeminar(id);
        seminar.setName(name);
        seminar.setShortName(shortName);

        Date newSeminarDate = new Date(seminarDate);
        Time newSeminarTime = new Time(seminarTime);

        seminar.setSeminarDate(newSeminarDate);
        seminar.setSeminarTime(newSeminarTime);
        seminar.setDuration(duration);
        seminar.setPrice(price);
        seminarService.updateSeminar(seminar);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteSeminar(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Seminar seminar = seminarService.findSeminar(id);
        seminarService.deleteSeminar(seminar);
        return Response.status(200).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postSeminar(
            @FormParam("name") String name,
            @FormParam("shortName") String shortName,
            @FormParam("seminarDate") long seminarDate,
            @FormParam("seminarTime") long seminarTime,
            @FormParam("duration") int duration,
            @FormParam("price") int price,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Date newSeminarDate = new Date(seminarDate);
        Time newSeminarTime = new Time(seminarTime);
        Seminar seminar = new Seminar(name, shortName, newSeminarDate, newSeminarTime, duration, price);
        seminarService.saveSeminar(seminar);
        return Response.status(200).build();
    }
}

