package com.cg.dfs.ClientRnD;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class FooBarClient {

    private static final String API_URL = "https://api.example.com/";
    private final Client client;

    // Constructor for dependency injection
    public FooBarClient(Client client) {
        this.client = client;
    }

    public ClientResponse getFooBarData() {
        WebResource webResource = client.resource(API_URL);
        ClientResponse response = webResource.get(ClientResponse.class);

        // If the status is 200, return the response entity
        if (response.getStatus() == 200) {
//            String result = response.getEntity(String.class);
//            response.close();
            return response;
        } else {
            // If the status is not 200, throw an exception
            response.close();
            throw new RuntimeException("Failed with HTTP error code: " + response.getStatus());
        }
    }
}



