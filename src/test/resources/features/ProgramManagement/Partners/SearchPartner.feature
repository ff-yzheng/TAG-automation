@TAG
Feature: Search for Partners

   Background: User logged in
    Given I navigate to TagUI
    When I login as superUser
    Then I should be authenticated

  # For demoing 'I navigate to MAIN - SUBMENU'

  Scenario Outline: ShowSearchResults for PM-Partners by Partner Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    Then I should see <valueToFind> in the Partner Name
    And I should NOT see <valueNotFound> in the search results
    Then I logout
    Then I should be logged out and on the login page

    Examples:
    | main               | subMenu    | searchField  | searchValue | valueToFind | valueNotFound |
    | Program Management | Partners   | Partner Name |  partner    |  partner    | awesome       |
    | Program Management | Partners   | Partner Name |  partner    |  9091       | 333e          |
    | Program Management | Partners   | Partner Name |  Awesome    |  Awesome    | Partners      |
    | Program Management | Partners   | Partner Name |  Awesome    |  ESmith     | NZ            |


  Scenario Outline: ShowSearchResults for PM-Partners by FI Name

    When I navigate to <main> - <subMenu>
    When I set the FI Name dropdown under PM-Partners to <setValue>
    Then I should see <valueToFind> in the FI Name
    And I should NOT see <valueNotFound> in the FI Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | setValue   | valueToFind | valueNotFound |
      | Program Management | Partners   | DEMO FI QA |  DEMO FI QA | Avidia Bank QA|
      | Program Management | Partners   | DEMO FI QA |  Jordan Partners of CAN | Smith FI|

