package pages.ProgramManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.TransactGlobalPage;

public class CompaniesSetup extends TransactGlobalPage {

    public CompaniesSetup(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'Setup')]"; // An element that only shows on this page

    // FI Dropdown
    @FindBy(how = How.XPATH, using = "//select[@name='FiID']")
    public WebElement FIDropdown;

    public void SetFIDropdown(String value){
        Select select = new Select(FIDropdown);
        select.selectByVisibleText(value);
    }

    // FI Name
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'FI Name')]/../p")
    public WebElement FIName;

    // Partner Name
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Partner Name')]/../p")
    public WebElement PartnerName;

    // Client Dropdown
    @FindBy(how = How.XPATH, using = "//select[@name='ClientID']")
    public WebElement ClientDropdown;

    // Client Name
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Client Name')]/../div/p")
    public WebElement ClientName;

    // Company Name
    @FindBy(how = How.XPATH, using = "//input[@name='Name']")
    public WebElement CompanyName;

    public void SetCompanyName(String value) {
        CompanyName.clear();
        CompanyName.sendKeys(value);
    }

    // Company Number
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Company Number')]/../div/p")
    public WebElement CompanyNumber;

    // Primary Contact
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.PrimaryContact']")
    public WebElement PrimaryContact;

    public void SetPrimaryContact(String value) {
        PrimaryContact.clear();
        PrimaryContact.sendKeys(value);
    }

    // Phone Number
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.Phone']")
    public WebElement PhoneNumber;

    public void SetPhoneNumber(String value) {
        PhoneNumber.clear();
        PhoneNumber.sendKeys(value);
    }

    // Fax Number
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.Fax']")
    public WebElement FaxNumber;

    public void SetFaxNumber(String value) {
        FaxNumber.clear();
        FaxNumber.sendKeys(value);
    }

    // Use Client Address Checkbox
    @FindBy(how = How.XPATH, using = "//input[@name='UseClientAddress']")
    public WebElement SameAsClientAddressCheckbox;

    // Country
    @FindBy(how = How.XPATH, using = "//select[@name='Contact.Address.Country']")
    public WebElement Country;

    // Address1
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.Address.Street1']")
    public WebElement Address1;

    public void SetAddress1(String value) {
        Address1.clear();
        Address1.sendKeys(value);
    }

    // Address2
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.Address.Street2']")
    public WebElement Address2;

    public void SetAddress2(String value) {
        Address2.clear();
        Address2.sendKeys(value);
    }

    // City
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.Address.City']")
    public WebElement City;

    public void SetCity(String value) {
        City.clear();
        City.sendKeys(value);
    }

    // StateProvince
    @FindBy(how = How.XPATH, using = "//select[@name='Contact.Address.State']")
    public WebElement StateProvince;

    // Postal Code
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.Address.PostalCode']")
    public WebElement PostalCode;

    public void SetPostalCode(String value) {
        PostalCode.clear();
        PostalCode.sendKeys(value);
    }

    // Status Dropdown
    @FindBy(how = How.XPATH, using = "//select[@name='Status']")
    public WebElement StatusDropdown;

    // Over Credit Limit
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Over Credit Limit')]/../p")
    public WebElement OverCreditLimit;

    // Delinquent
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Delinquent')]/../p")
    public WebElement Delinquent;

    // Email
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.EmailAddress']")
    public WebElement Email;

    public void SetEmail(String value) {
        Email.clear();
        Email.sendKeys(value);
    }

    // Extension
    @FindBy(how = How.XPATH, using = "//input[@name='Contact.Extension']")
    public WebElement Extension;

    public void SetExtension(String value) {
        Extension.clear();
        Extension.sendKeys(value);
    }

    // Tax ID Number
    @FindBy(how = How.XPATH, using = "//input[@name='TaxIDNumber']")
    public WebElement TaxIDNumber;

    public void SetTaxIDNumber(String value) {
        TaxIDNumber.clear();
        TaxIDNumber.sendKeys(value);
    }

    // Credit National ID
    @FindBy(how = How.XPATH, using = "//input[@name='CreditNationalID']")
    public WebElement CreditNationalID;

    public void SetCreditNationalID(String value) {
        CreditNationalID.clear();
        CreditNationalID.sendKeys(value);
    }
}
