package staticPO.tests;

import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test
    public void unsuccessfulLoginTest() {
        loginPage.attemptIncorrectLogin();
        loginPage.getMessageError();

        Assert.assertEquals(
                webDriver.findElement(loginPage.errorMessage).getText(),
                loginPage.expectedErrorMessage);
    }

    @Test
    public void successfulLoginTest() {
        loginPage.attemptCorrectLogin();
        loginPage.getMessageSuccess();

        Assert.assertEquals(
                webDriver.findElement(loginPage.successMessage).getText(),
                loginPage.expectedSuccessMessage);

    }

}
