@TAG
Feature: Create A Company

  Background: User logged in
	Given the login form at https://test.transact-global.net/
	#When I login as automationFISUPER with Abcd-4321
    When I login as automationTAGSUPER with Abcd-1234
	Then I should be authenticated

  Scenario Outline: AddNewCompany

	When I navigate to Program Management - Companies
	And I click the Add New button
	Then I should be on the Setup page
	#Next step only needed when logging in as TAGSuper
	When I set the FI Name dropdown to WEX Bank
	And I create a new company with <Client Name>, <Company Name Start>, <Primary Contact>, <Phone Number>, <Address1>, <City>,  <StateProvince>, <Postal Code>, <Tax ID Number>, <Currency>, <BIN>, <Credit Limit>, <Bill Cycle>, <Cycle Day>, <Grace Period>, <Late Fee Percentage>, <International Fee Percentage>, <Statement Template>, <Payment Method>

    Examples:
	  |	Client Name		|	Company Name Start	|	Primary Contact	|	Phone Number	|	Address1		|	City		|	StateProvince	|	Postal Code	|	Tax ID Number	|	Currency	|	BIN		|	Credit Limit	|	Bill Cycle	|	Cycle Day	|	Grace Period	|	Late Fee Percentage	|	International Fee Percentage	|	Statement Template	|	Payment Method	|
	  |	QA USD Client	|	USD Test Company	|	Esmith			|	706-243-6621	|	123 Test Lane	|	Columbus	|	Ohio				|	31904		|	212-05-0518		|	USD			|	520471	|	10000			|	Weekly		|	Tuesday		|	6 Days			|	No Late Fee			|	Waive all Fees					|	WEX Bank AP 2018	|	Check			|

  Scenario: AssignBIN to new company
	When I navigate to Program Management - Companies
	And I search <Company Name for USD Test Company>
	Then I should be on the Credit Limit page


  Scenario: Enter Credit Limit for new company
	Then I see the Program Management – Companies – Credit Limit page
	Then I should be on the Billing Features page


  Scenario: Enter Billing Features new company
	Then I see the Program Management – Companies – Billing Features page
	Then I should be on the Setup page


  Scenario: UpdateCompanyStatus
	Then I see the Program Management – Companies – Setup page
	And I select the Status – Active
	And I click the SAVE button
	Then I should verify data via the Audit Log


	Scenario: VerifyChangesonAuditLog
		Then I see the Operations - Audit Log page
		And I select Type = Company = USD Test Company
	    And I press the SEARCH button
		And I verify changes for USD Test Company
		Then I see all entries for Company = USD Test Company
		Then I logout of TAG

