package home;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("getWithParams")
public class GetWithParams {

    @GET
    @Produces("text/plain")
    @Consumes("text/plain")
    public String getWithParams(@DefaultValue("nonName")@QueryParam("name") String name) {
        return "got name=" + name;
    }
}