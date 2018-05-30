package stepDefinitions.ProgramManagement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProgramManagement.*;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static stepDefinitions.common.NavigationSteps.iClickOnTheYTab;
import static stepDefinitions.common.NavigationSteps.iShouldSeeTheXTab;

public class CompaniesSteps extends AbstractSteps {

    private CompaniesSetup companiesSetup;
    private CompaniesBINs companiesBINs;
    private CompaniesCreditLimit companiesCreditLimit;
    private CompaniesBillingFeatures companiesBillingFeatures;
    private CompaniesAuthorizationControls companiesAuthorizationControls;
    private CompaniesNotes companiesNotes;

    private String companyNumber;
    private String companyNameFull;

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

        // Create full company name (with datestring)
        companyNameFull = companyNameStart + " " + GenerateDateTimeStringShort();

        // Set other required values on setup tab
        companiesSetup.SetCompanyName(companyNameFull);
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

        companiesSetup.ClickSaveButtonAndWait();
        /*
        // click Save
        companiesSetup.SaveButton.click();
        // wait for save button to be disabled
        WaitForElementToLoad(getDriver(), companiesSetup.DisabledSaveButton);
        // wait for Updates have been saved alert to disappear before continuing
        WaitForElementToDisappear(getDriver(), companiesSetup.AlertSuccess);
        */

        companiesSetup.RefreshModel();

        WaitForElementToLoad(getDriver(), companiesSetup.CompanyNumber);

        // I should see the company number
        assertThat("Cannot find the company number", RetryFindElement(companiesSetup.CompanyNumber).isDisplayed(), is(equalTo(true)));

        // Save the company number for later use
        companyNumber = companiesSetup.CompanyNumber.getText();
        System.out.println("Company number: " + companyNumber);

        // I should see the new tabs
        try {
            iShouldSeeTheXTab("BINs");
            iShouldSeeTheXTab("Credit Limit");
            iShouldSeeTheXTab("Billing Features");
            iShouldSeeTheXTab("MCC Groups");
            iShouldSeeTheXTab("Authorization Controls");
            iShouldSeeTheXTab("Notes");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        // Go to Credit Limit Tab
        try {
            iClickOnTheYTab("Credit Limit");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        companiesCreditLimit = new CompaniesCreditLimit(getDriver());

        // Wait for the Credit Limit tab to go active
        WaitUntilElementExists(companiesCreditLimit.CreditLimitActiveTab);

        // Check that CL tab says: You must select a BIN before setting a company credit limit.
        assertThat("Credit Limit tab doesn't have message to set BIN before credit limit", companiesCreditLimit.BinNotSetWarning.isDisplayed(), is(equalTo(true)));

        // Go to BIN tab
        try {
            iClickOnTheYTab("BINs");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        companiesBINs = new CompaniesBINs(getDriver());

        // Wait for the page to load
        WaitForElementToLoad(getDriver(), companiesBINs.SchemeDropdown);

        // Set the Scheme
        companiesBINs.SetSchemeDropdown("MasterCard");
        // after picking scheme USD should be picked in Currency
        assertThat("Default currency is not what was expected", companiesBINs.CurrencyDropdown.getAttribute("value"), is(equalTo(currency)));

        // Pick the BIN
        companiesBINs.SetBINsDropdown(bin);

        // after picking BIN should see BIN status
        assertThat("BIN Status is empty", companiesBINs.BinStatus.getSize(), is(notNullValue()));

        // click Save
        companiesBINs.ClickSaveButtonAndWait();

        // Go to Credit Limit Tab
        try {
            iClickOnTheYTab("Credit Limit");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        companiesCreditLimit.RefreshModel();

        // Wait for the Credit Limit tab to go active
        WaitUntilElementExists(companiesCreditLimit.CompanyCreditLimit);

        // Enter credit limit
        companiesCreditLimit.CompanyCreditLimit.sendKeys(creditLimit);

        // After entering a credit limit I should see company credit limit met options
        assertThat("Credit limit decline/override options are not present", companiesCreditLimit.DeclineAuthsRadioButton.isDisplayed(), is(equalTo(true)));

        // click Save
        companiesCreditLimit.ClickSaveButtonAndWait();

        // Modal covers the screen for a second during save, need to wait it out
        WaitUntilElementExists(companiesCreditLimit.LoadingSpinnerIsHidden);

        // Go to Billing Features tab
        try {
            iClickOnTheYTab("Billing Features");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        companiesBillingFeatures = new CompaniesBillingFeatures(getDriver());

        // Wait for the Billing Features tab to go active
        WaitUntilElementExists(companiesBillingFeatures.BillingFeaturesActiveTab);

        // Set Billing Features required fields
        companiesBillingFeatures.SetBillCycleDropdown(billCycle);
        companiesBillingFeatures.SetCycleDayDropdown(cycleDay);
        companiesBillingFeatures.SetGracePeriodDropdown(gracePeriod);
        companiesBillingFeatures.SetLateFeePercDropdown(lateFeePerc);
        companiesBillingFeatures.SetInterFeePercDropdown(interFeePerc);
        companiesBillingFeatures.SetStatementDropdown(statementTemplate);
        companiesBillingFeatures.SetPaymentMethodDropdown(paymentMethod);

        // click Save
        companiesBillingFeatures.ClickSaveButtonAndWait();

        // Modal covers the screen for a second during save, need to wait it out
        WaitUntilElementExists(companiesBillingFeatures.LoadingSpinnerIsHidden);

        // Go to Setup tab
        try {
            iClickOnTheYTab("Setup");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        companiesSetup.RefreshModel();

        // Confirm we are on the Setup page
        WaitUntilElementExists(companiesSetup.SetupActiveTab);

        // Activate the company
        companiesSetup.SetStatusDropdown("Active");

        // click Save
        companiesSetup.ClickSaveButtonAndWait();

        // confirm the company shows as Active
        assertThat("Status is not Active", companiesSetup.StatusDropdown.getAttribute("value"), is(equalTo("Active")));
    }

    @Then("I verify the new company changes in the audit log for (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
    public void iVerifyTheNewCompanyChangesInTheAuditLog(String clientName, String companyNameStart, String primaryContact, String phoneNumber, String address1, String city, String stateProvince, String postalCode, String taxIdNumber, String currency, String bin, String creditLimit, String billCycle, String cycleDay, String gracePeriod, String lateFeePerc, String interFeePerc, String statementTemplate, String paymentMethod) {
        // Go to Ops - Audit Log

        // Search for Type company and the company name

        // Verify the entries in the audit log

        // Eventually have a test that the API creating a new company was sent to EnCompass and CoreCard?

    }
}


