package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DetailPage extends BasePage{

    public DetailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.ID, using = "add-to-cart-button")
    private WebElement btnAddToCart;

    /**
     * Click add button to add to shopping cart
     */
    public void clickAddToCart() {
        btnAddToCart.click();
     }
}
