package pages.ProgramManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class CompaniesAuthorizationControls extends TransactGlobalPage {

    public CompaniesAuthorizationControls(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'Authorization Controls')]"; // An element that only shows on this page

    // ** DEFAULT CARD ADDRESS **
    // Same as Company Name Checkbox
    @FindBy(how = How.XPATH, using = "//input[@name='UseCompanyName']")
    public WebElement SameAsCompanyNameCheckbox;

    // Name
    @FindBy(how = How.XPATH, using = "//input[@name='Controls.Name']")
    public WebElement Name;

    // Same as Company Address
    @FindBy(how = How.XPATH, using = "//input[@name='UseCompanyAddress']")
    public WebElement SameAsCompanyAddressCheckbox;

    // Country
    @FindBy(how = How.XPATH, using = "//select[@name='Country']")
    public WebElement Country;

    // Address1
    @FindBy(how = How.XPATH, using = "//input[@name='Street1']")
    public WebElement Address1;

    public void SetAddress1(String value) {
        Address1.clear();
        Address1.sendKeys(value);
    }

    // Address2
    @FindBy(how = How.XPATH, using = "//input[@name='Street2']")
    public WebElement Address2;

    public void SetAddress2(String value) {
        Address2.clear();
        Address2.sendKeys(value);
    }

    // City
    @FindBy(how = How.XPATH, using = "//input[@name='City']")
    public WebElement City;

    public void SetCity(String value) {
        City.clear();
        City.sendKeys(value);
    }

    // StateProvince
    @FindBy(how = How.XPATH, using = "//select[@name='State']")
    public WebElement StateProvince;

    // Postal Code
    @FindBy(how = How.XPATH, using = "//input[@name='PostalCode']")
    public WebElement PostalCode;

    public void SetPostalCode(String value) {
        PostalCode.clear();
        PostalCode.sendKeys(value);
    }

    // ** CARD CONTROLS **
    // Address Verification - Yes radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]/input[@name='Controls.AVS']")
    public WebElement AddressVerificationYesRadioButton;

    // Address Verification - No radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'No')]/input[@name='Controls.AVS']")
    public WebElement AddressVerificationNoRadioButton;

    // CSC Verification - Yes radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]/input[@name='Controls.CVV']")
    public WebElement CSCVerificationYesRadioButton;

    // CSC Verification - No radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'No')]/input[@name='Controls.CVV']")
    public WebElement CSCVerificationNoRadioButton;

    // Expiration Date Verification - Yes radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]/input[@name='Controls.EDV']")
    public WebElement ExpDateVerificationYesRadioButton;

    // Expiration Date Verification - No radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'No')]/input[@name='Controls.EDV']")
    public WebElement ExpDateVerificationNoRadioButton;

    // Default Expiration Date
    @FindBy(how = How.XPATH, using = "//select[@name='CardExpiration']")
    public WebElement DefaultExpirationDateDropdown;

    // ** COUNTRY CONTROLS **
    // Country Controls Checkbox
    @FindBy(how = How.XPATH, using = "//input[@id='toggleCountry']")
    public WebElement CountryControlsCheckbox;

    // Override FI Country Controls - Yes radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Yes')]/input[@name='Controls.OverrideFIControlCountry']")
    public WebElement OverrideFICountryControlsYesRadioButton;

    // Override FI Country Controls - No radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'No')]/input[@name='Controls.OverrideFIControlCountry']")
    public WebElement OverrideFICountryControlsNoRadioButton;

    // Exclude radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Exclude')]/input[@name='AllowCountry']")
    public WebElement ExcludeCountryRadioButton;

    // Include radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Include')]/input[@name='AllowCountry']")
    public WebElement IncludeCountryRadioButton;

    // Country Row 1 Dropdown
    @FindBy(how = How.XPATH, using = "//tr[1]//select[@name='CountryCode']")
    public WebElement CountryRow1Dropdown;

    // MCC Group Row 1 Dropdown
    @FindBy(how = How.XPATH, using = "//tr[1]//select[@name='CountryMCCGroupID']")
    public WebElement MCCGRow1Dropdown;

    // Add Action Row 1
    @FindBy(how = How.XPATH, using = "//tr[1]//a[@class='add-item btn-icon']")
    public WebElement AddCountryRow1Action;

    // Remove Action Row 1
    @FindBy(how = How.XPATH, using = "//tr[1]//a[@class='remove-item btn-icon']")
    public WebElement RemoveCountryRow1Action;

    // Country Row 2 Dropdown
    @FindBy(how = How.XPATH, using = "//tr[2]//select[@name='CountryCode']")
    public WebElement CountryRow2Dropdown;

    // MCC Group Row 2 Dropdown
    @FindBy(how = How.XPATH, using = "//tr[2]//select[@name='CountryMCCGroupID']")
    public WebElement MCCGRow2Dropdown;

    // Add Action Row 2
    @FindBy(how = How.XPATH, using = "//tr[2]//a[@class='add-item btn-icon']")
    public WebElement AddCountryRow2Action;

    // Remove Action Row 2
    @FindBy(how = How.XPATH, using = "//tr[2]//a[@class='remove-item btn-icon']")
    public WebElement RemoveCountryRow2Action;

}

