Feature: BP Login
  As a user, I should be able to log in and see that all I require is on the home page.

  Scenario: I log into the application
    Given I navigate to the login page
    When I log in
    Then I should see that I am logged in on the home page