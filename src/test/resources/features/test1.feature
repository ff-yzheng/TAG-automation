Feature: Gmail Login
  As a user I should able to login into Gmail.

  Scenario: I login with valid credential
    Given I navigate to https://google.com
    When I search for This is crazy
    Then I should see a link for https://www.youtube.com/watch?v=fWNaR-rxAic
    When I click the link https://www.youtube.com/watch?v=fWNaR-rxAic
    Then I listen to some sweet tunes for 1 minutes