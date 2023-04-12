package staticPO.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {



    private final By emailInput = By.name("email");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.name("login");
    private final By messageError = By.cssSelector("[class='notice errors']");

    private final String correctUsername = "l.zubtsova@mail.ru";
    private final String correctPassword = "14031993Atc";
    private final String incorrectUsername = "l.zubtsova@gmail.com";
    private final String incorrectPassword = "14033Atc";
    public By successMessage = By.xpath("//div[@class='notice success']");
    public String expectedSuccessMessage = "You are now logged in as L Z.";
    public By errorMessage = By.xpath("//div[@class='notice errors']");
    public String expectedErrorMessage = "Wrong password or the account is disabled, or does not exist";


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void attemptCorrectLogin() {
        webDriver.findElement(emailInput).sendKeys(correctUsername);
        webDriver.findElement(passwordInput).sendKeys(correctPassword);
        webDriver.findElement(loginButton).click();
    }
    public void attemptIncorrectLogin() {
        webDriver.findElement(emailInput).sendKeys(incorrectUsername);
        webDriver.findElement(passwordInput).sendKeys(incorrectPassword);
        webDriver.findElement(loginButton).click();
    }

    public String getMessageError() {
        wait.until(ExpectedConditions.presenceOfElementLocated(messageError));
        System.out.println(webDriver.findElement(messageError).getText());
        return null;
    }

    public String getMessageSuccess() {
        wait.until(ExpectedConditions.presenceOfElementLocated(successMessage));
        System.out.println(webDriver.findElement(successMessage).getText());
        return null;
    }
}
