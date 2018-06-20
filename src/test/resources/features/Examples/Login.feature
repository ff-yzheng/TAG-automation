Feature: Login

  @IgnoreForNow
  Scenario: LoginFailure
	Given I navigate to TagUI
	When I login with a wrong password
	Then I should see the login failed alert
	And I should be logged out and on the login page

  Scenario: LoginSuccess
	Given I navigate to TagUI
	When I login as User1
	Then I should be authenticated
	When I logout
	Then I should be logged out and on the login page
