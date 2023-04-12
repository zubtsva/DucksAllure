package staticPO.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RubberDucksPage extends BasePage {
    private final By rubberDucks = By.xpath("//a[text()='Rubber Ducks']");

    private final By buttonData = By.xpath("//a[text()='Date']");

    private final By buttonName = By.xpath("//a[text()='Name']");
    private final By numberOfDucks = By.cssSelector(".product.column.shadow.hover-light");
    public By priceOfDuckOnDatePage = By.xpath("//a[@title='Yellow Duck']/div//strong");
    public By priceOfDuckOnNamePage = By.xpath("//a[@title='Blue Duck']/div/span");
    public int expectedCount = 5;
    public String expectedPriceOnDatePage = "$18";
    public String expectedPriceOnNamePage = "$20";


    public RubberDucksPage(WebDriver webDriver) {
        super(webDriver);
    }



    public void clickRubberDucks() {

//        wait.until(ExpectedConditions.presenceOfElementLocated(rubberDucks));
        webDriver.findElement(rubberDucks).click();
    }

    public void clickDatePage() {

        webDriver.findElement(buttonData).click();
    }

    public void clickNamePage() {

        webDriver.findElement(buttonName).click();
    }
    public int getCountOfDucks() {
        List<WebElement> number = webDriver.findElements(numberOfDucks);
        return number.size();
    }

    public void checkRubberDucksAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(rubberDucks));

    }
    public void checkDatePageAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonData));
    }
    public void checkNanePageAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonName));
    }

    public void goToRubberDucks() {
        checkRubberDucksAppeared();
        clickRubberDucks();
    }
    public void goToDatePage() {
        checkDatePageAppeared();
        clickDatePage();
    }
    public void goToNamePage() {
        checkDatePageAppeared();
        clickNamePage();
    }


}
