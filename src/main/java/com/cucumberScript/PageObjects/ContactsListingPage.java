package com.cucumberScript.PageObjects;

import com.cucumberScript.BaseClass;
import com.cucumberScript.Utils.BrowserUtils;
import org.openqa.selenium.By;

public class ContactsListingPage extends BaseClass {

    public static By createContact = By.xpath("//a[.//span[normalize-space()='Create Contact']]");

    public static void clickCreateContact(){
        BrowserUtils.clickBtn(createContact);
    }
    public static boolean validateContactCreation(String expectedFullname){
        By contactName = By.xpath("//table//tr//td[normalize-space()='" + expectedFullname + "']");
        return BrowserUtils.isElementDisplayed(contactName);
    }
}
