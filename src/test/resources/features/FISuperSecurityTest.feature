@TAG
Feature: FI Super Role which has access to all FI-level privileges within the system except adding FIs and BINs


	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as automationFISuper with Abcd-4321
		Then I should be authenticated

	Scenario: CheckFISuperUserMainMenu
		Then I should see the Program Management menu
		And  I should see the Operations menu
		And  I should see the Customer Service menu
		And  I should see the Security menu
		And  I should see the Help menu
		When I logout
		Then I should be on the login page

	Scenario: CheckFISuperUserPMSubMenu
		When I click on the Program Management menu
		Then I should see the Program Management - FIs submenu
		And  I should not see the Program Management - Partners submenu
		And  I should see the Program Management - Clients submenu
		And  I should see the Program Management - Companies submenu
		When I logout
		Then I should be on the login page

	Scenario: CheckFISuperUserPMFITabs
		When I navigate to Program Management - FIs
		Then I should be on the Setup tab
		And  I should see the FIs submenu – BINs tab
		And  I should not see the ADD NEW button
		And  I should see the FIs submenu – MCC Groups
		And  I should see the FIs submenu – Authorization Controls tab
		And  I should see the FIs submenu – Statements tab
		And  I should see the FIs submenu – Fees tab
		And  I should see the FIs submenu – Reports tab
		When I logout
		Then I should be on the login page

	Scenario: CheckFISuperUserOpsSubMenu
		When I click on the Operations menu
		Then I should see the Operations - Audit Log submenu
		And  I should not see the Operations - Card Orders submenu
		And  I should see the Operations - Chargebacks submenu
		And  I should not see the Operations - Events submenu
		And  I should see the Operations - Non-Posted Exceptions submenu
		And  I should see the Operations - Financial Audit submenu
		When I logout
		Then I should be on the login page

	Scenario: CheckFISuperUserOpsChargebackTabs
		When I navigate to Operations - Chargebacks
		Then I should be on 1st Chargeback tab
		And  I should see the Chargebacks submenu – 2nd Presentment tab
		And  I should see the Chargebacks submenu –2nd Chargeback
		And  I should see the Chargebacks submenu – Arbitration tab
		And  I should see the FIs 	Chargebacks submenu – Closed tab
		When I logout
		Then I should be on the login page

	Scenario: CheckFISuperUserOpsNonPostedExceptionTabs
		When I navigate to the Operations – Non-Posted Exceptions
		Then I should be on Current NPEs tab
		And  I should see the Non-Posted Exception submenu – Closed NPEs tab
		When I logout
		Then I should be on the login page

	Scenario: CheckFISuperUserCSSubMenu
		When I click on the Customer Service menu
		Then I should see the Customer Service - Cards submenu
		And  I should see the Customer Service - Companies submenu
		When I logout
		Then I should be on the login page

	Scenario: CheckFISuperUserSecSubMenu
		When I click on the Security menu
		Then I should see the Security - Roles submenu
		And  I should see the Security - Users submenu
		And  I should see the Security - Settings submenu
		When I logout
		Then I should be on the login page
