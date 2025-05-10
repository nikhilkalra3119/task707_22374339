package web.service;

import static org.junit.Assert.*;
import org.junit.Test;

public class LoginServiceTest {

    @Test
    public void testValidLogin() {
        assertTrue(LoginService.login("nikhil", "nikhil_pass", "1998-11-19"));
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(LoginService.login("invalid", "nikhil_pass", "1998-11-19"));
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(LoginService.login("nikhil", "wrong_pass", "1998-11-19"));
    }

    @Test
    public void testInvalidDob() {
        assertFalse(LoginService.login("nikhil", "nikhil_pass", "1991-01-01"));
    }

    @Test
    public void testNullValues() {
        assertFalse(LoginService.login(null, null, null));
    }

    @Test
    public void testEmptyValues() {
        assertFalse(LoginService.login("", "", ""));
    }

    @Test
    public void testValidUser2() {
        assertTrue(LoginService.login("test", "test_pass", "2000-12-31"));
    }
}
