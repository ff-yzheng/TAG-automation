@TAG
Feature: Partner Super Role which has access to all FI-level privileges within the system except FI and Client submenu


	Background: User logged in
		Given the login form at https://test.transact-global.net/
		When I login as automationPartnerSuper with Abcd-4321
		Then I should be authenticated

	Scenario: CheckPartnerSuperUserMainMenu
		Then I should see the Program Management menu
		And  I should see the Operations menu
		And  I should see the Customer Service menu
		And  I should not see the Security menu
		And  I should see the Help menu
		When I logout
		Then I should be on the login page

	Scenario: CheckPartnerSuperUserPMSubMenu
		When I click on the Program Management menu
		Then I should not see the Program Management - FIs submenu
		And  I should not see the Program Management - Partners submenu
		And  I should not see the Program Management - Clients submenu
		And  I should see the Program Management - Companies submenu
		When I logout
		Then I should be on the login page

	Scenario: CheckPartnerSuperMUserOpsSubMenu
		When I click on the Operations menu
		Then I should see the Operations - Audit Log submenu
		And  I should not see the Operations - Card Orders submenu
		And  I should see the Operations - Chargebacks submenu
		And  I should not see the Operations - Events submenu
		And  I should see the Operations - Non-Posted Exceptions submenu
		And  I should see the Operations - Financial Audit submenu
		When I logout
		Then I should be on the login page

	Scenario: CheckPartnerSuperMUserCSSubMenu
		When I click on the Customer Service menu
		Then I should see the Customer Service - Cards submenu
		And  I should see the Customer Service - Companies submenu
		When I logout
		Then I should be on the login page

