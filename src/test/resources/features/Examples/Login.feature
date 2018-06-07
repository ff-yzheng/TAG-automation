Feature: Login
  Scenario: LoginFailure
   Given the login form at https://test.transact-global.net
   When I login as RannnorexAvidiaCRM with wrongpassword
   Then I should see the login failed alert
   And I should be logged out and on the login page

  Scenario: LoginSuccess
    Given the login form at https://test.transact-global.net/
    When I login as specflowtest with ABCd-1234
    Then I should be authenticated
    When I logout
    Then I should be logged out and on the login page
