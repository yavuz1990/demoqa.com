
Feature: User can logout / Search book / Add-Delete books / Change row number on profile page
  User Story:
  1. Verify that user can Logout
  2. Verify that user can Search book
  3. Verify that user can Add books
  4. Verify that user can Delete books
  5. Verify that user can Change row number on profile page

  Background: Login to the dashboard
    Given user goes to Book Store Page Without Login
    Given user clicks to loginSubmodule Button
    Given user enters correct Username
    Given user enters correct Password
    Given user should land on Dashboard


  Scenario: Verify that user can Logout
    And user click logout Button
    Then user sees "Login in Book Store"

  Scenario: Verify that user can Search book
    When  user types "Git Pocket Guide" on Search Name Area
    And user clicks Search Button
    Then user sees "Git Pocket Guide" on Title Area in Book Store Page

  Scenario: Verify that user can Add books
    When  user clicks Go To Book Store Button
    And user click "Git Pocket Guide" Book
    And user click Add To Your Collection Button
    And user sees "Book added to your collection." pop-up message1
    And user click OK Button1
    And user click Profile SubModule Button
    Then user sees "Git Pocket Guide" on Title Area in Profile Page

  Scenario: Verify that user can Delete books
    When  user clicks Delete Icon
    And user sees "Do you want to delete this book?" pop-up message2
    And user click OK Button2
    And user sees "Book deleted." pop-up message3
    And user click OK Button3
    Then user sees that the book was deleted

  Scenario: Verify that user can Change row number on profile page
    When  user clicks Rows More Button
    And user click "10 rows"
    Then user sees "10 rows" on the row number area

