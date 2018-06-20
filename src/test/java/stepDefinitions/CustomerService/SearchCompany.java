package stepDefinitions.CustomerService;

import cucumber.api.java.en.When;
import pages.ProgramManagement.PartnerSearch;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;


public class SearchCompany extends AbstractSteps {


    private PartnerSearch partnerSearch;


    //TESTCASE 1 - Scenarios for PM-Partner Search

    //FI Dropdown for CS-Companies
    @When("^I set the FI Name dropdown under CS-Companies to (.*)$")
    public void iSetTheFINameDropdownUnderCSCompaniesToValue(String SearchText) throws Throwable {

        partnerSearch = new PartnerSearch(getDriver());
        // Set the FI Dropdown
        partnerSearch.SetCompanyFIDropdown(SearchText);
    }


}
