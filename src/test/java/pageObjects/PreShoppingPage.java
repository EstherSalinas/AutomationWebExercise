package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PreShoppingPage extends BasePage{

    public PreShoppingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "hlb-view-cart-announce")
    private WebElement btnGoToCart;

    /**
     * Click button to go to shopping cart
     */
    public void clickGoToCart() {
        btnGoToCart.click();
    }

}
