package com.cg.dfs.ClientRnD;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class FooBarClientTest {

    @InjectMocks
    private FooBarClient fooBarClient;

    @Mock
    private Client mockClient;

    @Mock
    private WebResource mockWebResource;

    @Mock
    private ClientResponse mockClientResponse;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Success Test Case: Simulate HTTP 200 response and check the content
    @Test
    public void testGetFooBarData_Success() {
        // Mock the successful response
        when(mockClient.resource(anyString())).thenReturn(mockWebResource);
        when(mockWebResource.get(ClientResponse.class)).thenReturn(mockClientResponse);
        when(mockClientResponse.getStatus()).thenReturn(200); // Simulate success status
        when(mockClientResponse.getEntity(String.class)).thenReturn("{\"login\":\"capgemini\",\"id\":1967}");

        // Call the method under test
        String result = fooBarClient.getFooBarData();

        // Assert the result contains expected data
        assertNotNull(result);
        assertTrue(result.contains("\"login\":\"capgemini\""));
        assertTrue(result.contains("\"id\":1967"));
    }

    // Failure Test Case: Simulate HTTP 500 and expect a RuntimeException
    @Test(expected = RuntimeException.class)
    public void testGetFooBarData_Failure() {

        // Mock the failed response with HTTP status 500
        when(mockClient.resource(anyString())).thenReturn(mockWebResource);
        when(mockWebResource.get(ClientResponse.class)).thenReturn(mockClientResponse);
        when(mockClientResponse.getStatus()).thenReturn(500);

        // Call the method under test, which should throw a RuntimeException
        fooBarClient.getFooBarData();
    }
}
