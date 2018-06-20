package stepDefinitions.common;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.FileReaderManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import pages.common.LoginPage;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginSteps extends AbstractSteps {

    private LoginPage loginPage;
    String tagURL = FileReaderManager.getInstance().getConfigReader().getTAGApplicationUrl();
    String super_userName = FileReaderManager.getInstance().getConfigReader().getSuperUserName();
    String User1_userName = FileReaderManager.getInstance().getConfigReader().getUser1UserName();
    String User2_userName = FileReaderManager.getInstance().getConfigReader().getUser2UserName();
    String FISUPER_userName = FileReaderManager.getInstance().getConfigReader().getFISUPERUserName();
    String PartnerSuper_userName = FileReaderManager.getInstance().getConfigReader().getPartnerSuperUserName();
    String TAGCRM_userName = FileReaderManager.getInstance().getConfigReader().getTAGCRMUserName();
    String TAGQA_userName = FileReaderManager.getInstance().getConfigReader().getTAGQAUserName();
    String automationTAGSUPER_password = FileReaderManager.getInstance().getConfigReader().getSuperUserPassword();
    String automationUser1_password = FileReaderManager.getInstance().getConfigReader().getUser1Password();
    String automationUser2_password = FileReaderManager.getInstance().getConfigReader().getUser2Password();
    String automationFISUPER_password = FileReaderManager.getInstance().getConfigReader().getFISUPERPassword();
    String automationPartnerSuper_password = FileReaderManager.getInstance().getConfigReader().getPartnerSuperPassword();
    String automationTAGCRM_password = FileReaderManager.getInstance().getConfigReader().getTAGCRMPassword();
    String automationTAGQA_password = FileReaderManager.getInstance().getConfigReader().getTAGQAPassword();
    //private MFAEntryPage mfaEntryPage;

    @Given("^I navigate to TagUI$")
    public void iNavigateToTagUi() {

        loginPage = new LoginPage(getDriver());

        System.out.println(tagURL);
        // Navigate to url
        loginPage.driver.navigate().to(tagURL);

        // size the browser so the menu is visible (menu doesn't show if window is too small)
        getDriver().manage().window().setSize(new Dimension(1440, 900));

        // Refresh the page model after load
        loginPage.RefreshModel();

        // Wait until the page loads by checking for the username field before continuing
        WaitForElementToLoad(getDriver(), loginPage.UserName);

        // Check to see if I am on the login page
        assertThat("Cannot find the username field", loginPage.UserName.isDisplayed(), is(equalTo(true)));
    }

    @When("^I login as superUser")
    public void iLoginAsUsernameWithPassword() throws Throwable {

        // Set the local storage at login so MFA is skipped
        System.out.println(super_userName);
        SetMFAKey(super_userName);

        // Populate username and password from feature file
        loginPage.SetUsername(super_userName);
        loginPage.SetPassword(automationTAGSUPER_password);

        // Click login button
        loginPage.LoginClick();
    }

    @When("^I login with a wrong password")
    public void iLoginWithAWrongPassword() throws Throwable {

        // Set the local storage at login so MFA is skipped
        System.out.println(super_userName);
        SetMFAKey(super_userName);

        // Populate username and password from feature file
        loginPage.SetUsername(super_userName);
        loginPage.SetPassword("wrongpassword");

        // Click login button
        loginPage.LoginClick();
    }

    @When("^I login as User1")
    public void iLoginAsUser1WithPassword() throws Throwable {

        // Set the local storage at login so MFA is skipped
        System.out.println(User1_userName);
        SetMFAKey(User1_userName);

        // Populate username and password from feature file
        loginPage.SetUsername(User1_userName);
        loginPage.SetPassword(automationUser1_password);

        // Click login button
        loginPage.LoginClick();
    }

    @When("^I login as User2")
    public void iLoginAsUser2WithPassword() throws Throwable {

        // Set the local storage at login so MFA is skipped
        System.out.println(User2_userName);
        SetMFAKey(User2_userName);

        // Populate username and password from feature file
        loginPage.SetUsername(User2_userName);
        loginPage.SetPassword(automationUser2_password);

        // Click login button
        loginPage.LoginClick();
    }

    @When("^I login as FISUPER")
    public void iLoginAsFISUPERWithPassword() throws Throwable {

        // Set the local storage at login so MFA is skipped
        System.out.println(FISUPER_userName);
        SetMFAKey(FISUPER_userName);

        // Populate username and password from feature file
        loginPage.SetUsername(FISUPER_userName);
        loginPage.SetPassword(automationFISUPER_password);

        // Click login button
        loginPage.LoginClick();
    }

    @When("^I login as PartnerSuper")
    public void iLoginAsPartnerSuperWithPassword() throws Throwable {

        // Set the local storage at login so MFA is skipped
        System.out.println(PartnerSuper_userName);
        SetMFAKey(PartnerSuper_userName);

        // Populate username and password from feature file
        loginPage.SetUsername(PartnerSuper_userName);
        loginPage.SetPassword(automationPartnerSuper_password);

        // Click login button
        loginPage.LoginClick();
    }

    @When("^I login as TAGCRM")
    public void iLoginAsTAGCRMWithPassword() throws Throwable {

        // Set the local storage at login so MFA is skipped
        System.out.println(TAGCRM_userName);
        SetMFAKey(TAGCRM_userName);

        // Populate username and password from feature file
        loginPage.SetUsername(TAGCRM_userName);
        loginPage.SetPassword(automationTAGCRM_password);

        // Click login button
        loginPage.LoginClick();
    }

    @When("^I login as TAGQA")
    public void iLoginAsTAGQAWithPassword() throws Throwable {

        // Set the local storage at login so MFA is skipped
        System.out.println(TAGQA_userName);
        SetMFAKey(TAGCRM_userName);

        // Populate username and password from feature file
        loginPage.SetUsername(TAGQA_userName);
        loginPage.SetPassword(automationTAGQA_password);

        // Click login button
        loginPage.LoginClick();
    }

    @When("^I login as (.*) with (.*)")
    public void iLoginAsUsernameWithPassword(String userName, String password) throws Throwable {
        // Set the local storage at login so MFA is skipped
        SetMFAKey(userName);

        // Populate username and password from feature file
        loginPage.SetUsername(userName);
        loginPage.SetPassword(password);

        // Click login button
        loginPage.LoginClick();
    }


    @Then("^I should be authenticated$")
    public void iShouldBeAuthenticated() throws Throwable {

        loginPage.RefreshModel();

        // Wait until the page loads by checking for the logout link before continuing
        WaitForElementToLoad(getDriver(), loginPage.LogoutLink);

        // Check to see we are logged in by seeing if the logout link is present
        assertThat("Cannot find the logout link", loginPage.LogoutLink.isDisplayed(), is(equalTo(true)));

        // size the browser so the menu is visible (menu doesn't show if window is too small)
        getDriver().manage().window().setSize(new Dimension(1440, 900));
    }

    @When("^I logout$")
    public void iLogout() throws Throwable {
        // click the logout link
        loginPage.Logout();
    }

    @Then("^I should be logged out and on the login page$")
    public void iShouldBeLoggedOutAndOnTheLoginPage() throws Throwable {
        loginPage.RefreshModel();

        // Verify I am on the login page
        assertThat("Cannot find the username field", loginPage.UserName.isDisplayed(), is(equalTo(true)));
    }

    @Then("^I should see the login failed alert$")
    public void iShouldSeeTheLoginFailedAlert() throws Throwable {
        WaitForElementToLoad(getDriver(), loginPage.AlertText);

        // Get the text from the alert, trimming spaces and line breaks
        String actualAlertText = AllTrim(loginPage.AlertText.getText());

        // Confirm that the alert text contains the expected message
        assertThat("Unexpected alert text", actualAlertText, containsString("The Login has failed. Please try again using a valid Username and Password."));
    }

    // SETMFAKey method creates the local storage setting such the MFA is skipped
    // The first time a login is used, you'll need to stop the test after login
    // and when the MFA screen is up and enter the MFA validation.
    // That should create the matching record in TAG's database and you shouldn't
    // have to provide MFA at login for that user in when running the next automated tests.
    private void SetMFAKey(String login) {
        // Build login/key portion of js query string
        String keyString = "TRANSACT_GLOBAL_" + login.toLowerCase() + "_DEVICE_ID";

        // Create key and value in local storage
        JavascriptExecutor jse = ((JavascriptExecutor) getDriver());
        jse.executeScript("window.localStorage.setItem('" + keyString + "', 'Automation');");
    }
}
