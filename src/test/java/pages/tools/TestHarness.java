package pages.tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class TestHarness extends TransactGlobalPage {

    public TestHarness(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//select[@name='environment']"; // An element that only shows on this page

    // Environment Dropdown
    @FindBy(how = How.XPATH, using = "//select[@name='environment']")
    public WebElement EnvironmentDropdown;

    // Enter Your Name
    @FindBy(how = How.XPATH, using = "//b[text()='Enter your name:']/../input")
    public WebElement Name;

    public void SetName(String value) {
        Name.clear();
        Name.sendKeys(value);
    }

    // ** STEP 1 Upload Authorization File **
    // Auth File File Upload
    @FindBy(how = How.XPATH, using = "//form[@name='authForm']//input[@name='file']")
    public WebElement AuthFilePath;

    public void SetAuthFileUploadPath(String value) {
        AuthFilePath.clear();
        AuthFilePath.sendKeys(value);
    }

    // Submit Auth button
    @FindBy(how = How.XPATH, using = "//form[@name='authForm']//button[@type='submit']")
    public WebElement SubmitAuthButton;

    // Success message for auth upload
    @FindBy(how = How.XPATH, using = "//div[text()='Success']")
    public WebElement SuccessAuthUpload;

    // ** STEP 2 Run Authorizations **
    // Auth filename from step 1 to post
    @FindBy(how = How.XPATH, using = "//input[@name='filename']")
    public WebElement AuthFileName;

    public void SetAuthFileName(String value) {
        AuthFileName.clear();
        AuthFileName.sendKeys(value);
    }

    // Submit Run Auths button
    @FindBy(how = How.XPATH, using = "//button[text()='Run auths']")
    public WebElement RunAuthButton;

    // ** STEP 3 Download Transactions **
    // Download Transactions button
    // TODO: Is there a way (maybe in step definition) to control where it downloads? See https://stackoverflow.com/questions/29770599/how-to-download-docx-file-using-selenium-webdriver-in-java/29770750#29770750
    @FindBy(how = How.XPATH, using = "//button[text()='Download transactions']")
    public WebElement DownloadTransactionsButton;

    // Transaction File
    // Transaction File File Upload
    @FindBy(how = How.XPATH, using = "//form[@name='txnForm']//input[@type='file']")
    public WebElement TransFilePath;

    public void SetTransFileUploadPath(String value) {
        TransFilePath.clear();
        TransFilePath.sendKeys(value);
    }

    // Upload Transaction button
    @FindBy(how = How.XPATH, using = "//form[@name='txnForm']//button[text()='Upload']")
    public WebElement UploadTransButton;

    // Transaction Upload Alert (empty text() means success)
    @FindBy(how = How.XPATH, using = "//div[@class='alert alert-warning ng-binding']")
    public WebElement TransactionUploadAlert;
}
