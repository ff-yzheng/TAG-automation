package pages;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import repo.Locator;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

public class BPHomePage {

    @FindBy(how = How.XPATH, using = Locator.CLIENT_WELCOME_TEXT)
    public WebElement WelcomeText;

    @FindBy(how = How.XPATH, using = Locator.BP_LOGO_IMG)
    public WebElement BPLogo;

    @FindBy(how = How.XPATH, using = Locator.HOME_MENU)
    public WebElement HomeMenu;

    @FindBy(how = How.ID, using = Locator.ACCOUNTS_MENU)
    public WebElement Accounts;

    @FindBy(how = How.ID, using = Locator.CARDS_MENU)
    public WebElement Cards;

    @FindBy(how = How.ID, using = Locator.TRANSACTIONS_MENU)
    public WebElement Transactions;

    @FindBy(how = How.ID, using = Locator.REPORTS_MENU)
    public WebElement Reports;

    @FindBy(how = How.ID, using = Locator.SUPPORT_MENU)
    public WebElement Support;

    @FindBy(how = How.ID, using = Locator.ADMIN_MENU)
    public WebElement Admin;

    @FindBy(how = How.XPATH, using = Locator.HELP_REF)
    public WebElement help;

    @FindBy(how = How.LINK_TEXT, using = Locator.LOGOUT)
    public WebElement logoff;

    @FindBy(how = How.ID, using = Locator.STATUS_MENU)
    public WebElement Status;

    @FindBy(how = How.ID, using = Locator.ACCOUNT_MAINTENANCE_MENU)
    public WebElement AccountMaintenance;

    @FindBy(how = How.XPATH, using = Locator.CONTACTS_MENU)
    public WebElement Contacts;

    @FindBy(how = How.ID, using = Locator.DRIVERS_MENU)
    public WebElement Drivers;

    @FindBy(how = How.ID, using = Locator.VEHICLES_MENU)
    public WebElement Vehicles;

    @FindBy(how = How.ID, using = Locator.COST_CENTERS_MENU)
    public WebElement CostCenters;

    @FindBy(how = How.ID, using = Locator.QUICK_LINKS)
    public WebElement QuickLinks;

    @FindBy(how = How.XPATH, using = Locator.CUSTOMER_NAME_COMBO)
    public WebElement CustomerNameCombo;

    @FindBy(how = How.XPATH, using = Locator.CUSTOMER_NAME_LABEL)
    public WebElement CustomerNameLabel;

    private WebDriver driver;

    public BPHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void validateUserLoggedInPage() throws Exception {
        validateLogo();
        validateWelcomeText();
        validateLogoutLink();
        validateQuickLinks();
        validateHome();
        validateCustomerName();

    }

    private void validateLogo() throws Exception {

        assertTrue(BPLogo.isDisplayed());
    }

    private void validateWelcomeText() throws Exception {

        assertTrue("Welcome Text is Not Displayed", WelcomeText.isDisplayed());
        String welcomeTextString = WelcomeText.getText().trim();
        assertThat(welcomeTextString, CoreMatchers.containsString("Welcome to StarCard Online"));
    }

    private void validateLogoutLink() throws Exception {

        assertTrue("Logout is Not Displayed", logoff.isDisplayed());
    }

    private void validateQuickLinks() throws Exception {

        assertTrue("Quick Links is Not Displayed", QuickLinks.isDisplayed());
    }
    private void validateHelpLink() throws Exception {
        assertTrue("Help is Not Displayed", help.isDisplayed());
    }
    private void validateAccountsMenu() throws Exception{

        assertTrue("Menu Item Accounts is Not Displayed", Accounts.isDisplayed());

        Actions act = new Actions(driver);
        act.moveToElement(Accounts);

        assertTrue("Sub Menu Item Status is Not Displayed", Status.isDisplayed());
        assertTrue("Sub Menu Item AccountMaintenance is Not Displayed", AccountMaintenance.isDisplayed());
        assertTrue("Sub Menu Item Contacts is Not Displayed", Contacts.isDisplayed());
        assertTrue("Sub Menu Item Drivers is Not Displayed", Drivers.isDisplayed());
        assertTrue("Sub Menu Item Vehicles is Not Displayed", Vehicles.isDisplayed());
        assertTrue("Sub Menu Item CostCenters is Not Displayed", CostCenters.isDisplayed());
    }

    private void validateHome() throws Exception {

        assertTrue("Menu Item HomeMenu is Not Displayed", HomeMenu.isDisplayed());
        assertTrue("Menu Item Cards is Not Displayed", Cards.isDisplayed());
        assertTrue("Menu Item Transactions is Not Displayed", Transactions.isDisplayed());
        assertTrue("Menu Item Reports is Not Displayed", Reports.isDisplayed());
        assertTrue("Menu Item Support is Not Displayed", Support.isDisplayed());
    }

    private void validateCustomerName() throws Exception {
        assertTrue("Customer Name Combo is Not Displayed", CustomerNameCombo.isDisplayed());
        System.out.println("Customer Name: " + CustomerNameCombo.getText());
        assertTrue("Customer Name Label is Not Displayed", CustomerNameLabel.isDisplayed());
        //        Probably want to assert on the account number or something here...
    }
}

