package home;

import javassist.bytecode.analysis.MultiType;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by pc-users on 6/27/2015.
 */
@Path("post")
public class MyPostService {

    @POST
    @Path("/one")
    public String myPost(String mypost,@Context HttpHeaders headers){
        StringBuilder stringBuilder = new StringBuilder(mypost);
        MultivaluedMap<String,String> map = headers.getRequestHeaders();
        stringBuilder.append("Headers here:\n");
        for (String key : map.keySet()) {
            stringBuilder.append("key="+key+" value="+map.get(key)+"\n");
        }

        return stringBuilder.toString();
    }
}
