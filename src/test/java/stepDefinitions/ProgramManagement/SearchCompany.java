package stepDefinitions.ProgramManagement;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import pages.ProgramManagement.CompanySearch;
import pages.ProgramManagement.PartnerSearch;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class SearchCompany extends AbstractSteps {


    private CompanySearch companySearch;
    private PartnerSearch partnerSearch;


    //Test case 3 - Scenarios for PM - Companies and for Test Case 9 - CS - Companies
    //PM-Companies-Company Name
    @Then("^I should see (.*) in the Companies-Company Name$")
    public void iShouldSeeValueToFindInThePMCompaniesCompanyName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    //PM-Companies-Company Name
    @Then("^I should NOT see (.*) in the Companies-Company Name$")
    public void iShouldNOTSeeValueNotFoundInThePMCompaniesCompanyName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //PM-Companies-Company Number
    @Then("^I should see (.*) in the Companies-Company Number")
    public void iShouldSeeValueToFindInThePMCompaniesCompanyNumber(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[2][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    //PM-Companies-Company Number
    @Then("^I should NOT see (.*) in the Companies-Company Number")
    public void iShouldNOTSeeValueNotFoundInThePMCompaniesCompanyNumber(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[2][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //PM-Companies-Partner Name
    @Then("^I should see (.*) in the Companies-Partner Name")
    public void iShouldSeeValueToFindInThePMCompaniesPartnerName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[4][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    //PM-Companies-Partner Name
    @Then("^I should NOT see (.*) in the Companies-Partner Name")
    public void iShouldNOTSeeValueNotFoundInThePMCompaniesPartnerName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[4][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //PM-Companies-Client Name
    @Then("^I should see (.*) in the Companies-Client Name")
    public void iShouldSeeValueToFindInThePMCompaniesClientName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[3][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    //PM-Companies-Client Name
    @Then("^I should NOT see (.*) in the Companies-Client Name")
    public void iShouldNOTSeeValueNotFoundInThePMCompaniesClientName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[3][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }

    //FI Dropdown for PM-Companies
    @When("^I set the FI Name dropdown under PM-Companies to (.*)$")
    public void iSetTheFINameDropdownUnderPMCompaniesToValue(String SearchText) throws Throwable {

        companySearch = new CompanySearch(getDriver());
        // Set the FI Dropdown
        companySearch.SetCompanyFIDropdown(SearchText);
    }

    // PM-Companies-FI Name
    @Then("^I should see (.*) in the Companies-FI Name$")
    public void iShouldSeeValueToFindInThePMCompaniesFIName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[5][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    // PM-Companies-FI Name
    @Then("^I should NOT see (.*) in the Companies-FI Name$")
    public void iShouldNOTSeeValueNotFoundInThePMCompaniesFIName(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        // Confirm that the Text is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr/td[5][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Found " + search1Text + " in the search results", itemPresent);
    }


}
