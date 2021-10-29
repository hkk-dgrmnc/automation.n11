import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By girisYapButonLocator = new By.ByCssSelector("a[title='Hesabım']");
    private final By emailLocator = By.id("email");
    private final By passwordLocator = By.id("password");
    private final By loginButonLocator = By.id("loginButton");


   public String email = "klmn_0505@hotmail.com";
   public String password = "123456789aa";


    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public void addMailAndPassword() throws InterruptedException {

        find(girisYapButonLocator).click();
        find(emailLocator).sendKeys(email);
        find(passwordLocator).sendKeys(password);
        Thread.sleep(2000);
        find(loginButonLocator).click();

    }
}
