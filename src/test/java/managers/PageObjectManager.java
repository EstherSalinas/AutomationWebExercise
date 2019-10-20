package managers;

import org.openqa.selenium.WebDriver;
import pageObjects.*;

public class PageObjectManager {

    private WebDriver driver;
    MainPage mainPage;
    ResultsPage resultsPage;
    DetailPage detailPage;
    PreShoppingPage preShoppingPage;
    ShoppingCartPage shoppingCartPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage getMainPage() {
        return (mainPage == null) ? mainPage = new MainPage(driver) : mainPage;
    }

    public ResultsPage getResultsPage() {
        return (resultsPage == null) ? resultsPage = new ResultsPage(driver) : resultsPage;
    }

    public DetailPage getDetailPage() {
        return (detailPage == null) ? detailPage = new DetailPage (driver) : detailPage;
    }

    public PreShoppingPage getPreShoppingPage() {
        return (preShoppingPage == null) ? preShoppingPage = new PreShoppingPage (driver) : preShoppingPage;
    }

    public ShoppingCartPage getShoppingCartPage() {
        return (shoppingCartPage == null) ? shoppingCartPage = new ShoppingCartPage (driver) : shoppingCartPage;
    }
}
