package stepDefinitions;

import global.SharedWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.List;

import static global.SharedWebDriver.getDriver;

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
                Thread.sleep(250);
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

    // TODO: Global check for errors ?
    /*
    protected void CheckForErrors(){
        System.out.println("    checking for errors");

    }
    */

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
