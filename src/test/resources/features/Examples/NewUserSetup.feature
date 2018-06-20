Feature: New Automation User Setup

# Steps to create a new user to use in automation
# - Create the user in TAG as you normally would
# - Manually login as the user to change the password
# - Update user info in the SettingUpNewUser scenario
# - Run and complete user MFA during the wait time
# - Dev will need modify the MFA check flag in Mongo to false
# - Automation should then be able log in as the user via the login steps
  @IgnoreForNow
  Scenario: SettingUpNewUser
	Given I navigate to TagUI
	When I login as NEWUSERNAME with PASSWORD
	Then I wait for 120 seconds

