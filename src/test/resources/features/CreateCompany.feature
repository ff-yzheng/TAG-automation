@TAG
Feature: Create A Company

  Background: User logged in
	Given the login form at https://test.transact-global.net/
	When I login as wexeula with Abcd-1234
	Then I should be authenticated

  Scenario: AddNewCompanyMainMenu
	Then I should see the Program Management menu
	And I should see the Program Management – Companies submenu
	Then I click on the Add New button
	And I should see the Program Management – Companies – Setup page
	Then I should select the FI Name – WEX Bank
	Then I should select the Client Name – QA USD Client
	Then I should enter the Company Name –  USD Test Company
	Then I should enter the Enter Primary Contact – Esmith
	Then I should enter the Enter Phone Number – 706-243-6621
	Then I should enter the Address 1 – 123 Test Lane
	Then I should enter the City – Columbus
	Then I should enter the State/Province – Georgia
	Then I should enter the Postal Code – 31904
	Then I should enter the Tax ID Number – 212-05-0518
	Then I should click the SAVE button
	Then I should see the company number and new tabs on the page
	Then I should be on the BINS page0





  Scenario: AssignBIN to new company
	Then I should see the Program Management – Companies – BINs page
	Then I should select the Scheme – MasterCard or Visa
	Then I should select the Currency – USD
	Then I should select the BIN – 520471
	Then I should click the SAVE button
	Then I should be on the Credit Limit page

  Scenario: Enter Credit Limit for new company
	Then I should see the Program Management – Companies – Credit Limit page
	Then I should enter the Credit Limit Amount – 10000.00
	Then I should click the SAVE button
	Then I should be on the Billing Features page

  Scenario: Enter Billing Features new company
	Then I should see the Program Management – Companies – Billing Features page
	Then I should select the Bill Cycle – Weekly
	Then I should select the Cycle Day – Tuesday
	Then I should select the Grace Period – 6 Days
	Then I should select the Late Fee Percentage – No Late Fee
	Then I should select the International Fee Percentage – Waive All Fees
	Then I should select the Statement Template – WEX Bank AP
	Then I should select the Payment Method – Check
	Then I should click the SAVE button
	Then I should be on the Setup page

  Scenario: UpdateCompanyStatus
	And I should see the Program Management – Companies – Setup page
	Then I should select the Status – Active
	Then I should click the SAVE button
	When I logout
	Then I should be on the login page

