package staticPO.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import staticPO.pages.RubberDucksPage;
import staticPO.tests.BaseTest;

public class RubberDucksTest extends BaseTest {

    @Test
    public void numberOfDucks() {
        RubberDucksPage.goToRubberDucks(driver);
        int numberOfDucks = driver.findElements(By.cssSelector("li[class='product column shadow hover-light']")).size();
        int actualCount = numberOfDucks;
        int expectedCount = 5;
        Assert.assertEquals(actualCount, expectedCount);
    }
    @Test
    public void priceOfTheFirstDuckOnDatePage() {
        RubberDucksPage.goToDatePage(driver);
        String price = driver.findElement
                (By.xpath("//div[@class='price-wrapper']//*[@class='campaign-price']")).getText();
        String expectedPrice = "$18";
        Assert.assertEquals(price, expectedPrice);
    }
    @Test
    public void priceOfTheFirstDuckOnNamePage() {
        RubberDucksPage.goToNamePage(driver);
        String price = driver.findElement
                (By.xpath("//*[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/blue-duck-p-4']//*[@class='price']"))
                .getText();
        String expectedPrice = "$20";
        Assert.assertEquals(price, expectedPrice);
    }
}
