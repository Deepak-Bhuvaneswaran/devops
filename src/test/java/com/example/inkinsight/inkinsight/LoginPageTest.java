package com.example.inkinsight.inkinsight;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPageTest {

    WebDriver driver;

    @Before(value = "")
    public void setUp() {
        // Setup WebDriver (assuming ChromeDriver)
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testLoginSuccess() {
        driver.get("http://localhost:8080/login");

        // Increase the wait time to 20 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Wait for the username field to be visible
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
        
        // Check if the username field is visible and interact with it
        usernameField.sendKeys("testuser");

        // Continue with your test, e.g., finding password field and login button
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("testpassword");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();

        // Add assertions as per your test case
        // Assert the login is successful by checking the page redirection, welcome message, etc.
    }

    @After(value = "")
    public void tearDown() {
        driver.quit();
    }
}