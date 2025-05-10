package web.service;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;

import static org.junit.Assert.*;

public class FunctionalTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to ChromeDriver here (make sure this is the correct path to your chromedriver)
    	System.setProperty("webdriver.chrome.driver", 
    			"C:\\Users\\hp\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();  // Initialize ChromeDriver
        
        // Set an implicit wait to handle slower loading elements
        driver.manage().timeouts().implicitlyWait(10, java.util.concurrent.TimeUnit.SECONDS);
        
        // Optionally, set window size
        driver.manage().window().setSize(new Dimension(1024, 768));
    }

    @Test
    public void testValidQ1Form_submission() {
        System.out.println("Starting test: testValidQ1Form_submission");

        // Navigate to Q1 page
        driver.get("http://localhost:8080/q1");

        // Wait until elements are visible before interacting
        WebDriverWait wait = new WebDriverWait(driver, 10);  // 10-second wait
        WebElement number1Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number1")));
        WebElement number2Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number2")));
        WebElement resultField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("result")));

        System.out.println("Found number1Field: " + (number1Field != null));
        System.out.println("Found number2Field: " + (number2Field != null));
        System.out.println("Found resultField: " + (resultField != null));

        // Fill out the form with valid data
        number1Field.sendKeys("3.0");
        number2Field.sendKeys("4.0");
        resultField.sendKeys("7.0");

        // Submit the form
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Verify redirection to Q2 page
        assertEquals("http://localhost:8080/q2", driver.getCurrentUrl());
        
        System.out.println("Test Passed: testValidQ1Form_submission");
    }

    @Test
    public void testInvalidQ1Form_submission() {
        System.out.println("Starting test: testInvalidQ1Form_submission");

        // Navigate to Q1 page
        driver.get("http://localhost:8080/q1");

        // Wait until elements are visible before interacting
        WebDriverWait wait = new WebDriverWait(driver, 10);  // 10-second wait
        WebElement number1Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number1")));
        WebElement number2Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number2")));
        WebElement resultField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("result")));

        System.out.println("Found number1Field: " + (number1Field != null));
        System.out.println("Found number2Field: " + (number2Field != null));
        System.out.println("Found resultField: " + (resultField != null));

        // Leave form empty or input invalid data
        number1Field.sendKeys("");
        number2Field.sendKeys("");
        resultField.sendKeys("");

        // Submit the form
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Check if error message is displayed
        String errorMessage = driver.findElement(By.id("errorMessage")).getText();  // Adjust this with the actual ID
        assertTrue(errorMessage.contains("Please enter valid numbers for the calculation."));


        System.out.println("Test Passed: testInvalidQ1Form_submission");
    }

    @Test
    public void testValidQ2Form_submission() {
        System.out.println("Starting test: testValidQ2Form_submission");

        // Navigate to Q2 page
        driver.get("http://localhost:8080/q2");

        // Wait until elements are visible before interacting
        WebDriverWait wait = new WebDriverWait(driver, 10);  // 10-second wait
        WebElement number1Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number1")));
        WebElement number2Field = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("number2")));
        WebElement resultField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("result")));

        System.out.println("Found number1Field: " + (number1Field != null));
        System.out.println("Found number2Field: " + (number2Field != null));
        System.out.println("Found resultField: " + (resultField != null));

        // Fill out the form with valid data
        number1Field.sendKeys("5.0");
        number2Field.sendKeys("3.0");
        resultField.sendKeys("2.0");

        // Submit the form
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Verify redirection to success page
        assertEquals("http://localhost:8080/q3", driver.getCurrentUrl());

        System.out.println("Test Passed: testValidQ2Form_submission");
    }

    @After
    public void tearDown() {
        // Quit the driver after test execution to close the browser
        if (driver != null) {
            driver.quit();
            System.out.println("Driver quit successfully.");
        }
    }
}