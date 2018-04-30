package stepDefinitions.common;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import global.SharedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.TransactGlobalPage;
import stepDefinitions.AbstractSteps;

import java.util.List;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class NavSmokeTestSteps extends AbstractSteps {

    private TransactGlobalPage tagPage;

    @Then("^I check every page I can find for errors$")
    public void i_check_every_page_I_can_find_for_errors() throws Throwable {

        tagPage = new TransactGlobalPage(getDriver());

        // maximize the browser so the menu is visible (menu doesn't show if window is too small)
        getDriver().manage().window().maximize();

        //Thread.sleep(2000);

        List<WebElement> mainNav = tagPage.NavBarDropDowns.findElements(By.className("dropdown-toggle"));

        // Get the Main Menu Items
        for(Integer i = 0; i < mainNav.size(); i++){
            String menuName = AllTrim(mainNav.get(i).getText());
            //System.out.println(menuName);

            // To get the submenu I need to navigate back a level in xpath then through the xpath
            List<WebElement> subMenuNav = mainNav.get(i).findElements(By.xpath("../ul/li/a"));

            // Get the Sub-Menu Items
            for(Integer j = 0; j < subMenuNav.size(); j++){

                // TODO need the refresh routines like in C#?
                tagPage.RefreshModel();

                // Had to use innerText to get the label for name
                String subMenuName = AllTrim(subMenuNav.get(j).getAttribute("innerText"));

                // Print the menu and submenu names
                System.out.println(menuName + " - " + subMenuName);

                // Click the main and submenu
                mainNav.get(i).click();
                subMenuNav.get(j).click();

                Thread.sleep(2000);

            }
        }


    }

    /*
    private void loadMainMenuData()
    {
        // Set variable to the Main Menu Area repo item
        tagPage.NavBarDropDowns = repo.TransactGlobal.Menu.NavBarDropdowns;
        // Look for descendents of the Main Menu Area with LI tag and "dropdown" (to get only the top level items)
        this.myMainMenuItems = mainNav.Find<LiTag>("Li[@class='dropdown']");
    }
    */
}
