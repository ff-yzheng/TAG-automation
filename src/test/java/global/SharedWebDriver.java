package global;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class SharedWebDriver extends EventFiringWebDriver {
    private static final WebDriver REAL_DRIVER = WebDriverFactory.create();

    private static final Thread CLOSE_THREAD = new Thread() {
        @Override
        public void run() {
            REAL_DRIVER.quit();
        }
    };

    static {
        Runtime.getRuntime().addShutdownHook(CLOSE_THREAD);
    }

    public SharedWebDriver() {
        super(REAL_DRIVER);
    }

    public static WebDriver getDriver() {
        return REAL_DRIVER;
    }

    public static Scenario scenario;

    @Override
    public void quit() {
        if (Thread.currentThread() != CLOSE_THREAD) {
            throw new UnsupportedOperationException("You shouldn't quit this WebDriver. It's shared and will quit when the JVM exits.");
        }
        super.quit();
    }

    @Before
    public void deleteAllCookies() {
        manage().deleteAllCookies();
    }
    @Before
    public void before(Scenario scenario) {
        SharedWebDriver.scenario = scenario;
    }

    @After
    public void embedScreenshotOnFail(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }
}
