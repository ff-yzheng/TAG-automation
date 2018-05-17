package stepDefinitions.tools;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.tools.TestHarness;
import stepDefinitions.AbstractSteps;

import java.awt.*;
import java.awt.event.KeyEvent;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class TestHarnessSteps extends AbstractSteps {

    private TestHarness testHarness;
    private WebDriver testHarnessDriver; // driver specific to test harness so it gets it's own browser instance during test

    @Given("^I open the TestHarness")
    public void iOpenTheTestHarness() {
        testHarnessDriver = new ChromeDriver();
        testHarness = new TestHarness(testHarnessDriver);

        // Navigate to TestHarness url
        testHarnessDriver.navigate().to("http://mock.transact-global.net:8080/");

        // Wait until the page loads by checking for the username field before continuing
        WaitForElementToLoad(testHarnessDriver, testHarness.Name);

        // Check to see if I am on the login page
        assertThat("Cannot find the username field", testHarness.Name.isDisplayed(), is(equalTo(true)));
    }

    @When("^I set the auth file path to (.*)$")
    public void iSetTheAuthFilePathToX(String value) throws Throwable {
        // Sets the auth upload path & file without using the Browse button
        testHarness.SetAuthFileUploadPath(value);

    }

    @When("^I download the transaction file")
    public void iSetTheAuthFilePathToX() throws Throwable {
        // TODO: Is there a way to control where it downloads? See https://stackoverflow.com/questions/29770599/how-to-download-docx-file-using-selenium-webdriver-in-java/29770750#29770750

        // Create object of Robot class
        Robot object = new Robot();

        // Press Enter
        object.keyPress(KeyEvent.VK_ENTER);

        // Release Enter
        object.keyRelease(KeyEvent.VK_ENTER);

        //object.keyPress("c:\savelocation");


    }

    @Then("^I close the TestHarness")
    public void iCloseTheTestHarness() {
        testHarnessDriver.close();
    }
}
