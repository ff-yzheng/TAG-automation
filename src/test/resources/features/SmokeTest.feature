@TAG
Feature: Login

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

  Scenario: Super user should be able to go through every menu/tab in the home page
	Then I check every page I can find for errors
	When I logout
	Then I should be on the login page
