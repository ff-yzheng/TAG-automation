@TAG
Feature: Search for Companies

   Background: User logged in
    Given I navigate to TagUI
    When I login as superUser
    Then I should be authenticated

  # For demoing 'I navigate to MAIN - SUBMENU'

  Scenario Outline: ShowSearchResults for PM-Companies by Company Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Company Name
    And I should NOT see <valueNotFound> in the Companies-Company Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField  | searchValue | valueToFind | valueNotFound |
      | Program Management | Companies  | Company Name |  101816     |  101816     | 201609        |
      | Program Management | Companies  | Company Name |  101816     |  KKCO       | 000227        |
      | Program Management | Companies  | Company Name |  2016       |  2016       | 0001270       |

  Scenario Outline: ShowSearchResults for PM-Companies by Company Number

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Company Number
    And I should NOT see <valueNotFound> in the Companies-Company Number
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField   | searchValue | valueToFind | valueNotFound          |
      | Program Management | Companies  | Company Number|  0001249    |  0001249    | 101816 - KKCO          |
      | Program Management | Companies  | Company Number|  000123     |  000123     | Todd Script Test 201611|

  Scenario Outline: ShowSearchResults for PM-Companies by Partner Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Partner Name
    And I should NOT see <valueNotFound> in the Companies-Partner Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField   | searchValue | valueToFind | valueNotFound  |
      | Program Management | Companies  | Partner Name  |  Partner 47 |  Partner 47 | N/A            |
      | Program Management | Companies  | Partner Name  |  PArTner 47 |  Partner 47 | Partner #123456|

  Scenario Outline: ShowSearchResults for PM-Companies by Client Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Client Name
    And I should NOT see <valueNotFound> in the Companies-Client Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField   | searchValue | valueToFind          | valueNotFound  |
      | Program Management | Companies  | Client Name   |  08222016   |  08222016            | 0001249        |
      | Program Management | Companies  | Client Name   |  08222016   |  08222016            | Galaxy         |
      | Program Management | Companies  | Client Name   |  G          |  Galaxy International| 08222016       |
      | Program Management | Companies  | Client Name   |  G          |  gCL Inc             | Woodrow BBQ    |

  Scenario Outline: ShowSearchResults for PM-Companies by FI Name

    When I navigate to <main> - <subMenu>
    When I set the FI Name dropdown under PM-Companies to <setValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-FI Name
    And I should NOT see <valueNotFound> in the Companies-FI Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | setValue   |  valueToFind  | valueNotFound  |
      | Program Management | Companies  | FTS        |  FTS          | Avidia Bank QA |
      | Program Management | Companies  | DEMO FI QA |  DEMO FI QA   | Test Bank      |

  Scenario Outline: ShowSearchResults for PM-Companies by Credit National ID

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Company Number
    And I should NOT see <valueNotFound> in the Companies-Company Number
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField        | searchValue | valueToFind | valueNotFound |
      | Program Management | Companies  | Credit National ID |  99999999   |  0002781    | 0001270       |