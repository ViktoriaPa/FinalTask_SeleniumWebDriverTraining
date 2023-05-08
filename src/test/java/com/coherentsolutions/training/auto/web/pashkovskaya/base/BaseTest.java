package com.coherentsolutions.training.auto.web.pashkovskaya.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static java.util.concurrent.TimeUnit.SECONDS;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        handlingSSL.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(handlingSSL);
        driver.manage().timeouts().implicitlyWait(2, SECONDS);
        driver.manage().window().maximize();
    }

//    @AfterMethod (alwaysRun = true)
//    public void cleanUp() {
//        driver.quit();
//    }
}
