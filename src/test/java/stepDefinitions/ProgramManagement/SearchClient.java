package stepDefinitions.ProgramManagement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.ProgramManagement.ClientSearch;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SearchClient extends AbstractSteps {

    private ClientSearch clientSearch;

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

        clientSearch = new ClientSearch(getDriver());
        // Set the FI Dropdown
        clientSearch.SetClientFIDropdown(searchText);
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

}
