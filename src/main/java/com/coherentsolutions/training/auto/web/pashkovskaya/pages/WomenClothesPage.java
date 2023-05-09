package com.coherentsolutions.training.auto.web.pashkovskaya.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WomenClothesPage extends BasePage{
    @FindBy(xpath = "//ol[@class='product-items widget-product-grid'][1]")
    public WebElement productItem;

    public WomenClothesPage(WebDriver driver) {
        super(driver);
    }

    public ItemPage openItemPage() {
        productItem.click();

        return new ItemPage(driver);
    }
}
