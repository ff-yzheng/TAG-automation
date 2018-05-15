@TAG
Feature: SmokeTest

  Background: User logged in
	Given the login form at https://test.transact-global.net/
	When I login as automationTAGSUPER with Abcd-1234
	Then I should be authenticated

  @IgnoreForNow
  Scenario: NavSmokeTestSuperUser
	And I check every page I can find for errors
	When I logout
	Then I should be on the login page

  # For demoing 'I navigate to MAIN - SUBMENU'
  Scenario: ShowMenuNavigation
	When I navigate to Security - Users
	Then I wait for 10 seconds
	When I logout
	Then I should be on the login page

  # For demoing 'I search SEARCHFIELD for SEARCHVALUE'
  Scenario: ShowSearching
	When I navigate to Program Management - Companies
	When I search Company Name for ABC Company
	When I execute the search
	Then I wait for 10 seconds
	When I logout
	Then I should be on the login page

Scenario: CheckSuperUserMainMenu
	When I should see the Program Management menu
	Then I should see the Operations menu
	And I should see the Customer Service menu
	And I should see the Security menu
	And I should see the Help menu
	When I logout
	Then I should be on the login page

Scenario: CheckSuperUserPMSubMenu
	When I click on the Program Management menu
    Then I should see the Program Management - FIs submenu
	And I should see the Program Management - Partners submenu
	And I should see the Program Management - Clients submenu
	And I should see the Program Management - Companies submenu
	When I logout
	Then I should be on the login page

  Scenario: CheckSuperUserOpsSubMenu
    When I click on the Operations menu
    Then I should see the Operations - Audit Log submenu
    And I should see the Operations - Card Orders submenu
    And I should see the Operations - Chargebacks submenu
    And I should see the Operations - Events submenu
    And I should see the Operations - Non-Posted Exceptions submenu
    And I should see the Operations - Financial Audit submenu
    When I logout
    Then I should be on the login page

  Scenario: CheckSuperUserCSSubMenu
    When I click on the Customer Service menu
    Then I should see the Customer Service - Cards submenu
    And I should see the Customer Service - Companies submenu
    When I logout
    Then I should be on the login page

  Scenario: CheckSuperUserSecSubMenu
    When I click on the Security menu
    Then I should see the Security - Roles submenu
    And I should see the Security - Users submenu
    And I should see the Security - Settings submenu
    When I logout
    Then I should be on the login page
