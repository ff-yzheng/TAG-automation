package stepDefinitions;

import cucumber.api.java.en.Given;
import global.SharedWebDriver;
import org.openqa.selenium.WebDriver;

public class Steps {

    @Given("^everything is working$")
    public void everything_is_working() throws Throwable {
        WebDriver driver = SharedWebDriver.getDriver();
        driver.get("https://google.com");
    }
}
