package stepDefinitions.Security;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.Security.UsersSearch;
import pages.TransactGlobalPage;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SearchUsers extends AbstractSteps {


    private UsersSearch usersSearch;
    private TransactGlobalPage tagPage;

    //Last name steps

    @Then("^I should see (.*) in the Last Name$")
    public void iShouldSeeValueToFindInTheLastName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Last Name$")
    public void iShouldNOTSeeValueNotFoundInTheLastName(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //Role name Dropdown for Sec-Users
    @When("^I set the Role Name dropdown under Sec-Users to (.*)$")
    public void iSetTheRoleNameDropdownUnderSecUsersToValue(String SearchText) throws Throwable {

        usersSearch = new UsersSearch(getDriver());
        // Set the FI Dropdown
        usersSearch.SetRoleDropdown(SearchText);
    }

    @Then("^I should see (.*) in the Role Name on Users$")
    public void iShouldSeeValueToFindInTheRoleNameOnUsers(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[6][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Role Name on Users$")
    public void iShouldNOTSeeValueNotFoundInTheRoleNameOnUsers(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[6][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //Owner Dropdown for Sec-Users
    @When("^I set the Owner dropdown under Sec-Users to (.*)$")
    public void iSetTheOwnerDropdownUnderSecUsersToValue(String SearchText) throws Throwable {

        usersSearch = new UsersSearch(getDriver());
        // Set the FI Dropdown
        usersSearch.SetOwnerDropdown(SearchText);
    }

    @Then("^I should see (.*) in the Owner on Users$")
    public void iShouldSeeValueToFindInTheOwnerOnUsers(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[5][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Owner on Users$")
    public void iShouldNOTSeeValueNotFoundInTheOwnerOnUsers(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[5][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //Status Dropdown for Sec-Users
    @When("^I set the Status dropdown under Sec-Users to (.*)$")
    public void iSetTheStatusDropdownUnderSecUsersToValue(String SearchText) throws Throwable {

        usersSearch = new UsersSearch(getDriver());
        // Set the FI Dropdown
        usersSearch.SetStatusDropdown(SearchText);
    }

    @Then("^I should see (.*) in the Status on Users$")
    public void iShouldSeeValueToFindInTheStatusOnUsers(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[7][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Status on Users$")
    public void iShouldNOTSeeValueNotFoundInTheStatusOnUsers(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[7][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

}