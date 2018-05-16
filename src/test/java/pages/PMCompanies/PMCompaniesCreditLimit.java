package pages.PMCompanies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class PMCompaniesCreditLimit extends TransactGlobalPage {

    public PMCompaniesCreditLimit(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'Credit Limit')]"; // An element that only shows on this page

    // Company Credit Limit
    @FindBy(how = How.XPATH, using = "//input[@name='CreditLimit.Cents']")
    public WebElement CompanyCreditLimit;

    // Currency
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Currency')]/../div/span")
    public WebElement Currency;

    // Available Credit
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Available Credit')]/../div/span")
    public WebElement AvailableCredit;

    // Balance
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Balance')]/../div/span")
    public WebElement Balance;

    // CL Override, Decline Authorizations radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Decline Authorizations')]/input[@name='CreditLimit.Override']")
    public WebElement DeclineAuthsRadioButton;

    // CL Override, Override Company Credit Limit radio button
    @FindBy(how = How.XPATH, using = "//label[contains(text(),'Override')]/input[@name='CreditLimit.Override']")
    public WebElement OverrideCCLRadioButton;

    // Days to Hold Auths
    @FindBy(how = How.XPATH, using = "//input[@name='DaysToHold']")
    public WebElement DaysToHoldAuths;
}
