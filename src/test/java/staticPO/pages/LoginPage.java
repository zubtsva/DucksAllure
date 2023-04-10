package staticPO.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    WebDriverWait wait;

    private static By emailInput = By.name("email");
    private static By passwordInput = By.name("password");
    private static By loginButton = By.name("login");

    public LoginPage(WebDriver driver) {
        super(driver);
    }


    public static void attemptLogin(WebDriver driver, String username, String password) {


        driver.findElement(emailInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
