@TAG
Feature: Search for Roles

   Background: User logged in
    Given I navigate to TagUI
    When I login as superUser
    Then I should be authenticated

  # For demoing 'I navigate to MAIN - SUBMENU'

  Scenario Outline: ShowSearchResults for Security-Roles by Role Name

    When I navigate to <main> - <subMenu>
    When I set the Role Name dropdown under Sec-Roles to <setValue>
    Then I should see <valueToFind> in the Role Name
    And I should NOT see <valueNotFound> in the Role Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main     | subMenu | setValue    | valueToFind  | valueNotFound |
      | Security | Roles   | Killer Role |  KiLLer RoLe | 49er Role     |

  Scenario Outline: ShowSearchResults for Security-Roles by Owner

    When I navigate to <main> - <subMenu>
    When I set the Owner dropdown under Sec-Roles to <setValue>
    Then I should see <valueToFind> in the Owner
    And I should NOT see <valueNotFound> in the Owner
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main     | subMenu | setValue       | valueToFind     | valueNotFound   |
      | Security | Roles   | TAG            |  TAG            | Avidia Bank QA  |
      | Security | Roles   | Avidia Bank QA |  Avidia Bank QA | TAG             |