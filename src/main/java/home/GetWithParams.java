package home;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("getWithParams")
public class GetWithParams {

    @DefaultValue("nonName")@QueryParam("lastName")
    String lastName;
    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    public String getWithParams(@DefaultValue("nonName")@QueryParam("name") String name) {
        return "got name=" + name+" last name="+lastName;
    }

    @Path("/id/{id}")
    @GET
    public String getId(@PathParam("id")int id){

        return "getId(): id="+id;

    }
}