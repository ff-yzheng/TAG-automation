package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class LoginPage extends TransactGlobalPage {

    public LoginPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }
//    public LoginPage(WebDriver driver){
//        this.driver = driver;
//    }

    // Page Info
    private static final String LOGIN_XPATH = "//input[@id='login_username']"; // An element that only shows on this page
    private static final String ALERT_XPATH = "//div[@class='alert alert-danger alert-dismissible']";

    // Username
    @FindBy(how = How.XPATH, using = LOGIN_XPATH)
    public WebElement UserName;

    public void SetUsername(String value) {
        UserName.clear();
        UserName.sendKeys(value);
    }

    // WHY DON'T THESE WORK
    public WebElement UserName2 = UserName;
    //public Boolean HasUsernameField = UserName.isDisplayed();

    public Boolean HasUsernameField() {
        return UserName.isDisplayed();
    }
}
