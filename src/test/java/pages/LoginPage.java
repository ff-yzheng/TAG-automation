package pages;

import global.SharedWebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import repo.Locator;

import static org.junit.Assert.assertTrue;

public class LoginPage {
    @FindBy(how = How.XPATH, using = Locator.CHEVRON_LOGO_IMG)
    public WebElement ChevronLogo;

    @FindBy(how = How.XPATH, using = Locator.BP_LOGO_IMG)
    public WebElement BPLogo;

    @FindBy(how = How.ID, using = Locator.USERNAME_FIELD)
    public WebElement usernameField;

    @FindBy(how = How.ID, using = Locator.PASSWORD_FIELD)
    public WebElement passwordField;

    @FindBy(how = How.ID, using = Locator.SIGNIN)
    public WebElement signin;

    @FindBy(how = How.LINK_TEXT, using = Locator.LOGOUT)
    public WebElement logoffLink;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static LoginPage navigateToLoginPage() {
        WebDriver driver = SharedWebDriver.getDriver();
        LoginPage loginPage = new LoginPage(driver);
        driver.get(PropUtils.getPropValue(configProp, url));
        return loginPage;
    }

    public void login(String username, String password, String clientName) throws Exception {
        if (clientName.equals("BP")) {
            assertTrue("BP Logo is Not Displayed", BPLogo.isDisplayed());
        }
        else {
            assertTrue("Chevron Logo is Not Displayed", ChevronLogo.isDisplayed());
        }

        assertTrue("User Name Field is Not Displayed", usernameField.isDisplayed());
        usernameField.clear();
        usernameField.sendKeys(PropUtils.getPropValue(configProp, username));

        assertTrue("Password Field is Not Displayed", passwordField.isDisplayed());
        passwordField.clear();
        passwordField.sendKeys(PropUtils.getPropValue(configProp, password));

        assertTrue("Login button is Not Displayed", signin.isDisplayed());
        signin.click();
    }

    public void logout() throws Exception {
        // Initialize Elements
        assertTrue("Logout link is Not Displayed", logoffLink.isDisplayed());
        logoffLink.click();

        assertTrue("Logout Failed", usernameField.isDisplayed());

    }
}
