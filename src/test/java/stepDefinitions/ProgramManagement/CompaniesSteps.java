package stepDefinitions.ProgramManagement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.testng.internal.collections.Pair;
import pages.Operations.AuditLog;
import pages.ProgramManagement.*;
import stepDefinitions.AbstractSteps;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static global.SharedWebDriver.getDriver;
import static global.SharedWebDriver.scenario;
import static org.hamcrest.CoreMatchers.containsString;
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
    private AuditLog auditLog;

    private String companyNumber = "uninitialized";
    private String companyNameFull = "uninitialized";
    private String stateAbbrev = "uninitialized";

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
        // I'm not sure why but I've been unable to set the state drop down via the value and text, using sendKeys instead
        //companiesSetup.SetStateProvinceDropdown(stateProvince);
        //SetDropdownByValue(companiesSetup.StateProvince, stateProvince);
        companiesSetup.StateProvince.sendKeys(stateProvince);
        companiesSetup.SetPostalCode(postalCode);
        companiesSetup.SetTaxIDNumber(taxIdNumber);

        // Saving state abbrev for later verifications
        stateAbbrev = companiesSetup.StateProvince.getAttribute("value");

        companiesSetup.ClickSaveButtonAndWait();
        WaitForElementToDisappear(getDriver(), companiesSetup.LoadingSpinnerXPATH);
        WaitForElementToDisappear(getDriver(), companiesSetup.AlertSuccessXPATH);

        companiesSetup.RefreshModel();

        WaitForElementToLoad(getDriver(), RetryFindElement(companiesSetup.CompanyNumber));

        // I should see the company number
        assertThat("Cannot find the company number", RetryFindElement(companiesSetup.CompanyNumber).isDisplayed(), is(equalTo(true)));

        // Save the company number for later use
        companyNumber = companiesSetup.CompanyNumber.getText();
        System.out.println("Company number: " + companyNumber);

        // Verify that I see the new tabs
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

        // Verify that CL tab says: You must select a BIN before setting a company credit limit.
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
        // Verify that after picking scheme USD is shown in Currency
        assertThat("Default currency is not what was expected", companiesBINs.CurrencyDropdown.getAttribute("value"), is(equalTo(currency)));

        // Pick the BIN
        companiesBINs.SetBINsDropdown(bin);

        // Verify that after picking a BIN that I see BIN status
        assertThat("BIN Status is empty", companiesBINs.BinStatus.getSize(), is(notNullValue()));

        // click Save
        companiesBINs.ClickSaveButtonAndWait();
        WaitForElementToDisappear(getDriver(), companiesSetup.LoadingSpinnerXPATH);
        WaitForElementToDisappear(getDriver(), companiesSetup.AlertSuccessXPATH);

        // Need an extra wait because modal is sometimes in the way for next click
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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

        // Verify that after entering a credit limit I see the company credit limit met options
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
        WaitForElementToDisappear(getDriver(), companiesSetup.LoadingSpinnerXPATH);
        WaitForElementToDisappear(getDriver(), companiesSetup.AlertSuccessXPATH);

        // Verify that the company shows as Active
        assertThat("Status is not Active", companiesSetup.StatusDropdown.getAttribute("value"), is(equalTo("Active")));
    }

    @Then("I verify the new company changes in the audit log for (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*), (.*)")
    public void iVerifyTheNewCompanyChangesInTheAuditLog(String clientName, String companyNameStart, String primaryContact, String phoneNumber, String address1, String city, String stateProvince, String postalCode, String taxIdNumber, String currency, String bin, String creditLimit, String billCycle, String cycleDay, String gracePeriod, String lateFeePerc, String interFeePerc, String statementTemplate, String paymentMethod) {
        auditLog = new AuditLog(getDriver());

        // Go to Ops - Audit Log
        auditLog.OperationsMenu.click();
        auditLog.AuditLogSubMenu.click();
        WaitUntilElementExists(auditLog.SearchButton);

        // Search for Type company and the company number
        auditLog.SetTypeDropdown("Company");
        auditLog.CompanyNumberSearchField.sendKeys(companyNumber);
        auditLog.SearchButton.click();
        WaitUntilElementExists(auditLog.LoadingSpinnerIsHidden);

        // Need to reformat the credit limit for verification step (entered as number, displayed with thousands separator)
        String formattedCL = FormatWithThousandAnd2Decimals(creditLimit);

        // Verify the entries in the audit log
        // Set up an array of pairs (field name, expected value) to look for in the table
        ArrayList<Pair<String, String>> dataToVerify = new ArrayList<Pair<String, String>>();

        // populate the pairs to test
        dataToVerify.add(Pair.create("Status","Active"));
        dataToVerify.add(Pair.create("Payment Method",paymentMethod));
        dataToVerify.add(Pair.create("Bill Cycle",billCycle)); // 3 entered values in this 1 row
        dataToVerify.add(Pair.create("Bill Cycle",cycleDay));
        dataToVerify.add(Pair.create("Bill Cycle",gracePeriod));
        dataToVerify.add(Pair.create("International Fee",interFeePerc));
        dataToVerify.add(Pair.create("Credit Limit Amount",formattedCL)); // 2 entered values in this 1 row
        dataToVerify.add(Pair.create("Credit Limit Amount",currency));
        dataToVerify.add(Pair.create("BINs",bin));
        dataToVerify.add(Pair.create("Card Address",address1)); // 4 entered values in this 1 row
        dataToVerify.add(Pair.create("Card Address",city));
        dataToVerify.add(Pair.create("Card Address",stateAbbrev));
        dataToVerify.add(Pair.create("Card Address",postalCode));
        dataToVerify.add(Pair.create("Primary Contact",primaryContact));
        dataToVerify.add(Pair.create("Address",address1)); // 4 entered values in this 1 row
        dataToVerify.add(Pair.create("Address",city));
        dataToVerify.add(Pair.create("Address",stateAbbrev));
        dataToVerify.add(Pair.create("Address",postalCode));
        dataToVerify.add(Pair.create("Tax ID Number",taxIdNumber));
        dataToVerify.add(Pair.create("Phone",phoneNumber));
        dataToVerify.add(Pair.create("Name",companyNameFull));

        Integer i = 0;

        do {
            //System.out.println("Iteration " + i.toString());
            // Get the row number for the field
            String rowNumber = GetRowNumberFromCellText(dataToVerify.get(i).first());

            // Build the xpath for the row
            String rowXpath = "//table/tbody/tr[" + rowNumber + "]";

            // Looks for the expected test somewhere in that row
            System.out.println("Checking " + dataToVerify.get(i).first() + " row for " + dataToVerify.get(i).second());
            scenario.write("Checking " + dataToVerify.get(i).first() + " row for " + dataToVerify.get(i).second());
            assertThat("Could not find " + dataToVerify.get(i).second() + " in row " + rowNumber, getDriver().findElement(By.xpath(rowXpath)).getText(), containsString(dataToVerify.get(i).second()));

            // Next
            i++;
        }
        while (i < dataToVerify.size());

        // Eventually have a test that the API creating a new company was sent to EnCompass and CoreCard?

    }
}


