package staticPO.tests;
import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;


public class LoginTest extends BaseTest {


    @Test
    public void unsuccessfulLoginTest() {
        loginPage.attemptIncorrectLogin();
        $(loginPage.errorMessage).should(Condition.exist);
        $(loginPage.errorMessage).shouldHave(exactText(loginPage.expectedErrorMessage));
    }

    @Test
    public void successfulLoginTest() {
        loginPage.attemptCorrectLogin();
        $(loginPage.successMessage).should(Condition.exist);
        $(loginPage.successMessage).shouldHave(exactText(loginPage.expectedSuccessMessage));
    }
}
