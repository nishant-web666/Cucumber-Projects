package com.cucumberScript.PageObjects;

import com.cucumberScript.BaseClass;
import com.cucumberScript.Utils.BrowserUtils;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass{
    private static By emailInputField = By.name("email");
    private static By passwordInputField = By.name("password");
    private static By loginBtn = By.xpath("//button[@type=\"submit\"]");
    private static By forgotPasswordLink = By.xpath("\"//a[text()='Forgot password']\\n\"");
    private static By loginErrorToast = By.xpath("//div[@class=\"deactivate-error\"]");

    public static void enterEmail(String email){
        BrowserUtils.enterText(emailInputField,email);
    }
    public static void enterPassword(String password){
        BrowserUtils.enterText(passwordInputField,password);
    }
    public static void clickLoginBtn(){
        BrowserUtils.clickBtn(loginBtn);
    }
    public static void clickForgotPassword(){
        driver.findElement(forgotPasswordLink).click();
    }
    public static void validateInvalidEmailAndPassword(String expectedText){
        BrowserUtils.validateToast(loginErrorToast , expectedText);
        System.out.println(expectedText);
    }
}
