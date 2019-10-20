package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;


public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }


    /**
     *
     * Executed after test executiom
     * If Scenario fails, a screenshot is saved
     * Driver is closed after each scenario
     */
    @After
    public void AfterSteps(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException wde) {
                System.err.println(wde.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        testContext.getWebDriverManager().closeDriver();
    }
}
