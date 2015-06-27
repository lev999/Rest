package home;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

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
    public String allParams(@Context UriInfo info,@Context HttpHeaders headers){

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


        stringBuilder.append("\nHeaders:\n");
        MultivaluedMap<String,String> headersMap = headers.getRequestHeaders();
        for (String key : headersMap.keySet()) {
            stringBuilder.append("key="+key+" value="+headersMap.get(key)+"\n");
        }

        return stringBuilder.toString();
    }

    @Path("/arrayList")
    @GET
    public String getArray(@DefaultValue("no value")@QueryParam("Array")List<String> arrayList){
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i <arrayList.size(); i++) {
            stringBuilder.append(arrayList.get(i));
        }

        return stringBuilder.toString();
    }

}