package com.okta.rest.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.security.Principal;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class HelloControllerHelloTest {

    @Mock
    private Principal mockPrincipal;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testHelloWithValidPrincipal() {
        // Arrange
        String expectedName = "John Doe";
        when(mockPrincipal.getName()).thenReturn(expectedName);

        // Act
        String result = hello(mockPrincipal);

        // Assert
        assertEquals("Hello, " + expectedName + "!", result);
    }

    @Test(expected = NullPointerException.class)
    public void testHelloWithNullPrincipal() {
        // Arrange
        Principal nullPrincipal = null;

        // Act
        String result = hello(nullPrincipal);
    }

    @Test
    public void testHelloWithNullPrincipalName() {
        // Arrange
        when(mockPrincipal.getName()).thenReturn(null);

        // Act
        String result = hello(mockPrincipal);

        // Assert
        assertEquals("Hello, null!", result);
    }
    
    public String hello(Principal principal) {
        return "Hello, " + principal.getName() + "!";
    }
}
