package global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

import java.net.URL;
import java.net.MalformedURLException;


public final class WebDriverFactory {

    private WebDriverFactory() {

    }

    public static WebDriver create() {
        String webDriverProperty = getProperty("webdriver");

        if (webDriverProperty == null || webDriverProperty.isEmpty()) {
            throw new IllegalStateException("The webdriver system property must be set");
        }

        try {
            return Drivers.valueOf(webDriverProperty.toUpperCase()).newDriver();
        } catch (IllegalArgumentException e) {
            String msg = format("The webdriver system property '%s' did not match any " +
                            "existing browser or the browser was not supported on your operating system. " +
                            "Valid values are %s",
                    webDriverProperty, stream(Drivers
                            .values())
                            .map(Enum::name)
                            .map(String::toLowerCase)
                            .collect(toList()));

            throw new IllegalStateException(msg, e);
        }
    }

    private enum Drivers {
        FIREFOX {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                return new FirefoxDriver(capabilities);
            }
        }, CHROME {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();

                 return new ChromeDriver(capabilities);

            }
        },CHROME_HEADLESS {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                // chromeOptions.setBinary("/Applications/Google Chrome Canary.app/Contents/MacOS/Google Chrome Canary");
                ChromeOptions chromeOptions= new ChromeOptions();
                chromeOptions.addArguments("--headless");
                return new ChromeDriver(chromeOptions);
                //  return new ChromeDriver(capabilities);

            }
        }, OPERA {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.operaBlink();
                return new OperaDriver(capabilities);
            }
        }, PHANTOMJS {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.phantomjs();
                return new PhantomJSDriver(capabilities);
            }
        }, IE {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                return new InternetExplorerDriver(capabilities);
            }
        }, EDGE {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities capabilities = DesiredCapabilities.edge();
                return new EdgeDriver(capabilities);
            }
        }, REMOTE {
            @Override
            public WebDriver newDriver() {
                DesiredCapabilities caps = DesiredCapabilities.chrome();
                caps.setCapability("platform", "Windows 7");
                caps.setCapability("version", "38.0");
                RemoteWebDriver remoteDriver = null;


                try {
                    remoteDriver = new RemoteWebDriver(new URL("http://yzheng:943377be-9ce8-4a98-8c29-5f721a07037f@ondemand.saucelabs.com:80/wd/hub"), caps);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return remoteDriver;

            }
        };


        public abstract org.openqa.selenium.WebDriver newDriver();

    }
}