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

  Scenario: UseTestHarnessPOC
    Proof of Concept work for using Test Harness
    Given the login form at https://test.transact-global.net/
    Given I open TestHarness
    When I set the environment to test and name to JavaAutomation
    When I set the auth file path to C:\Users\Todd.Gagel\Desktop\temp\TestHarnessAuthFile_copy.xlsx and upload
    When I run authorizations on the TestHarnessAuthFile_copy.xlsx auth file
    When I download the transaction file
    When I set the transaction file path and upload
    Then I close the TestHarness

    Scenario: Ying's test for pull request code review

  Scenario: CreateCompanyPrework
    Given the login form at https://test.transact-global.net/
    When I login as automationTAGSUPER with Abcd-1234
    Then I should be authenticated
    When I navigate to Program Management - Companies
    When I click the Add New button
    When I create a new company
    Then I wait for 10 seconds
