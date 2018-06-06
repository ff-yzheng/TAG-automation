Feature: Create Auth and Transaction in Test Harness
  Scenario: UseTestHarnessPOC
    Proof of Concept work for using Test Harness
    Given the login form at https://test.transact-global.net/
    And I open TestHarness
    When I set the environment to test and name to JavaAutomation
    And I set the auth file path to C:\Users\Todd.Gagel\Desktop\temp\TestHarnessAuthFile_copy.xlsx and upload
    And I run authorizations on the TestHarnessAuthFile_copy.xlsx auth file
    And I download the transaction file
    And I set the transaction file path and upload
    Then I close the TestHarness