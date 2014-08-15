package no.web.rest.jersey;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/hello")
public class RestApp {

    @GET
    @Path("/{parameter}")
    public Response responseMsg( @PathParam("parameter") String parameter, @DefaultValue("..") @QueryParam("value") String value) {
        String output = "Thou shall not pass. Best regards from " + parameter + "." + value;
        return Response.status(200).entity(output).build();
    }
}