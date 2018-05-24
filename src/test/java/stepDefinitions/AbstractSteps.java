package stepDefinitions;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.openqa.selenium.OutputType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static global.SharedWebDriver.getDriver;
import static global.SharedWebDriver.scenario;

public class AbstractSteps{

    // Enable wait options in steps
    protected void WaitForElementToLoad(WebDriver activeDriver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(activeDriver, 10);
        wait.until((ExpectedConditions.visibilityOf(webElement)));
    }

    protected void WaitForElementToLoad(WebDriver activeDriver, WebElement webElement, int waitForSeconds) {
        WebDriverWait wait = new WebDriverWait(activeDriver, waitForSeconds);
        wait.until((ExpectedConditions.visibilityOf(webElement)));
    }

    // I don't think this works consistently
    protected void WaitForElementToDisappear(WebDriver activeDriver, WebElement webElement){
        WebDriverWait wait = new WebDriverWait(activeDriver, 10);
        wait.until((ExpectedConditions.invisibilityOf(webElement)));
    }

    // Method to check an element and retry 'attempts' times before failing due to stale element
    protected Boolean WaitUntilElementIsReady(WebElement webElement) {
        Boolean result = false;
        int attempts = 0;
        while (attempts < 3) {
            try {
                //getDriver().findElement(by).click();
                webElement.isDisplayed();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    // Method to check an element and retry 'attempts' times before failing due to stale element
    protected WebElement RetryFindElement(WebElement webElement) {
        int attempts = 0;
        while (attempts < 3) {
            try {
                //getDriver().findElement(by).click();
                webElement.isDisplayed();
                return webElement;
            } catch (StaleElementReferenceException e) {
            }
            // Couldn't get the element, wait and try again

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            attempts++;
        }
        return webElement;
    }

    // Trim all special characters and leading and trailing spaces
    protected String AllTrim(String value){
        // replace line breaks with a space
        value = value.replaceAll("\\r\\n|\\r|\\n", " ");

        // trim leading and trailing spaces
        value = value.trim();

        return value;
    }

    protected Boolean ElementDisplays(WebElement webElement){
        try{
            return webElement.isDisplayed();
        }
        catch(NoSuchElementException e){
            return false;
        }
    }

    // Set a drop down by passing in the element and display text
    protected void SetDropdownByText(WebElement webElement, String value){
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }

    // Set a drop down by passing in the element and value
    protected void SetDropdownByValue(WebElement webElement, String value){
        Select select = new Select(webElement);
        select.selectByValue(value);
    }

    // Methods to create date time string for uniquely naming things
    // Return length is 23, fully formatted date and time to the milliseconds
    protected String GenerateDateTimeStringFull(){
        String format = "yyyy-MM-dd HH:mm:ss.SSS";
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    // Return length is 12 (still a date to the second and trimmed of spaces and extra characters
    protected String GenerateDateTimeStringShortest(){
        String format = "yyMMddHHmmss";
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    // Return length is 15 (year is 4 digit and space between date and time, to the second)
    protected String GenerateDateTimeStringShort(){
        String format = "yyyyMMdd HHmmss";
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    // Format is passed into method, format must be valid like "yyyy-MM-dd HH:mm:ss.SSS"
    protected String GenerateDateTimeStringCustom(String format){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(format));
    }

    // Gets and returns the text of the parent node only (useful for getting the tab name without the count)
    public static String GetTestFromNodeOnly(WebElement webElement)
    {
        String text = webElement.getText().trim();
        List<WebElement> children = webElement.findElements(By.xpath("./*"));
        for (WebElement child : children)
        {
            text = text.replaceFirst(child.getText(), "").trim();
        }
        return text;
    }

    // Check for error alert and report results
    public void CheckForErrors(){
        Integer delayMSTime = 250;
        Integer totalSeconds = 1;
        Integer attempts = 0;
        Integer maxAttempts = totalSeconds * 1000 / delayMSTime;
        //System.out.println("maxAttempts: " + maxAttempts.toString());

        // Check to see if an alert error is present
        Boolean isPresent = getDriver().findElements(By.xpath("//div[contains(@class,'alert')]")).size() > 0;

        while(attempts < maxAttempts){
            //if(getDriver().findElement(By.xpath("//*[@class='form-error' and @innertext!~'Credit Limit.*' or @class='alert' or @class~'alert-danger']")).isDisplayed()){
            if(isPresent){
                System.out.println("    I see an error");
                System.out.println("    Error message: " + getDriver().findElement(By.xpath("//div[contains(@class,'alert')]/p")).getText());
                //scenario.write("    I see an error");
                scenario.write("    ERROR MESSAGE: " + getDriver().findElement(By.xpath("//div[contains(@class,'alert')]/p")).getText());
                embedScreenshot(scenario);
                break;
            }
            else
            {
                //System.out.println("    No error after attempt " + attempts.toString() + " and " + attempts*delayMSTime + " miliseconds");

                try {
                    Thread.sleep(delayMSTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                attempts++;
                //embedScreenshot(scenario);
                isPresent = getDriver().findElements(By.xpath("//div[contains(@class,'alert')]")).size() > 0;
            }
        }

        // report there were no errors if alert wasn't found after all attempts
        if(!isPresent){
            System.out.println("    No error detected");
            //scenario.write("    No error detected");
        }
    }

    // Capture and insert a screenshot into the report
    public void embedScreenshot(Scenario scenario) {
        try {
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } catch (WebDriverException wde) {
            System.err.println(wde.getMessage());
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }

    // TODO: Add Common reporting/logging functions

    protected void logInfo(String msg){
        Reporter.log(msg);
    }
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
