Feature: Login
  Scenario: LoginFailure
   Given the login form at https://test.transact-global.net
   When I login as RannnorexAvidiaCRM with wrongpassword
   Then I should see the login failed alert
   And I should be on the login page

  Scenario: LoginSuccess
    Given the login form at https://test.transact-global.net/
    When I login as specflowtest with ABCd-1234
    Then I should be authenticated
    When I logout
    Then I should be on the login page

  Scenario: SettingUpNewUser
    Given the login form at https://test.transact-global.net/
    When I login as automationWEXRole1 with Abcd-1234
    #When I login as specflowtest with ABCd-1234
    Then I wait for 120 seconds
# Steps to create a new user to use in automation
# - Create the user in TAG as you normally would
# - Manually login as the user to change the password
# - Update user info in the SettingUpNewUser scenario
# - Run and complete user MFA during the wait time
# - Dev will need modify the MFA check flag in Mongo from false to true
# - Automation should then be able log in as the user via the login steps

  Scenario: UseTestHarness
    Given the login form at https://test.transact-global.net/
    Given I open the TestHarness
    When I set the auth file path to C:\Users\Todd.Gagel\Desktop\temp\TestHarnessAuthFile_copy.xlsx
    Then I wait for 15 seconds
    Then I close the TestHarness
