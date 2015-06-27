package Clients;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Client_Post extends baseclass{

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();

        Response response = client
                .target(PATH)
                .path("post/one")
                .request()
                .post(Entity.entity("my post here", MediaType.TEXT_PLAIN_TYPE));
        System.out.println("Status:"+response.getStatus());
        System.out.println("Response:"+response.readEntity(String.class));
    }

}
