package no.web.client;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import no.web.domain.Person;

public class MyClient {

    final static String REST_ENDPOINT = "http://localhost:8080/webapp/rest/json/consume";

    public static void main(String[] args) {
        Person person = new Person("Gandalf", "White", 123);
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        com.sun.jersey.api.client.Client client = com.sun.jersey.api.client.Client.create(clientConfig);


        WebResource webResource = client.resource(REST_ENDPOINT);
        ClientResponse response = webResource.accept("application/json").type("application/json").post(ClientResponse.class, person);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Something went wrong. Response status is " + response.getStatus());
        }

        String output = response.getEntity(String.class);
        System.out.println("Server response:\n");
        System.out.println(output);
    }
}