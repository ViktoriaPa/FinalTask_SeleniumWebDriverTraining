package com.coherentsolutions.training.auto.web.pashkovskaya.base;

import com.coherentsolutions.training.auto.web.pashkovskaya.util.PageDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.coherentsolutions.training.auto.web.pashkovskaya.util.DriverInit;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DriverInit driverInit = DriverInit.getInstance();
        driver = driverInit.getDriver();

        PageDriver.setDriver(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
