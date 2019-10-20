package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.When;
import pageObjects.DetailPage;
import pageObjects.ResultsPage;

public class AddToShoppingCartSteps extends BaseSteps{


    ResultsPage resultsPage;
    DetailPage detailPage;

    public AddToShoppingCartSteps(TestContext context) {
        super(context);
        detailPage = testContext.pageObjectManager().getDetailPage();
        resultsPage = testContext.pageObjectManager().getResultsPage();
    }

    @When("^he adds the first item into the shopping cart$")
    public void he_adds_the_first_item_into_the_shopping_cart()  {

        resultsPage.selectProduct(0);
        detailPage.clickAddToCart();

    }


}
