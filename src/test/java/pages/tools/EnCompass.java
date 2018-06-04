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

    // *** LOGIN PAGE ***
    // Username
    @FindBy(how = How.XPATH, using = "//input[@id='txtusername']")
    public WebElement EncUsername;

    // Password
    @FindBy(how = How.XPATH, using = "//input[@id='txtpassword']")
    public WebElement EncPassword;

    // Organization ID
    @FindBy(how = How.XPATH, using = "//input[@id='txtLoginOrgGroupId']")
    public WebElement EncOrgId;

    // Login Button
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_logIn']")
    public WebElement EncLoginButton;

    // *** ORG GROUP PAGE ***
    // Company Name
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_tbCompanyName']")
    public WebElement EncCompanyName;

    // Company Number
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_tbCompanyNumber']")
    public WebElement EncCompanyNumber;

    // Search Button
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_cmdSearch']")
    public WebElement EncSearchButton;

    // Org Group Row 1
    @FindBy(how = How.XPATH, using = "//tbody/tr[@id='ctl00_contents_dgClients_ctl03']")
    public WebElement EncOrgGroupRow1;

    // Select Org Action
    @FindBy(how = How.XPATH, using = "//a[@id='ctl00_contents_dgClients_rowButtons_actionLink0']")
    public WebElement EncOrgSelectAction;

    // *** ENCOMPASS MENU ***
    // Payables Menu
    @FindBy(how = How.XPATH, using = "//span[@id='payablesItemText']")
    public WebElement EncPayablesMenu;

    // Accounts Payable Submenu
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_MainMenu2_map']")
    public WebElement EncAccountsPayableSubMenu;

    // Create Merchant Log Sidemenu
    @FindBy(how = How.XPATH, using = "//a[@href='/payables/merchantPayments/MerchantLogEdit.aspx']")
    public WebElement EncCreateMlogSideMenu;

    // *** CREATE MERCHANT LOG PAGE ***
    // Merchant Dropdown
    @FindBy(how = How.XPATH, using = "//select[@id='ctl00_contents_MerchantDropDown']")
    public WebElement EncMerchantDropDown;

    // Merchant Note
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_MerchantDropDown']")
    public WebElement EncMerchantNote;

    // Customer Code
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_CustomerCodeTextBox']")
    public WebElement EncCustomerCode;

    // Customer Account No
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_CustomerAccountNoTextBox']")
    public WebElement EncCustomerAccountNo;

    // Effective From Date
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_EffectiveDateStartText']")
    public WebElement EncEffectiveFromDate;

    // Effective To Date
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_EffectiveDateStopText']")
    public WebElement EncEffectiveToDate;

    // Invoice Number
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_InvoiceGridView_ctl02_InvoiceNumberTextBox']")
    public WebElement EncInvNum;

    // Invoice Date
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_InvoiceGridView_ctl02_InvoiceDateTextBox']")
    public WebElement EncInvDate;

    // Invoice Amount
    @FindBy(how = How.XPATH, using = "//input[@id='ctl00_contents_InvoiceGridView_ctl02_AmountTextBox']")
    public WebElement EncInvAmount;

    // Submit Button
    @FindBy(how = How.XPATH, using = "//input[@type='submit']")
    public WebElement EncSubmitButton;

    // Merchant Log ID
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_MerchantLogIdLabel']")
    public WebElement EncMlogId;

    // Card Number
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_lblActNo']")
    public WebElement EncCardNumber;

    // Card Expiration Date
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_lblExpDt']")
    public WebElement EncCardExpDate;

    // Card CSC
    @FindBy(how = How.XPATH, using = "//span[@id='ctl00_contents_lblCVC2value']")
    public WebElement EncCardCsc;

}
