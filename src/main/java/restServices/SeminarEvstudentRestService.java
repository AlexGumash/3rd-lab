package restServices;

import models.SeminarEvstudent;
import services.SeminarEvstudentService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Timestamp;
import java.util.List;

//@RolesAllowed("ADMIN")
@Path("/seminarEvstudent")
public class SeminarEvstudentRestService extends RestService {
    SeminarEvstudentService seminarEvstudentService = null;

    public SeminarEvstudentRestService() {
        this.seminarEvstudentService = new SeminarEvstudentService();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getSeminarEvstudent(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(seminarEvstudentService.findSeminarEvstudent(id)).build();
    }

    @GET
    @Path("/all")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getSeminarEvstudent(@HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(seminarEvstudentService.findAllSeminarEvstudents()).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateSeminarEvstudent(
            @PathParam("id") int id,
            @QueryParam("seminarId") int seminarId,
            @QueryParam("evstudentId") int evstudentId,
            @QueryParam("paymentState") String paymentState,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        SeminarEvstudent seminarStudent = seminarEvstudentService.findSeminarEvstudent(id);
        seminarStudent.setSeminarId(seminarId);
        seminarStudent.setEvstudentId(evstudentId);
        seminarStudent.setPaymentState(paymentState);
        seminarEvstudentService.updateSeminarEvstudent(seminarStudent);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvstudent(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        SeminarEvstudent seminarStudent = seminarEvstudentService.findSeminarEvstudent(id);
        seminarEvstudentService.deleteSeminarEvstudent(seminarStudent);
        return Response.status(200).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postSeminarEvstudent(
            @FormParam("seminarId") int seminarId,
            @FormParam("evstudentId") int evstudentId,
            @FormParam("paymentState") String paymentState,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        SeminarEvstudent seminarStudent = new SeminarEvstudent(seminarId, evstudentId, paymentState);
        seminarEvstudentService.saveSeminarEvstudent(seminarStudent);
        return Response.status(200).build();
    }
}

