package staticPO.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import org.apache.log4j.Logger;

public class LoginPage extends BasePage {

    private final By EMAIL_INPUT = By.name("email");
    private final By PASSWORD_INPUT = By.name("password");
    private final By LOGIN_BUTTON = By.name("login");
    private final String CORRECT_USERNAME = "l.zubtsova@mail.ru";
    private final String CORRECT_PASSWORD = "14031993Atc";
    private final String INCORRECT_USERNAME = "l.zubtsova@gmail.com";
    private final String INCORRECT_PASSWORD = "14033Atc";
    public By successMessage = By.xpath("//div[@class='notice success']");
    public String expectedSuccessMessage = "You are now logged in as L Z.";
    public By errorMessage = By.xpath("//div[@class='notice errors']");
    public String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";

    Logger logger = Logger.getLogger(LoginPage.class);
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void attemptCorrectLogin() {
        logger.info("start login with " + CORRECT_USERNAME);
        $(EMAIL_INPUT).sendKeys(CORRECT_USERNAME);
        logger.info("start login with " + CORRECT_USERNAME);
        $(PASSWORD_INPUT).sendKeys(CORRECT_PASSWORD);
        logger.info("start clicking Button login ");
        $(LOGIN_BUTTON).click();
        logger.info("Method ends");
    }

    public void attemptIncorrectLogin() {
        logger.info("start login with " + INCORRECT_USERNAME);
        $(EMAIL_INPUT).sendKeys(INCORRECT_USERNAME);
        logger.info("start login with " + INCORRECT_PASSWORD);
        $(PASSWORD_INPUT).sendKeys(INCORRECT_PASSWORD);
        logger.info("start clicking Button login ");
        $(LOGIN_BUTTON).click();
        logger.info("Method ends");
    }
}
