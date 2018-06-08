package stepDefinitions.tools;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
    public String mlogId;
    public String cardNumber;
    public String cardExpDate;
    public String cardCsc;

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

    @Then("^I close EnCompass")
    public void iCloseEnCompass() {
        // Close EnCompass
        enCompassDriver.close();
    }
}
