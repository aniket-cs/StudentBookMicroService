package com.cg.dfs.ClientRnD;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ActualClient {

        private static final String API_URL = "https://api.github.com/users/octocat";

        public ClientResponse getActualData() {

            Client client = Client.create();
            WebResource webResource = client.resource(API_URL);
            return webResource.get(ClientResponse.class);
        }
}

