package pages.ProgramManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.TransactGlobalPage;

public class ClientsSetup extends TransactGlobalPage {

    public ClientsSetup(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'Setup')]"; // An element that only shows on this page

    // Setup active tab
    @FindBy(how = How.XPATH, using = "//ul[contains(@class,'nav nav-tabs')]/li[@class='active']/a[contains(text(),'Setup')]")
    public WebElement SetupActiveTab;

    // FI Dropdown
    @FindBy(how = How.XPATH, using = "//select[@name='FiID']")
    public WebElement FIDropdown;

    public void SetFIDropdown(String value){
        Select select = new Select(FIDropdown);
        select.selectByVisibleText(value);
    }

    // Client Name
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Client Name')]/../div/input")
    public WebElement ClientName;

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

    public void SetStateProvinceDropdown(String value){
        Select select = new Select(StateProvince);
        select.selectByVisibleText(value);
    }

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

    public void SetStatusDropdown(String value){
        Select select = new Select(StatusDropdown);
        select.selectByVisibleText(value);
    }

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
}
