Feature: Create a contact

  Background:
    Given User is logged into the application

  Scenario Outline: User creates a contact with different details
    Given User navigates to the Contacts module
    And User clicks on the CreateContact button
    And User enters First Name "<firstname>"
    And User enters Last Name "<lastname>"
    And User selects Contact Type "<type>"
    And User selects the contact status if contact is recruit type the contactStatus "<contactStatus>" and contact type "<type>"
    When User clicks on the Save button
    Then The newly created contact with First Name "<firstname>" and Last Name "<lastname>" should be visible in the Contact Listing page

    Examples:

      | firstname | lastname  | type     | contactStatus
      | Jumbo     | Raja      | Recruit  | Prospect (Recruit)
      | Krazzy    | 12345     | Lead     | NA
      | Al1234e   | *$^%$     | Customer | NA
      | 98765     | Smith     | Other    | NA

