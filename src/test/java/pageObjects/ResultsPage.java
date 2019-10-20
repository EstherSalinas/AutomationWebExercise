package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


import java.util.List;

public class ResultsPage extends BasePage{

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//span[@class='a-size-medium a-color-base a-text-normal']")
    List<WebElement> listProducts;

    /**
     * Select a product from the search result list
     * @param position The position where is the product inside the list of results
     */
    public void selectProduct(int position) {
        listProducts.get(position).click();
    }
}
