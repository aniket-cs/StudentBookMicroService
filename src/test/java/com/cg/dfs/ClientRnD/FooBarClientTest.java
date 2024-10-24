package com.cg.dfs.ClientRnD;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.header.InBoundHeaders;
import com.sun.jersey.core.spi.component.ProviderServices;
import com.sun.jersey.core.spi.factory.MessageBodyFactory;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import com.sun.jersey.spi.MessageBodyWorkers;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import javax.ws.rs.core.*;

public class FooBarClientTest {

    @InjectMocks
    private FooBarClient fooBarClient;

    @Mock
    private Client mockClient;

    @Mock
    private WebResource mockWebResource;

//    @Mock
//    private ClientResponse mockClientResponse;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Success Test Case: Simulate HTTP 200 response and check the content
    @Test
    public void testGetFooBarData_Success() {

        // Mock the successful response
        int statusCode = 200;

//        MultivaluedMap<String,String> headersMap = new MultivaluedMapImpl();
//        headersMap.putSingle("Content-Type", MediaType.APPLICATION_JSON);
        InBoundHeaders inBoundHeaders = new InBoundHeaders();
        inBoundHeaders.add("Content-Type", MediaType.APPLICATION_JSON);

        MessageBodyWorkers messageBodyWorkers = mock(MessageBodyWorkers.class);

        String mockResponseBody = "{\"login\": \"capgemini\", \"id\": 1967}";
        InputStream entityStream = new ByteArrayInputStream(mockResponseBody.getBytes(StandardCharsets.UTF_8));

        ClientResponse clientResponse = new ClientResponse(
                statusCode,
                inBoundHeaders,
                entityStream,
                messageBodyWorkers);

        when(mockClient.resource(anyString())).thenReturn(mockWebResource);
        when(mockWebResource.get(ClientResponse.class)).thenReturn(clientResponse);
//        when(mockClientResponse.getStatus()).thenReturn(200); // Simulate success status
//        when(mockClientResponse.getEntity(String.class)).thenReturn("{\"login\":\"capgemini\",\"id\":1967}");

        // Call the method under test
        ClientResponse result = fooBarClient.getFooBarData();

        // Assert the result contains expected data
        assertNotNull(result);
//        assertTrue(result.contains("\"login\":\"capgemini\""));
//        assertTrue(result.contains("\"id\":1967"));
    }

    // Failure Test Case: Simulate HTTP 500 and expect a RuntimeException
//    @Test(expected = RuntimeException.class)
//    public void testGetFooBarData_Failure() {
//
//        // Mock the failed response with HTTP status 500
//        when(mockClient.resource(anyString())).thenReturn(mockWebResource);
//        when(mockWebResource.get(ClientResponse.class)).thenReturn(mockClientResponse);
//        when(mockClientResponse.getStatus()).thenReturn(500);
//
//        // Call the method under test, which should throw a RuntimeException
//        fooBarClient.getFooBarData();
//    }
}
