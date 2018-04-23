package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BPHomePage;
import pages.LoginPage;

import static pages.LoginPage.navigateToLoginPage;

public class BPHomePageSteps {
    private LoginPage loginPage;

    @Then("^I should see that I am logged in on the home page$")
    public void navigateTo(String website) throws Throwable {
        BPHomePage bpHomePage = new BPHomePage();
        bpHomePage.validateUserLoggedInPage();
    }
}
