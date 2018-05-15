@TAG
Feature: SmokeTestUser1

  Background: User logged in
	Given the login form at https://test.transact-global.net/
	When I login as automationWEXRole1 with Abcd-1234
	Then I should be authenticated

  @IgnoreForNow
  Scenario: NavSmokeTestSuperUser
	And I check every page I can find for errors
	When I logout
	Then I should be on the login page

Scenario: CheckUser1MainMenu
	When I should see the Program Management menu
	Then I should see the Operations menu
	And I should see the Customer Service menu
	And I should NOT see the Security menu
	And I should see the Help menu
	When I logout
	Then I should be on the login page

Scenario: CheckUser1PMSubMenu
	When I click on the Program Management menu
    Then I should NOT see the Program Management - FIs submenu
	And I should NOT see the Program Management - Partners submenu
	And I should see the Program Management - Clients submenu
	And I should NOT see the Program Management - Companies submenu
	When I logout
	Then I should be on the login page
