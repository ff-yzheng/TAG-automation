package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.SharedWebDriver;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.MatcherAssert.assertThat;

public class Steps {
    private static final By GOOGLE_SEARCH_BOX_ID = By.id("lst-ib");
    private WebDriver driver = SharedWebDriver.getDriver();

    @Given("^I navigate to (.*)$")
    public void navigateTo(String website) throws Throwable {
        driver.get(website);
    }

    @When("^I search for (.*)$")
    public void search(String searchText) throws Throwable {
        WebElement textBox = driver.findElement(GOOGLE_SEARCH_BOX_ID);
        textBox.sendKeys(searchText);
        textBox.submit();
    }

    @Then("^I should see a link for (.*)")
    public void findOnPage(String link) {
        WebElement element = driver.findElement(By.cssSelector("a[href*='" + link + "']"));
        assertThat(element, CoreMatchers.notNullValue());
    }

    @When("^I click the link (.*)$")
    public void clickLinkFor(String link) throws Throwable {
        WebElement element = driver.findElement(By.cssSelector("a[href*='" + link + "']"));
        element.click();
    }

    @Then("^I listen to some sweet tunes for (\\d+) seconds")
    public void waitForMinutes(int seconds) throws Throwable {
        int time = seconds * 1000;
        Thread.sleep(time);
    }
}
