package staticPO.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RubberDucksTest extends BaseTest {


    @Test
    public void numberOfDucks() {
        rubberDucksPage.goToRubberDucks();

        Assert.assertEquals(
                rubberDucksPage.getCountOfDucks(),
                rubberDucksPage.expectedCount);

    }

    @Test
    public void priceOfTheFirstDuckOnDatePage() {
        rubberDucksPage.goToRubberDucks();
        rubberDucksPage.goToDatePage();

        Assert.assertEquals(
                webDriver.findElement(rubberDucksPage.priceOfDuckOnDatePage).getText(),
                rubberDucksPage.expectedPriceOnDatePage);
    }

    @Test
    public void priceOfTheFirstDuckOnNamePage() {
        rubberDucksPage.goToRubberDucks();
        rubberDucksPage.goToNamePage();
        Assert.assertEquals(
                webDriver.findElement(rubberDucksPage.priceOfDuckOnNamePage).getText(),
                rubberDucksPage.expectedPriceOnNamePage);

    }
}
