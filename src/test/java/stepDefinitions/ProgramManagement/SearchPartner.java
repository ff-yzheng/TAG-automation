package stepDefinitions.ProgramManagement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import pages.TransactGlobalPage;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import pages.ProgramManagement.*;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.ProgramManagement.*;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static stepDefinitions.common.NavigationSteps.iClickOnTheYTab;
import static stepDefinitions.common.NavigationSteps.iShouldSeeTheXTab;


public class SearchPartner extends AbstractSteps {


    private PartnerSearch partnerSearch;


    //TESTCASE 1 - Scenarios for PM-Partner Search

    @Then("^I should see (.*) in the Partner Name$")
    public void i_should_see_valueToFind_in_the_partner_name(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the search results$")
    public void i_should_NOT_see_valueNotFound_in_the_search_results(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //FI Dropdown for PM-Partners
    @When("^I set the FI Name dropdown under PM-Partners to (.*)$")
    public void i_set_the_FI_Name_dropdown_under_PM_Partners_to_value(String SearchText) throws Throwable {

        partnerSearch = new PartnerSearch(getDriver());
        // Set the FI Dropdown
        partnerSearch.SetClientFIDropdown(SearchText);
    }

    @Then("^I should see (.*) in the FI Name$")
    public void i_should_see_valueToFind_in_the_FI_name(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the FI Name$")
    public void i_should_NOT_see_valueNotFound_in_the_FI_name(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }


    @Then("^I should see (.*) in the Client Name$")
    public void i_should_see_in_the_Client(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Client Name$")
    public void i_should_NOT_see_valueNotFound_in_the_Client_Name(String searchText) throws Throwable {

        String search2Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search2Text + "')]")).isEmpty();
        assertFalse("Error: Found " + searchText + " in the search results", itemPresent);
    }


    //Testcase-2 scenario PM-Clients Partner search

    @Then("^I should see (.*) in the Partner results$")
    public void i_should_see_valueToFind_in_the_PMClientPartner_results(String searchText) throws Throwable {

        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[2][contains(text(), '" + searchText + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + searchText + " in the search results", itemPresent);
    }

    // PM-Client-FI Name
    @Then("^I should NOT see (.*) in the Partner results$")
    public void i_should_NOT_see_valueNotFound_in_the_PMClientpartner_results(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[2][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }


    @When("^I set the FI Name dropdown under PM-Clients to (.*)$")
    public void i_set_the_FI_Name_dropdown_under_PMClients_to_value(String searchText) throws Throwable {

        partnerSearch = new PartnerSearch(getDriver());
        // Set the FI Dropdown
        partnerSearch.SetFIDropdown(searchText);
    }

    //Testcase 2 for PM-Clients Search
    // PM-Client-FI Name
    @Then("^I should see (.*) in the Clients-FI Name$")
    public void i_should_see_valueToFind_in_the_PMClientsFI_name(String searchText) throws Throwable {

        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[3][contains(text(), '" + searchText + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + searchText + " in the search results", itemPresent);
    }

    // PM-Client-FI Name
    @Then("^I should NOT see (.*) in the Clients-FI Name$")
    public void i_should_NOT_see_valueNotFound_in_the_PMClientsFI_name(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[3][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //Search Button click
    @When("^I click on Search Button$")
    public void i_click_the_search_button() throws Throwable {

        partnerSearch = new PartnerSearch(getDriver());
        getDriver().manage().window().setSize(new Dimension(1440, 900));
        partnerSearch.SearchButton.click();
        partnerSearch.iWaitForXTime(5,"seconds");

    }

}
