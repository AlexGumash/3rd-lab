package restServices;

import models.EvclassEvstudent;
import services.EvclassEvstudentService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;
import java.sql.Time;

//@RolesAllowed("ADMIN")
@Path("/evclassEvstudent")
public class EvclassEvstudentRestService extends RestService {
    EvclassEvstudentService evclassEvstudentService = null;

    public EvclassEvstudentRestService() {
        this.evclassEvstudentService = new EvclassEvstudentService();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getEvclassEvstudent(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(evclassEvstudentService.findEvclassEvstudent(id)).build() ;
    }

    @GET
    @Path("/all")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getEvclassEvstudent(@HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(evclassEvstudentService.findAllEvclassEvstudents()).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEvclassEvstudent(
            @PathParam("id") int id,
            @QueryParam("evclassId") int evclassId,
            @QueryParam("evstudentId") int evstudentId,
            @QueryParam("consultationDate") long consultationDate,
            @QueryParam("consultationTime") long consultationTime,
            @QueryParam("paymentState") String paymentState,
            @QueryParam("contractState") String contractState,
            @QueryParam("status") String status,
            @QueryParam("comment") String comment,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        EvclassEvstudent classStudent = evclassEvstudentService.findEvclassEvstudent(id);
        classStudent.setEvclassId(evclassId);
        classStudent.setEvstudentId(evstudentId);

        Date newConsultationDate = new Date(consultationDate);
        Time newConsultationTime = new Time(consultationTime);
        classStudent.setConsultationDate(newConsultationDate);
        classStudent.setConsultationTime(newConsultationTime);

        classStudent.setPaymentState(paymentState);
        classStudent.setContractState(contractState);
        classStudent.setStatus(status);
        classStudent.setComment(comment);
        evclassEvstudentService.updateEvclassEvstudent(classStudent);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvstudent(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        EvclassEvstudent classStudent = evclassEvstudentService.findEvclassEvstudent(id);
        evclassEvstudentService.deleteEvclassEvstudent(classStudent);
        return Response.status(200).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postEvclassEvstudent(
            @FormParam("evclassId") int evclassId,
            @FormParam("evstudentId") int evstudentId,
            @FormParam("consultationDate") long consultationDate,
            @FormParam("consultationTime") long consultationTime,
            @FormParam("paymentState") String paymentState,
            @FormParam("contractState") String contractState,
            @FormParam("status") String status,
            @FormParam("comment") String comment,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Date newConsultationDate = new Date(consultationDate);
        Time newConsultationTime = new Time(consultationTime);
        EvclassEvstudent classStudent = new EvclassEvstudent(evclassId, evstudentId, newConsultationDate, newConsultationTime, paymentState, contractState, status, comment);
        evclassEvstudentService.saveEvclassEvstudent(classStudent);
        return Response.status(200).build();
    }
}
