@TAG
Feature: Custom role with privileges to View Payment History, Post Payment, Edit Card and View Audit Log


	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as automationUser1 with Abcd-4321
		Then I should be authenticated

	Scenario: CheckUser1MainMenu
		Then I should see the Program Management menu
		And  I should see the Operations menu
		And  I should see the Customer Service menu
		And  I should see the Help menu
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

	Scenario: CheckUser1OpsSubMenu
		When I click on the Operations menu
		Then I should see the Operations - Audit Log submenu
		And  I should see the Operations - Financial Audit submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckUser1CSSubMenu
		When I click on the Customer Service menu
		Then I should see the Customer Service - Cards submenu
		And  I should see the Customer Service - Companies submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckUser1CSCardsTabs
		#Verify all the tabs under card and update Credit Limit and Credit Min field
		When I navigate to Customer Service - Cards
		Then I should see Card Number field
		And  I should see the SEARCH button
		And  I search Card Number for 5476550200019204
		And  I execute the search
		Then I should be on the Setup tab
		And  I should see the Authorizations tab
		And  I should see the Transactions tab
		And  I should see the Notes tab
		And  I should see the Manual Authorization  tab
		And  I should see the Instant Approval tab
		When I should be on the Setup tab
		And  I set Credit Limit Max to 2,000
		And  I set Credit Limit Min to 100.00
        And  I click on SAVE
        Then I should see the message on top "Updates have been saved."
		When I logout
		Then I should be logged out and on the login page

	 Scenario: CheckUser1OpsAuditLogsubmenu
		#Verify Audit Log page captures Credit Limit Max and Credit Limit Min updates

		 When I navigate to Operations - Audit Log
		 Then I should select Card from the DDL for Type
		 And  I search card number  for 5476550200019204
		 And  I execute the search
		 Then I should see Credit Limit Max for 2,000
		 And  I should see Credit Limit Min for 100.00
		 When I logout
		 Then I should be logged out and on the login page

	Scenario: CheckUser1CSCardsTabs
		#Resetting Credit Limit Max and Credit Min value back to what they were

	  	When I navigate to Customer Service - Cards
		And  I search Card Number for 5476550200019204
		And  I execute the search
		Then I should be on the Setup tab
		And  I set Credit Limit Max to 1,000
		And  I set Credit Limit Min to 5.00
		And  I click on SAVE
		Then I should see the message on top "Updates have been saved."
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckUser1CSCompaniesTabs
		#Verify all the tabs under companies and user is able to see Amount field and Submit button under Manual Payment header

		When I navigate to Customer Service - Companies
		Then I should see Company Name field
		And  I should see Company Number field
		And  I should see Partner Name field
		And  I should see Client Name field
		And  I should see the Search button
		When I search Company Number for 0002886
		And  I execute the search
		Then I should see only one record with "Company 1 (WIRE)" for Company Name column
		And  I should see "0002886" for Company Number column
		When I click on "0002886" for Company Number
		Then I should be on the Authorizations tab
		And  I should see the Transactions tab
		And  I should see the Statements tab
		And  I should see the Payments tab
		And  I should see the Notes tab
		When I click on the Payments tab
		Then I should see Amount field
		And  I should see the SUBMIT button
		When I logout
		Then I should be logged out and on the login page

