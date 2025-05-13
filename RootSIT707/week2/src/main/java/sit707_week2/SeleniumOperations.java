package sit707_week2;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class SeleniumOperations {
    public static void magento_registration_page(String url) {
        // Set the path to ChromeDriver
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\hp\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");

        // Start Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        // Wait setup
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try {
            // Wait and fill First Name
            WebElement firstName = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("firstname")));
            firstName.sendKeys("Nikhil");

            // Fill Last Name
            WebElement lastName = driver.findElement(By.id("lastname"));
            lastName.sendKeys("Kalra");

            // Fill Email
            WebElement email = driver.findElement(By.id("email_address"));
            email.sendKeys("nikhil@example.com");

            // Fill Password
            WebElement password = driver.findElement(By.id("password"));
            password.sendKeys("123");

            // Fill Confirm Password
            WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
            confirmPassword.sendKeys("123");

            // Click Create an Account button
            WebElement registerButton = driver.findElement(By.cssSelector("button.action.submit.primary"));
            registerButton.click();

            // Take screenshot after form submission
            TakesScreenshot ts = (TakesScreenshot) driver;
            File srcFile = ts.getScreenshotAs(OutputType.FILE);
            File destFile = new File("screenshot.png");

            // Copy file to destination
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Screenshot saved as screenshot.png");

        } catch (Exception e) {
            System.out.println("Error during registration: " + e.getMessage());
        } finally {
            // Optional: close the browser
            // driver.quit();
        }
    }
}