package staticPO.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class RubberDucksPage extends BasePage {
    private static final By rubberDucks = By.xpath("//a[@href='https://litecart.stqa.ru/en/rubber-ducks-c-1/']");

    private static final By buttonData =  By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=date']");

    private static final By buttonName = By.cssSelector("[href='https://litecart.stqa.ru/en/rubber-ducks-c-1/?category_id=1&page=1&sort=name']");

    public RubberDucksPage(WebDriver driver) {
        super(driver);
    }

    public static void goToRubberDucks(WebDriver driver) {
        driver.findElement(rubberDucks).click();
    }

    public static void goToDatePage(WebDriver driver) {
        driver.findElement(buttonData).click();
    }

    public static void goToNamePage(WebDriver driver) {
        driver.findElement(buttonName).click();
    }

}
