package com.cucumberScript.Utils;

import com.cucumberScript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;
import java.util.Properties;

public class BrowserUtils extends BaseClass {
    // Custom find element function to wait for the loading elements in the page
    public static WebElement findAndWaitForElement(String xpath){
        WebElement element = null;
        try{
            String timeout = frameworkProperties.getProperty("timeout.maximum");
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
    // To validate the text with the actual and expected text on the browser
    public static void validateText(String xpath, String expectedText){
        String actualText = findAndWaitForElement(xpath).getText();
        Assert.assertEquals("Home Heading Text after login is not matched", expectedText, actualText);
    }
    // To validate the toast messages which are coming from the data attributes
    public static void validateToast(String xpath, String propertyErrLoginMessage){
        String actualText = findAndWaitForElement(xpath).getAttribute("data-message");
        String expectedText = appProperties.getProperty("propertyErrLoginMessage");
        Assert.assertEquals("The text is not matched in the given text.", expectedText, actualText);
    }
}
