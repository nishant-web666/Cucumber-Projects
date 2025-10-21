package com.cucumberScript.Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetBrowserDriver {
    public static WebDriver driver;
    // Getting browser driver dynamically from framework properties
    public static WebDriver getBrowserDriver(String browser){
        if (browser != null){
            if (browser.equalsIgnoreCase("chrome")){
                driver = setChromeDriver();
            } else if (browser.equalsIgnoreCase("firefox")) {
                driver = setFirefoxDriver();
            }
            else if (browser.equalsIgnoreCase("ie")) {
                driver = setIEDriver();
            }
        }
        return driver;
    }
    // Methods for the driver setup for each types of browsers
    private static WebDriver setChromeDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        return driver;
    }
    private static WebDriver setFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        return driver;
    }
    private static WebDriver setIEDriver(){
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        return driver;
    }
}
