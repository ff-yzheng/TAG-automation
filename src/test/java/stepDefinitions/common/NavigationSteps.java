package stepDefinitions.common;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TransactGlobalPage;
import pages.common.LoginPage;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class NavigationSteps extends AbstractSteps {

    private TransactGlobalPage tagPage;

    @When("^I navigate to (.*) - (.*)")
    public void iNavigateToMainMenuSubMenu(String mainMenuText, String subMenuText) throws Throwable {

        tagPage = new TransactGlobalPage(getDriver());

        // maximize the browser so the menu is visible (menu doesn't show if window is too small)
        getDriver().manage().window().setSize(new Dimension(1440, 900));

        // Find the Main Menu item from the passed mainMenu
        WebElement mainMenu = getDriver().findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'" + mainMenuText + "')]"));

        // Find the submenu item from the passed mainMenu and subMenu
        WebElement subMenu = getDriver().findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'" + mainMenuText + "')]/../ul[@class='dropdown-menu']/li/a[contains(text(),'" + subMenuText + "')]"));

        // Click the main then submenu
        mainMenu.click();
        subMenu.click();

        // Wait for the loading spinner to disappear before proceeding
        WaitForElementToDisappear(getDriver(), tagPage.LoadingSpinnerXPATH);
        Thread.sleep(500); // Test is moving a little too fast even waiting for the spinner to disappear

        // When going to the users page there is an extra delay in load that can break the test
        if (subMenuText.equals("Users")){
            WaitForElementToLoad(getDriver(), tagPage.ClickableRow1);
        }

        // For slower loading pages: Wait until breadcrumb2 (found via expected text & xpath) is present before continuing
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath((("//*[@id='breadcrumb-region']//*[contains(text(),'" + subMenuText + "')]")))));
        // Extra wait to make sure the Home page breadcrumb is no longer present (hidden behind picture)
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath((("//*[@id='breadcrumb-region']//*[contains(text(),'Home')]")))));

        // Confirm we are on the correct page
        assertThat("Breadcrumb1 is not what was expected", AllTrim(tagPage.BreadCrumb1.getAttribute("innerText")), is(equalTo(mainMenuText)));
        assertThat("Breadcrumb2 is not what was expected", AllTrim(tagPage.BreadCrumb2.getAttribute("innerText")), is(equalTo(subMenuText)));
    }

    @Then("^I should see the (.*) menu$")
    public void iShouldSeeTheYMenu(String menuName) throws Throwable {
        // Find the menu from the passed text value
        //Boolean menuPresent = getDriver().findElement(By.xpath("//ul[contains(@class,'navbar')]/li/a[contains(text(),'" + menuName + "')]")).isDisplayed();
        //assertThat("Error: Cannot find " + menuName + " menu", menuPresent, is(equalTo(true)));

        // Check to see if the menu is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//ul[contains(@class,'navbar')]/li/a[contains(text(),'" + menuName + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + menuName + " menu", itemPresent);
    }

    @Then("^I should NOT see the (.*) menu$")
    public void iShouldNOTSeeTheYMenu(String menuName) throws Throwable {
        // Confirm that the menu is NOT found
        //assertThat("Error: Found  " + menuName + " menu", getDriver().findElements(By.xpath("//ul[contains(@class,'navbar')]/li/a[contains(text(),'" + menuName + "')]")).isEmpty(), is(equalTo(true)));

        // Confirm that the menu is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//ul[contains(@class,'navbar')]/li/a[contains(text(),'" + menuName + "')]")).isEmpty();
        assertFalse("Error: Found " + menuName + " menu", itemPresent);
    }

    @When("^I click on the (.*) menu")
    public void iClickOnTheYMenu(String mainMenuText) throws Throwable {
        // Find the Main Menu item from the passed mainMenu
        WebElement mainMenu = getDriver().findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'" + mainMenuText + "')]"));

        // Click the main then submenu
        mainMenu.click();
    }

    @When("^I click on the (.*) tab")
    public static void iClickOnTheYTab(String tabName) throws Throwable {
        // Find the tab item from the passed tabName
        WebElement tab = getDriver().findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]//a[contains(text(),'" + tabName + "')]"));

        // Click the main then submenu
        tab.click();

        // This won't always work since the display name isn't always the url name (i.e. 1st Chargebacks and firstchargebak)
        //WaitForUrlToContain(getDriver(), tabName);

        //Thread.sleep(2000);

        // Wait for the tab to go active
        //WaitUntilElementExists(getDriver().findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]/li[@class='active']/a[contains(text(),'" + tabName + "')]")));
        //WaitForElementToLoad(getDriver(), getDriver().findElement(By.xpath("//ul[contains(@class,'nav nav-tabs')]/li[@class='active']/a[contains(text(),'" + tabName + "')]")));
    }

    @Then("^I should see the (.*) - (.*) submenu")
    public void iShouldSeeTheMainMenuSubMenu(String mainMenuText, String subMenuText) throws Throwable {
        // Confirm that the menu is displayed
        //assertThat("Error: Cannot find " + mainMenuText + " - " + subMenuText, false, is(equalTo(getDriver().findElements(By.xpath("//ul[contains(@class,'navbar')]/li/a[contains(text(),'" + mainMenuText + "')]/../ul[@class='dropdown-menu']/li/a[contains(text(),'" + subMenuText + "')]")).isEmpty())));

        // Check to see if the submenu is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//ul[contains(@class,'navbar')]/li/a[contains(text(),'" + mainMenuText + "')]/../ul[@class='dropdown-menu']/li/a[contains(text(),'" + subMenuText + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + mainMenuText + " - " + subMenuText, itemPresent);
    }

    @Then("^I should NOT see the (.*) - (.*) submenu")
    public void iShouldNOTSeeTheMainMenuSubMenu(String mainMenuText, String subMenuText) throws Throwable {
        // Confirm that the submenu is NOT found
        Boolean itemPresent = !getDriver().findElements(By.xpath("//ul[contains(@class,'navbar')]/li/a[contains(text(),'" + mainMenuText + "')]/../ul[@class='dropdown-menu']/li/a[contains(text(),'" + subMenuText + "')]")).isEmpty();
        assertFalse("Error: Found " + mainMenuText + " - " + subMenuText, itemPresent);
    }

    @Then("^I should be on the (.*) tab$")
    public void iShouldBeOnTheXTab(String tabName) throws Throwable {
        // Check to see if I am on the correct tab
        Boolean tabActive = !getDriver().findElements(By.xpath("//ul[contains(@class,'nav nav-tabs')]/li[@class='active']/a[contains(text(),'" + tabName + "')]")).isEmpty();
        assertTrue("Error: " + tabName + " is not the active tab", tabActive);
    }

    // Checks anywhere in the breadcrumb for the passed value
    @Then("^I should be on the (.*) page$")
    public void iShouldBeOnTheXPage(String value) throws Throwable {
        // Check to see if I am on the correct tab
        Boolean itemPresent = !getDriver().findElements(By.xpath("//ol[contains(@class,'breadcrumb')]//*[contains(text(),'" + value + "')]")).isEmpty();
        assertTrue("Error: " + value + " not found in the page breadcrumb", itemPresent);
    }

    @Then("^I should see the (.*) tab$")
    public static void iShouldSeeTheXTab(String tabName) throws Throwable {
        // Check to see if the tab is present
        Boolean itemPresent = !getDriver().findElements(By.xpath("//ul[contains(@class,'nav nav-tabs')]/li/a[contains(text(),'" + tabName + "')]")).isEmpty();
        assertTrue("Error: Cannot find " + tabName, itemPresent);
    }

    @When("^I click the Add New button")
    public void iClickTheAddNewButton() throws Throwable {
        // Click the add new button
        tagPage.AddNewButton.click();

        // Wait for Breadcrumb3 to load (when we should be on the new page)
        WaitForElementToLoad(getDriver(), tagPage.BreadCrumb3);
    }

    @Then("^I wait for (\\d+) (.*)")
    public void iWaitForXTime(int value, String timeUnit) throws Throwable {
        Integer timeToWaitInMS = 0;
        Boolean uniteOfTimeValid = false;

        //System.out.println("unitOfTime: " + timeUnit);

        // Translate the value and timeUnit text to get the proper amount of time
        if(timeUnit.toLowerCase().equals("milliseconds")){
            uniteOfTimeValid = true;
            timeToWaitInMS = value;
        }

        if(timeUnit.toLowerCase().equals("seconds")){
            uniteOfTimeValid = true;
            timeToWaitInMS = value * 1000;
        }

        if(timeUnit.toLowerCase().equals("minutes")){
            uniteOfTimeValid = true;
            timeToWaitInMS = value * 60000;
        }

        if (!uniteOfTimeValid){
            System.out.println("Invalid unit of time, you can only use 'milliseconds', 'seconds', and 'minutes'");
        }

        try {
            Thread.sleep(timeToWaitInMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


