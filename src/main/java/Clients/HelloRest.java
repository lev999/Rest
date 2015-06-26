package Clients;

import baseClass.BaseClass;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class HelloRest extends BaseClass{

    public static void main(String[] args) {
        getResponse();
    }

    public static int getResponse(){
        Client client = ClientBuilder.newClient();
        Response response =client
                .target(PATH)
                .path("helloRest")
                .request()
                .get();

        System.out.println("STATUS:"+response.getStatus());;
        System.out.println("Entity:"+response.readEntity(String.class));;

        return response.getStatus();
    }


}
