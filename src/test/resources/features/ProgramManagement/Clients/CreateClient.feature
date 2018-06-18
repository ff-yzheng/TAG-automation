@TAG
Feature: Create A Client

  Background: User logged in
  Given I navigate to TagUI
	#When I login as automationFISUPER with Abcd-1234
  When I login as superUser
  Then I should be authenticated

  Scenario Outline: Add New Client and Verify the Audit Log
    When I navigate to Program Management - Clients
    And I click the Add New button
    Then I should be on the Setup page
	#Next step only needed when logging in as TAGSuper
    When I set the FI Name dropdown to WEX Bank
	And I create a new client with <Client Name>, <Primary Contact>, <Phone Number>, <Address1>, <City>,  <StateProvince>, <Postal Code>, <Tax ID Number>, <Sales Region>
    Then I verify the new client changes in the audit log for <Client Name>, <Primary Contact>, <Phone Number>, <Address1>, <City>,  <StateProvince>, <Postal Code>, <Tax ID Number>, <Sales Region>
	#Eventually verify the API calls after a new company is activated
    When I logout
    Then I should be logged out and on the login page

    Examples:
      |	Client Name		|	Primary Contact	|	Phone Number	|	Address1		|	City		|	StateProvince	|	Postal Code	|	Tax ID Number	|
      |	ES USD Client	|	Esmith	        |	706-243-6621	|	444 Test Lane	|	Columbus	|	Georgia			|	31904		|	212-05-0518		|


