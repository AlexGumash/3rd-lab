package restServices;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/authtest")
public class AuthTestRestService extends RestService {

    @GET
    @Path("/test")
    public Response test(@HeaderParam("authorization") String authString) {
        if(!isUserAuthenticated(authString)){
            return Response.status(401).build();
        }
        return Response.status(200).build();
    }
}

