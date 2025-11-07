package com.cucumberScript.PageObjects;

import com.cucumberScript.BaseClass;
import com.cucumberScript.Utils.BrowserUtils;
import com.cucumberScript.Utils.ExcelUtils;
import org.openqa.selenium.By;
import java.util.List;

public class LoginPage extends BaseClass{
    private static String emailInputField = "//input[@name=\"email\"]";
    private static String passwordInputField = "//input[@name=\"password\"]";
    private static String loginBtn = "//button[@type=\"submit\"]";
    private static String forgotPasswordLink = "//a[text()='Forgot password']\n";
    private static String loginErrorToast = "//div[@class=\"deactivate-error\"]";

    static ExcelUtils excelUtils = new ExcelUtils("src/test/resources/testData/ExcelData.xlsx");

    public static void enterEmail(String email){
        List<String> usernames =  excelUtils.readExcelData("Sheet1" , "Username");
        String username = usernames.get(1);
        System.out.println(username);
        BrowserUtils.enterText(emailInputField,username);
    }
    public static void enterPassword(String password){
        List<String> passwords = excelUtils.readExcelData("Sheet1" , "Password");
        String passwordExcel = passwords.get(1);
        BrowserUtils.enterText(passwordInputField,passwordExcel);
    }
    public static void pressLoginBtn(){
        BrowserUtils.clickBtn(loginBtn);
    }
    public static void clickForgotPassword(){
        driver.findElement(By.xpath(forgotPasswordLink)).click();
    }
    public static void validateInvalidEmailAndPassword(String expectedText){
        BrowserUtils.validateToast(loginErrorToast , expectedText);
        System.out.println(expectedText);
    }
    public static void getUsername(){

    }
    public static void getPassword(){

    }
}
