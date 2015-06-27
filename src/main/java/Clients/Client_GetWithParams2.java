package Clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class Client_GetWithParams2 extends baseclass {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        Response response =client
                .target(PATH)
                .path("getWithParams/id/12")
                .request()
                .get();

        System.out.println("STATUS:"+response.getStatus());
        System.out.println("RESPONSE:"+response.readEntity(String.class));
    }
}
