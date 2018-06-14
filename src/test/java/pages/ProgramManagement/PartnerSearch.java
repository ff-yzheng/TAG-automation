package pages.ProgramManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.TransactGlobalPage;
import stepDefinitions.AbstractSteps;

import static global.SharedWebDriver.getDriver;

public class PartnerSearch extends TransactGlobalPage {

    public PartnerSearch(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //FI Dropdown for PM-Partners
    @FindBy(how = How.XPATH, using = "//select[@name='fiID']")
    public WebElement FINameDropdown;

    public void SetFIDropdown(String value){
        Select select = new Select(FINameDropdown);
        select.selectByVisibleText(value);
    }

    //FI Dropdown for PM-Clients
    @FindBy(how = How.XPATH, using = "//select[@name='FiName']")
    public WebElement ClientFINameDropdown;

    public void SetClientFIDropdown(String value){
        Select select = new Select(ClientFINameDropdown);
        select.selectByVisibleText(value);
    }

    // SEARCH Button for PM-Clients
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-lg btn-primary']") // Need more definitions? //button[@id='search-btn']
    public WebElement SearchButton;

    //Code for wait
    public void iWaitForXTime(int value, String timeUnit) throws Throwable {
        Integer timeToWaitInMS = 0;
        Boolean uniteOfTimeValid = false;

        //System.out.println("unitOfTime: " + timeUnit);

        // Translate the value and timeUnit text to get the proper amount of time
        if(timeUnit.toLowerCase().equals("milliseconds")){
            uniteOfTimeValid = true;
            timeToWaitInMS = value;
        }

        if(timeUnit.toLowerCase().equals("seconds")){
            uniteOfTimeValid = true;
            timeToWaitInMS = value * 1000;
        }

        if(timeUnit.toLowerCase().equals("minutes")){
            uniteOfTimeValid = true;
            timeToWaitInMS = value * 60000;
        }

        if (!uniteOfTimeValid){
            System.out.println("Invalid unit of time, you can only use 'milliseconds', 'seconds', and 'minutes'");
        }

        try {
            Thread.sleep(timeToWaitInMS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}