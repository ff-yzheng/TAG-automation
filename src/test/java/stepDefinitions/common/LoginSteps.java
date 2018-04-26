package stepDefinitions.common;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.common.LoginPage;
import stepDefinitions.AbstractSteps;
import stepDefinitions.Steps;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class LoginSteps extends AbstractSteps {

    private LoginPage loginPage;

    @Given("^the login form at (.*)$")
    public void the_login_form_at_url(String url) {

        loginPage = new LoginPage(driver);

        // Navigate to url
        loginPage.driver.navigate().to(url);

        //Thread.sleep(5000);

        // Refresh the page model after load
        loginPage.RefreshModel();

        // Wait until the page loads by checking for the username field before continuing
        WaitUntilLoaded(loginPage.driver, loginPage.UserName);

        // Check to see if I am on the login page
        assertThat(loginPage.UserName.isDisplayed(), is(equalTo(true)));

        //System.out.println(loginPage.HasUsernameField.toString());

        /*        if (loginPage.HasUsernameField == true) {
            loginPage.logPass("Login page is displayed");
        } else {
            loginPage.logFail("Not on the login page");
        }
*/
    }

    @When("^I login as (.*) with (.*)")public void i_login_as_username_with_password(String userName, String password) throws Throwable {

        loginPage.SetUsername(userName);


    }
}
