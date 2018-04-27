package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractSteps {

    // Set the webdriver to be passed between stepdefinitions
    protected WebDriver driver;

    protected WebDriver getDriver(){
        if (driver == null){
            // TODO: Read webdriver value from pom.xml instead of hardcoding to ChromeDriver here
            driver = new ChromeDriver();
        }
        return driver;
    }

    // Enable wait options in steps
    protected void WaitUntilLoaded(WebDriver activeDriver, WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(activeDriver, 10);
        wait.until((ExpectedConditions.visibilityOf(webElement)));
    }

    protected void WaitUntilLoaded(WebDriver activeDriver, WebElement webElement, int waitForSeconds) {
        WebDriverWait wait = new WebDriverWait(activeDriver, waitForSeconds);
        wait.until((ExpectedConditions.visibilityOf(webElement)));
    }

    // Trim all special characters and leading and trailing spaces
    protected String AllTrim(String value){
        // replace line breaks with a space
        value = value.replaceAll("\\r\\n|\\r|\\n", " ");

        // trim leading and trailing spaces
        value = value.trim();

        return value;
    }
}
