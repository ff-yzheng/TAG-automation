package stepDefinitions.tools;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.Hooks;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.tools.EnCompass;
import stepDefinitions.AbstractSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class EnCompassSteps extends AbstractSteps {

    private EnCompass enCompass;
    private WebDriver enCompassDriver; // driver specific to test harness so it gets it's own browser instance during test

    // Variables to save the card and  mlog information
    public String mlogId = "uninitialized";
    public String cardNumber = "uninitialized";
    public String cardExpDate = "uninitialized";
    public String cardCsc = "uninitialized";

    // Variables saving company information
    public String companyName = "uninitialized";
    public String companyNumber = "uninitialized";
    public String orgId = "uninitialized";
    public String orgAbbrevation = "uninitialized";

    @Given("^I open EnCompass")
    public void iOpenEnCompass() {
        // Create the driver and page object
        enCompassDriver = new ChromeDriver();
        enCompass = new EnCompass(enCompassDriver);

        // Navigate to WEX QA EnCompass url
        enCompassDriver.navigate().to("https://wexqa.encompass-suite.com/");

        // size the browser so the menu is visible (menu doesn't show if window is too small)
        enCompassDriver.manage().window().setSize(new Dimension(1440, 900));

        // Wait until the page loads by checking for the username field before continuing
        WaitForElementToLoad(enCompassDriver, enCompass.Username);

        // Check to see if I am on the login page
        assertThat("Cannot find the EnCompass username field", enCompass.Username.isDisplayed(), is(equalTo(true)));

        // TODO Todd POC work on sharing data across step definition classes
        // Just seeing if I can see the sharedCompanyNumber, I can!
        System.out.println("shared co number = " + AbstractSteps.sharedCompanyNumber);
    }

    @When("^I login to EnCompass as a SuperUser")
    public void iLoginToEnCompassAs() {
        // Login information may change but can be seen & updated in this step if needed
        // See the login information in https://knox.aocsolutions.com/
        // in the QAWexRanorexSuper entry

        // EnCompass Login information
        String userName = "ranorexsuper";
        String password = "usz7(QoN4W*1";
        String orgId = "encsuper";

        // Clear any pre-existing login info
        enCompass.Username.clear();
        enCompass.Password.clear();
        enCompass.OrgIdLogin.clear();

        // Populate login information
        enCompass.Username.sendKeys(userName);
        enCompass.Password.sendKeys(password);
        enCompass.OrgIdLogin.sendKeys(orgId);

        // Click Log In button
        enCompass.LoginButton.click();

        // Make sure we are logged into EnCompass
        // Wait until the page loads by checking for the logout link before continuing
        WaitForElementToLoad(enCompassDriver, enCompass.LogoutLink);

        // Check to see we are logged in by seeing if the logout link is present
        assertThat("Cannot find the logout link", enCompass.LogoutLink.isDisplayed(), is(equalTo(true)));
    }

    @When("^I select the (.*) company number on the EnCompass select org page")
    public void iSelectTheXOrgIdInEnCompass(String orgId) {
        WaitForElementToLoad(enCompassDriver, enCompass.OrgGroupLoginPageBar);

        // Clear any previous search values
        enCompass.CompanyName.clear();
        enCompass.CompanyNumber.clear();
        enCompass.OrganizationId.clear();

        // Select all search criteria checkboxes
        SetCheckboxToTrue(enCompass.ActiveClientsCheckbox);
        SetCheckboxToTrue(enCompass.DisableClientsCheckbox);
        SetCheckboxToTrue(enCompass.NewClientsCheckbox);

        // Set the company number
        enCompass.CompanyNumber.sendKeys(orgId);

        // click search
        enCompass.SearchOrgGroupButton.click();

        // Wait for search to complete by checking for when row 2 disappears (the search should only return 1 row)
        WaitForElementToDisappear(enCompassDriver, enCompass.ORGROW2XPATH);

        // Click row 1
        enCompass.OrgGroupRow1.click();

        // Click Select action
        WaitForElementToLoad(enCompassDriver, enCompass.SelectOrgAction);
        enCompass.SelectOrgAction.click();

        // Wait for Main EnCompass Screen to load
        WaitForElementToLoad(enCompassDriver, enCompass.HomeWelcomeMessage);
    }

    @When("^I navigate to the Create Merchant Log page in EnCompass")
    public void iNavigateToTheCreateMlogPageInEnCompass() {
        // Click Payables - Accounts Payable
        enCompass.PayablesMenu.click();
        enCompass.AccountsPayableSubMenu.click();

        WaitForElementToLoad(enCompassDriver, enCompass.CreateMlogSideMenu);

        // Click Create Mlog Sidemenu
        enCompass.CreateMlogSideMenu.click();

        WaitForElementToLoad(enCompassDriver, enCompass.MerchantDropDown);
    }


    @When("^I create an AP Plog with (.*) amount")
    public void iCreateAnApPlogWithXAmount(String amount) {
        // Merchant Drop down should have Purchase Log (* as value) as the default
        //System.out.println("select value = " + enCompass.MerchantDropDown.getAttribute("value"));
        assertThat("Purchase log is not set as the option", enCompass.MerchantDropDown.getAttribute("value").equals("*"), is(equalTo(true)));

        // Populate the amount
        enCompass.InvAmount.clear();
        enCompass.InvAmount.sendKeys(amount);

        // Populate the Inv Number with a random datetime
        enCompass.InvNum.sendKeys(GenerateDateTimeStringShortest());

        // Click the submit button
        enCompass.SubmitButton.click();

        // Wait for the Create Mlog success message
        WaitForElementToLoad(enCompassDriver, enCompass.SuccessMessage);
    }

    @When("^I save the mlog and account information")
    public void iSaveTheMlogAndAccountInformation() {
        // Get the Mlog Id
        mlogId = enCompass.MlogId.getText();
        System.out.println("mlog id = " + mlogId);

        // Get card info
        cardNumber = enCompass.CardNumber.getText();
        cardExpDate = enCompass.CardExpDate.getText();
        cardCsc = enCompass.CardCsc.getText();

        System.out.println("Card Num = " + cardNumber);
        System.out.println("Card Exp = " + cardExpDate);
        System.out.println("Card CSC = " + cardCsc);
    }

    @When("^I search for company number (.*) in Encompass Select Org Group$")
    public void iSearchForCompanyNumberXInEncompassSelectOrgGroup(String companyNum) {
        // *** If you want to search for a company created in
        // Confirm I am on the Select Org Page
        assertThat("Cannot find the New Clients checkbox", enCompass.NewClientsCheckbox.isDisplayed(), is(equalTo(true)));

        // Set the Active Clients, Disabled Clients and New Clients checkboxes to true
        SetCheckboxToTrue(enCompass.ActiveClientsCheckbox);
        SetCheckboxToTrue(enCompass.DisableClientsCheckbox);
        SetCheckboxToTrue(enCompass.NewClientsCheckbox);

        // Clear any existing search values
        enCompass.CompanyName.clear();
        enCompass.CompanyNumber.clear();
        enCompass.OrganizationId.clear();

        // Populate the company number search
        enCompass.CompanyNumber.sendKeys(companyNum);

        // Click Search
        enCompass.SearchOrgGroupButton.click();

        // Wait for the search to complete (should only have 1 row returned)
        WaitForElementToDisappear(enCompassDriver, enCompass.ORGROW2XPATH);
        WaitUntilElementExists(enCompass.OrgGroupRow1);

        // Keep the Org Info for later use
        companyName = enCompass.OrgGroupRow1Colm1.getText();
        //System.out.println("Org Group Name = " + companyName);
        companyNumber = companyNum;
        //System.out.println("Org Number = " + companyNumber);
    }

    @Then("^I set up the company in EnCompass$")
    public void iSetUpTheCompanyInEnCompass() {
        // Prereq: should have the company to setup in row 1 on the org group page

        // Click the company row
        enCompass.OrgGroupRow1.click();

        // Click edit
        enCompass.EditRowAction.click();

        // wait for the page to load
        WaitUntilElementExists(enCompass.OrganizationIdInput);

        // Set the Org Id to the company name
        enCompass.OrganizationIdInput.sendKeys(companyName);

        // Save Client Profile
        enCompass.SaveButton.click();

        // Wait for success message
        WaitUntilElementExists(enCompass.SuccessMessage);
    }

    @Then("^I navigate to Super Admin Accounts Payable in EnCompass$")
    public void iNavigateToSuperAdminAccountsPayableInEnCompass() {
        // click Super Admin Utilities
        enCompass.SuperAdminUtilitiesLink.click();

        // wait for the page to load
        WaitUntilElementExists(enCompass.SuperAdminUtilitiesBreadcrumb);

        // Check to see if we are already on the Manage AP page, if so no further navigation is needed
        if(!enCompass.APOrgRow1.isDisplayed()){
            //System.out.println("I am not on the AP Page");
            // click the menu items to get to manage ap
            enCompass.SuperrAdminPayablesLink.click();
            enCompass.SuperAdminAPToolsLink.click();
            WaitUntilElementExists(enCompass.SuperAdminManageAPLink);
            enCompass.SuperAdminManageAPLink.click();

            WaitUntilElementExists(enCompass.APOrgRow1);
        }
        else{
            //System.out.println("I am already on the AP Page");
        }

        assertThat("Cannot fine the Manage AP Search grid", enCompass.APOrgRow1.isDisplayed(), is(equalTo(true)));
    }

    @Then("^I search for company number (.*) in EnCompass Super Admin$")
    public void iSearchForCompanyNumberXInEnCompassSuperAdmin(String companyNum) {
        // Populate the search
        SetDropdownByText(enCompass.SearchTermDropdown, "Company Number");
        SetDropdownByText(enCompass.SearchFilterTypeDropdown, "Starts With");
        enCompass.SearchValueText.sendKeys(companyNum);

        // Click search
        enCompass.SearchButton.click();

        // Wait for only one row to exist
        WaitForElementToDisappear(enCompassDriver, enCompass.APORGROW2XPATH);
    }

    @Then("^I activate AP for the company in EnCompass$")
    public void iActivateAPForTheCompanyInEnCompass() {
        // click on row 1
        enCompass.APOrgRow1.click();
        WaitUntilElementExists(enCompass.EditRowAction);

        // click Enable AP
        enCompass.EnableAPRowAction.click();
        WaitUntilElementExists(enCompass.OrgAbbrev);

        // Get org abbrev value
        orgAbbrevation = enCompass.OrgAbbrev.getText();
        System.out.println("Org Abbrev = " + orgAbbrevation);

        // set up ap options
        // Enable AP
        SetCheckboxToTrue(enCompass.EnableAPOnlineCheckbox);
        // Set up the required email address to use
        enCompass.StatusEmailAddress.clear();
        enCompass.StatusEmailAddress.sendKeys("tagtesting@wexinc.com");
        enCompass.DisputeReplyToEmail.clear();
        enCompass.DisputeReplyToEmail.sendKeys("tagtesting@wexinc.com");
        // Click Use Single Use Accounts option
        SetCheckboxToTrue(enCompass.EnableSingleUseAccountsCheckbox);
        // Wait for the additional SUGA options to appear
        WaitForElementToDisappear(enCompassDriver, enCompass.UPDATINGDISPLAYEDXPATH);
        WaitUntilElementExists(enCompass.EnableAPPlogCheckbox);
        // Click the additional SUGA options
        SetCheckboxToTrue(enCompass.EnableAPPlogCheckbox);
        WaitForElementToDisappear(enCompassDriver, enCompass.UPDATINGDISPLAYEDXPATH);
        SetCheckboxToTrue(enCompass.EnableEffDatesCheckbox);
        WaitForElementToDisappear(enCompassDriver, enCompass.UPDATINGDISPLAYEDXPATH);

        // save
        enCompass.SaveButton.click();

        // Wait for success message
        WaitUntilElementExists(enCompass.SuccessMessage);
    }

    @Then("^I create inventory for the company in EnCompass$")
    public void iCreateInventoryForTheCompanyInEnCompass() {
        // click on row 1
        enCompass.APOrgRow1.click();
        WaitUntilElementExists(enCompass.EditRowAction);

        // click inventory
        enCompass.InventoryRowAction.click();
        WaitUntilElementExists(enCompass.ManageInventoryBreadcrumb);

        // click add new
        enCompass.AddNewButton.click();
        WaitUntilElementExists(enCompass.MinQuantity);

        // set inventory value
        SetDropdownByText(enCompass.CurrencyDropdown, "USD - US dollar");
        SetDropdownByText(enCompass.ProcessorDropdown, "TG");
        enCompass.MinQuantity.clear();
        enCompass.MinQuantity.sendKeys("10");
        enCompass.MaxQuantity.clear();
        enCompass.MaxQuantity.sendKeys("50");
        enCompass.OrderQuantity.clear();
        enCompass.OrderQuantity.sendKeys("20");

        // save
        enCompass.SubmitButton.click();

        // Wait for success message
        WaitUntilElementExists(enCompass.SuccessMessage);
    }

    @Then("^I close EnCompass")
    public void iCloseEnCompass() {
        // Close EnCompass
        enCompassDriver.close();
    }
}
