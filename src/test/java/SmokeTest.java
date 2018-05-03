import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "src/test/resources/features",
        features = "src/test/resources/features/NavSmokeTest.feature",
        glue = {"global", "stepDefinitions", "pages"},
        format = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"

        }
        //pretty:target/cucumber-json-report.json
)
public class SmokeTest extends AbstractTestNGCucumberTests{
}
