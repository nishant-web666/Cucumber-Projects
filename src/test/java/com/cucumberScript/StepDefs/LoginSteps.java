package com.cucumberScript.StepDefs;

import com.cucumberScript.BaseClass;
import com.cucumberScript.PageObjects.LoginPage;
import com.cucumberScript.Utils.PropertiesUtil;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Properties;

public class LoginSteps extends BaseClass {

    Properties properties = PropertiesUtil.loadProperties("src/test/resources/config/user.properties");

    @Given("User enters valid email in the email field")
    public void userEntersValidUsernameInTheUsernameField() {
        String email = properties.getProperty("email");
        LoginPage.enterEmail(email);
    }

    @And("User enters valid password in the password field")
    public void userEntersValidPasswordInThePasswordField() {
        String password = properties.getProperty("password");
        LoginPage.enterEmail(password);
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        LoginPage.pressLoginBtn();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        // Write code here that turns the phrase above into concrete actions
        String expectedURL = "https://app.repcard.com/admin/home";
        String currentURL = BaseClass.driver.getCurrentUrl();
        Assert.assertEquals("URL after login is not as expected!", expectedURL, currentURL);
    }

    @Given("User enters invalid email in the email field")
    public void userEntersInvalidUsernameInTheUsernameField() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("User enters invalid password in the password field")
    public void userEntersInvalidPasswordInThePasswordField() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("Validation error message is displayed")
    public void userIsNotLoggedIntoTheApplication() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
