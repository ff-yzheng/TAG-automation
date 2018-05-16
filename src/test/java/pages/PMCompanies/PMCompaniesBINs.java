package pages.PMCompanies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class PMCompaniesBINs extends TransactGlobalPage {

    public PMCompaniesBINs(WebDriver driver){
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

    // BIN Status
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'BIN Status')]/../div/span")
    public WebElement BinStatus;
}
