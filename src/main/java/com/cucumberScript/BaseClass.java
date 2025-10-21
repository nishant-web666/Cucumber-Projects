package com.cucumberScript;

import com.cucumberScript.Utils.PropertiesUtil;
import org.openqa.selenium.WebDriver;
import java.util.Properties;
import static com.cucumberScript.Utils.GetBrowserDriver.getBrowserDriver;

public class BaseClass {
    public static WebDriver driver;
    // Make properties protected static so child classes can access
    protected static Properties appProperties;
    protected static Properties frameworkProperties;
    protected static Properties userProperties;

    public static void initializeDriver(){
        appProperties = PropertiesUtil.loadProperties("src/test/resources/config/application.properties");
        frameworkProperties = PropertiesUtil.loadProperties("src/test/resources/config/framework.properties");
        userProperties = PropertiesUtil.loadProperties("src/test/resources/config/user.properties");
        String url = appProperties.getProperty("application.url");
        String browser = frameworkProperties.getProperty("browser.driver");
        driver = getBrowserDriver(browser);
        driver.manage().window().maximize();
        driver.get(url);
    }

    public static void closeBrowser() {
        if(driver != null) {
            driver.quit();
        }
    }
}
