package com.cucumberScript.PageObjects;

import com.cucumberScript.BaseClass;
import com.cucumberScript.Utils.BrowserUtils;

public class HomePage extends BaseClass {

    private static String homeText = "//div[h1]";
    public static void validateLogin(String expectedText){
        BrowserUtils.validateText(homeText, expectedText);
    }
public class HomePage {
}
