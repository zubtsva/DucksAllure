package staticPO.tests;

import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.example.Listener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import staticPO.pages.LoginPage;
import staticPO.pages.RubberDucksPage;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.open;

@Listeners(Listener.class)
public class BaseTest {

    WebDriver webDriver;
    LoginPage loginPage;
    RubberDucksPage rubberDucksPage;
    String baseUrl = "https://litecart.stqa.ru/en/";
    Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() {
        logger.info("Before test started");
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        rubberDucksPage = new RubberDucksPage(webDriver);
        WebDriverRunner.setWebDriver(webDriver);
        logger.info("Before test ended");


    }

    @BeforeMethod
    public void beforeMethod() {
        logger.info("Before method deleting cookies");
        webDriver.manage().deleteAllCookies();
        logger.info("Opening " + baseUrl);
        open(baseUrl);

    }

    @AfterClass
    public void teardown() {
        logger.info("Test ended");
        webDriver.quit();
    }
}
