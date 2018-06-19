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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AuditLogSearch extends AbstractSteps {

    private AuditLog auditlog;

    @When("^I set the Type dropdown to (.*)$")
    public void i_set_the_Type_dropdown_to_FI(String searchText) throws Throwable {

        auditlog = new AuditLog(getDriver());
        // Set the Type Dropdown
        auditlog.SetTypeDropdown(searchText);
    }

    @Then("^I should see (.*)in the Type Column$")
    public void i_should_see_valueToFind_in_the_Type_Column(String searchText) throws Throwable {

       String search1Text = searchText.toLowerCase().trim();
       // check to see if the Text is present
       Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-fixed']/tbody/tr/td[1][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
       assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }


    @Then("^I should NOT see (.*) in the Type Column$")
    public void i_should_not_see_in_the_Type_Column(String searchText) throws Throwable {

        String search1Text = searchText.toLowerCase().trim();
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

    //Testcase 4 scenario 2 using username

    @When("^I set the username to (.*)$")
    public void i_set_the_username_to_ww(String searchText) throws Throwable {
        auditlog = new AuditLog(getDriver());
        auditlog.SetUserName(searchText);
    }

    @Then("^I should see (.*) in the Username Column$")
    public void i_should_see_valueToFind_in_the_Username_Column(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase().trim();
        // check to see if the Text is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-fixed']/tbody/tr/td[6][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Username Column$")
    public void i_should_NOT_see_valueNotTOFind_in_the_Username_Column(String searchText) throws Throwable {
        String search1Text = searchText.toLowerCase().trim();
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-fixed']/tbody/tr/td[6][contains(translate(text(),'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '" + search1Text + "')]")).isEmpty();
        assertFalse("Error: Cannot find " + search1Text + " in the search results", itemPresent);
    }


    @When("^I set the To Date to (.*)$")
    public void i_set_the_To_Date_to(String date) throws Throwable {

       //DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
       //String date1= dateFormat.format(date);
        auditlog = new AuditLog(getDriver());
        auditlog.SetToDate(date);
    }

    @Then("^I should see (.*) in the Date/Time Column$")
    public void i_should_see_in_the_Date_Time_Column(String date) throws Throwable {

        //using two SimpleDateFormat objects: one for parsing, and one for formatting
        DateFormat outputFormat  = new SimpleDateFormat("M/d/yy ");
        DateFormat inputFormat   = new SimpleDateFormat("MM/dd/yyyy");
        Date newDate = inputFormat.parse(date);
        String outputText = outputFormat.format(newDate);
        //String search1Text = outputText.toLowerCase().trim();
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-fixed']/tbody/tr/td[7][text()[contains(.,'" + outputText + "')]]")).isEmpty();
        assertTrue("Error: Cannot find " + outputText + " in the search results", itemPresent);
    }

    @Then("^I should NOT see (.*) in the Date/Time Column$")
    public void i_should_NOT_see_in_the_Date_Time_Column(String date) throws Throwable {

        //using two SimpleDateFormat objects: one for parsing, and one for formatting
        DateFormat dateFormat = new SimpleDateFormat("M/d/yy ");
        DateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date newDate = inputFormat.parse(date);
        String outputText = dateFormat.format(newDate);
       //String search1Text = outputText.toLowerCase().trim();
        Boolean itemPresent = !getDriver().findElements(By.xpath("//table[@class='table table-bordered table-striped table-fixed']/tbody/tr/td[7][text()[contains(.,'" + outputText + "')]]")).isEmpty();
        assertFalse("Error: Cannot find " + outputText + " in the search results", itemPresent);
    }

}

