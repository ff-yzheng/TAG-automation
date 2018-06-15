Feature: New Automation User Setup

# Steps to create a new user to use in automation
# - Create the user in TAG as you normally would
# - Manually login as the user to change the password
# - Update user info in the SettingUpNewUser scenario
# - Run and complete user MFA during the wait time
# - Dev will need modify the MFA check flag in Mongo to false
# - Automation should then be able log in as the user via the login steps
  Scenario: SettingUpNewUser
    Given the login form at https://test.transact-global.net/
    When I login as automationFISUPER with Abcd-5321
    #When I login as specflowtest with ABCd-1234
    Then I wait for 120 seconds

