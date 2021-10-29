import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {

    private final By accountTextLocator = new By.ByCssSelector("a.btnSignIn");
    private final By searchProductLocator = By.id("searchData");
    private final By iconSearchButonLocator = new By.ByCssSelector("a>span.iconSearch");
    private final By basketEmptyQuestionLocator = new By.ByCssSelector("div.cartEmptyText>h2");


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public boolean isLogin() throws InterruptedException {

        Thread.sleep(2000);
        return forIsLogin().isEmpty();

    }


    public void searchProduct(String product) {

        find(searchProductLocator).sendKeys(product);
        find(iconSearchButonLocator).click();

    }


    public boolean isEmpty() throws InterruptedException {
        Thread.sleep(2000);
        return find(basketEmptyQuestionLocator).isDisplayed();

    }


    private List<WebElement> forIsLogin() { return findAll(accountTextLocator); }

}
