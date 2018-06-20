@TAG
Feature: SmokeTest

  Background: User logged in
    Given I navigate to TagUI
    When I login as superUser
    Then I should be authenticated


  Scenario Outline: ShowSearchResults for Ops-Audit by Type

    When I navigate to <main> - <subMenu>
    When I set the Type dropdown to <setValue>
    Then I click on the Search Button
    Then I should see <valueToFind> in the Type Column
    And I should NOT see <valueNotToFind> in the Type Column
    Then I logout
    Then I should be logged out and on the login page


    Examples:
      | main       | subMenu    | setValue  | valueToFind | valueNotToFind |
      | Operations | Audit Log  | FI        | FI          | Client         |
      | Operations | Audit Log  | Partner   | Partner     | FI             |
      | Operations | Audit Log  | Client    | Client      | Final Status   |
      | Operations | Audit Log  | Company   | Company     | awesome        |
      | Operations | Audit Log  | 1st Chargeback       | 1st Chargeback         | Client         |
      | Operations | Audit Log  | 2nd Presentment      | 2nd Presentment        | Partner        |
      | Operations | Audit Log  | 2nd Chargeback       | 2nd Chargeback         | awesome        |
      | Operations | Audit Log  | Retrieval Request    | Retrieval Request      | Partner        |
      | Operations | Audit Log  | Non-Posted Exception | Non-Posted Exception   | Partner        |
      | Operations | Audit Log  | Arbitration          | Arbitration            | Partner        |

  Scenario Outline: ShowSearchResults for Ops-Audit by Username

    When I navigate to <main> - <subMenu>
    When I set the username to <setValue>
    Then I click on the Search Button
    Then I should see <valueToFind> in the Username Column
    And  I should NOT see <valueNotToFind> in the Username Column
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main       | subMenu    | setValue  | valueToFind | valueNotToFind |
      | Operations | Audit Log  | ww        | wwinters    | system         |
      | Operations | Audit Log  | ranorexa  | RanorexAOC  | system         |
      | Operations | Audit Log  | kpowell   | kpowell     | wwinters       |


  Scenario Outline: ShowSearchResults for Ops-Audit by ToDate

    When I navigate to <main> - <subMenu>
    When I set the To Date to <setValue>
    Then I click on the Search Button
    Then I should see <valueToFind> in the Date/Time Column
    And  I should NOT see <valueNotToFind> in the Date/Time Column
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main       | subMenu    | setValue   | valueToFind | valueNotToFind |
      | Operations | Audit Log  | 12/02/2017 | 12/02/2017  | 06/18/2018     |
      | Operations | Audit Log  | 12/01/2017 | 12/01/2017  | 06/18/2099     |
