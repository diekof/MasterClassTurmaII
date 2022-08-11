import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"steps","util"},
        format = {"pretty", "html:target/cucumber-report", "json:target/cucumber.json"},
        tags = "@smoke"
)
public class RunTest extends BasePage {
}

