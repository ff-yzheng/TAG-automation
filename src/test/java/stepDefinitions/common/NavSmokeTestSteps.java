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
import static org.hamcrest.core.IsEqual.equalTo;

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
                mainNav.get(i).click();
                subMenuNav.get(j).click();

                // Wait for the loading spinner to disappear before proceeding
                WaitForElementToDisappear(getDriver(), tagPage.LoadingSpinner);
                Thread.sleep(500); // Test is moving a little too fast even waiting for the spinner to disappear

                // Make sure we are on the right page by checking the breadcrumb text
                assertThat("Breadcrumb1 is not what was expected", AllTrim(tagPage.BreadCrumb1.getAttribute("innerText")), is(equalTo(menuName)));
                assertThat("Breadcrumb2 is not what was expected", AllTrim(tagPage.BreadCrumb2.getAttribute("innerText")), is(equalTo(subMenuName)));
                //System.out.println("breadcrumb1: " + tagPage.BreadCrumb1.getAttribute("innerText"));
                //System.out.println("breadcrumb2: " + tagPage.BreadCrumb2.getAttribute("innerText"));

                CheckForErrors();

                // START WORK FOR ROW DETAILS
                // Check to see if there is a clickable row on the page
                Boolean clickableRowExists = ElementDisplays(tagPage.ClickableRow1);
                //System.out.println("clickableRowExists: " + clickableRowExists.toString());

                // Override clickableRowExists to false if we are on the chargeback or npes page
                // since the row click doesn't load a new page
                if (subMenuName.contains("Chargebacks") || subMenuName.contains("Non-Posted Exceptions")){
                    clickableRowExists = false;
                }

                // clickableRow can exist on the page when tabs are present
                // For example, logged in as an FI super and go to PM - FIs it loads the FI detail immediately
                // with a clickable MCCGroups page and tabs.
                // In the case we want to skip the rowclick and go to the tab navigation and checking code
                Boolean tabsExist = ElementDisplays(tagPage.TabArea);

                // Some pages with a clickableRow open on a new page with tabs, some on a new page without tabs or some in-line with the grid
                // Need to identify each page type so the correct code can execute
                // I'm not sure why but subMenuName == "Cards" wasn't working, using contains instead
                if (clickableRowExists || subMenuName.contains("Cards")){

                    // clickableRow exists but no tabs, need to click to get to the detail page
                    if (clickableRowExists && !tabsExist){
                        //System.out.println("clickable row exists but no tabs");

                        // Click the clickable row
                        tagPage.ClickableRow1.click();

                        // Wait for clickable row to disappear
                        //WaitForElementToLoad(getDriver(), tagPage.TabArea); // Can't rely on this since some details pages don't have tabs (e.g. Partners)
                        //WaitForElementToDisappear(getDriver(), tagPage.ClickableRow1); // Selenium bug with this https://github.com/angular/protractor/issues/3777
                        WaitForElementToLoad(getDriver(), tagPage.BreadCrumb3);
                        Thread.sleep(500);

                        // See if there are tabs present on the current page
                        tabsExist = ElementDisplays(tagPage.TabArea);

                        // If there are not tabs within the details page, report the breadcrumb and do error check
                        // If there are tabs they will be cycled tjrough and checked later in this test
                        if (!tabsExist){
                            System.out.println("single tab: " + AllTrim(tagPage.BreadCrumb3.getAttribute("innerText")));

                            // Check for error alert and report results
                            CheckForErrors();
                        }
                    }

                    // If we are on the Cards screen, need to search for a card to get the detail screen to open
                    // I'm not sure why but subMenuName == "Cards" wasn't working , using contains instead
                    if (subMenuName.contains("Cards")){
                        //System.out.println("Cards screen");

                        // Populate the Card search field
                        // Card number is for QA, eventually we'll probably need some for other environments and update the code here
                        tagPage.SetCardNumberSearchField("5388997000021673");

                        // Click the Search button
                        tagPage.SearchButton.click();

                        // Wait for tabs page to load
                        WaitForElementToLoad(getDriver(), tagPage.TabArea);
                    }

                    // See if there are tabs present on the current page
                    tabsExist = ElementDisplays(tagPage.TabArea);

                    // tabs exist within clickable row case
                    // If tabs exist load the tab data before trying to loop through tabs
                    if (tabsExist){
                        //System.out.println("tabs exist within clickable row");

                        checkTabs();
                    }
                }
                else
                {
                    // tabs exist but there was no clickable row case
                    // If tabs exist load the tab data before trying to loop through tabs
                    //tabsExist = ElementDisplays(tagPage.TabArea);

                    if (tabsExist){
                        //System.out.println("Tabs exist with no clickable row");

                        RetryFindElement(tagPage.TabArea);
                        checkTabs();
                    }
                }
                System.out.println();

            }
        }
    }

    private List<WebElement> loadMainMenuData(){

        tagPage.RefreshModel();
        //WaitUntilElementIsReady(tagPage.NavBarDropDowns);
        List<WebElement> mainNav = RetryFindElement(tagPage.NavBarDropDowns).findElements(By.className("dropdown-toggle"));
        return mainNav;
    }

    private List<WebElement> loadTabData(){

        tagPage.RefreshModel();

        // Code to, hopefully, prevent the sporadic StaleElementReferenceException
        RetryFindElement(tagPage.TabArea);
        /*
        new WebDriverWait(getDriver(), 10)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.id("checkoutLink")).click();
                    return true;
                });
        */

        List<WebElement> tabArea = tagPage.TabArea.findElements(By.className("tab"));
        return tabArea;
    }

    private void checkTabs() {
        // Load Tab Data
        List<WebElement> tabItems = loadTabData();

        // Navigate through the tabs
        for (Integer k = 0; k < tabItems.size(); k++) {
            // Reload the tabs for each iteration
            tabItems = loadTabData();

            // Get the tab name
            //String tabName = AllTrim(tabItems.get(k).getText()); // This was getting the tab count too
            tagPage.RefreshModel();
            //WaitUntilElementIsReady(tabItems.get(k));
            String tabName = GetTestFromNodeOnly(RetryFindElement(tabItems.get(k)));

            // Report Menu, Submenu & Tab
            System.out.println("tab: " + tabName);
            logInfo("tab: " + tabName);

            // Click the tab
            tagPage.RefreshModel();
            RetryFindElement(tabItems.get(k)).click();

            // Wait to make sure page updates before next steps
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Wait for breadcrumb3 to change to expected before continuing
            //WebElement breadcrumb3FoundByText = getDriver().findElement(By.xpath("//ol[@class='breadcrumb']/li[text()[contains(.,'" + tabName + "')]]"));
            //WaitForElementToLoad(getDriver(), getDriver().findElement(By.xpath("//ol[@class='breadcrumb']/li[text()[contains(.,'" + tabName + "')]]")));

            // Make sure the breadcrumb shows the expected tab name (used contains since some tabs have counts in them)
            //assertThat("Breadcrumb3 is not what was expected", tabName, containsString(AllTrim(tagPage.BreadCrumb3.getAttribute("innerText"))));
            tagPage.RefreshModel();
            assertThat("Breadcrumb3 is not what was expected", AllTrim(RetryFindElement(tagPage.BreadCrumb3).getAttribute("innerText")), is(equalTo(tabName)));

            CheckForErrors();
        }
    }

    private void CheckForErrors(){
        // Check for error alert and report results
        tagPage.RefreshModel();

        try{
            if(tagPage.AlertError.isDisplayed()){
                System.out.println("    I see an error");
            }
            else{
                System.out.println("    I don't see an error");
            }
        }
        catch(Exception exception){
            System.out.println("    I don't see an error");
        }
    }
}
