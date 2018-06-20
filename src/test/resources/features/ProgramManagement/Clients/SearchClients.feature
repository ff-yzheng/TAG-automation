@TAG
Feature: Search for Clients

   Background: User logged in
    Given I navigate to TagUI
    When I login as superUser
    Then I should be authenticated

  # For demoing 'I navigate to MAIN - SUBMENU'

  Scenario Outline: ShowSearchResults for PM-Clients by Client Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And I click on Search Button
    Then I should see <valueToFind> in the Client Name
    And I should NOT see <valueNotFound> in the Client Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField  | searchValue | valueToFind | valueNotFound   |
      | Program Management | Clients    | Client Name  |  08222016   |  08222016   | AOC             |
      | Program Management | Clients    | Client Name  |  Client     |  Client     | FTS             |


  Scenario Outline: ShowSearchResults for PM-Clients by Partner Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And I click on Search Button
    Then I should see <valueToFind> in the Partner results
    And I should NOT see <valueNotFound> in the Partner results
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField  | searchValue | valueToFind | valueNotFound   |
      | Program Management | Clients    | Partner Name |  Partner 47 |  Partner 47 | Partner #123456 |


   Scenario Outline: ShowSearchResults for PM-Clients by FI Name

    When I navigate to <main> - <subMenu>
    When I set the FI Name dropdown under PM-Clients to <setValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Clients-FI Name
    And I should NOT see <valueNotFound> in the Clients-FI Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | setValue   | valueToFind | valueNotFound |
      | Program Management | Clients    | FTS        |  FTS        |  08222016     |