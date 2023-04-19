package staticPO.tests;
import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;


public class LoginTest extends BaseTest {


    @Test
    public void unsuccessfulLoginTest() {
        logger.info("unsuccessfulLoginTest()");
        loginPage.attemptIncorrectLogin();
        $(loginPage.errorMessage).should(Condition.exist);
        Assert.assertEquals(
                $(loginPage.errorMessage).getText(),
                loginPage.expectedErrorMessage);
    }

    @Test
    public void successfulLoginTest() {
        logger.info("successfulLoginTest");
        loginPage.attemptCorrectLogin();
        $(loginPage.successMessage).should(Condition.exist);
        Assert.assertEquals(
                $(loginPage.successMessage).getText(),
                loginPage.expectedSuccessMessage);
    }
}
