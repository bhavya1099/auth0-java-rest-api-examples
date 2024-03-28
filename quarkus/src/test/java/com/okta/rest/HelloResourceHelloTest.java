package com.okta.rest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;

import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class HelloResourceHelloTest {

    @Mock
    private SecurityContext securityContext;

    @Mock
    private Principal principal;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testHelloWithValidUserPrincipal() {
        // Arrange
        String expectedGreeting = "Hello, John!";
        when(securityContext.getUserPrincipal()).thenReturn(principal);
        when(principal.getName()).thenReturn("John");

        // Act
        String actualGreeting = hello(securityContext);

        // Assert
        assertEquals(expectedGreeting, actualGreeting);
    }

    @Test
    public void testHelloWithNoUserPrincipal() {
        // Arrange
        when(securityContext.getUserPrincipal()).thenReturn(null);

        // Act and Assert
        assertThrows(NullPointerException.class, () -> hello(securityContext));
    }

    @Test
    public void testHelloWithEmptyUserName() {
        // Arrange
        String expectedGreeting = "Hello, !";
        when(securityContext.getUserPrincipal()).thenReturn(principal);
        when(principal.getName()).thenReturn("");

        // Act
        String actualGreeting = hello(securityContext);

        // Assert
        assertEquals(expectedGreeting, actualGreeting);
    }

    public String hello(SecurityContext context) {
        Principal userPrincipal = context.getUserPrincipal();
        return "Hello, " + userPrincipal.getName() + "!";
    }
}
