Feature: Navigation Examples

  Background: User logged in
	Given the login form at https://test.transact-global.net/
	When I login as automationTAGSUPER with Abcd-1234
	Then I should be authenticated

  # For demoing 'I navigate to MAIN - SUBMENU'
  Scenario: ShowMenuNavigation
	When I navigate to Security - Users
	Then I wait for 10 seconds
	When I logout
    Then I should be logged out and on the login page

  # For demoing 'I search SEARCHFIELD for SEARCHVALUE'
  Scenario: ShowSearching
	When I navigate to Program Management - Companies
	When I search Company Name for ABC Company
	When I execute the search
	Then I wait for 10 seconds
	When I logout
	Then I should be logged out and on the login page