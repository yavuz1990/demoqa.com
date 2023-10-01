@wip
Feature: User can Login
  User Story:
  1. Verify that user can Login

  Scenario: Verify that user can Login
    When user goes to Book Store Page Without Login
    And user clicks to loginSubmodule Button
    And  user enters correct Username
    And  user enters correct Password
    And user click login Button
    Then user should land on Dashboard


  Scenario: Verify that user can not Login
    When user goes to Book Store Page Without Login
    And user clicks to loginSubmodule Button
    And  user enters invalid username
    And  user enters invalid password
    And user click login Button
    Then user should not land on Dashboard