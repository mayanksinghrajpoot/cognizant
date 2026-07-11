package com.cognizant.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MyServiceTest {

    @Mock
    private ExternalApi mockApi;

    @InjectMocks
    private MyService service;

    @Test
    public void testExternalApi() {
        // Exercise 1: Mocking and Stubbing
        when(mockApi.getData()).thenReturn("Mock Data");

        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    @Test
    public void testVerifyInteraction() {
        // Exercise 2: Verifying Interactions
        service.fetchData();

        verify(mockApi).getData();
    }

    @Test
    public void testArgumentMatching() {
        // Exercise 3: Argument Matching
        when(mockApi.processData(anyString())).thenReturn("Matched Result");

        String result = service.getFormattedData("some random string");

        assertEquals("Processed: Matched Result", result);
        verify(mockApi).processData(eq("some random string"));
    }

    @Test
    public void testHandlingVoidMethods() {
        // Exercise 4: Handling Void Methods
        doNothing().when(mockApi).logAccess("Alice");

        service.logAccess("Alice");

        verify(mockApi).logAccess("Alice");
    }

    @Test
    public void testMockingMultipleReturns() {
        // Exercise 5: Mocking and Stubbing with Multiple Returns
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call");

        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
    }

    @Test
    public void testVerifyingInteractionOrder() {
        // Exercise 6: Verifying Interaction Order
        when(mockApi.getData()).thenReturn("Data");
        
        service.fetchData();
        service.logAccess("User");

        var inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).logAccess("User");
    }

    @Test
    public void testVoidMethodWithExceptions() {
        // Exercise 7: Handling Void Methods with Exceptions
        doThrow(new RuntimeException("DB Connection Failed")).when(mockApi).logAccess("BadUser");

        assertThrows(RuntimeException.class, () -> {
            service.logAccess("BadUser");
        });
    }
}
