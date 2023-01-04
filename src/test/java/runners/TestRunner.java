package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "html:Reports/htmlReport.html", "json:Reports/jsonReport.json"},
		features="./src/test/resources/features",
                 glue="step_defintions",
                 dryRun=false, // when is true cucumber only runs the scenario steps that have not been implemented.
                 tags="@ValidLoginTest",
                 publish=true
                 )
public class TestRunner {
	
}
