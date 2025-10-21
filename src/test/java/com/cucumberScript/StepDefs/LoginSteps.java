package com.cucumberScript.StepDefs;

import com.cucumberScript.BaseClass;
import com.cucumberScript.PageObjects.HomePage;
import com.cucumberScript.PageObjects.LoginPage;
import com.cucumberScript.PageObjects.LoginPage;
import com.cucumberScript.Utils.PropertiesUtil;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Properties;

public class LoginSteps extends BaseClass {

    @Given("User enters valid email in the email field")
    public void userEntersValidUsernameInTheUsernameField() {
        String email = userProperties.getProperty("email");
        LoginPage.enterEmail(email);
    }

    @And("User enters valid password in the password field")
    public void userEntersValidPasswordInThePasswordField() {
        String password = userProperties.getProperty("password");
        LoginPage.enterPassword(password);
    }

    @When("User clicks on login button")
    public void userClicksOnLoginButton() {
        // Write code here that turns the phrase above into concrete actions
        LoginPage.pressLoginBtn();
    }

    @Then("User is logged in successfully")
    public void userIsLoggedInSuccessfully() {
        HomePage.validateLogin("DASHBOARD");
    }

    @Given("^User enters invalid (.*) in the email field$")
    public void userEntersInvalidUsernameInTheUsernameField(String email) {
        LoginPage.enterEmail(email);
    }

    @And("^User enters invalid (.*) in the password field$")
    public void userEntersInvalidPasswordInThePasswordField(String password) {
        LoginPage.enterPassword(password);
    }

    @Then("^Validation error (.*) is displayed$")
    public void userIsNotLoggedIntoTheApplication(String message) {
        LoginPage.validateInvalidEmailAndPassword(message);
    }
}
