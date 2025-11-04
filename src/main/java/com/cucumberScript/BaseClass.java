package com.cucumberScript;

import com.cucumberScript.Utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.Properties;
import static com.cucumberScript.Utils.GetBrowserDriver.getBrowserDriver;

public class BaseClass {
    public static WebDriver driver;
    public static Properties appProperties;
    public static Properties frameworkProperties;
    public static Properties userProperties;

    static {
        appProperties = PropertiesUtil.loadProperties("src/test/resources/config/application.properties");
        frameworkProperties = PropertiesUtil.loadProperties("src/test/resources/config/framework.properties");
        userProperties = PropertiesUtil.loadProperties("src/test/resources/config/user.properties");
    }

    public static void initializeDriver(){
        String browser = frameworkProperties.getProperty("browser.driver");
        String url = appProperties.getProperty("application.url");
        driver = getBrowserDriver(browser);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void closeBrowser() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
