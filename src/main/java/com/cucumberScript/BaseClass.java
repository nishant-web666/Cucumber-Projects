package com.cucumberScript;

import com.cucumberScript.Utils.PropertiesUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

public class BaseClass {
    public static WebDriver driver;

    public static void initializeDriver(){
        if (driver==null) {
            Properties properties = PropertiesUtil.loadProperties("src/test/resources/config/application.properties");
            String url = properties.get("application.url").toString();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
        }
    }
    public static void closeBrowser(){
        driver.quit();
    }
}
