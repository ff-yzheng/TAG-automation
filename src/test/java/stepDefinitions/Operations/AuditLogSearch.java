package stepDefinitions.Operations;


import pages.Operations.AuditLog;
import pages.ProgramManagement.PartnerSearch;
import stepDefinitions.AbstractSteps;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import static global.SharedWebDriver.getDriver;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class AuditLogSearch extends AbstractSteps {

    private AuditLog auditlog;
    private PartnerSearch partnerSearch;
    private AbstractSteps abstractSteps;

    @When("^I set the Type dropdown to (.*)$")
    public void i_set_the_Type_dropdown_to_FI(String searchText) throws Throwable {

        auditlog = new AuditLog(getDriver());
        // Set the Type Dropdown
        auditlog.SetTypeDropdown(searchText);
    }

    @Then("^I should see (.*)in the Type Column$")
    public void i_should_see_valueToFind_in_the_Type_Column(String searchText) throws Throwable {

       String search1Text = searchText.toLowerCase();
            // check to see if the Text is present
       Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-fixed']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
       assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }


    @Then("^I should NOT see (.*) in the Type Column$")
    public void i_should_not_see_in_the_Type_Column(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase();
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-fixed']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }


    @Then("^I click on the Search Button$")
    public void i_click_on_the_Search_Button() throws Throwable {

        auditlog = new AuditLog(getDriver());
        auditlog.SearchButton.click();
        WaitForElementToDisappear(getDriver(), auditlog.LoadingSpinnerXPATH);
        auditlog.RefreshModel();
    }
}
