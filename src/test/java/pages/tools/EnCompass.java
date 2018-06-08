package pages.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class EnCompass extends TransactGlobalPage {

    public EnCompass(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Site Info
    private static final String SITE_XPATH = "//*[contains(text(),'EnCompass')]"; // An element that only shows on this page

    // Log Out link
    @FindBy(how = How.XPATH, using = "//a[@href='/logout.aspx']")
    public WebElement LogoutLink;

    // Hello message on main home screen
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_ctl03_TitleText']")
    public WebElement HomeWelcomeMessage;

    // Success Message
    @FindBy(how = How.XPATH, using = "//div[@id='ctl00_DivSuccessMessage']")
    public WebElement SuccessMessage;

    // *** LOGIN PAGE ***
    // Username
    @FindBy(how = How.XPATH, using = "//input[@id='txtusername']")
    public WebElement Username;

    // Password
    @FindBy(how = How.XPATH, using = "//input[@id='txtpassword']")
    public WebElement Password;

    // Organization ID
    @FindBy(how = How.XPATH, using = "//input[@id='txtLoginOrgGroupId']")
    public WebElement OrgIdLogin;

    // Login Button
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_logIn']")
    public WebElement LoginButton;

    // *** ORG GROUP PAGE ***
    // Org Group Login Page Bar
    @FindBy(how = How.XPATH, using = "//caption[contains(text(),'Organization Groups')]")
    public WebElement OrgGroupLoginPageBar;

    // Active Clients Checkbox
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_chkActive']")
    public WebElement ActiveClientsCheckbox;

    // Disabled Clients Checkbox
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_chkInactive']")
    public WebElement DisableClientsCheckbox;

    // New Clients Checkbox
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_chkNew']")
    public WebElement NewClientsCheckbox;

    // Company Name
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_tbCompanyName']")
    public WebElement CompanyName;

    // Company Number
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_tbCompanyNumber']")
    public WebElement CompanyNumber;

    // Company Org ID
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_tbOrganizationId']")
    public WebElement OrganizationId;

    // Search Button, Org Group Page
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_cmdSearch']")
    public WebElement SearchOrgGroupButton;

    // Org Group Row 1
    @FindBy(how = How.XPATH, using = "//tbody/tr[@id='ctl00_contents_dgClients_ctl03']")
    public WebElement OrgGroupRow1;

    // Org Group Row 2
    public static final String ORGROW2XPATH = "//tbody/tr[@id='ctl00_contents_dgClients_ctl04']";

    @FindBy(how = How.XPATH, using = ORGROW2XPATH)
    public WebElement OrgGroupRow2;

    // Select Org Action
    @FindBy(how = How.XPATH, using = "//a[text()='Select']")
    public WebElement SelectOrgAction;

    // Edit Org Org Group Settings Action
    @FindBy(how = How.XPATH, using = "//a[text()='Edit Organization Group Settings']")
    public WebElement EditOrgGroupOrgAction;

    // Edit Row Action
    @FindBy(how = How.XPATH, using = "//a[text()='Edit']")
    public WebElement EditRowAction;

    // *** ORGANIZATION GROUP SETTINGS ***
    // Enable MFA Checkbox
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_chkEnableMultifactorAuthentication']")
    public WebElement EnableMFACheckbox;

    // Save Org Group Settings button
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_btnSaveOrgSetting']")
    public WebElement SaveOrgGroupSettingsButton;

    // *** ORGANIZATION SETTINGS ***
    // Organization ID
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_txtOrgGroupLoginId']")
    public WebElement OrganizationIdInput;

    // Instant Approval section header
    @FindBy(how = How.XPATH, using = "//h2[text()='Instant Approval']")
    public WebElement InstantApprovalSection;

    // Enable Instant Approval checkbox
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_chkEnableInstantApproval']")
    public WebElement EnableInstantApprovalCheckbox;

    // Save Client Profile button
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_btnSave']")
    public WebElement SaveClientProfileButton;

    // Close button
    @FindBy(how = How.XPATH, using = "//input[@value='Close']")
    public WebElement CloseButton;

    // *** ENCOMPASS MENU ***
    // Super Admin Utilities link
    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_MainHeader_lnkSuperAdmin']")
    public WebElement SuperAdminUtilitiesLink;

    // Payables Menu
    @FindBy(how = How.XPATH, using = "//span[@id='payablesItemText']")
    public WebElement PayablesMenu;

    // Accounts Payable Submenu
    @FindBy(how = How.XPATH, using = "//div[@id='ctl00_MainMenu2_map']")
    public WebElement AccountsPayableSubMenu;

    // Create Merchant Log Sidemenu
    @FindBy(how = How.XPATH, using = "//a[@href='/payables/merchantPayments/MerchantLogEdit.aspx']")
    public WebElement CreateMlogSideMenu;

    // *** CREATE MERCHANT LOG PAGE ***
    // Merchant Dropdown
    @FindBy(how = How.XPATH, using = "//select[@id='ctl00_contents_MerchantDropDown']")
    public WebElement MerchantDropDown;

    // Merchant Note
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_MerchantDropDown']")
    public WebElement MerchantNote;

    // Customer Code
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_CustomerCodeTextBox']")
    public WebElement CustomerCode;

    // Customer Account No
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_CustomerAccountNoTextBox']")
    public WebElement CustomerAccountNo;

    // Effective From Date
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_EffectiveDateStartText']")
    public WebElement EffectiveFromDate;

    // Effective To Date
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_EffectiveDateStopText']")
    public WebElement EffectiveToDate;

    // Invoice Number
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_InvoiceGridView_ctl02_InvoiceNumberTextBox']")
    public WebElement InvNum;

    // Invoice Date
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_InvoiceGridView_ctl02_InvoiceDateTextBox']")
    public WebElement InvDate;

    // Invoice Amount
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_InvoiceGridView_ctl02_AmountTextBox']")
    public WebElement InvAmount;

    // Submit Button
    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    public WebElement SubmitButton;

    // Merchant Log ID
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_MerchantLogIdLabel']")
    public WebElement MlogId;

    // Card Number
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_lblActNo']")
    public WebElement CardNumber;

    // Card Expiration Date
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_lblExpDt']")
    public WebElement CardExpDate;

    // Card CSC
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_lblCVC2value']")
    public WebElement CardCsc;

    // *** SEARCH CONTROLS ***
    // Search Term Dropdown
    @FindBy(how = How.XPATH, using = "//select[@aria-label='Search Term']")
    public WebElement SearchTermDropdown;

    // Filter Type Dropdown
    @FindBy(how = How.XPATH, using = "//select[@aria-label='Filter Type']")
    public WebElement FilterTypeDropdown;

    // Search Values Dropdown
    @FindBy(how = How.XPATH, using = "//select[@aria-label='Search Term Values']")
    public WebElement SearchValuesDropdown;

    // Search button
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_btnSearch']")
    public WebElement SearchButton;

    // *** SUPER ADMIN - MANAGE AP ***
    // AP Orgs Group Row 1
    @FindBy(how = How.XPATH, using = "//tbody/tr[@id='ctl00_contents_dgAP_ctl03']")
    public WebElement APOrgRow1;

    // AP Orgs Row 2
    public static final String APORGROW2XPATH = "//tbody/tr[@id='ctl00_contents_dgAP_ctl04']";

    @FindBy(how = How.XPATH, using = APORGROW2XPATH)
    public WebElement APOrgRow2;

    // Edit Row Action
    // already defined above as EditRowAction

    // Inventory Row Action
    @FindBy(how = How.XPATH, using = "//a[text()='Inventory']")
    public WebElement InventoryRowAction;

    // *** AP CONFIGURATION PAGE ***
    // Company Number (get)

    // Status Email Address

    // Enable AP Online Checkbox

    // Enable SUGA Checkbox

    // Enable APPlog Checkbox

    // Dispute Reply To Email

    // Enable Effective Dates Checkbox

    // Override Corporate Credit Limit Checkbox

    // Save AP Config Button


    // *** INVENTORY PAGE
    // Add New button

    // Currency

    // Min Quantity

    // Max Quantity

    // Order Quantity

    // Purge Date

    // Submit Button

    // *** Job Test Automation ***




}
