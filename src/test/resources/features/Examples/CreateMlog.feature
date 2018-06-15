Feature: Create Mlog in EnCompass
  Scenario: EnCompassCreateMlogPOC
    Proof of Concept / Test work for Create Mlog within EnCompass
    Given the login form at https://test.transact-global.net/
    And I open EnCompass
    When I login to EnCompass as a SuperUser
    And I select the 0003414 company number on the EnCompass select org page
    And I navigate to the Create Merchant Log page in EnCompass
    And I create an AP Plog with 1.00 amount
    Then I save the mlog and account information
    # At this point other steps can be run against the new card
    And I close EnCompass


