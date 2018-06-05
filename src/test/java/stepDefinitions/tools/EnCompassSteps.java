package stepDefinitions.tools;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.tools.EnCompass;
import stepDefinitions.AbstractSteps;

import static java.lang.Thread.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class EnCompassSteps extends AbstractSteps {

    private EnCompass enCompass;
    private WebDriver enCompassDriver; // driver specific to test harness so it gets it's own browser instance during test

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
        enCompass.SearchButton.click();

        // Wait for search to complete by checking for when row 2 disappears (the search should only return 1 row)
        WaitForElementToDisappear(enCompassDriver, enCompass.ORGROW2XPATH);

        // Click row 1
        enCompass.OrgGroupRow1.click();

        // Click Select action
        WaitForElementToLoad(enCompassDriver, enCompass.OrgSelectAction);
        enCompass.OrgSelectAction.click();

        // Wait for Main EnCompass Screen to load
        WaitForElementToLoad(enCompassDriver, enCompass.HomeWelcomeMessage);
    }

    @Then("^I close EnCompass")
    public void iCloseEnCompass() {
        // Close EnCompass
        enCompassDriver.close();
    }
}
