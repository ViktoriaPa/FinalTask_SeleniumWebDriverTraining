package com.coherentsolutions.training.auto.web.pashkovskaya.tests;

import com.coherentsolutions.training.auto.web.pashkovskaya.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestAddingToCart extends BaseTest {
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
    public void testAddingToWishList() {
        WebElement womenLink = driver.findElement(By.linkText("Women"));
        womenLink.click();

        WebElement productItem = driver.findElement(By.xpath("//ol[@class='product-items widget-product-grid'][1]"));
        productItem.click();

        WebElement sizeLabel = driver.findElement(By.xpath("//div[@class='swatch-attribute size'] /div[@class='swatch-attribute-options clearfix'] /div[1]"));
        sizeLabel.click();

        WebElement colorLabel = driver.findElement(By.xpath("//div[@class='swatch-option color'][1]"));
        colorLabel.click();

        WebElement addToWishListLink = driver.findElement(By.id("product-addtocart-button"));
        addToWishListLink.click();

        WebElement successMessage = driver.findElement(By.xpath("//div[@class='page messages']"));

        assertTrue(successMessage.isDisplayed());
    }
}
