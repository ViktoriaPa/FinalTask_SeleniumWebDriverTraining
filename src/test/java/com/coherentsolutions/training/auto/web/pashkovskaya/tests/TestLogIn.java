package com.coherentsolutions.training.auto.web.pashkovskaya.tests;

import com.coherentsolutions.training.auto.web.pashkovskaya.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestLogIn extends BaseTest {
    @Test
    public void testPasswordsAreDifferent() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com");

        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        WebElement emailTextField = driver.findElement(By.id("email"));
        emailTextField.sendKeys("VikaVqwe@gmail.com");

        WebElement passwordTextField = driver.findElement(By.id("pass"));
        passwordTextField.sendKeys("VikaVqwe1234!");

        WebElement signInButton = driver.findElement(By.xpath("//button [@class='action login primary']"));
        signInButton.click();

        WebElement loggedInUserLabel = driver.findElement(By.xpath("//div[@class='panel wrapper'] //span[contains(text(), 'Viktoria Pa')]"));
        Thread.sleep(2500);

        assertEquals(loggedInUserLabel.getText(), "Welcome, Viktoria Pa!", "User is not logged in");
    }
}
