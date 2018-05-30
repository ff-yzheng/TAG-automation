package pages;

import global.SharedWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;

public class TransactGlobalPage {

    public WebDriver driver;

    public TransactGlobalPage(WebDriver driver) {
        this.driver = SharedWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Initialize Elements
    public void RefreshModel(){
        PageFactory.initElements(driver, this);
    }

    // Home
    @FindBy(how = How.XPATH, using = "//a[@href='#home']")
    public WebElement HomeLink;

    public void NavigateToHomePage() {
        HomeLink.click();
    }

    // Logout
    private static final String LOGOUT_XPATH = "//a[@href='#logout']";

    @FindBy(how = How.XPATH, using = LOGOUT_XPATH)
    public WebElement LogoutLink;

    public void Logout() {
        LogoutLink.click();
    }

    // **** Navigation Options ****
    // Nav Bar Region
    @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav pull-right']")
    public WebElement NavBarDropDowns;

    // Tab Region
    @FindBy(how = How.XPATH, using = "//ul[@class='nav nav-tabs']")
    public WebElement TabArea;

    // **** Menu & Submenu Items ****
    // Program Management Menu
    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle' and contains(text(),'Program Management')]")
    public WebElement ProgramMgmtMenu;

    // FIs Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'FIs')]")
    public WebElement FIsSubMenu;

    // Partners Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Partners')]")
    public WebElement PartnersSubMenu;

    // Clients Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Clients')]")
    public WebElement ClientsSubMenu;

    // PM Companies Submenu
    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle' and contains(text(),'Program Management')]/../ul[@class='dropdown-menu']/li/a[contains(text(),'Companies')]")
    public WebElement CompaniesPMSubMenu;

    // Operations Menu
    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle' and contains(text(),'Operations')]")
    public WebElement OperationsMenu;

    // Audit Log Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Audit Log')]")
    public WebElement AuditLogSubMenu;

    // Card Orders Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Card Orders')]")
    public WebElement CardOrdersSubMenu;

    // Chargebacks Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Chargebacks')]")
    public WebElement ChargebacksSubMenu;

    // Events Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Events')]")
    public WebElement EventsSubMenu;

    // Non-Posted Exceptions Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Non-Posted Exceptions')]")
    public WebElement NonPostedExceptionsSubMenu;

    // Financial Audit Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Financial Audit')]")
    public WebElement FinancialAuditSubMenu;

    // Customer Service Menu
    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle' and contains(text(),'Customer Service')]")
    public WebElement CustomerServiceMenu;

    // Cards Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Cards')]")
    public WebElement CardsSubMenu;

    // CS - Companies Submenu
    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle' and contains(text(),'Customer Service')]/../ul[@class='dropdown-menu']/li/a[contains(text(),'Companies')]")
    public WebElement CompaniesCSSubMenu;

    // Security Menu
    @FindBy(how = How.XPATH, using = "//a[@class='dropdown-toggle' and contains(text(),'Security')]")
    public WebElement SecurityMenu;

    // Roles Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Roles')]")
    public WebElement RolesSubMenu;

    // Users Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Users')]")
    public WebElement UsersSubMenu;

    // Settings Submenu
    @FindBy(how = How.XPATH, using = "//ul[@class='dropdown-menu']/li/a[contains(text(),'Settings')]")
    public WebElement SettingsSubMenu;

    // Help Menu
    @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav pull-right']/li/a[contains(text(),'Help')]")
    public WebElement HelpMenu;

    // **** Breadcrumb Items ****
    // Breadcrumb1
    @FindBy(how = How.XPATH, using = "//ol[@class='breadcrumb']/li[1]")
    public WebElement BreadCrumb1;

    // Breadcrumb2
    @FindBy(how = How.XPATH, using = "//ol[@class='breadcrumb']/li[2]")
    public WebElement BreadCrumb2;

    // Breadcrumb3
    @FindBy(how = How.XPATH, using = "//ol[@class='breadcrumb']/li[3]")
    public WebElement BreadCrumb3;

    // **** Loading Spinner/Modal ****
    @FindBy(how = How.XPATH, using = "//div[@class='loading-container']")
    public WebElement LoadingSpinner;

    @FindBy(how = How.XPATH, using = "//div[@class='loading-container' and contains(@style,'display: none')]")
    public WebElement LoadingSpinnerIsHidden;

    @FindBy(how = How.XPATH, using = "//div[@class='loading-container' and contains(@style,'display: block')]")
    public WebElement LoadingSpinnerIsActive;

    // **** Shared Grid & Search Controls ****
    // Clickable Row 1
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'table-container')]/table/tbody/tr[@class='clickable']")
    public WebElement ClickableRow1;

    // Row 1
    @FindBy(how = How.XPATH, using = "//div[@class='table-container']/table/tbody/tr")
    public WebElement GridRow1;

    // Card Number Search Field
    @FindBy(how = How.XPATH, using = "//input[@name='CardNumber']")
    public WebElement CardNumberSearchField;

    public void SetCardNumberSearchField(String value) {
        CardNumberSearchField.clear();
        CardNumberSearchField.sendKeys(value);
    }

    // Search Button
    @FindBy(how = How.XPATH, using = "//button[text()='Search']") // Need more definitions? //button[@id='search-btn']
    public WebElement SearchButton;

    // Save Button
    @FindBy(how = How.XPATH, using = "//button[text()='Save']")
    public WebElement SaveButton;

    public void ClickSaveButtonAndWait(){
        SaveButton.click();

        // wait for save button to be disabled
        AbstractSteps.WaitForElementToLoad(getDriver(), DisabledSaveButton);

        /*
        // Wait for loading spinner to disappear
        AbstractSteps.WaitForElementToLoad(getDriver(), LoadingSpinnerIsHidden);

        // wait for Updates have been saved alert to disappear before continuing
        AbstractSteps.WaitForElementToDisappear(getDriver(), AlertSuccess);
        */
    }

    // Disabled Save Button
    @FindBy(how = How.XPATH, using = "//button[text()='Save' and contains(@class,'disabled')]")
    public WebElement DisabledSaveButton;

    // Add New Button
    @FindBy(how = How.XPATH, using = "//a[@class='btn-icon-text']/span[contains(text(),'Add New')]")
    public WebElement AddNewButton;

    // **** Page Level Verification Items ****
    // Error Alert
    @FindBy(how = How.XPATH, using = "//*[@class='form-error' and @innertext!~'Credit Limit.*' or @class='alert' or @class~'alert-danger']")
    public WebElement AlertError;

    // Alert success
    @FindBy(how = How.XPATH, using = "//div[@id='alert-region']//div[contains(@class,'alert-success')]")
    public WebElement AlertSuccess;


}

