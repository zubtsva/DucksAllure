package staticPO.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticPO.pages.LoginPage;


public class LoginTest extends BaseTest {

    @Test
    public void unsuccessfulLoginTest() {
        LoginPage.attemptLogin(driver, "l.zubtsova@mail.ru", "14031Atc");
        String expectedMessage = "Wrong password or the account is disabled, or does not exist";
        String actualMessage = driver.findElement(By.cssSelector("[class='notice errors']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test
    public void successfulLoginTest() {
        LoginPage.attemptLogin(driver, "l.zubtsova@mail.ru", "14031993Atc");
        String expectedMessage = "You are now logged in as L Z.";
        String actualMessage = driver.findElement(By.cssSelector("[class='notice success']")).getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

}
