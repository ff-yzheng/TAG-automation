package pages.ProgramManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.TransactGlobalPage;

public class CompaniesBillingFeatures extends TransactGlobalPage {

    public CompaniesBillingFeatures(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'Billing Features')]"; // An element that only shows on this page

    // Billing Features active tab
    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'nav nav-tabs')]/li[@class='active']/a[contains(text(),'Billing Features')]")
    public WebElement BillingFeaturesActiveTab;

    // Bill Cycle
    @FindBy(how = How.XPATH, using = "//select[@name='BillingFeatures.BillCycle.BillCycleType']")
    public WebElement BillCycleDropdown;

    public void SetBillCycleDropdown(String value){
        Select select = new Select(BillCycleDropdown);
        select.selectByVisibleText(value);
    }

    // Cycle Day
    @FindBy(how = How.XPATH, using = "//select[@name='BillingFeatures.BillCycle.CycleDay']")
    public WebElement CycleDayDropdown;

    public void SetCycleDayDropdown(String value){
        Select select = new Select(CycleDayDropdown);
        select.selectByVisibleText(value);
    }

    // Grace Period
    @FindBy(how = How.XPATH, using = "//select[@name='BillingFeatures.BillCycle.GracePeriod']")
    public WebElement GracePeriodDropdown;

    public void SetGracePeriodDropdown(String value){
        Select select = new Select(GracePeriodDropdown);
        select.selectByVisibleText(value);
    }

    // Late Fee %
    @FindBy(how = How.XPATH, using = "//select[@name='LateFeePercentage.Value']")
    public WebElement LateFeePercDropdown;

    public void SetLateFeePercDropdown(String value){
        Select select = new Select(LateFeePercDropdown);
        select.selectByVisibleText(value);
    }

    // International Late Fee %
    @FindBy(how = How.XPATH, using = "//select[@name='FiFeeID']")
    public WebElement InternationalFeePercDropdown;

    public void SetInterFeePercDropdown(String value){
        Select select = new Select(InternationalFeePercDropdown);
        select.selectByVisibleText(value);
    }

    // Statement Template
    @FindBy(how = How.XPATH, using = "//select[@name='StatementConfigID']")
    public WebElement TemplateDropdown;

    public void SetStatementDropdown(String value){
        Select select = new Select(TemplateDropdown);
        select.selectByVisibleText(value);
    }

    // Payment Method
    @FindBy(how = How.XPATH, using = "//select[@name='BillingFeatures.PaymentMethod']")
    public WebElement PaymentMethodDropdown;

    public void SetPaymentMethodDropdown(String value){
        Select select = new Select(PaymentMethodDropdown);
        select.selectByVisibleText(value);
    }

    // Bank Name
    @FindBy(how = How.XPATH, using = "//input[@name='BillingFeatures.BankName']")
    public WebElement BankName;

    public void SetBankName(String value) {
        BankName.clear();
        BankName.sendKeys(value);
    }

    // Routing Number
    @FindBy(how = How.XPATH, using = "//input[@name='BillingFeatures.RoutingNumber']")
    public WebElement RoutingNumber;

    public void SetRoutingNumber(String value) {
        RoutingNumber.clear();
        RoutingNumber.sendKeys(value);
    }

    // Account Number
    @FindBy(how = How.XPATH, using = "//input[@name='BillingFeatures.AccountNumber']")
    public WebElement AccountNumber;

    public void SetAccountNumber(String value) {
        AccountNumber.clear();
        AccountNumber.sendKeys(value);
    }

    // View Account Number
    @FindBy(how = How.XPATH, using = "//a[@class='view-acct-num']")
    public WebElement ViewAccountNumber;

    // Account Type
    @FindBy(how = How.XPATH, using = "//select[@name='BillingFeatures.AccountType']")
    public WebElement AccountTypeDropdown;

    // Enable VIP Status
    @FindBy(how = How.XPATH, using = "//input[@name='VIP']")
    public WebElement EnableVIPStatusCheckbox;
}

