package stepDefinitions.Security;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.Security.RoleSearch;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SearchRoles extends AbstractSteps {


    private RoleSearch roleSearch;


    //Role name Dropdown for Sec-Roles
    @When("^I set the Role Name dropdown under Sec-Roles to (.*)$")
    public void iSetTheRoleNameDropdownUnderSecRolesToValue(String SearchText) throws Throwable {

        roleSearch = new RoleSearch(getDriver());
        // Set the FI Dropdown
        roleSearch.SetRoleDropdown(SearchText);
    }

    @Then("^I should see (.*) in the Role Name$")
    public void iShouldSeeValueToFindInTheRoleName(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Role Name$")
    public void iShouldNOTSeeValueNotFoundInTheRoleName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //Owner Dropdown for Sec-Roles
    @When("^I set the Owner dropdown under Sec-Roles to (.*)$")
    public void iSetTheOwnerDropdownUnderSecRolesToValue(String SearchText) throws Throwable {

        roleSearch = new RoleSearch(getDriver());
        // Set the FI Dropdown
        roleSearch.SetOwnerDropdown(SearchText);
    }

    @Then("^I should see (.*) in the Owner$")
    public void iShouldSeeValueToFindInTheOwner(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[3][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Owner$")
    public void iShouldNOTSeeValueNotFoundInTheOwner(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-sortable']/tbody/tr/td[3][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

}

