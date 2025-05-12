package sit707_week2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Ahsan Habib
 */
public class MainTest {
    
    public MainTest() {
        System.out.println("MainTest");
    }
    
    @Before
    public void setup() {
        System.out.println("Before...");
    }
    
    @Test
    public void testStudentIdentity() {
        String studentId = "223764339";  // Using a valid student ID here
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Nikhil Kalra";  // Using a valid name here
        Assert.assertNotNull("Student name is null", studentName);
    }
    
    @Test
    public void testAssertTrue() {
        System.out.println("testAssertTrue...");
        Assert.assertTrue(true);
    }
    
    @Test
    public void testAssertFalse() {
        System.out.println("testAssertFalse...");
        Assert.assertFalse(!true);
    }

    // You can add a test to call Selenium's officeworks_registration_page here
    @Test
    public void testRegistration() {
    	String gumtreeUrl = "https://www.gumtree.com.au/t-login-form.html?registration=1";
        // Call the Gumtree registration page method
        SeleniumOperations.magento_registration_page("https://magento.softwaretestingboard.com/customer/account/create/");
    }}
