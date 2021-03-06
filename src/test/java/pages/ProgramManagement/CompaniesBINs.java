package pages.ProgramManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.TransactGlobalPage;

public class CompaniesBINs extends TransactGlobalPage {

    public CompaniesBINs(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'BINs')]"; // An element that only shows on this page

    // Corporate Account
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Corporate Account')]/../div/span")
    public WebElement CorporateAccount;

    // Scheme
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Scheme')]/../div/span")
    public WebElement Scheme;

    // Scheme Dropdown
    @FindBy(how = How.XPATH, using = "//select[@name='Scheme']")
    public WebElement SchemeDropdown;

    public void SetSchemeDropdown(String value){
        Select select = new Select(SchemeDropdown);
        select.selectByVisibleText(value);
    }

    // Currency
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Currency')]/../div/span")
    public WebElement Currency;

    // Currency Dropdown
    @FindBy(how = How.XPATH, using = "//select[@name='Currency']")
    public WebElement CurrencyDropdown;

    // BIN
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'BIN')]/../div/span")
    public WebElement Bin;

    // BIN Dropdown
    @FindBy(how = How.XPATH, using = "//select[@name='bin']")
    public WebElement BinDropdown;

    public void SetBINsDropdown(String value){
        Select select = new Select(BinDropdown);
        select.selectByValue(value);
    }

    // BIN Status
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'BIN Status')]/../div/span")
    public WebElement BinStatus;
}
