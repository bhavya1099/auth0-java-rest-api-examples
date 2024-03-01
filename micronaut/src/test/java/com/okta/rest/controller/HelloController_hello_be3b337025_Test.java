package com.okta.rest.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.security.Principal;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HelloController_hello_be3b337025_Test {

    @Mock
    private Principal principal;

    @Test
    public void testHello_withValidPrincipal() {
        when(principal.getName()).thenReturn("John");

        String result = new HelloController().hello(principal);

        assertEquals("Hello, John!", result);
    }

    @Test
    public void testHello_withNullPrincipal() {
        assertThrows(NullPointerException.class, () -> {
            new HelloController().hello(null);
        });
    }

    @Test
    public void testHello_withNullPrincipalName() {
        when(principal.getName()).thenReturn(null);

        String result = new HelloController().hello(principal);

        assertEquals("Hello, null!", result);
    }

    @Test
    public void testHello_withEmptyPrincipalName() {
        when(principal.getName()).thenReturn("");

        String result = new HelloController().hello(principal);

        assertEquals("Hello, !", result);
    }

    @Test
    public void testHello_withPrincipalNameSpecialCharacters() {
        when(principal.getName()).thenReturn("@#$%");

        String result = new HelloController().hello(principal);

        assertEquals("Hello, @#$%!", result);
    }

    @Test
    public void testHello_withPrincipalNameWhitespace() {
        when(principal.getName()).thenReturn(" ");

        String result = new HelloController().hello(principal);

        assertEquals("Hello, !", result);
    }

    @Test
    public void testHello_withPrincipalNameLong() {
        when(principal.getName()).thenReturn("thisisaveryverylongname");

        String result = new HelloController().hello(principal);

        assertEquals("Hello, thisisaveryverylongname!", result);
    }

    // TODO: Implement a security test scenario when the security dependency is added
}
