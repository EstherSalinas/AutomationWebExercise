package stepDefinitions;

import cucumber.TestContext;

public class BaseSteps {
    TestContext testContext;

    public BaseSteps(TestContext context) {
        testContext = context;
    }
}
