package staticPO.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RubberDucksPage extends BasePage {
    public final By NUMBER_OF_DUCKS = By.cssSelector(".product.column.shadow.hover-light");
    private final By RUBBER_DUCKS = By.xpath("//a[text()='Rubber Ducks']");
    private final By BUTTON_DATA = By.xpath("//a[text()='Date']");
    private final By BUTTON_NAME = By.xpath("//a[text()='Name']");
    private final By SUBCATEGORY_BUTTON = By.xpath("//ul[@class='list-vertical']//a[contains(text(),'Subcategory')]");
    public By searchButton = By.xpath("//*[@type='search']");
    private final By CHANCE_BUTTON = By.xpath("//a[@class='fancybox-region']");
    public By currencyChangeButton = By.xpath("//select[@name='currency_code']");
    public By priceOfDuckOnDatePage = By.xpath("//a[@title='Yellow Duck']/div//strong");
    public By priceOfDuckOnNamePage = By.xpath("//a[@title='Blue Duck']/div/span");
    public int expectedCount = 5;
    public String expectedPriceOnDatePage = "$18";
    public String expectedPriceOnNamePage = "$20";
    public By ducksListHomePage = By.xpath("//a//div[@class='name']");
    public int size = 11;
    public By descriptionOfYellowDuck = By.xpath("//*[@title='Yellow Duck']//*[@class='description']");
    public String expectedDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse sollicitudin ante massa, eget ornare libero porta congue.";
    public By priceOfDuckAfterSearch = By.xpath("//div[@class='price-wrapper']/span");
    public String expectedPriceOfDuckAfterSearch = "$20";
    public String textForSearch = "Green Duck";
    public By priceOfDuckEUR = By.xpath("//a[@title='Green Duck']//span");
    public String expectedPriceOfDuckEUR = "14.52 €";


    public RubberDucksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickRubberDucks() {
        $(RUBBER_DUCKS).click();
    }

    public void clickDatePage() {
        $(BUTTON_DATA).click();
    }

    public void clickNamePage() {
        $(BUTTON_NAME).click();
    }

    public String getDescriptionFromYellowDuckOnSubcategoryPage() {
        $(SUBCATEGORY_BUTTON).click();
        return $(descriptionOfYellowDuck).getText();
    }

    public int getNumberOfDucks() {
        ElementsCollection number = $$(NUMBER_OF_DUCKS);
        return number.size();
    }

    public String searchGreenDuck() {
        $(searchButton).click();
        return $(priceOfDuckAfterSearch).getText();
    }

    public String changeCurrency() {
        $(CHANCE_BUTTON).click();
        return $(priceOfDuckEUR).getText();
    }
}