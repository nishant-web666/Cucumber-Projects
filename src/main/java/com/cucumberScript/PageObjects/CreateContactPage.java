package com.cucumberScript.PageObjects;

import com.cucumberScript.BaseClass;
import com.cucumberScript.Utils.BrowserUtils;
import com.google.gson.internal.bind.util.ISO8601Utils;
import org.openqa.selenium.By;

public class CreateContactPage extends BaseClass {

    private static  By firstName = By.xpath("//legend[normalize-space()='First Name']/following-sibling::input");
    private static  By lastName = By.xpath("//legend[normalize-space()='Last Name']/following-sibling::input");
    private static By contactTypeSelector = By.xpath("//ul/li[normalize-space()='Contact Type']/ancestor::div[contains(@class,'nice-select')]");
    private static By contactStatusSelector = By.id("select2-status-id-container");
    private static By saveBtn = By.xpath("//button[@id='submitButton' and normalize-space(text())='Save']");
    private static String contactType = "//ul[@class='list']//li[contains(@class,'option') and normalize-space(text())='{value}']";
    private static String statusOptions = "//ul[@id='select2-status-id-results']//li[normalize-space(text())='{value}']";

    public static void enterFirstName(String name){
        BrowserUtils.enterText(firstName , name);
    }
    public static void enterlastName(String name){
        BrowserUtils.enterText(lastName , name);
    }
    public static void selectContactType(String type){
        BrowserUtils.selectFromDropdown(contactTypeSelector , contactType , type );
        System.out.println(statusOptions);
    }
    public static void selectContactStatus(String contactStatus){
        BrowserUtils.selectFromDropdown(contactStatusSelector , statusOptions , contactStatus);
        System.out.println(statusOptions);
    }
    public static void clickSaveButton(){
        BrowserUtils.clickBtn(saveBtn);
    }

}
