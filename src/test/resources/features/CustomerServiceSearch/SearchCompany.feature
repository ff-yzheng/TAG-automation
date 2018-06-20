@TAG
Feature: Search in CustomerService a Company

   Background: User logged in
    Given I navigate to TagUI
    When I login as superUser
    Then I should be authenticated

  Scenario Outline: ShowSearchResults for CS-Companies by Company Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Company Name
    And I should NOT see <valueNotFound> in the Companies-Company Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main             | subMenu    | searchField   | searchValue | valueToFind | valueNotFound |
      | Customer Service | Companies  | Company Name  |  101816     |  101816     | 201609        |
      | Customer Service | Companies  | Company Name  |  101816     |  COKKS      | Galaxy        |
      | Customer Service | Companies  | Company Name  |  101816     |  KKCO       | 0002276       |
      | Customer Service | Companies  | Company Name  |  2016       |  2016       | 0001270       |

  Scenario Outline: ShowSearchResults for CS-Companies by Company Number

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Company Number
    And I should NOT see <valueNotFound> in the Companies-Company Number
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main             | subMenu    | searchField     | searchValue | valueToFind  | valueNotFound          |
      | Customer Service | Companies  | Company Number  |  0001249    |  0001249     | 101816 - KKCO          |
      | Customer Service | Companies  | Company Number  |  000123     |  0001231     | Todd Script Test 201611|

  Scenario Outline: ShowSearchResults for CS-Companies by FI Name

    When I navigate to <main> - <subMenu>
    When I set the FI Name dropdown under CS-Companies to <setValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-FI Name
    And I should NOT see <valueNotFound> in the Companies-FI Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | setValue   |  valueToFind  | valueNotFound  |
      | Customer Service   | Companies  | Test Bank  |  TESt bANK    | 101816 - COKKs |
      | Customer Service   | Companies  | FTS        |  FTS          | Avidia Bank QA |
      | Customer Service   | Companies  | DEMO FI QA |  DEMO FI QA   | Test Bank      |

  Scenario Outline: ShowSearchResults for CS-Companies by Partner Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Partner Name
    And I should NOT see <valueNotFound> in the Companies-Partner Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField   | searchValue | valueToFind | valueNotFound  |
      | Customer Service   | Companies  | Partner Name  |  Partner 47 |  Partner 47 | N/A            |
      | Customer Service   | Companies  | Partner Name  |  Partner 47 |  ParTneR 47 | Partner #123456|

  Scenario Outline: ShowSearchResults for CS-Companies by Client Name

    When I navigate to <main> - <subMenu>
    And I search <searchField> for <searchValue>
    And  I click on Search Button
    Then I should see <valueToFind> in the Companies-Client Name
    And I should NOT see <valueNotFound> in the Companies-Client Name
    Then I logout
    Then I should be logged out and on the login page

    Examples:
      | main               | subMenu    | searchField   | searchValue | valueToFind          | valueNotFound  |
      | Customer Service   | Companies  | Client Name   |  08222016   |  08222016            | 0001249        |
      | Customer Service   | Companies  | Client Name   |  08222016   |  08222016            | Galaxy         |
      | Customer Service   | Companies  | Client Name   |  G          |  Galaxy International| 08222016       |
      | Customer Service   | Companies  | Client Name   |  G          |  gCL Inc             | Woodrow BBQ    |