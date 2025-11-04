package com.cucumberScript.PageObjects;

import com.cucumberScript.BaseClass;
import com.cucumberScript.Utils.BrowserUtils;
import org.openqa.selenium.By;

public class HomePage extends BaseClass {

    private static By homeText = By.xpath("//div[h1]");
    private static By contactsIcon = By.xpath("//span[normalize-space()='Contacts']");

    public static void validateLogin(String expectedText){
        BrowserUtils.validateText(homeText, expectedText);
    }

    public static void clickContacts(){
        BrowserUtils.clickBtn(contactsIcon);
    }

}
