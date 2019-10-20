package runners;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/functionalTests",
        monochrome = true,
        glue = {"stepDefinitions"},
        plugin = {"json:target/cucumber-report/cucumber.json", "pretty"}

)
public class TestRunner {
}
