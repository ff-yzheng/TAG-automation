package pages.ProgramManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pages.TransactGlobalPage;

public class CompaniesNotes extends TransactGlobalPage {

    public CompaniesNotes(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Page Info
    private static final String PAGE_XPATH = "//ol[@class='breadcrumb']/*[contains(text(),'Notes')]"; // An element that only shows on this page

    // Bulletin Text Area
    @FindBy(how = How.XPATH, using = "//textarea[@id='bulletin']")
    public WebElement BulletinText;

    public void SetBulletinText(String value) {
        BulletinText.clear();
        BulletinText.sendKeys(value);
    }

    // Save Bulletin Button
    @FindBy(how = How.XPATH, using = "//div[@id='bulletin-region']//button[contains(text(),'Save')]")
    public WebElement SaveBulletinButton;

    // Cancel Bulletin Button
    @FindBy(how = How.XPATH, using = "//div[@id='bulletin-region']//button[contains(text(),'Cancel')]")
    public WebElement CancelBulletinButton;

    // Clear Bulletin Button
    @FindBy(how = How.XPATH, using = "//div[@id='bulletin-region']//button[contains(text(),'Clear')]")
    public WebElement ClearBulletinButton;

    // Notes Text Area
    @FindBy(how = How.XPATH, using = "//textarea[@id='notes']")
    public WebElement NotesText;

    public void SetNotesText(String value) {
        NotesText.clear();
        NotesText.sendKeys(value);
    }

    // Save Notes Button
    @FindBy(how = How.XPATH, using = "//div[@id='add-note-region']//button[contains(text(),'Save')]")
    public WebElement SaveNotesButton;

    // Cancel NOtes Button
    @FindBy(how = How.XPATH, using = "//div[@id='add-note-region']//button[contains(text(),'Cancel')]")
    public WebElement CancelNotesButton;
}
