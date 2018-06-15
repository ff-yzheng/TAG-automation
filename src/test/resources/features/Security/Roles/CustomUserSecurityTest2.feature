@TAG
Feature: Custom role without privileges to Post Payment and Edit Card

	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as automationUser2 with Abcd-4321
		Then I should be authenticated

	Scenario: CheckUser1MainMenu
		Then I should see the Program Management menu
		And  I should see the Customer Service menu
		And  I should see the Help menu
		And  I should NOT see the Operations menu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckUser1PMSubMenu
		When I click on the Program Management menu
		Then I should see the Program Management - Companies submenu
		And  I should NOT see the Program Management - FIs submenu
		And  I should NOT see the Program Management - Partners submenu
		And  I should NOT see the Program Management - Clients submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckUser1CSSubMenu
		When I click on the Customer Service menu
		Then I should see the Customer Service - Cards submenu
		And  I should see the Customer Service - Companies submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckUser1CSCardsTabs
		#Verify user is unable to set Credit Limit Max and Credit Limit Min field

		When I navigate to Customer Service - Cards
		Then I should see Card Number field
		And  I should see the SEARCH button
		And  I search Card Number for 5476550200019204
		And  I execute the search
		Then I should be on the Setup tab
		And  I should not be able to set Credit Limit Max
		And  I should not be able to set Credit Limit Min
		When I logout
		Then I should be logged out and on the login page


	Scenario: CheckUser1CSCompaniesTabs
		#Verify user is unable to see Amount field and Submit button under Manual Payment header

		When I navigate to Customer Service - Companies
		Then I should see Company Name field
		And  I should see Company Number field
		And  I should see Partner Name field
		And  I should see Client Name field
		And  I should see the Search button
		When I enter "0002886" for Company Number field
		And  I Click on the SEARCH
		Then I should see only one record with "Company 1 (WIRE)" for Company Name column
		And  I should see "0002886" for Company Number column
		When I click on "0002886" for Company Number
		Then I should be on the Authorizations tab
		And  I should see the Transactions tab
		And  I should see the Statements tab
		And  I should see the Payments tab
		And  I should see the Notes tab
        When I navigate to Payments tab
		Then I should NOT see the Amount field
		And  I should NOT see the Submit button
		When I logout
		Then I should be logged out and on the login page






