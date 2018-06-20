@TAG
Feature: Search for users

   Background: User logged in
    Given I navigate to TagUI
    When I login as superUser
    Then I should be authenticated

  # For demoing 'I navigate to MAIN - SUBMENU'

  Scenario Outline: ShowSearchResults for Security-Users by Last Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    Then I should see <valueToFind> in the Last Name
    And I should NOT see <valueNotFound> in the Last Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main     | subMenu | searchField | searchValue | valueToFind | valueNotFound |
      | Security | Users   | Last Name   |  Rano       |  Ranorex    | naveed        |
      | Security | Users   | Last Name   |  AOC User   |  AoC USER   | Choi          |
      | Security | Users   | Last Name   |  Choi       |  Choi       | AVIDIA        |

  Scenario Outline: ShowSearchResults for Security-Users by Role Name

    When I navigate to <main> - <subMenu>
    When I set the Role Name dropdown under Sec-Users to <setValue>
    Then I should see <valueToFind> in the Role Name on Users
    And I should NOT see <valueNotFound> in the Role Name on Users
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main     | subMenu | setValue     | valueToFind   | valueNotFound |
      | Security | Users   | CRM          | CRM           | TAG SUPER     |
      | Security | Users   | TAG Super    | TAG Super     | CRM           |
      | Security | Users   | FI Super     | FI SUPER      | Non           |
      | Security | Users   | Wex FI Super | WEX FI SUPER  | TAG QA        |

  Scenario Outline: ShowSearchResults for Security-Users by Owner

    When I navigate to <main> - <subMenu>
    When I set the Owner dropdown under Sec-Users to <setValue>
    Then I should see <valueToFind> in the Owner on Users
    And I should NOT see <valueNotFound> in the Owner on Users
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main     | subMenu | setValue       | valueToFind     | valueNotFound   |
      | Security | Users   | DEMO FI QA     |  dEMo FI Qa     | todd            |
      | Security | Users   | TAG            |  TAG            | nonTAG          |
      | Security | Users   | Avidia Bank QA |  AVIDIA BANk QA | Killer          |
      | Security | Users   | Test Bank      |  TEST bank      | Super FI        |
      | Security | Users   | WEX Bank       |  wex bank       | automation      |

  Scenario Outline: ShowSearchResults for Security-Users by Status

    When I navigate to <main> - <subMenu>
    When I set the Status dropdown under Sec-Users to <setValue>
    Then I should see <valueToFind> in the Status on Users
    And I should NOT see <valueNotFound> in the Status on Users
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main     | subMenu | setValue    | valueToFind     | valueNotFound   |
      | Security | Users   | Inactive    |  Inactive       |  RanorexAOC     |
      | Security | Users   | Active      |  Active         |  Inactive     |