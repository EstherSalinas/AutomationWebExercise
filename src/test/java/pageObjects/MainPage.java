package pageObjects;

import managers.FileReaderManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MainPage extends BasePage{


    public MainPage (WebDriver driver) {
        super(driver);

    }

    @FindBy(how = How.ID, using = "twotabsearchtextbox")
    private WebElement txtSearchProduct;

    /**
     * Navigate to main page
     */
    public void navigateToMainPage() {
        driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());

    }

    /**
     * Search a product in the search bar
     * @param productName The product to search
     */
    public void searchProduct(String productName) {

        txtSearchProduct.sendKeys(productName);
        txtSearchProduct.sendKeys(Keys.RETURN);
    }


}
