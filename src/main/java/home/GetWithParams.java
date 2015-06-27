package home;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

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

    @Path("/allData/{a}/{b}/{c}")
    @GET
    public String allParams(@Context UriInfo info){

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("\n Queryparams Map:\n");
        MultivaluedMap<String,String> queryMap = info.getQueryParameters();


        for (String key : queryMap.keySet()) {

            stringBuilder.append("key="+key);
            stringBuilder.append(" value=" + queryMap.get(key));
            stringBuilder.append("\n");

        }
        MultivaluedMap<String,String> pathParamMap = info.getPathParameters();
        stringBuilder.append("\nPath params map:\n");
        for (String key : pathParamMap.keySet()) {

            stringBuilder.append("key="+key);
            stringBuilder.append(" value=" + pathParamMap.get(key));
            stringBuilder.append("\n");
        }


        return stringBuilder.toString();
    }

}