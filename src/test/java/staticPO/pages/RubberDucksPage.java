package staticPO.pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RubberDucksPage extends BasePage {
    public final By numberOfDucks = By.cssSelector(".product.column.shadow.hover-light");
    private final By rubberDucks = By.xpath("//a[text()='Rubber Ducks']");
    private final By buttonData = By.xpath("//a[text()='Date']");
    private final By buttonName = By.xpath("//a[text()='Name']");
    private final By subcategoryButton = By.xpath("//ul[@class='list-vertical']//a[contains(text(),'Subcategory')]");
    public By searchButton = By.xpath("//*[@type='search']");
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

    public String getDescriptionFromYellowDuckOnSubcategoryPage() {
        $(subcategoryButton).click();
        return $(descriptionOfYellowDuck).getText();
    }

    public int getNumberOfDucks() {
        ElementsCollection number = $$(numberOfDucks);
        return number.size();
    }

    public String searchGreenDuck() {
        $(searchButton).click();
        return $(priceOfDuckAfterSearch).getText();
    }
}