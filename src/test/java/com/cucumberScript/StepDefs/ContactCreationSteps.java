package com.cucumberScript.StepDefs;

import com.cucumberScript.BaseClass;
import com.cucumberScript.PageObjects.ContactsListingPage;
import com.cucumberScript.PageObjects.CreateContactPage;
import com.cucumberScript.PageObjects.HomePage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ContactCreationSteps extends BaseClass {

    @Given("User navigates to the Contacts module")
    public void user_navigates_to_the_contacts_module() {
        HomePage.clickContacts();
    }

    @Given("User clicks on the CreateContact button")
    public void user_clicks_on_the_create_contact_button() {
        ContactsListingPage.clickCreateContact();
    }

    @Given("User enters First Name {string}")
    public void user_enters_first_name(String firstname) {
        CreateContactPage.enterFirstName(firstname);
    }

    @Given("User enters Last Name {string}")
    public void user_enters_last_name(String lastname) {
        CreateContactPage.enterlastName(lastname);
    }

    @Then("User selects Contact Type {string}")
    public void user_selects_contact_type(String type) {
        CreateContactPage.selectContactType(type);
    }

    @When("User clicks on the Save button")
    public void user_clicks_on_the_save_button() {
        CreateContactPage.clickSaveButton();
    }

    @Then("The newly created contact with First Name {string} and Last Name {string} should be visible in the Contact Listing page")
    public void theNewlyCreatedContactWithFirstNameAndLastNameShouldBeVisibleInTheContactListingPage(String firstname, String lastname) {
        String fullName = firstname + " " + lastname;
        boolean isVisible = ContactsListingPage.validateContactCreation(fullName);
        Assert.assertTrue("Customer " + fullName + " is not visible in the table!", isVisible);
    }

    @And("User selects the contact status if contact is recruit type the contactStatus {string} and contact type {string}")
    public void userSelectsTheContactStatusIfContactIsRecruitTypeTheContactStatusAndContactType(String type, String contactStatus) {
        // Only run for Recruit
        if ("Recruit".equalsIgnoreCase(type)) {
            if (contactStatus != null && !contactStatus.isEmpty() && !contactStatus.equalsIgnoreCase("NA")) {
                CreateContactPage.selectContactStatus(contactStatus);
            }
        } else {
            System.out.println("Skipping contact status selection for type: " + type);
        }
    }
}
