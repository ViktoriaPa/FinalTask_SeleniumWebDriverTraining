package com.coherentsolutions.training.auto.web.pashkovskaya.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import util.DriverInit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverInit driverInit = DriverInit.getInstance();
        driver = driverInit.getDriver();
    }

    @AfterMethod (alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
