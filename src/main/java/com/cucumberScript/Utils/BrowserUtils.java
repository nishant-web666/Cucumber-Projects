package com.cucumberScript.Utils;

import com.cucumberScript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;

public class BrowserUtils extends BaseClass {
    static Properties properties = PropertiesUtil.loadProperties("src/test/resources/config/framework.properties");

    // Custom find element function to wait for the loading elements in the page
    public static WebElement findAndWaitForElement(String xpath){
        WebElement element = null;
        try{
            String timeout = properties.getProperty("timeout.maximum");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
            element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        }catch (Exception e){
            System.out.println("No such element found");
        }
        return element;
    }
    // Dynamic method for entering the input inside the input fields
    public static void enterText(String xpath, String text){
        findAndWaitForElement(xpath).clear();
        findAndWaitForElement(xpath).sendKeys(text);
    }
    // Dynamic method for clicking the buttons
    public static void clickBtn(String xpath){
        findAndWaitForElement(xpath).click();
    }
}
