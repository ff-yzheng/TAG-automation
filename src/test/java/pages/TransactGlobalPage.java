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


    // **** Shared Search Controls ****
    // Row 1 is clickable
    @FindBy(how = How.XPATH, using = "//div[@class~'table-container.*']//table/tbody/tr[@childindex=0 and @class='clickable']")
    public WebElement ClickableRow1;

    // Card Number Search Field
    @FindBy(how = How.XPATH, using = "//label[@innertext='Card Number']/../?/input")
    public WebElement CardNumberSearchField;

    // Search Button
    @FindBy(how = How.XPATH, using = "//button[@innertext='Search']")
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

