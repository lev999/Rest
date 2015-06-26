package firstClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class FirstClient {

    public static void main(String[] args) {
        getResponse();
    }

    public static int getResponse(){
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080").path("helloRest");
        Response response =target.request().get();
        System.out.println("STATUS:"+response.getStatus());;
        System.out.println("Entity:"+response.readEntity(String.class));;

        return response.getStatus();
    }


}
