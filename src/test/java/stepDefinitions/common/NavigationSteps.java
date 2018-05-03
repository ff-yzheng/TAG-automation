package stepDefinitions.common;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.TransactGlobalPage;
import pages.common.LoginPage;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class NavigationSteps extends AbstractSteps {

    private TransactGlobalPage tagPage;

    @When("^I navigate to (.*) - (.*)")
    public void i_navigate_to_MainMenu_SubMenu(String mainMenuText, String subMenuText) throws Throwable {

        tagPage= new TransactGlobalPage(getDriver());

        // maximize the browser so the menu is visible (menu doesn't show if window is too small)
        getDriver().manage().window().maximize();

        // Find the Main Menu item from the passed mainMenu
        WebElement mainMenu = getDriver().findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'" + mainMenuText + "')]"));

        // Find the submenu item from the passed mainMenu and subMenu
        WebElement subMenu = getDriver().findElement(By.xpath("//a[@class='dropdown-toggle' and contains(text(),'" + mainMenuText + "')]/../ul[@class='dropdown-menu']/li/a[contains(text(),'" + subMenuText + "')]"));

        // Click the main then submenu
        mainMenu.click();
        subMenu.click();

        // Wait for the loading spinner to disappear before proceeding
        WaitForElementToDisappear(getDriver(), tagPage.LoadingSpinner);
        Thread.sleep(500); // Test is moving a little too fast even waiting for the spinner to disappear

        // When going to the users page there is an extra delay in load that can break the test
        if (subMenuText == "Users"){
            WaitForElementToLoad(getDriver(), tagPage.ClickableRow1);
        }

        // Confirm we are on the correct page
        assertThat("Breadcrumb1 is not what was expected", AllTrim(tagPage.BreadCrumb1.getAttribute("innerText")), is(equalTo(mainMenuText)));
        assertThat("Breadcrumb2 is not what was expected", AllTrim(tagPage.BreadCrumb2.getAttribute("innerText")), is(equalTo(subMenuText)));
    }

    @Then("^I wait for (\\d+) (.*)")
    public void i_wait_for_seconds(int value, String timeUnit) throws Throwable {
        Integer timeToWaitInMS = 0;
        Boolean uniteOfTimeValid = false;

        System.out.println("unitOfTime: " + timeUnit);

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


}
