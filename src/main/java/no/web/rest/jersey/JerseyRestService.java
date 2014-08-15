package no.web.rest.jersey;

import no.web.domain.Person;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json")
public class JerseyRestService {

    /**
     * REST Service to produce JSON output
     */
    @GET
    @Path("/produce/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person produceJSON( @PathParam("name") String name ) {

        Person person = new Person(name, "White", 99);
        return person;

    }

    /**
     * REST Service to consume JSON
     */
    @POST
    @Path("/consume")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response consumeJSON( Person person) {

        String output = person.toString();

        Response build = Response.status(200).entity(output).build();
        return build;
    }

}
