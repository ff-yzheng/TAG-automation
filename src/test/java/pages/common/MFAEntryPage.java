package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class MFAEntryPage extends TransactGlobalPage {

    public MFAEntryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String MFA_XPATH = "//input[@name='MFACode']"; // An element that only shows on this page

    // MFA Code
    @FindBy(how = How.XPATH, using = MFA_XPATH)
    public WebElement MFACode;

    public void SetMFACode(String value) {
        MFACode.clear();
        MFACode.sendKeys(value);
    }

    // Continue button
    @FindBy(how = How.XPATH, using = "//button[text()='Continue']")
    public WebElement ContinueButton;

    public void ContinueClick(){
        ContinueButton.click();
    }
}
