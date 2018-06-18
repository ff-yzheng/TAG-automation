import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "src/test/resources/features",
        features ={"src/test/resources/features/SmokeTest.feature"} ,
        glue = {"global", "stepDefinitions"},
        tags = {"~@IgnoreForNow"},
        dryRun =false,

        format = {
                "pretty",
                "html:target/cucumber-report-html",
                "json:target/cucumber-report-html/Cucumber.json",
                "rerun:target/cucumber-reports/rerun.txt"

        }
        //pretty:target/cucumber-json-report.json
)
public class SmokeTest {
}
