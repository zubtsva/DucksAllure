package staticPO.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class RubberDucksTest extends BaseTest {


    @Test
    public void numberOfDucks() {
        rubberDucksPage.goToRubberDucks();
        ElementsCollection numOfDucks = $$(rubberDucksPage.numberOfDucks);
        numOfDucks.shouldBe(CollectionCondition.size(rubberDucksPage.expectedCount));
    }

    @Test
    public void priceOfTheFirstDuckOnDatePage() {
        rubberDucksPage.goToRubberDucks();
        rubberDucksPage.goToDatePage();
        $(rubberDucksPage.priceOfDuckOnDatePage)
                .shouldHave(Condition.exactText(rubberDucksPage.expectedPriceOnDatePage));
    }

    @Test
    public void priceOfTheFirstDuckOnNamePage() {
        rubberDucksPage.goToRubberDucks();
        rubberDucksPage.goToNamePage();
        $(rubberDucksPage.priceOfDuckOnNamePage)
                .shouldHave(Condition.exactText(rubberDucksPage.expectedPriceOnNamePage));
    }

    @Test //проверяем имена в списке уточек
    public void checkNamesOfDucksList() {
        ElementsCollection ducksList = $$(rubberDucksPage.ducksListHomePage);
        ducksList.shouldBe(CollectionCondition.
                containExactTextsCaseSensitive("Blue Duck", "Green Duck",
                        "Yellow Duck", "Purple Duck", "Red Duck", "Yellow Duck", "Yellow Duck", "Green Duck",
                        "Red Duck", "Blue Duck", "Purple Duck"));
    }

    @Test //проверяем размер коллекции уточек(11)
    public void sizeOfCollectionOfDucks() {
        ElementsCollection ducksList = $$(rubberDucksPage.ducksListHomePage);
        ducksList.shouldBe(CollectionCondition.size(rubberDucksPage.size));
    }


}
