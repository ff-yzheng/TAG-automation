@TAG
Feature: SmokeTest

  Background: User logged in
	Given the login form at https://test.transact-global.net/
	When I login as specflowtest with ABCd-1234
	Then I should be authenticated

  @UI @Test @IgnoreForNow
  Scenario: LoginFailure
	Given the login form at https://test.transact-global.net
	When I login as RannnorexAvidiaCRM with wrongpassword
	Then I should see the login failed alert
	And I should be on the login page

  @UI @Test  @IgnoreForNow
  Scenario: LoginSuccess
	When I login as specflowtest with ABCd-1234
	Then I should be authenticated
	When I logout
	Then I should be on the login page

  # For showing 'I navigate to MAIN - SUBMENU'
  Scenario: ShowMenuNavigation
	When I navigate to Security - Users
	Then I wait for 10 seconds
	When I logout
	Then I should be on the login page

  # For showing 'I navigate to MAIN - SUBMENU'
  Scenario: ShowSearching
	When I navigate to Program Management - Companies
	When I search Company Name for ABC Company
	When I execute the search
	Then I wait for 10 seconds
	When I logout
	Then I should be on the login page

Scenario: CheckSuperUserMainMenu
	Then I should see the Program Management menu
	And I should see the Operations menu
	And I should see the Customer Service menu
	And I should see the Security menu
	And I should see the Help menu
	When I logout
	Then I should be on the login page

Scenario: CheckSuperUserPMSubMenu
	Then I should see the Program Management menu
    And I navigate to Program Management - FIs
	And I navigate to Program Management - Partners
	And I navigate to Program Management - Clients
	And I navigate to Program Management - Companies
	When I logout
	Then I should be on the login page

  Scenario: CheckSuperUserOpsSubMenu
    Then I should see the Operations menu
    And I navigate to Operations - Audit Log
    And I navigate to Operations - Card Orders
    And I navigate to Operations - Chargebacks
    And I navigate to Operations - Events
    And I navigate to Operations - Non-Posted Exceptions
    And I navigate to Operations - Financial Audit
    When I logout
    Then I should be on the login page

  Scenario: CheckSuperUserCSSubMenu
    Then I should see the Customer Service menu
    And I navigate to Customer Service - Cards
    And I navigate to Customer Service - Companies
    When I logout
    Then I should be on the login page

  Scenario: CheckSuperUserSecSubMenu
    Then I should see the Security menu
    And I navigate to Security - Roles
    And I navigate to Security - Users
    And I navigate to Security - Settings
    When I logout
    Then I should be on the login page
