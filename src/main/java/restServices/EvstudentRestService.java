package restServices;

import models.Evstudent;
import services.EvstudentService;

import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

//@RolesAllowed("ADMIN")
@Path("/evstudent")
public class EvstudentRestService extends RestService {
    EvstudentService evstudentService = null;

    public EvstudentRestService() {
        this.evstudentService = new EvstudentService();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getEvstudent(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(evstudentService.findEvstudent(id)).build();
    }

    @GET
    @Path("/all")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getEvstudent(@HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response
                .status(200)
                .entity(evstudentService.findAllEvstudents())
                .build();
//        return evstudentService.findAllEvstudents();
    }

    @PUT
    @Path("/{id}")
    public Response updateEvstudent(
            @PathParam("id") int id,
            @QueryParam("name") String name,
            @QueryParam("surname") String surname,
            @QueryParam("patronymic") String patronymic,
            @QueryParam("phone") String phone,
            @QueryParam("email") String email,
            @QueryParam("source") String source,
            @QueryParam("sendMails") Boolean sendMails,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Evstudent student = evstudentService.findEvstudent(id);
        student.setName(name);
        student.setSurname(surname);
        student.setPatronymic(patronymic);
        student.setPhone(phone);
        student.setEmail(email);
        student.setSource(source);
        student.setSendMails(sendMails);
        evstudentService.updateEvstudent(student);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvstudent(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Evstudent student = evstudentService.findEvstudent(id);
        evstudentService.deleteEvstudent(student);
        return Response.status(200).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postEvstudent(
            @FormParam("name") String name,
            @FormParam("surname") String surname,
            @FormParam("patronymic") String patronymic,
            @FormParam("phone") String phone,
            @FormParam("email") String email,
            @FormParam("source") String source,
            @FormParam("sendMails") Boolean sendMails,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Evstudent student = new Evstudent(name, surname, patronymic, phone, email, source, sendMails);
        evstudentService.saveEvstudent(student);
        return Response.status(200).build();
    }

}
