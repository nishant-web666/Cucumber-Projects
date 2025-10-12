Feature: User Login

  Scenario: User is able to login with valid credentials

    Given User enters valid email in the email field
    And User enters valid password in the password field
    When User clicks on login button
    Then User is logged in successfully

  Scenario:  User is not able to login with invalid credentials
    Given User enters invalid email in the email field
    And User enters invalid password in the password field
    When User clicks on login button
    Then Validation error message is displayed