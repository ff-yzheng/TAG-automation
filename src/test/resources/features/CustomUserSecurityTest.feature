@TAG
Feature:
	1st Iteration: User1 which is assigned a custom role with privileges to View Payment History, Post Payment, Edit Card and View Audit Log within the system.
	FI Super will log into the system and Edit Automation Custom Role assigned to User1 by removing Post Payment and Edit Card privilege.
	2nd Iteration: User1 will log back in and verify Submit Manual Payment button is no longer available and no longer allowed to edit card

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
		And  I should not see the Program Management - FIs submenu
		And  I should not see the Program Management - Partners submenu
		And  I should not see the Program Management - Clients submenu
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
		And  I should see Search button
		When I enter "5476550200019204" for Card Number field
		And  I click on the SEARCH
		Then I should be on the Setup tab
		And  I should see the Authorizations tab
		And  I should see the Transactions tab
		And  I should see the Notes tab
		And  I should see the Manual Authorization  tab
		And  I should see the Instant Approval tab
		When I am on the Setup tab
		Then I update the
          |Credit Limit Max| |Credit Limit Min|
          | 2,000.00       | |100.00		  |
   		And  I click on the SAVE
		Then I should see the message on top "Updates have been saved."
		When I logout
		Then I should be logged out and on the login page


		#How do I increment the Credit Limit Max and Credit Limit Min whenever the script is run? (Question for Todd)

	 Scenario: CheckUser1OpsAuditLogsubmenu
		#Verify Audit Log page captures Credit Limit Max and Credit Limit Min updates

		 When I navigate to Operations - Audit Log
		 Then I should select Card from the DDL for Type
		 And  I should enter "5476550200019204" for Card Number field
		 And  I click on the SEARCH
		 Then I should see the update for
           |Credit Limit Max| |Credit Limit Min|
           | 2,000.00       | |100.00		   |
		 When I log out
		 Then I should be logged out and on the login page


		 #How do verify the increment in the previous steps is verified on the Audit Log page? (Question for Todd)

	Scenario: CheckUser1CSCompaniesTabs
		#Verify all the tabs under companies and user is see Amount field and Submit button under Manual Payment header

		When I navigate to Customer Service - Companies
		Then I should see Company Name field
		And  I should see Company Number field
		And  I should see Partner Name field
		And  I should see Client Name field
		And  I should see the Search button
		When I enter "0002886" for Company Number field
		And  I click on the SEARCH
		Then I should see only one record with "Company 1 (WIRE)" for Company Name column
		And  I should see "0002886" for Company Number column
		When I click on "0002886" for Company Number
		Then I should be on the Authorizations tab
		And  I should see the Transactions tab
		And  I should see the Statements tab
		And  I should see the Payments tab
		And  I should see the Notes tab
		When I navigate to Payments tab
		Then I should see "Amount" field
		And  I should see "Submit" button
		When I logout
		Then I should be logged out and on the login page

	Scenario: User logged in
			# FI Super logs in and Update the automation Custom role and remove Post Payment and Edit Card privilege

		When I login as automationFISuper with Abcd-4321
		Then I should be authenticated


	Scenario: CheckFISuperUserSecSubMenu
		When I click on the Security menu
		Then I should see the Security - Roles submenu
		And  I should see the Security - Users submenu
		And  I should see the Security - Settings submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckFISuperSecRolesSubMenu
		When I navigate to Security menu - Roles submenu
		And  I select "Automation Custom Role" from the drop down list for Role Name field
		And  I select "Wex Bank" from the drop down list for Owner field
		Then I should see only one record with "Automation Custom Role" for Role Name column
		When I click on "Automation Custom Role"
		Then I should see the Edit Role tab
		When I uncheck Post Payment privilege
		And  I uncheck Edit Card privilege
		When I click on the SAVE
		Then I should see the message on top "Updates have been saved."
		When I logout
		Then I should be logged out and on the login page

	Scenario: User logged in
			# 2nd Iteration:  User1 logs back in and can no longer Edit Card and Post Manual Payment

		When I login as automationUser1 with Abcd-4321
		Then I should be authenticated

	Scenario: CheckUser1CSCardsTabs

		When I navigate to Customer Service - Cards
		Then I should see Card Number field
		And  I should see Search button
		When I enter "5476550200019204" for Card Number field
		And  I click Search button
		Then I should be on the Setup tab
		And  I should see all the fields are greyed out
		And  I should not be able to update Credit Limit Max field
		And  I should not be able to update Credit Limit Min field
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckUser1CSCompaniesTabs

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
		Then I should not see the "Amount" field
		And  I should not see the "Submit" button
		When I logout
		Then I should be logged out and on the login page
