package pages.Operations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.TransactGlobalPage;

public class AuditLog extends TransactGlobalPage {

    public AuditLog(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'Audit Log')]"; // An element that only shows on this page

    // Type Dropdown
    @FindBy(how = How.XPATH, using = "//select[@id='searchTypes']")
    public WebElement TypeDropdown;

    public void SetTypeDropdown(String value){
        Select select = new Select(TypeDropdown);
        select.selectByVisibleText(value);
    }

    // Username Search Field
    @FindBy(how = How.XPATH, using = "//input[@name='username']")
    public WebElement UsernameSearchField;

    // From Date Search Field
    @FindBy(how = How.XPATH, using = "//input[@name='fromDate']")
    public WebElement FromDateSearchField;

    // To Date Search Field
    @FindBy(how = How.XPATH, using = "//input[@name='toDate']")
    public WebElement ToDateSearchField;

    // FI Name Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'FI Name')]/..//input")
    public WebElement FINameSearchField;

    // Partner Name Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Partner Name')]/..//input")
    public WebElement PartnerNameSearchField;

    // Client Name Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Client Name')]/..//input")
    public WebElement ClientNameSearchField;

    // Company Name Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Company Name')]/..//input")
    public WebElement CompanyNameSearchField;

    // Company Number Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Company Number')]/..//input")
    public WebElement CompanyNumberSearchField;

    // Card Number Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Card Number')]/..//input")
    public WebElement CardNumberSearchField;

    // Role Name Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Role Name')]/..//input")
    public WebElement RoleNameSearchField;

    // Owner Dropdown
    @FindBy(how = How.XPATH, using = "//select[@id='owner']")
    public WebElement OwnerDropdown;

    public void SetOwnerDropdown(String value){
        Select select = new Select(OwnerDropdown);
        select.selectByVisibleText(value);
    }

    // Last Name Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Last Name')]/..//input")
    public WebElement LastNameSearchField;

    // Card Issuer Reference Search Field
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Card Issuer Reference')]/..//input")
    public WebElement CardIssuerReferenceSearchField;



}

