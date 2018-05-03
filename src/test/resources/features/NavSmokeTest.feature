@TAG
  Feature: Nav Smoke Test
    @UI @Test
      Scenario: SuperUserSmokeTest
      Given the login form at https://test.transact-global.net/
      When I login as specflowtest with ABCd-1234
      Then I should be authenticated
      Then I check every page I can find for errors
      When I logout
      Then I should be on the login page