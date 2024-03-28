package com.okta.rest;

import jakarta.ws.rs.core.SecurityContext;
import java.security.Principal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HelloResourceHelloTest {

    @Mock 
    private SecurityContext securityContext;
    @Mock 
    private Principal principal;

    @Test
    public void testHelloWithValidUserPrincipal() {
        // Arrange
        String mockPrincipalName = "testUser";
        when(securityContext.getUserPrincipal()).thenReturn(principal);
        when(principal.getName()).thenReturn(mockPrincipalName);

        // Act
        String result = hello(securityContext);

        // Assert
        assertEquals("Hello, " + mockPrincipalName + "!", result);
    }

    @Test
    public void testHelloWithNullUserPrincipal() {
        // Arrange
        when(securityContext.getUserPrincipal()).thenReturn(null);

        // Act & Assert
        assertThrows(NullPointerException.class, () -> hello(securityContext));
    }

    @Test
    public void testHelloWithNullSecurityContext() {
        // Act & Assert
        assertThrows(NullPointerException.class, () -> hello(null));
    }

    public String hello(SecurityContext context) {
        Principal userPrincipal = context.getUserPrincipal();
        return "Hello, " + userPrincipal.getName() + "!";
    }
}
