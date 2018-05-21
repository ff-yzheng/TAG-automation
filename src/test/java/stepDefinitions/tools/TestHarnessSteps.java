package stepDefinitions.tools;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.tools.TestHarness;
import stepDefinitions.AbstractSteps;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestHarnessSteps extends AbstractSteps {

    private TestHarness testHarness;
    private WebDriver testHarnessDriver; // driver specific to test harness so it gets it's own browser instance during test

    // The path we use for the transaction file
    private String TransFilePath = System.getProperty("user.dir")+ File.separator + "target" + File.separator + "downloadFiles";

    @Given("^I open TestHarness")
    public void iOpenTestHarness() {
        // Block of code to set the download options default directory for the session
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", TransFilePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        // Create the driver and page object
        testHarnessDriver = new ChromeDriver(options);
        testHarness = new TestHarness(testHarnessDriver);

        // Navigate to TestHarness url
        testHarnessDriver.navigate().to("http://mock.transact-global.net:8080/");

        // Wait until the page loads by checking for the username field before continuing
        WaitForElementToLoad(testHarnessDriver, testHarness.Name);

        // Check to see if I am on the login page
        assertThat("Cannot find the username field", testHarness.Name.isDisplayed(), is(equalTo(true)));
    }

    @When("^I set the environment to (.*) and name to (.*)")
    public void iSetTheEnvToXAndNameToY(String env, String name) throws Throwable {
        // Sets the environment drop down
        testHarness.EnvironmentDropdown.sendKeys(env);

        // Sets the name field
        testHarness.SetName(name);
    }

    @When("^I set the auth file path to (.*) and upload")
    public void iSetTheAuthFilePathToX(String value) throws Throwable {
        // Sets the auth upload path & file without using the Browse button
        testHarness.SetAuthFileUploadPath(value);

        // Click the Submit auth button
        testHarness.SubmitAuthButton.click();

        // Wait for successful upload message
        WaitForElementToLoad(testHarnessDriver, testHarness.SuccessAuthUpload);
    }

    @When("^I run authorizations on the (.*) auth file")
    public void iRunAuthorizationOnTheXFile(String value) throws Throwable {
        // Sets the run auth filename
        testHarness.SetAuthFileName(value);

        // Click the Run Auths button
        testHarness.RunAuthButton.click();
    }

    @When("^I download the transaction file")
    public void iDownloadTheTransactionFile() throws Throwable {
        // Find & delete any Transactions.xlsx that may be in the download folder so we know the new file has the default name
        String oldTransFilePathAndName = TransFilePath + File.separator + "Transactions.xlsx";
        File oldTransFile = new File(oldTransFilePathAndName);
        oldTransFile.delete();

        // Make sure the Download Transaction button exists
        WaitForElementToLoad(testHarnessDriver, testHarness.DownloadTransactionsButton);

        // Click the Download Transaction button
        // Per the chromedriver settings, it will download automatically to the project\target\downloadFiles folder
        testHarness.DownloadTransactionsButton.click();

        // Short delay to make sure the file is saved before continuing
        Thread.sleep(1000);
    }

    @When("^I set the transaction file path and upload")
    public void iSetTheTransFilePathToX() throws Throwable {
        // Transactions file path and file name
        String transFilePathAndName = TransFilePath + File.separator + "Transactions.xlsx";

        // Sets the trans upload path & file without using the Browse button
        testHarness.SetTransFileUploadPath(transFilePathAndName);

        // Click the Upload transaction button
        testHarness.UploadTransButton.click();

        // Wait for successful upload message
        WaitForElementToLoad(testHarnessDriver, testHarness.SuccessAuthUpload);
    }

    @Then("^I close the TestHarness")
    public void iCloseTheTestHarness() {
        // Close the Test Harness
        testHarnessDriver.close();
    }

    // Code for debugging if a file cannot be found or deleted
    public String getReasonForFileDeletionFailureInPlainEnglish(File file) {
        try {
            if (!file.exists())
                return "It doesn't exist in the first place.";
            else if (file.isDirectory() && file.list().length > 0)
                return "It's a directory and it's not empty.";
            else
                return "Somebody else has it open, we don't have write permissions, or somebody stole my disk.";
        } catch (SecurityException e) {
            return "We're sandboxed and don't have filesystem access.";
        }
    }
}
