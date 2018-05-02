package pages;

import global.SharedWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TransactGlobalPage {

    public WebDriver driver;

    public TransactGlobalPage(WebDriver driver) {
        this.driver = SharedWebDriver.getDriver();
        PageFactory.initElements(driver, this);
    }

    // Initialize Elements
    public void RefreshModel(){
        PageFactory.initElements(driver, this);
    }

    // Home
    @FindBy(how = How.XPATH, using = "//a[@href='#home']")
    public WebElement HomeLink;

    public void NavigateToHomePage() {
        HomeLink.click();
    }

    // Logout
    private static final String LOGOUT_XPATH = "//a[@href='#logout']";

    @FindBy(how = How.XPATH, using = LOGOUT_XPATH)
    public WebElement LogoutLink;

    public void Logout() {
        LogoutLink.click();
    }

    // **** Navigation Options ****
    // Nav Bar Region
    @FindBy(how = How.XPATH, using = "//ul[@class='nav navbar-nav pull-right']")
    public WebElement NavBarDropDowns;

    // Tab Region
    @FindBy(how = How.XPATH, using = "//ul[@class='nav nav-tabs']")
    public WebElement TabArea;

    // TODO: Add TAG Menu Items

    // **** Breadcrumb Items ****
    // Breadcrumb1
    @FindBy(how = How.XPATH, using = "//ol[@class='breadcrumb']/li[1]")
    public WebElement BreadCrumb1;

    // Breadcrumb2
    @FindBy(how = How.XPATH, using = "//ol[@class='breadcrumb']/li[2]")
    public WebElement BreadCrumb2;

    // Breadcrumb3
    @FindBy(how = How.XPATH, using = "//ol[@class='breadcrumb']/li[3]")
    public WebElement BreadCrumb3;

    // **** Loading Spinner/Modal ****
    @FindBy(how = How.XPATH, using = "//div[@class='loading-container']")
    public WebElement LoadingSpinner;

    @FindBy(how = How.XPATH, using = "//div[@class='loading-container' and contains(@style,'display: none')]")
    public WebElement LoadingSpinnerIsHidden;

    @FindBy(how = How.XPATH, using = "//div[@class='loading-container' and contains(@style,'display: block')]")
    public WebElement LoadingSpinnerIsActive;

    // **** Shared Grid & Search Controls ****
    // Clickable Row 1
    @FindBy(how = How.XPATH, using = "//div[contains(@class,'table-container')]/table/tbody/tr[@class='clickable']")
    public WebElement ClickableRow1;

    // Row 1
    @FindBy(how = How.XPATH, using = "//div[@class='table-container']/table/tbody/tr")
    public WebElement GridRow1;

    // Card Number Search Field
    @FindBy(how = How.XPATH, using = "//input[@name='CardNumber']")
    public WebElement CardNumberSearchField;

    public void SetCardNumberSearchField(String value) {
        CardNumberSearchField.clear();
        CardNumberSearchField.sendKeys(value);
    }

    // Search Button
    @FindBy(how = How.XPATH, using = "//button[@id='search-btn']")
    public WebElement SearchButton;

    // **** Page Level Verification Items ****
    // Error Alert
    @FindBy(how = How.XPATH, using = "//*[@class='form-error' and @innertext!~'Credit Limit.*' or @class='alert' or @class~'alert-danger']")
    public WebElement AlertError;

    // TODO: Add Common reporting/logging functions
/*
    public void logInfo(String msg) {
        test.info(MarkupHelper.createLabel(msg, ExtentColor.BLUE));
    }

    public void logFail(String msg) {
        test.fail(MarkupHelper.createLabel(msg, ExtentColor.RED));
        Assert.assertFalse(true, msg);
    }

    public void logPass(String msg) {
        test.pass(MarkupHelper.createLabel(msg, ExtentColor.GREEN));
    }
*/

}

