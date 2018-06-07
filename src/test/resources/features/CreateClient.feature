@TAG
Feature: Create A Client

  Background: User logged in
    Given the login form at https://test.transact-global.net/
    When I login as wexeula with Abcd-1234
    Then I should be authenticated

  Scenario: AddNewClient
    When I navigate to Program Management-Clients submenu
    When I click on the Add New button
    Then I should be on the Program Management – Clients – Setup page
    When I select the FI Name – WEX Bank
    And I enter the Client Name – ES USD Client
    And I enter the Enter Primary Contact – Esmith
    And I enter the Enter Phone Number – 706-243-6621
    And I enter the Address 1 – 444 Test Lane
    And I enter the City – Columbus
    And I enter the State/Province – Georgia
    And I enter the Postal Code – 31904
    And I enter the Tax ID Number – 606-06-0618
    And I enter the Sales Region - US
    And I click the SAVE button
    Then I should see the client and new tabs on the page

  Background: User logged in
    Given the login form at https://test.transact-global.net/
    When I login as wexeula with Abcd-1234
    Then I should be authenticated

  Scenario: VerifyChangesonAuditLog
    Then I see the Operations - Audit Log page
    And I select Type = Client = ES USD Client
    And I press the SEARCH button
    And I verify changes for ES USD Client
    Then I see all entries for Client = ES USD Client
    Then I logout of TAG