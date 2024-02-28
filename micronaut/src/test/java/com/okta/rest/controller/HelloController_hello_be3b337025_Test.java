// ********RoostGPT********
/*
Test generated by RoostGPT for test java-junit4-test using AI Type Open AI and AI Model gpt-4

1. Positive Scenario: Test with a valid Principal object. 
   - Create a Principal object with a valid name.
   - Call the hello function with the Principal object.
   - Verify that the returned string is "Hello, [Principal name]!".

2. Negative Scenario: Test with a null Principal object. 
   - Call the hello function with a null object.
   - Verify whether the function handles the null object properly or throws an appropriate exception.

3. Negative Scenario: Test with a Principal object having null name.
   - Create a Principal object with a null name.
   - Call the hello function with the Principal object.
   - Verify whether the function handles the null name properly or throws an appropriate exception.

4. Positive Scenario: Test with a Principal object having special characters in the name.
   - Create a Principal object with a name containing special characters.
   - Call the hello function with the Principal object.
   - Verify that the returned string is "Hello, [Principal name with special characters]!".

5. Positive Scenario: Test with a Principal object having numbers in the name.
   - Create a Principal object with a name containing numbers.
   - Call the hello function with the Principal object.
   - Verify that the returned string is "Hello, [Principal name with numbers]!".

6. Edge Scenario: Test with a Principal object having minimum possible name length.
   - Create a Principal object with a name of minimum possible length.
   - Call the hello function with the Principal object.
   - Verify that the returned string is "Hello, [Principal name]!".

7. Edge Scenario: Test with a Principal object having maximum possible name length.
   - Create a Principal object with a name of maximum possible length.
   - Call the hello function with the Principal object.
   - Verify that the returned string is "Hello, [Principal name]!".
*/

// ********RoostGPT********
package com.okta.rest.controller;

import org.junit.Before;
import org.junit.Test;
import java.security.Principal;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HelloController_hello_be3b337025_Test {
    private HelloController helloController;
    private Principal mockPrincipal;

    @Before
    public void setup() {
        helloController = new HelloController();
        mockPrincipal = mock(Principal.class);
    }

    @Test
    public void testHello_WithValidPrincipal() {
        when(mockPrincipal.getName()).thenReturn("John");
        String result = helloController.hello(mockPrincipal);
        assertEquals("Hello, John!", result);
    }

    @Test(expected = NullPointerException.class)
    public void testHello_WithNullPrincipal() {
        helloController.hello(null);
    }

    @Test(expected = NullPointerException.class)
    public void testHello_WithNullNamePrincipal() {
        when(mockPrincipal.getName()).thenReturn(null);
        helloController.hello(mockPrincipal);
    }

    @Test
    public void testHello_WithSpecialCharactersInName() {
        when(mockPrincipal.getName()).thenReturn("@John#");
        String result = helloController.hello(mockPrincipal);
        assertEquals("Hello, @John#!", result);
    }

    @Test
    public void testHello_WithNumbersInName() {
        when(mockPrincipal.getName()).thenReturn("John123");
        String result = helloController.hello(mockPrincipal);
        assertEquals("Hello, John123!", result);
    }

    @Test
    public void testHello_WithMinimumNameLength() {
        when(mockPrincipal.getName()).thenReturn("J");
        String result = helloController.hello(mockPrincipal);
        assertEquals("Hello, J!", result);
    }

    @Test
    public void testHello_WithMaximumNameLength() {
        String longName = new String(new char[100]).replace("\0", "J");
        when(mockPrincipal.getName()).thenReturn(longName);
        String result = helloController.hello(mockPrincipal);
        assertEquals("Hello, " + longName + "!", result);
    }
}
