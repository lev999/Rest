package Clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class Client_GetWithParams extends baseclass {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        Response response =client
                .target(PATH)
                .path("getWithParams")
                .queryParam("name","Vasia")
                .queryParam("lastName","Pupkin")
                .request()
                .get();

//                .post(javax.ws.rs.client.Entity.entity("My POSTing text", MediaType.TEXT_PLAIN_TYPE));
        System.out.println("STATUS:"+response.getStatus());
        System.out.println("RESPONSE:"+response.readEntity(String.class));
    }
}
