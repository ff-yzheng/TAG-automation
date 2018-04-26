@TAG
Feature: Login
  #@UI @Test:TAGStartupData
  #Scenario: LoginFailure
		#Given the login form at https://test.transact-global.net
   # Given the login form at [%Startup:TAGOpen~URL%]
   # When I login as RannnorexAvidiaCRM with wrongpassword
   # Then I should see the login failed alert
   # And I should be on the login page

  @UI @Test
  Scenario: LoginSuccess
    Given the login form at https://test.transact-global.net/
    When I login as username with password
    #Then I should be authenticated
    #When I logout
    #Then I should be on the login page