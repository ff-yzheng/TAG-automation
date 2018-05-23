package stepDefinitions.ProgramManagement;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import pages.ProgramManagement.*;
import pages.common.LoginPage;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class CompaniesSteps extends AbstractSteps {

    private CompaniesSetup companiesSetup;
    private CompaniesBINs companiesBINs;
    private CompaniesCreditLimit companiesCreditLimit;
    private CompaniesBillingFeatures companiesBillingFeatures;
    private CompaniesAuthorizationControls companiesAuthorizationControls;
    private CompaniesNotes companiesNotes;

    @When("I create a new company")
    public void iCreateANewCompany() {
        companiesSetup = new CompaniesSetup(getDriver());

        // Wait until the page loads by checking for company name field before continuing
        WaitForElementToLoad(getDriver(), companiesSetup.CompanyName);

        // Check to see if I am on the setup page
        assertThat("Cannot find the setup breadcrumb", companiesSetup.BreadCrumb3.getText(), is(equalTo("Setup")));

        companiesSetup.SetFIDropdown("WEX Bank");


    }
}
