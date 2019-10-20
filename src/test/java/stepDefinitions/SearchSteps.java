package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pageObjects.MainPage;

public class SearchSteps extends BaseSteps{

    MainPage mainPage;

    public SearchSteps(TestContext context) {
        super(context);
        mainPage = testContext.pageObjectManager().getMainPage();
    }

    @Given("^user is in Home Page$")
    public void user_is_in_Home_Page() {
        mainPage.navigateToMainPage();

    }

    @When("^he searches for \"([^\"]*)\"$")
    public void he_searches_for(String productName)  {
        mainPage.searchProduct(productName);
    }



}
