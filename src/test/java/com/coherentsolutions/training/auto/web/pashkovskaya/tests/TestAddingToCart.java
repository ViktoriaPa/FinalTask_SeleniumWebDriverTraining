package com.coherentsolutions.training.auto.web.pashkovskaya.tests;

import com.coherentsolutions.training.auto.web.pashkovskaya.base.BaseTest;
import com.coherentsolutions.training.auto.web.pashkovskaya.pages.*;
import com.coherentsolutions.training.auto.web.pashkovskaya.util.PageDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.coherentsolutions.training.auto.web.pashkovskaya.util.MainConstants.*;
import static org.testng.Assert.assertTrue;

public class TestAddingToCart extends BaseTest {
    public static final By SUCCESS_MESSAGE = By.xpath("//div[@class='page messages']");
    @Test
    public void testAddingToWishList() {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_TO_MAIN_PAGE);

        HomePageUnauthorizedUser homePageUnauthorizedUser = new HomePageUnauthorizedUser(driver);
        AuthorizationPage authorizationPage = homePageUnauthorizedUser.openAuthorizationPage();
        HomePageAuthorizedUser homePageAuthorizedUser = authorizationPage.openHomePageAuthorizedUser(EMAIL, PASSWORD);
        WomenClothesPage womenClothesPage = homePageAuthorizedUser.openWomenClothesPage();
        ItemPage itemPage = womenClothesPage.openItemPage();
        itemPage.addProductToCart();

        WebElement successMessage = driver.findElement(SUCCESS_MESSAGE);
        assertTrue(successMessage.isDisplayed(), "Failed to add product to a cart");
    }
}
