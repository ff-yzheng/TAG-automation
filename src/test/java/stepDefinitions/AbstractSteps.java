package stepDefinitions;

import global.SharedWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractSteps {

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

    // TODO: Check for errors on page
    protected void CheckForErrors(){
        System.out.println("    checking for errors");
    }
}
