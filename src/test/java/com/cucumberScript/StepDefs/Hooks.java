package com.cucumberScript.StepDefs;

import com.cucumberScript.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.util.Properties;

public class Hooks extends BaseClass {
    @Before
    public void setup(){
        System.out.println("Before hook is running...");
        BaseClass.initializeDriver();
    }

    @After
    public void close(){
        BaseClass.closeBrowser();
    }
}
