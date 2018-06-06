import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        //features = "src/test/resources/features",
        features = "src/test/resources/features/ProgramManagement/Companies/CreateCompany.feature",
        glue = {"global", "stepDefinitions", "pages"},
        tags = {"~@IgnoreForNow"},

        format = {
                "pretty",
                "html:target/cucumber-report-html",
                "json:target/cucumber-report-html/Cucumber.json",
                "rerun:target/cucumber-reports/rerun.txt"

        }
        //pretty:target/cucumber-json-report.json
)
public class SmokeTest_CreateCompany extends AbstractTestNGCucumberTests{
}
