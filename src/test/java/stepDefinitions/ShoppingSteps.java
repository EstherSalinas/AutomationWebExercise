package stepDefinitions;

import cucumber.TestContext;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import pageObjects.PreShoppingPage;
import pageObjects.ShoppingCartPage;

public class ShoppingSteps extends BaseSteps{

    PreShoppingPage preShoppingPage;
    ShoppingCartPage shoppingCartPage;

    public ShoppingSteps (TestContext context) {
        super(context);
        preShoppingPage = context.pageObjectManager().getPreShoppingPage();
        shoppingCartPage = context.pageObjectManager().getShoppingCartPage();
    }

    @Then("^the \"([^\"]*)\" is added correctly into the shopping cart$")
    public void the_is_added_correctly_into_the_shopping_cart(String productName)  {
        preShoppingPage.clickGoToCart();
        Assert.assertTrue((shoppingCartPage.getProductName().contains(productName)));
    }

}
