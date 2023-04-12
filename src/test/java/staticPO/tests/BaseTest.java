package staticPO.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import staticPO.pages.LoginPage;
import staticPO.pages.RubberDucksPage;

public class BaseTest {

    WebDriver webDriver;
    LoginPage loginPage;
    RubberDucksPage rubberDucksPage;
    String baseUrl = "https://litecart.stqa.ru/en/";

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        loginPage = new LoginPage(webDriver);
        rubberDucksPage = new RubberDucksPage(webDriver);


    }

    @BeforeMethod
    public void beforeMethod() {
        webDriver.manage().deleteAllCookies();
        webDriver.get(baseUrl);
    }


    @AfterTest
    public void teardown() {
        webDriver.quit();
    }
}
