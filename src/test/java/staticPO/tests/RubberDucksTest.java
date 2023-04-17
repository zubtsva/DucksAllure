package staticPO.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;

import java.io.File;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.OutputType.FILE;

public class RubberDucksTest extends BaseTest {


    @Test
    public void numberOfDucks() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.getNumberOfDucks();
        ElementsCollection numOfDucks = $$(rubberDucksPage.numberOfDucks);
        numOfDucks.shouldBe(CollectionCondition.size(rubberDucksPage.expectedCount));
    }

    @Test
    public void priceOfTheFirstDuckOnDatePage() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickDatePage();
        $(rubberDucksPage.priceOfDuckOnDatePage)
                .shouldHave(Condition.exactText(rubberDucksPage.expectedPriceOnDatePage));
    }

    @Test
    public void priceOfTheFirstDuckOnNamePage() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickNamePage();
        $(rubberDucksPage.priceOfDuckOnNamePage)
                .shouldHave(Condition.exactText(rubberDucksPage.expectedPriceOnNamePage));
    }

    @Test //проверяем имена в списке уточек
    public void checkNamesOfDucksList() {
        ElementsCollection ducksList = $$(rubberDucksPage.ducksListHomePage);
        ducksList.shouldBe(CollectionCondition.
                containExactTextsCaseSensitive("Blue Duck", "Green Duck",
                        "Yellow Duck", "Purple Duck", "Red Duck"));
    }

    @Test //проверяем размер коллекции уточек(11)
    public void sizeOfCollectionOfDucks() {
        ElementsCollection ducksList = $$(rubberDucksPage.ducksListHomePage);
        ducksList.shouldBe(CollectionCondition.size(rubberDucksPage.size));
    }

    @Test  //заходим на RubberDucksPage, затем кликаем на SubcategoryPage, проверяем описание желтой уточки
    public void descriptionOfYellowDuckTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.getDescriptionFromYellowDuckOnSubcategoryPage();
        $(rubberDucksPage.descriptionOfYellowDuck).shouldHave(Condition.exactText(rubberDucksPage.expectedDescription + "!!!"));
    }

    @Test
    public void searchTest() { //в поиске ищем "Green Duck", в открывшейся странице проверяем цену уточки
        rubberDucksPage.searchGreenDuck();
        $(rubberDucksPage.searchButton).sendKeys(rubberDucksPage.textForSearch);
        $(rubberDucksPage.searchButton).pressEnter();
        $(rubberDucksPage.priceOfDuckAfterSearch).shouldHave(Condition.exactText(rubberDucksPage.expectedPriceOfDuckAfterSearch));
    }

    @Test
    public void changeCurrencyTest() { //меняем валютю на евро и проверяем цену первой уточки
        rubberDucksPage.changeCurrency();
        $(rubberDucksPage.currencyChangeButton).selectOption("Euros");
        $(rubberDucksPage.currencyChangeButton).pressEnter();
        $(rubberDucksPage.priceOfDuckEUR).shouldHave(Condition.exactText(rubberDucksPage.expectedPriceOfDuckEUR));
    }
}
