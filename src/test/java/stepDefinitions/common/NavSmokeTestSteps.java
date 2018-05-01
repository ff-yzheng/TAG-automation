package stepDefinitions.common;

import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.TransactGlobalPage;
import stepDefinitions.AbstractSteps;

import java.util.List;

import static global.SharedWebDriver.getDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NavSmokeTestSteps extends AbstractSteps {

    private TransactGlobalPage tagPage;

    @Then("^I check every page I can find for errors$")
    public void i_check_every_page_I_can_find_for_errors() throws Throwable {

        // Create the page object, using TransactGlobalPage since this test navigates every page of the site
        tagPage = new TransactGlobalPage(getDriver());

        // maximize the browser so the menu is visible (menu doesn't show if window is too small)
        getDriver().manage().window().maximize();

        //Thread.sleep(2000);

        // Load the top level nav options in the Main menu
        List<WebElement> mainNav = loadMainMenuData();

        // Loop through the top level menu items
        for(Integer i = 0; i < mainNav.size(); i++){
            // Need to refresh the menu data after every page refresh
            mainNav = loadMainMenuData();

            // Get the display name of the top level menu items for reporting
            String menuName = AllTrim(mainNav.get(i).getText());
            //System.out.println(menuName);

            // Get the submenu by navigating back a level in xpath then through the xpath to the submenu items
            List<WebElement> subMenuNav = mainNav.get(i).findElements(By.xpath("../ul/li/a"));

            // Loop through the Main Menu's Sub-Menu Items
            for(Integer j = 0; j < subMenuNav.size(); j++){

                // Refresh the main and submenu items after page refresh
                mainNav = loadMainMenuData();
                subMenuNav = mainNav.get(i).findElements(By.xpath("../ul/li/a"));

                // Get the innerText to use for the sub menu name in reporting
                String subMenuName = AllTrim(subMenuNav.get(j).getAttribute("innerText"));

                // Print the menu and submenu names to console
                System.out.println(menuName + " - " + subMenuName);

                // Click the main then submenu
                //WaitForElementToLoad(getDriver(), mainNav.get(i));
                mainNav.get(i).click();
                //WaitForElementToLoad(getDriver(), subMenuNav.get(i));
                subMenuNav.get(j).click();

                // Wait for the loading spinner to disappear before proceeding
                WaitForElementToDisappear(getDriver(), tagPage.LoadingSpinner);
                Thread.sleep(500); // Moving a little too fast after spinner disappears

                // Make sure we are on the right page by checking the breadcrumb text
                System.out.println("breadcrumb1: " + tagPage.BreadCrumb1.getAttribute("innerText"));
                System.out.println("breadcrumb2: " + tagPage.BreadCrumb2.getAttribute("innerText"));
            }
        }
    }

    private List<WebElement> loadMainMenuData(){

        List<WebElement> mainNav = tagPage.NavBarDropDowns.findElements(By.className("dropdown-toggle"));
        return mainNav;
    }

    /*
    private List<WebElement> loadSubMenuData(){
        List<WebElement> subMenuNav = mainNav.get(i).findElements(By.xpath("../ul/li/a"));
        return subMenuNav;
    }
    */
}
