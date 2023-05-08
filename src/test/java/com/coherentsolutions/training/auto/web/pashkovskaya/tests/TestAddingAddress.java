package com.coherentsolutions.training.auto.web.pashkovskaya.tests;

import com.coherentsolutions.training.auto.web.pashkovskaya.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class TestAddingAddress extends BaseTest {
    @BeforeMethod
    public void logIn() {
        driver.get("https://magento.softwaretestingboard.com");

        WebElement signInLink = driver.findElement(By.linkText("Sign In"));
        signInLink.click();

        WebElement emailTextField = driver.findElement(By.id("email"));
        emailTextField.sendKeys("VikaVqwe@gmail.com");

        WebElement passwordTextField = driver.findElement(By.id("pass"));
        passwordTextField.sendKeys("VikaVqwe1234!");

        WebElement signInButton = driver.findElement(By.xpath("//button [@class='action login primary']"));
        signInButton.click();
    }

    @Test
    public void testAddingAddress() throws InterruptedException {
        WebElement loggedInUserLabel = driver.findElement(By.xpath("//div[@class = 'panel header'] //button[@class = 'action switch']"));
        Thread.sleep(2500);
        loggedInUserLabel.click();

        WebElement myAccountPage = driver.findElement(By.linkText("My Account"));
        myAccountPage.click();

        WebElement addressBookPage = driver.findElement(By.linkText("Address Book"));
        addressBookPage.click();

        WebElement addNewAddressButton = driver.findElement(By.xpath("//button[@class='action primary add']"));
        Thread.sleep(10000);
        addNewAddressButton.click();

        WebElement addressTextField1 = driver.findElement(By.id("street_1"));
        addressTextField1.sendKeys("Wenska");

        WebElement cityTextField = driver.findElement(By.id("city"));
        cityTextField.sendKeys("Wroclaw");

        WebElement countryDropdown = driver.findElement(By.id("country"));
        countryDropdown.click();
        WebElement country = driver.findElement(By.xpath("//*[@id='country']/option[178]"));
        country.click();

        WebElement stateDropdown = driver.findElement(By.id("region_id"));
        stateDropdown.click();
        WebElement state = driver.findElement(By.xpath("//*[@id='region_id']/option[2]"));
        state.click();

        WebElement zipTextField = driver.findElement(By.id("zip"));
        zipTextField.sendKeys("52-010");

        WebElement phoneNumberTextField = driver.findElement(By.id("telephone"));
        phoneNumberTextField.sendKeys("1234");

        WebElement saveAddressButton = driver.findElement(By.xpath("//button[@class = 'action save primary']"));
        saveAddressButton.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class = 'message-success success message']"));
        assertEquals(successMessage.getText(), "You saved the address.", "Failed to save address");
    }
}
