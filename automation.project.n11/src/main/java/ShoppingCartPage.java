import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {


    private final By increaseNumberOfProductLocator = new By.ByCssSelector("span.spinnerUp");
    private final By numberOfProductLocator = new By.ByCssSelector("div.spinnerField>input[value='2']");
    private final By deleteProductLocator = new By.ByCssSelector("span.removeProd");


    public ShoppingCartPage(WebDriver driver) { super(driver); }


    public void increaseProduct() throws InterruptedException {

        Thread.sleep(2000);
        find(increaseNumberOfProductLocator).click();
        Thread.sleep(3000);

    }


    public boolean isTwoProduct() {

        return find(numberOfProductLocator).isDisplayed();

    }


    public void deleteProduct() {

        find(deleteProductLocator).click();

    }
}
