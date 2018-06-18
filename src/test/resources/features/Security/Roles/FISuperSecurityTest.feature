@TAG
Feature: FI Super Role which has access to all FI-level privileges within the system except adding FIs and BINs


	Background: User logged in
		Given I login TagUI
		When  I login as FISUPER
		Then  I should be authenticated

	Scenario: CheckFISuperUserMainMenu
		Then I should see the Program Management menu
		And  I should see the Operations menu
		And  I should see the Customer Service menu
		And  I should see the Security menu
		And  I should see the Help menu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckFISuperUserPMSubMenu
		When I click on the Program Management menu
		Then I should see the Program Management - FIs submenu
		And  I should NOT see the Program Management - Partners submenu
		And  I should see the Program Management - Clients submenu
		And  I should see the Program Management - Companies submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckFISuperUserPMFITabs
		When I navigate to Program Management - FIs
		Then I should be on the Setup tab
		And  I should see the BINs tab
		And  I should see the MCC Groups tab
		And  I should see the Authorization Controls tab
		And  I should see the Statements tab
		And  I should see the Fees tab
		And  I should see the Reports tab
		When I click on the BINs tab
		Then I should NOT see the ADD New button
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckFISuperUserOpsSubMenu
		When I click on the Operations menu
		Then I should see the Operations - Audit Log submenu
		And  I should NOT see the Operations - Card Orders submenu
		And  I should see the Operations - Chargebacks submenu
		And  I should NOT see the Operations - Events submenu
		And  I should see the Operations - Non-Posted Exceptions submenu
		And  I should see the Operations - Financial Audit submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckFISuperUserOpsChargebackTabs
		When I navigate to Operations - Chargebacks
		Then I should be on the 1st Chargeback tab
		And  I should see the 2nd Presentment tab
		And  I should see the 2nd Chargeback tab
		And  I should see the Arbitration tab
		And  I should see the Closed tab
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckFISuperUserOpsNonPostedExceptionTabs
		When I navigate to Operations - Non-Posted Exceptions
		Then I should be on the Current NPEs tab
		And  I should see the Closed NPEs tab
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckFISuperUserCSSubMenu
		When I click on the Customer Service menu
		Then I should see the Customer Service - Cards submenu
		And  I should see the Customer Service - Companies submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckFISuperUserSecSubMenu
		When I click on the Security menu
		Then I should see the Security - Roles submenu
		And  I should see the Security - Users submenu
		And  I should see the Security - Settings submenu
		When I logout
		Then I should be logged out and on the login page
