package staticPO.tests;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;


public class LoginTest extends BaseTest {


    @Test
    public void unsuccessfulLoginTest() {
        loginPage.attemptIncorrectLogin();
        loginPage.getMessageError();
        $(loginPage.errorMessage).shouldHave(exactText(loginPage.expectedErrorMessage));
    }

    @Test
    public void successfulLoginTest() {
        loginPage.attemptCorrectLogin();
        loginPage.getMessageSuccess();
        $(loginPage.successMessage).shouldHave(exactText(loginPage.expectedSuccessMessage));
    }
}
