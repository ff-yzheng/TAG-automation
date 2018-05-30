@TAG
Feature: Create A Company

  Background: User logged in
	Given the login form at https://test.transact-global.net/
	#When I login as automationFISUPER with Abcd-4321
    When I login as automationTAGSUPER with Abcd-1234
	Then I should be authenticated

  Scenario Outline: Add New Company and Verify the Audit Log
	When I navigate to Program Management - Companies
	And I click the Add New button
	Then I should be on the Setup page
	#Next step only needed when logging in as TAGSuper
	When I set the FI Name dropdown to WEX Bank
	And I create a new company with <Client Name>, <Company Name Start>, <Primary Contact>, <Phone Number>, <Address1>, <City>,  <StateProvince>, <Postal Code>, <Tax ID Number>, <Currency>, <BIN>, <Credit Limit>, <Bill Cycle>, <Cycle Day>, <Grace Period>, <Late Fee Percentage>, <International Fee Percentage>, <Statement Template>, <Payment Method>
	#Then I verify the new company changes in the audit log for <Client Name>, <Company Name Start>, <Primary Contact>, <Phone Number>, <Address1>, <City>,  <StateProvince>, <Postal Code>, <Tax ID Number>, <Currency>, <BIN>, <Credit Limit>, <Bill Cycle>, <Cycle Day>, <Grace Period>, <Late Fee Percentage>, <International Fee Percentage>, <Statement Template>, <Payment Method>
	#Eventually verify the API calls after a new company is activated
	When I logout
	Then I should be logged out and on the login page

	  Examples:
	  |	Client Name		|	Company Name Start	|	Primary Contact	|	Phone Number	|	Address1		|	City		|	StateProvince	|	Postal Code	|	Tax ID Number	|	Currency	|	BIN		|	Credit Limit	|	Bill Cycle	|	Cycle Day	|	Grace Period	|	Late Fee Percentage	|	International Fee Percentage	|	Statement Template	|	Payment Method	|
	  |	QA USD Client	|	USD Test Company	|	Esmith			|	706-243-6621	|	123 Test Lane	|	Columbus	|	Ohio			|	31904		|	212-05-0518		|	USD			|	520471	|	10000			|	Weekly		|	Tuesday		|	6 days			|	No Late Fee			|	Waive all Fees					|	WEX Bank AP 2018	|	Check			|
