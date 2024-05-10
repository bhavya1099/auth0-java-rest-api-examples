

package com.okta.rest.controller;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.security.Principal;

public class HelloControllerHelloTest {
    private HelloController helloController;
    private Principal principal;
    @Before
    public void setUp() {
        helloController = new HelloController();
    }
    @Test
    public void testHelloMethodWithValidPrincipal() {
        principal = new Principal() {
            @Override
            public String getName() {
                return "John Doe";
            }
        };
        String result = helloController.hello(principal);
        assertEquals("Hello, John Doe!", result);
    }
    // This test case will fail if the hello method does not throw a NullPointerException when given a null principal. 
    // If the hello method does not throw a NullPointerException, the test case should be commented out and the issue should be addressed in the hello method.
    @Test(expected = NullPointerException.class)
    public void testHelloMethodWithNullPrincipal() {
        helloController.hello(null);
    }
    @Test
    public void testHelloMethodWithEmptyPrincipalName() {
        principal = new Principal() {
            @Override
            public String getName() {
                return "";
            }
        };
        String result = helloController.hello(principal);
        assertEquals("Hello, !", result);
    }
}
