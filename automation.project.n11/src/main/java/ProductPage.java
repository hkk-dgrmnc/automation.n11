import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPage extends BasePage {

    private final By productPageLocator = new By.ByCssSelector("div.pagination>a");
    private final By whichPageLocator = new By.ByCssSelector("div.pagination>a.active");
    private final By selectProductsLocator = new By.ByCssSelector("img[width='140']");


    public ProductPage(WebDriver driver) {
        super(driver);
    }


    public void goToSecondPage(int page) {

        getAllPages().get(page).click();

    }


    public boolean isSecondPage() {

        return find(whichPageLocator).getText().equals("2");

    }


    public void chooseProduct(int productNumber) throws InterruptedException {
        Thread.sleep(4000);
        getAllProducts().get(productNumber).click();
        Thread.sleep(2000);

    }


    private List<WebElement> getAllPages() {
        return findAll(productPageLocator);
    }

    private List<WebElement> getAllProducts() { return findAll(selectProductsLocator); }

}
