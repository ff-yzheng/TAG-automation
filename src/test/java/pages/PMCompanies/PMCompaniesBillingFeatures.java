package pages.PMCompanies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class PMCompaniesBillingFeatures extends TransactGlobalPage {

    public PMCompaniesBillingFeatures(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'Billing Features')]"; // An element that only shows on this page

    // Bill Cycle
    @FindBy(how = How.XPATH, using = "//select[@name='BillingFeatures.BillCycle.BillCycleType']")
    public WebElement BillCycleDropdown;

    // Late Fee %
    @FindBy(how = How.XPATH, using = "//select[@name='LateFeePercentage.Value']")
    public WebElement LateFeePercDropdown;

    // International Late Fee %
    @FindBy(how = How.XPATH, using = "//select[@name='FiFeeID']")
    public WebElement InternationalFeePercDropdown;

    // Statement Template
    @FindBy(how = How.XPATH, using = "//select[@name='StatementConfigID']")
    public WebElement TemplateDropdown;

    // Payment Method
    @FindBy(how = How.XPATH, using = "//select[@name='BillingFeatures.PaymentMethod']")
    public WebElement PaymentMethodDropdown;

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

