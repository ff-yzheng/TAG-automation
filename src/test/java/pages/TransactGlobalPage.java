package pages;

import global.SharedWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class TransactGlobalPage {

    public WebDriver driver;

    protected TransactGlobalPage(WebDriver driver) {
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

    // TODO: Add TAG Menu Items


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

