package com.cucumberScript.Utils;

import com.cucumberScript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import javax.swing.*;
import java.time.Duration;

public class BrowserUtils extends BaseClass {

    // Custom find element function to wait for the loading elements in the page
    public static WebElement findAndWaitForElement(By locator) {
        try {
            String timeout = frameworkProperties.getProperty("timeout.maximum");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new RuntimeException("Element not clickable within timeout: " + locator, e);
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Element not found on the page: " + locator, e);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error while waiting for element: " + locator, e);
        }
    }
    // Dynamic method for entering the input inside the input fields
    public static void enterText(By locator, String text){
        WebElement element = findAndWaitForElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    // Dynamic method for entering the input inside the input fields
    public static void hoverAndClick(By element1, By element2){
        Actions actions = new Actions(driver);
        WebElement e1 = findAndWaitForElement(element1);
        WebElement e2 = findAndWaitForElement(element2);
        actions.moveToElement(e1).click(e2).build().perform();
    }
    // Wait loader to disappear
    public static void waitForLoaderToDisappear() {
        try {
            String timeout = frameworkProperties.getProperty("timeout.maximum");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Long.parseLong(timeout)));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("load_screen")));
        } catch (Exception e) {
            System.out.println("Loader did not appear or already gone.");
        }
    }
    // Dynamic method for clicking the buttons
    public static void clickBtn(By locator){
        waitForLoaderToDisappear();
        findAndWaitForElement(locator).click();
    }
    // Dynamic Dropdown selector method
    public static void selectFromDropdown(By dropdownLocator, String optionsXpath, String value) {
        // Click the dropdown
        clickBtn(dropdownLocator);
        // Build dynamic option locator
        By option = By.xpath(optionsXpath.replace("{value}", value));
        // Click the option
        clickBtn(option);
    }
    // To validate the text with the actual and expected text on the browser
    public static void validateText(By locator, String expectedText){
        String actualText = findAndWaitForElement(locator).getText();
        Assert.assertEquals("Home Heading Text after login is not matched", expectedText, actualText);
    }
    // To validate the toast messages which are coming from the data attributes
    public static void validateToast(By locator, String propertyErrLoginMessage){
        String actualText = findAndWaitForElement(locator).getAttribute("data-message");
        String expectedText = appProperties.getProperty("propertyErrLoginMessage");
        Assert.assertEquals("The text is not matched in the given text.", expectedText, actualText);
    }
    // To validate whether the element is visible or not
    public static boolean isElementDisplayed(By locator){
        try{
            return findAndWaitForElement(locator).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
