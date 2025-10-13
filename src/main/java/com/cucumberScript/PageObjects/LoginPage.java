package com.cucumberScript.PageObjects;

import com.cucumberScript.BaseClass;
import com.cucumberScript.Utils.BrowserUtils;
import org.openqa.selenium.By;

public class LoginPage extends BaseClass{
    private static String emailInputField = "//input[@name=\"email\"]";
    private static String passwordInputField = "//input[@name=\"password\"]";
    private static String loginBtn = "//button[@type=\"submit\"]";
    private static String forgotPasswordLink = "//a[text()='Forgot password']\n";

    public static void enterEmail(String email){
        BrowserUtils.enterText(emailInputField,email);
    }
    public static void enterPassword(String password){
        BrowserUtils.enterText(passwordInputField,password);
    }
    public static void pressLoginBtn(){
        BrowserUtils.clickBtn(loginBtn);
    }
    public static void clickForgotPassword(){
        driver.findElement(By.xpath(forgotPasswordLink)).click();
    }
}
