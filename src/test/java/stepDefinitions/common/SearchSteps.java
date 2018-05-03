package stepDefinitions.common;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.TransactGlobalPage;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class SearchSteps extends AbstractSteps {

    private TransactGlobalPage tagPage;

    @When("^I search (.*) for (.*)")
    public void i_search_SEARCHFIELD_for_SEARCHTEXT(String searchFieldLabel, String searchText) throws Throwable {
        tagPage= new TransactGlobalPage(getDriver());

        // Find the Search Field item from the passed searchFieldLabel
        WebElement searchField = getDriver().findElement(By.xpath("//label[contains(text(),'" + searchFieldLabel + "')]/../div/input"));

        // Set the searchField to the passed searchText value
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    @When("^I execute the search$")
    public void i_click_the_search_button() throws Throwable {

        try {
            tagPage.SearchButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
