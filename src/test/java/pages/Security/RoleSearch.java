package pages.Security;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.TransactGlobalPage;

public class RoleSearch extends TransactGlobalPage {

    public RoleSearch(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Role Dropdown for SEC-Roles
    @FindBy(how = How.XPATH, using = "//select[@id='searchRoleID']")
    public WebElement RoleNameDropdown;

    public void SetRoleDropdown(String value){
        Select select = new Select(RoleNameDropdown);
        select.selectByVisibleText(value);
    }

    //Owner Dropdown for SEC-Roles
    @FindBy(how = How.XPATH, using = "//select[@id='searchFiID']")
    public WebElement OwnerDropdown;

    public void SetOwnerDropdown(String value){
        Select select = new Select(OwnerDropdown);
        select.selectByVisibleText(value);
    }

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