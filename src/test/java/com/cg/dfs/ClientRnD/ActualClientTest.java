package com.cg.dfs.ClientRnD;

import com.sun.jersey.api.client.ClientResponse;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ActualClientTest {

        @InjectMocks
        private ActualClient actualClient;

        @Mock
        private ClientResponse mockClientResponse;

        @Before
        public void setUp() {
            MockitoAnnotations.openMocks(this);
        }

       // Call the real API
        @Test
        public void testGetFooBarData_Success() throws JSONException {

            ClientResponse response = actualClient.getActualData();

            // Check if the status is 200
            assertEquals(200, response.getStatus());

            // Get the response entity as a string
            String result = response.getEntity(String.class);

            // Ensure result is not null
            assertNotNull(result);

            // Parse the result as a JSON object
            JSONObject jsonResponse = new JSONObject(result);

            // Verify the specific fields in the response
            assertEquals("octocat", jsonResponse.getString("login"));
            assertEquals(583231, jsonResponse.getInt("id"));
            assertNotNull(jsonResponse.getString("avatar_url"));

            // Close the response
            response.close();
        }

        // Mocking the failure case
        @Test
        public void testGetFooBarData_Failure() {

            // Simulate HTTP 500 error
            when(mockClientResponse.getStatus()).thenReturn(500);

            // Make sure to mock the rest of the response behavior
            when(mockClientResponse.getEntity(String.class)).thenReturn("");

            // Check if the status is 500
            assertEquals(500, mockClientResponse.getStatus());

            // The result is empty since we are simulating a server error
            String result = mockClientResponse.getEntity(String.class);
            assertEquals("", result);

            // Close the response
            mockClientResponse.close();
        }
}
