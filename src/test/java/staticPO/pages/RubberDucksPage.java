package staticPO.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;

public class RubberDucksPage extends BasePage {
    public final By numberOfDucks = By.cssSelector(".product.column.shadow.hover-light");
    private final By rubberDucks = By.xpath("//a[text()='Rubber Ducks']");
    private final By buttonData = By.xpath("//a[text()='Date']");
    private final By buttonName = By.xpath("//a[text()='Name']");
    public By priceOfDuckOnDatePage = By.xpath("//a[@title='Yellow Duck']/div//strong");
    public By priceOfDuckOnNamePage = By.xpath("//a[@title='Blue Duck']/div/span");
    public int expectedCount = 5;
    public String expectedPriceOnDatePage = "$18";
    public String expectedPriceOnNamePage = "$20";
    public By ducksListHomePage = By.xpath("//a//div[@class='name']");

    public String expectedListOfNames = ("Red Duck, " + "Purple Duck, " + "Yellow Duck, " + "Green Duck, " + "Blue Duck, " + "Yellow Duck, " + "Yellow Duck, " + "Green Duck, " +
            "Red Duck, " + "Blue Duck, " + "Purple Duck ");

    public int size = 11;


    public RubberDucksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickRubberDucks() {
        $(rubberDucks).click();
    }

    public void clickDatePage() {
        $(buttonData).click();
    }

    public void clickNamePage() {
        $(buttonName).click();
    }

    public void checkRubberDucksAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(rubberDucks));
    }

    public void checkDatePageAppeared() {
        wait.until(ExpectedConditions.presenceOfElementLocated(buttonData));
    }

    public void checkNamePageAppeared() {
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
        checkNamePageAppeared();
        clickNamePage();
    }
}
