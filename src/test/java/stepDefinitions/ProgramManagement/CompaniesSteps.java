package stepDefinitions.ProgramManagement;

import cucumber.api.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.ProgramManagement.*;
import stepDefinitions.AbstractSteps;
import stepDefinitions.common.NavigationSteps;

import java.util.List;

import static global.SharedWebDriver.getDriver;
import static global.SharedWebDriver.scenario;
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

    @When("I set the FI Name dropdown to (.*)")
    public void iCreateANewCompanyWithReqFields(String fiName){
        companiesSetup = new CompaniesSetup(getDriver());

        /*
        This step definition is only needed if we are using a TAG Super as
        they have access to all FIs and needs to pick on FI
        */
        // Set the FI Dropdown
        companiesSetup.SetFIDropdown(fiName);
        // Could also do:SetDropdownByText(companiesSetup.FIDropdown, "WEX Bank");
    }

    @When("I create a new company with (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
    public void iCreateANewCompanyWithReqFields(String clientName, String companyNameStart, String primaryContact, String phoneNumber, String address1, String city, String stateProvince, String postalCode, String taxIdNumber, String currency, String bin, String creditLimit, String billCycle, String cycleDay, String gracePeriod, String lateFeePerc, String interFeePerc, String statementTemplate, String paymentMethod){
        companiesSetup = new CompaniesSetup(getDriver());

        // Wait until the page loads by checking for company name field before continuing
        WaitForElementToLoad(getDriver(), companiesSetup.CompanyName);

        // Check to see if I am on the setup page
        assertThat("Cannot find the setup breadcrumb", companiesSetup.BreadCrumb3.getText(), is(equalTo("Setup")));

        /*
        This step definition assumes we are using an FI user and don't have to pick on FI,
        if you are a TAG super and need to pick on FI you'll need an extra step to pick FI
        before running this step definition
        */
        // Set the FI Dropdown
        //companiesSetup.SetFIDropdown("WEX Bank");
        // Could also do:SetDropdownByText(companiesSetup.FIDropdown, "WEX Bank");

        // Set client dropdown
        companiesSetup.SetClientDropdown(clientName);

        // Set other required values on setup tab
        companiesSetup.SetCompanyName(companyNameStart + " " + GenerateDateTimeStringShort());
        companiesSetup.SetPrimaryContact(primaryContact);
        companiesSetup.SetPhoneNumber(phoneNumber);
        companiesSetup.SetAddress1(address1);
        companiesSetup.SetCity(city);

        // I'm not sure why but I've been unable to set the state drop down via the value and text
        //companiesSetup.SetStateProvinceDropdown(stateProvince);
        //SetDropdownByValue(companiesSetup.StateProvince, stateProvince);
        companiesSetup.StateProvince.sendKeys(stateProvince);

        companiesSetup.SetPostalCode(postalCode);
        companiesSetup.SetTaxIDNumber(taxIdNumber);

        // click Save
        companiesSetup.SaveButton.click();
        // wait for save button to be disabled
        WaitForElementToLoad(getDriver(), companiesSetup.DisabledSaveButton);

        companiesSetup.RefreshModel();

        WaitForElementToLoad(getDriver(), companiesSetup.CompanyNumber);

        // I should see the company number
        assertThat("Cannot find the company number", RetryFindElement(companiesSetup.CompanyNumber).isDisplayed(), is(equalTo(true)));

        // Save the company number
        String companyNumber = companiesSetup.CompanyNumber.getText();
        System.out.println("Company number: " + companyNumber);

        // I should see the new tabs
        try {
            NavigationSteps.iShouldSeeTheXTab("BINs");
            NavigationSteps.iShouldSeeTheXTab("Credit Limit");
            NavigationSteps.iShouldSeeTheXTab("Billing Features");
            NavigationSteps.iShouldSeeTheXTab("MCC Groups");
            NavigationSteps.iShouldSeeTheXTab("Authorization Controls");
            NavigationSteps.iShouldSeeTheXTab("Notes");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // Go to BIN tab

        // Set required fields on BIN tab,
        // after picking scheme USD should be picked in Currency,
        // after picking BIN should see BIN status

        // click Save

        // Go to Credit Limit tab

        // Enter credit limit

        // After entering a credit limit I should see company credit limit met options

        // Go to Billing Features tab

        // Set required fields

        // click Save

        // Go to Setup tab

        // Activate the company

        // Go to Ops - Audit Log

        // Search for Type company and the company name

        // Verify the entries in the audit log

        // Eventually have a test that the API creating a new company was sent to EnCompass and CoreCard?
    }
}
