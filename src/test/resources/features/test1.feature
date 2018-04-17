Feature: Gmail Login
  As a user I should search and find sweet tunes.

  @randomTag
  Scenario: Listen to some sweet music through google search
    Given I navigate to https://google.com
    When I search for This is crazy
    Then I should see a link for https://www.youtube.com/watch?v=fWNaR-rxAic
    When I click the link https://www.youtube.com/watch?v=fWNaR-rxAic
    Then I listen to some sweet tunes for 1 seconds