package restServices;

import models.Evclass;
import services.EvclassService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

//@RolesAllowed("ADMIN")
@Path("/evclass")
public class EvclassRestService extends RestService {
    EvclassService evclassService = null;

    public EvclassRestService() {
        this.evclassService = new EvclassService();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getEvclass(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(evclassService.findEvclass(id)).build();
    }

    @GET
    @Path("/all")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getEvclass(@HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(evclassService.findAllEvclasses()).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEvclass(
            @PathParam("id") int id,
            @QueryParam("evcourseId") int evcourseId,
            @QueryParam("dateBegin") long dateBegin,
            @QueryParam("dateEnd") long dateEnd,
            @QueryParam("price") int price,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Evclass evclass = evclassService.findEvclass(id);
        evclass.setEvcourseId(evcourseId);

        Date newDateBegin = new Date(dateBegin);
        Date newDateEnd = new Date(dateEnd);

        evclass.setDateBegin(newDateBegin);
        evclass.setDateEnd(newDateEnd);
        evclass.setPrice(price);
        evclassService.updateEvclass(evclass);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvclass(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Evclass evclass = evclassService.findEvclass(id);
        evclassService.deleteEvclass(evclass);
        return Response.status(200).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postEvclass(
            @FormParam("evcourseId") int evcourseId,
            @FormParam("dateBegin") long dateBegin,
            @FormParam("dateEnd") long dateEnd,
            @FormParam("price") int price,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Date newDateBegin = new Date(dateBegin);
        Date newDateEnd = new Date(dateEnd);
        Evclass evclass = new Evclass(evcourseId, newDateBegin, newDateEnd, price);
        evclassService.saveEvclass(evclass);
        return Response.status(200).build();
    }
}
