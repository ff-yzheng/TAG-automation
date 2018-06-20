@TAG
Feature: SmokeTestUser1

  Background: User logged in
	Given I navigate to TagUI
	When I login as User1
	Then I should be authenticated

  @IgnoreForNow
  Scenario: NavSmokeTestSuperUser
	And I check every page I can find for errors
	When I logout
	Then I should be logged out and on the login page

Scenario: CheckUser1MainMenu
	When I should see the Program Management menu
	Then I should see the Operations menu
	And I should see the Customer Service menu
	And I should NOT see the Security menu
	And I should see the Help menu
	When I logout
	Then I should be logged out and on the login page

Scenario: CheckUser1PMSubMenu
	When I click on the Program Management menu
    Then I should NOT see the Program Management - FIs submenu
	And I should NOT see the Program Management - Partners submenu
	And I should see the Program Management - Clients submenu
	And I should NOT see the Program Management - Companies submenu
	When I logout
	Then I should be logged out and on the login page
