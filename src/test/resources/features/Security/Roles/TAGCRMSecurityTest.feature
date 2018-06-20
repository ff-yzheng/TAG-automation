@TAG
Feature: TAG CRM Role which has access to all FI-level privileges within the system except adding FIs, BINs, Users, Accessing Reports, Fees, and Reversing & Posting Payment


	Background: User logged in
      Given I navigate to TagUI
      When  I login as TAGCRM
      Then  I should be authenticated

	Scenario: CheckTAGCRMUserMainMenu
		Then I should see the Program Management menu
		And  I should see the Operations menu
		And  I should see the Customer Service menu
		And  I should NOT see the Security menu
		And  I should see the Help menu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckTAGCRMUserPMSubMenu
		When I click on the Program Management menu
		Then I should see the Program Management - FIs submenu
		And  I should NOT see the Program Management - Partners submenu
		And  I should see the Program Management - Clients submenu
		And  I should see the Program Management - Companies submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckTAGCRMUserPMFITabs
		When I navigate to Program Management - FIs
        And  I click on WEX Bank
        Then I should be on the MCC Groups tab
		And  I should see the Authorization Controls tab
		And  I should see the Statements tab
        And  I should NOT see the Setup tab
        And  I should NOT see the BINS tab
        And  I should NOT see the Fees tab
        And  I should NOT see the Reports tab
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckTAGCRMUserOpsSubMenu
		When I click on the Operations menu
		Then I should see the Operations - Audit Log submenu
		And  I should NOT see the Operations - Card Orders submenu
		And  I should see the Operations - Chargebacks submenu
		And  I should NOT see the Operations - Events submenu
		And  I should see the Operations - Non-Posted Exceptions submenu
		And  I should see the Operations - Financial Audit submenu
		When I logout
		Then I should be logged out and on the login page

	Scenario: CheckTAGCRMUserCSSubMenu
		When I click on the Customer Service menu
		Then I should see the Customer Service - Cards submenu
		And  I should see the Customer Service - Companies submenu
		When I logout
		Then I should be logged out and on the login page

