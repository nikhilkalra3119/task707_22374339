package web.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class LoginServletTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", 
    			"C:\\Users\\hp\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");  // Adjust this path if needed
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10); // Increased wait time
    }

    @Test
    public void testValidLogin() {
        driver.get("http://127.0.0.1:8082/login");

        driver.findElement(By.name("username")).sendKeys("nikhil");
        driver.findElement(By.name("passwd")).sendKeys("nikhil_pass");

        // Set DOB with JS to avoid input type="date" issues
        ((org.openqa.selenium.JavascriptExecutor) driver)
            .executeScript("document.getElementById('dob').value = '1998-11-19';");

        driver.findElement(By.cssSelector("form input[type='submit']")).click();

        // Wait for the actual page title
        wait.until(ExpectedConditions.titleIs("Login Successful"));
        String title = driver.getTitle();
        System.out.println("TestValidLogin - Title: " + title);
        assertEquals("Login Successful", title);
    }
    
    @Test
    public void testInvalidUsername() {
        driver.get("http://127.0.0.1:8082/login.html");

        driver.findElement(By.name("username")).sendKeys("wrong_user");
        driver.findElement(By.name("passwd")).sendKeys("nikhil_pass");
        driver.findElement(By.name("dob")).sendKeys("1998-11-19");

        driver.findElement(By.cssSelector("form input[type='submit']")).click();

        // Wait for the title to be "Login Failed"
        wait.until(ExpectedConditions.titleIs("Login Failed"));

        String title = driver.getTitle();
        System.out.println("TestInvalidUsername - Title: " + title);
        assertEquals("Login Failed", title);
    }

    @Test
    public void testInvalidPassword() {
        driver.get("http://127.0.0.1:8082/login.html");

        driver.findElement(By.name("username")).sendKeys("nikhil");
        driver.findElement(By.name("passwd")).sendKeys("wrong_pass");
        driver.findElement(By.name("dob")).sendKeys("1998-11-19");

        driver.findElement(By.cssSelector("form input[type='submit']")).click();

        // Wait for the title to be "Login Failed"
        wait.until(ExpectedConditions.titleIs("Login Failed"));

        String title = driver.getTitle();
        System.out.println("TestInvalidPassword - Title: " + title);
        assertEquals("Login Failed", title);
    }

    @Test
    public void testEmptyFields() {
        driver.get("http://127.0.0.1:8082/login.html");

        driver.findElement(By.name("username")).sendKeys("");
        driver.findElement(By.name("passwd")).sendKeys("");
        driver.findElement(By.name("dob")).sendKeys("");

        driver.findElement(By.cssSelector("form input[type='submit']")).click();

        // Wait for the title to be "Login Failed"
        wait.until(ExpectedConditions.titleIs("Login Failed"));

        String title = driver.getTitle();
        System.out.println("TestEmptyFields - Title: " + title);
        assertEquals("Login Failed", title);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser after each test
        }
    }
}