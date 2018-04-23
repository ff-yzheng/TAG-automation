package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.SharedWebDriver;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BPHomePage;
import pages.LoginPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static pages.LoginPage.navigateToLoginPage;

public class LoginPageSteps {

    private LoginPage loginPage;

    @Given("^I navigate to the login page$")
    public void navigateTo(String website) throws Throwable {
        loginPage = navigateToLoginPage();
    }

    @When("^I log in$")
    public void logIn(String searchText) throws Throwable {
        loginPage.login("BP_AU_Customer_UN","BP_AU_Customer_PWD", "BP");
    }
}
