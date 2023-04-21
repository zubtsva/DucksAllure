package staticPO.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {
    WebDriver webDriver;
    WebDriverWait wait;

    public BasePage (WebDriver webdriver) {
        this.webDriver = webdriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));

    }
}
