@TAG
Feature: Create A Company

  Background: User logged in
	Given I navigate to TagUI
	When I login as FISUPER
	Then I should be authenticated

  Scenario Outline: Add New Company and Verify the Audit Log
	When I navigate to Program Management - Companies
	And I click the Add New button
	Then I should be on the Setup page
	#Do we need to create a new client before this (so it shows in EnCompass as a new client and not adding to existing)
	And I create a new company with <Client Name>, <Company Name Start>, <Primary Contact>, <Phone Number>, <Address1>, <City>,  <StateProvince>, <Postal Code>, <Tax ID Number>, <Currency>, <BIN>, <Credit Limit>, <Bill Cycle>, <Cycle Day>, <Grace Period>, <Late Fee Percentage>, <International Fee Percentage>, <Statement Template>, <Payment Method>
	Then I verify the new company changes in the audit log for <Client Name>, <Company Name Start>, <Primary Contact>, <Phone Number>, <Address1>, <City>,  <StateProvince>, <Postal Code>, <Tax ID Number>, <Currency>, <BIN>, <Credit Limit>, <Bill Cycle>, <Cycle Day>, <Grace Period>, <Late Fee Percentage>, <International Fee Percentage>, <Statement Template>, <Payment Method>
	#Eventually verify the API calls after a new company is activated
	When I logout
	Then I should be logged out and on the login page

	  Examples:
	  |	Client Name		|	Company Name Start	|	Primary Contact	|	Phone Number	|	Address1		|	City		|	StateProvince	|	Postal Code	|	Tax ID Number	|	Currency	|	BIN		|	Credit Limit	|	Bill Cycle	|	Cycle Day	|	Grace Period	|	Late Fee Percentage	|	International Fee Percentage	|	Statement Template	|	Payment Method	|
	  |	QA USD Auto		|	USD Test Company	|	Esmith			|	706-243-6621	|	123 Test Lane	|	Columbus	|	Ohio			|	31904		|	212-05-0518		|	USD			|	520471	|	10000			|	Weekly		|	Tuesday		|	6 days			|	No Late Fee			|	Waive all Fees					|	WEX Bank AP 2018	|	Check			|

  Scenario: Activate & setup a company in EnCompass
    This scenario is designed to run on a company which was just created and activated in Transact Global
    When I open EnCompass
    And I login to EnCompass as a SuperUser
    And I search for company number X in Encompass Select Org Group
    Then I set up the company in EnCompass
    And I navigate to Super Admin Accounts Payable in EnCompass
    And I search for company number X in EnCompass Super Admin
    And I activate AP for the company in EnCompass
    And I create inventory for the company in EnCompass
    # Run the JTA Card Order or let it run on its own (hourly)?
    And I close EnCompass


