@TAG
Feature: SmokeTest

  Background: User logged in
    Given I login TagUI
    When I login as superUser
    Then I should be authenticated

  Scenario Outline: ShowSearchResults for Ops-Audit by Type

    When I navigate to <main> - <subMenu>
    When I set the Type dropdown to <setValue>
    Then I wait for 2 seconds
    Then I click on the Search Button
    Then I should see <valueToFind> in the Type Column
    And I should NOT see <valueNotToFind> in the Type Column
    Then I logout
    Then I should be logged out and on the login page


    Examples:
      | main       | subMenu    | setValue  | valueToFind | valueNotToFind |
      | Operations | Audit Log  | Card      | Card| awesome      |
