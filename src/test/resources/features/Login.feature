@TAG
Feature: Login
  @UI @Test
  Scenario: LoginFailure
   Given the login form at https://test.transact-global.net
   When I login as RannnorexAvidiaCRM with wrongpassword
   Then I should see the login failed alert
   And I should be on the login page

  @UI @Test
  Scenario: LoginSuccess
    Given the login form at https://test.transact-global.net/
    When I login as specflowtest with ABCd-1234
    Then I should be authenticated
    When I logout
    Then I should be on the login page

  Scenario: SettingUpNewUsers
    Given the login form at https://test.transact-global.net/
    When I login as automationWEXRole1 with Abcd-1234
    #When I login as specflowtest with ABCd-1234
    Then I wait for 120 seconds
# Need to login manually 1 time to change the password
# then run the script and complete MFA during the wait time
# then dev will need to update the user mfa entry in Mongo
# then automation should be able to log in to use it