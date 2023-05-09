package com.coherentsolutions.training.auto.web.pashkovskaya.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverInit {

    private static DriverInit instanceDriver  = null;
    private WebDriver driver;

    private DriverInit() {

    }

    public synchronized static DriverInit getInstance() {
        if (instanceDriver == null) {
            instanceDriver = new DriverInit();
        }
        return instanceDriver;
    }

    public WebDriver getDriver(){
        ChromeOptions handlingSSL = new ChromeOptions();
        handlingSSL.setAcceptInsecureCerts(true);
        handlingSSL.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(handlingSSL);
        driver.manage().timeouts().implicitlyWait(2, SECONDS);
        driver.manage().window().maximize();

        return driver;
    }
}
