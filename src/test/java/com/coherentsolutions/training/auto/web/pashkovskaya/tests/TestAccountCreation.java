package com.coherentsolutions.training.auto.web.pashkovskaya.tests;

import com.coherentsolutions.training.auto.web.pashkovskaya.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestAccountCreation extends BaseTest {

    @Test
    public void testPasswordsAreDifferent() {
        driver.get("https://magento.softwaretestingboard.com");

        WebElement createAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAccountLink.click();

        WebElement firstNameTextField = driver.findElement(By.id("firstname"));
        firstNameTextField.sendKeys("Viktoria");

        WebElement lastNameTextField = driver.findElement(By.id("lastname"));
        lastNameTextField.sendKeys("Pa");

        WebElement emailTextField = driver.findElement(By.id("email_address"));
        emailTextField.sendKeys("VikaVqwe@gmail.com");

        WebElement passwordTextField = driver.findElement(By.id("password"));
        passwordTextField.sendKeys("VikaVqwe1234!");

        WebElement passwordConfirmationTextField = driver.findElement(By.id("password-confirmation"));
        passwordConfirmationTextField.sendKeys("VikaVqwe1234");

        WebElement createAccountButton = driver.findElement(By.xpath("//button [@class='action submit primary']"));
        createAccountButton.click();

        WebElement errorMessage = driver.findElement(By.id("password-confirmation-error"));
        assertEquals(errorMessage.getText(), "Please enter the same value again.", "Error message mismatch");
    }

    @Test
    public void testAccountCreation() {
        driver.get("https://magento.softwaretestingboard.com");

        WebElement createAccountLink = driver.findElement(By.linkText("Create an Account"));
        createAccountLink.click();

        WebElement firstNameTextField = driver.findElement(By.id("firstname"));
        firstNameTextField.sendKeys("Viktoria");

        WebElement lastNameTextField = driver.findElement(By.id("lastname"));
        lastNameTextField.sendKeys("Pa");

        WebElement emailTextField = driver.findElement(By.id("email_address"));
        emailTextField.sendKeys("VikaVqwe@gmail.com");

        WebElement passwordTextField = driver.findElement(By.id("password"));
        passwordTextField.sendKeys("VikaVqwe1234!");

        WebElement passwordConfirmationTextField = driver.findElement(By.id("password-confirmation"));
        passwordConfirmationTextField.sendKeys("VikaVqwe1234!");

        WebElement createAccountButton = driver.findElement(By.xpath("//button [@class='action submit primary']"));
        createAccountButton.click();

        assertEquals(driver.getTitle(), "My Account", "Account is not created");
    }
}
