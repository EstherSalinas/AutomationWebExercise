package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//span[@class='a-size-medium sc-product-title a-text-bold']")
    private WebElement lblProductName;

    /**
     * @return The text of the product name label
     */
    public String getProductName() {
        return lblProductName.getText();
    }
}
