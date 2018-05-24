@TAG
Feature: Create A Company

  Background: User logged in
	Given the login form at https://test.transact-global.net/
	When I login as wexeula with Abcd-1234
	Then I should be authenticated

  Scenario: AddNewCompany
	When I navigate to Program Management-Companies submenu
	When I click on the Add New button
	Then I should be on the Program Management – Companies – Setup page
	When I select the FI Name – WEX Bank
	And I select the Client Name – QA USD Client
	And I enter the Company Name –  USD Test Company
	And I enter the Enter Primary Contact – Esmith
	And I enter the Enter Phone Number – 706-243-6621
	And I enter the Address 1 – 123 Test Lane
	And I enter the City – Columbus
	And I enter the State/Province – Ohio
	And I enter the Postal Code – 31904
	And I enter the Tax ID Number – 212-05-0518
	And I click the SAVE button
	Then I should see the company number and new tabs on the page


	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as wexeula with Abcd-1234
		Then I should be authenticated


  Scenario: AssignBIN to new company
	When I navigate to Program Management – Companies
	And I search <Company Name for USD Test Company>
	Then I should see the Currency – USD
	And I select the BIN – 520471
	And I click the SAVE button
	Then I should be on the Credit Limit page



	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as wexeula with Abcd-1234
		Then I should be authenticated

  Scenario: Enter Credit Limit for new company
	Then I see the Program Management – Companies – Credit Limit page
	And I enter the Credit Limit Amount – 10000.00
	And I click the SAVE button
	Then I should be on the Billing Features page


	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as wexeula with Abcd-1234
		Then I should be authenticated


  Scenario: Enter Billing Features new company
	Then I see the Program Management – Companies – Billing Features page
	And I select the Bill Cycle – Weekly
    And I select the Cycle Day – Tuesday
	And I select the Grace Period – 6 Days
	And I select the Late Fee Percentage – No Late Fee
	And I select the International Fee Percentage – Waive All Fees
	And I select the Statement Template – WEX Bank AP
	And I select the Payment Method – Check
	And I click the SAVE button
	Then I should be on the Setup page

	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as wexeula with Abcd-1234
		Then I should be authenticated

  Scenario: UpdateCompanyStatus
	Then I see the Program Management – Companies – Setup page
	And I select the Status – Active
	And I click the SAVE button
	Then I should verify data via the Audit Log

	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as wexeula with Abcd-1234
		Then I should be authenticated

	Scenario: VerifyChangesonAuditLog
		Then I see the Operations - Audit Log page
		And I select Type = Company = USD Test Company
	    And I press the SEARCH button
		And I verify changes for USD Test Company
		Then I see all entries for Company = USD Test Company
		Then I logout

