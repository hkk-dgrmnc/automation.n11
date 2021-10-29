import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class TestAddProduct extends BaseTest {

    public LoginPage loginPage;
    public HomePage homePage;
    public ProductPage productPage;
    public ProductDetailPage productDetailPage;
    public ShoppingCartPage shoppingCartPage;


    @Test
    @Order(1)
    public void login() throws InterruptedException {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        productDetailPage = new ProductDetailPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        loginPage.addMailAndPassword();
        Thread.sleep(2000);
        Assertions.assertTrue(homePage.isLogin(), "Not successful login");

    }


    @Test
    @Order(2)
    public void openSecondPage() {
        homePage.searchProduct("laptop");
        productPage.goToSecondPage(1);
        Assertions.assertTrue(productPage.isSecondPage(), "Not second page");

    }


    @Test
    @Order(3)
    public void selectProductAndCompare() throws InterruptedException {
        productPage.chooseProduct(4);
        Thread.sleep(2000);
        productDetailPage.addToCart(0);
        productDetailPage.goToCart();
        Assertions.assertEquals(productDetailPage.firstPrice, productDetailPage.secondPrice);
        Thread.sleep(2000);

    }


    @Test
    @Order(4)
    public void increaseNumberOfProduct() throws InterruptedException {
        shoppingCartPage.increaseProduct();
        Assertions.assertTrue(shoppingCartPage.isTwoProduct(), "Not two product");

    }


    @Test
    @Order(5)
    public void emptyCart() throws InterruptedException {
        shoppingCartPage.deleteProduct();
        Assertions.assertTrue(homePage.isEmpty(), "Not empty cart");

    }
}