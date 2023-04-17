package staticPO.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import org.apache.log4j.Logger;

public class LoginPage extends BasePage {

    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.name("login");
    private final String correctUsername = "l.zubtsova@mail.ru";
    private final String correctPassword = "14031993Atc";
    private final String incorrectUsername = "l.zubtsova@gmail.com";
    private final String incorrectPassword = "14033Atc";
    public By successMessage = By.xpath("//div[@class='notice success']");
    public String expectedSuccessMessage = "You are now logged in as L Z.";
    public By errorMessage = By.xpath("//div[@class='notice errors']");
    public String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

    Logger logger = Logger.getLogger(LoginPage.class);
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void attemptCorrectLogin() {
        logger.info("start login with " + correctUsername);
        $(emailInput).sendKeys(correctUsername);
        logger.info("start login with " + correctPassword);
        $(passwordInput).sendKeys(correctPassword);
        logger.info("start clicking Button login ");
        $(loginButton).click();
        logger.info("Method ends");
    }

    public void attemptIncorrectLogin() {
        logger.info("start login with " + incorrectUsername);
        $(emailInput).sendKeys(incorrectUsername);
        logger.info("start login with " + incorrectPassword);
        $(passwordInput).sendKeys(incorrectPassword);
        logger.info("start clicking Button login ");
        $(loginButton).click();
        logger.info("Method ends");
    }
}
