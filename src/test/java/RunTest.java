import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import pages.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"steps","util"},
        tags = {"@smoke","@login"},
        monochrome = true,
        plugin = {
                "pretty",
                "json:target/Cucumber.json"
        },
        dryRun = false
)
@FixMethodOrder(MethodSorters.DEFAULT)
public class RunTest extends BasePage {
}

