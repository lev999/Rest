package Clients;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class Client_GetWithParams_ArrayList extends baseclass {
    public static void main(String[] args) {

        Client client = ClientBuilder.newClient();

        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        Response response =client
                .target(PATH)
                .path("getWithParams/arrayList")
                .queryParam("Array",list)
                .request()
                .get();

        System.out.println("STATUS:"+response.getStatus());
        System.out.println("RESPONSE:"+response.readEntity(String.class));
    }
}
