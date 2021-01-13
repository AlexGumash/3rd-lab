package restServices;

import models.Evcourse;
import services.EvcourseService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

//@RolesAllowed("ADMIN")
@Path("/evcourse")
public class EvcourseRestService extends RestService {
    EvcourseService evcourseService = null;

    public EvcourseRestService() {
        this.evcourseService = new EvcourseService();
    }

    @GET
    @Path("/{id}")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getEvcourse(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).entity(evcourseService.findEvcourse(id)).build();
    }

    @GET
    @Path("/all")
    @Produces({ MediaType.APPLICATION_JSON,  MediaType.APPLICATION_XML} )
    public Response getEvcourse(@HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response
                .status(200)
                .entity(evcourseService.findAllEvcourses())
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateEvcourse(
            @PathParam("id") int id,
            @QueryParam("code") String code,
            @QueryParam("name") String name,
            @QueryParam("shortName") String shortName,
            @QueryParam("version") String version,
            @QueryParam("duration") int duration,
            @QueryParam("price") int price,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Evcourse course = evcourseService.findEvcourse(id);
        course.setCode(code);
        course.setName(name);
        course.setShortName(shortName);
        course.setVersion(version);
        course.setDuration(duration);
        course.setPrice(price);
        evcourseService.updateEvcourse(course);
        return Response.status(200).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteEvcourse(@PathParam("id") int id, @HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Evcourse course = evcourseService.findEvcourse(id);
        evcourseService.deleteEvcourse(course);
        return Response.status(200).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response postEvcourse(
            @FormParam("code") String code,
            @FormParam("name") String name,
            @FormParam("shortName") String shortName,
            @FormParam("version") String version,
            @FormParam("duration") int duration,
            @FormParam("price") int price,
            @HeaderParam("authorization") String authString
    ) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        Evcourse course = new Evcourse(code, name, shortName, version, duration, price);
        evcourseService.saveEvcourse(course);
        return Response.status(200).build();
    }
}
