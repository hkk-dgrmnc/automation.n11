import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductDetailPage extends BasePage {

    private final By addCartButonLocator = new By.ByCssSelector("a.btnGrey");
    private final By goBasketLocator = new By.ByCssSelector("i.iconBasket");
    private final By productPagePriceLocator = new By.ByCssSelector("div.newPrice>ins");
    private final By productCartPriceLocator = new By.ByCssSelector("div.priceArea");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public String firstPrice;
    public String secondPrice;

    public void addToCart(int butonNumber) throws InterruptedException {

        Thread.sleep(2000);
        firstPrice = find(productPagePriceLocator).getText();
        selectAddBasketButon().get(butonNumber).click();

    }


    public void goToCart() throws InterruptedException {

        Thread.sleep(3000);
        find(goBasketLocator).click();
        Thread.sleep(3000);
        secondPrice = find(productCartPriceLocator).getText();

    }


    private List<WebElement> selectAddBasketButon() {
        return findAll(addCartButonLocator);
    }

}
