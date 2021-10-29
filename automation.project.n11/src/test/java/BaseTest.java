import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class BaseTest {

   public WebDriver driver;

    @BeforeAll
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://www.n11.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }


    @AfterAll
    public void tearDown() {
        driver.quit();
    }

}
