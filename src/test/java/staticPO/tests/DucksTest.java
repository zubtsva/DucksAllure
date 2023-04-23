package staticPO.tests;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DucksTest extends BaseTest {


    @Test
    @Description  ("Count number of ducks on the Rubber Ducks Page")
    public void numberOfDucks() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.getNumberOfDucks();
        ElementsCollection numOfDucks = $$(rubberDucksPage.NUMBER_OF_DUCKS);
        numOfDucks.shouldBe(CollectionCondition.size(rubberDucksPage.expectedCount));
    }

    @Test
    @Description ("Go to Date Page and check price of the first duck")
    public void priceOfTheFirstDuckOnDatePage() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickDatePage();
        Assert.assertEquals(
                $(rubberDucksPage.priceOfDuckOnDatePage).getText(),
                rubberDucksPage.expectedPriceOnDatePage);
    }

    @Test
    @Description ("Go to Name Page and check price of the first duck")
    public void priceOfTheFirstDuckOnNamePage() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.clickNamePage();
        Assert.assertEquals(
                $(rubberDucksPage.priceOfDuckOnNamePage).getText(),
                rubberDucksPage.expectedPriceOnNamePage);
    }

    @Test
    @Description ("Check names of the ducks on the Rubber Ducks Page")
    public void checkNamesOfDucksList() {
        ElementsCollection ducksList = $$(rubberDucksPage.ducksListHomePage);
        ducksList.shouldBe(CollectionCondition.
                containExactTextsCaseSensitive("Blue Duck", "Green Duck",
                        "Yellow Duck", "Purple Duck", "Red Duck"));
    }

    @Test //проверяем размер коллекции уточек(11)
    @Description ("Count number of ducks on the first page")
    public void sizeOfCollectionOfDucks() {
        ElementsCollection ducksList = $$(rubberDucksPage.ducksListHomePage);
        ducksList.shouldBe(CollectionCondition.size(rubberDucksPage.size));
    }

    @Test  //заходим на RubberDucksPage, затем кликаем на SubcategoryPage, проверяем описание желтой уточки
    @Description ("Check description of the yellow duck on subcategory page ")
    public void descriptionOfYellowDuckTest() {
        rubberDucksPage.clickRubberDucks();
        rubberDucksPage.getDescriptionFromYellowDuckOnSubcategoryPage();
        Assert.assertEquals(
                $(rubberDucksPage.descriptionOfYellowDuck).getText(),
                rubberDucksPage.expectedDescription + "!!!!");

    }

    @Test
    public void searchTest() { //в поиске ищем "Green Duck", в открывшейся странице проверяем цену уточки
        rubberDucksPage.searchGreenDuck();
        $(rubberDucksPage.searchButton).sendKeys(rubberDucksPage.textForSearch);
        $(rubberDucksPage.searchButton).pressEnter();
        Assert.assertEquals(
                $(rubberDucksPage.priceOfDuckAfterSearch).getText(),
                rubberDucksPage.expectedPriceOfDuckAfterSearch);
    }

    @Test
    public void changeCurrencyTest() { //меняем валютю на евро и проверяем цену первой уточки
        rubberDucksPage.changeCurrency();
        $(rubberDucksPage.currencyChangeButton).selectOption("Euros");
        $(rubberDucksPage.currencyChangeButton).pressEnter();
        Assert.assertEquals(
                $(rubberDucksPage.priceOfDuckEUR).getText(),
                rubberDucksPage.expectedPriceOfDuckEUR);
    }
    @Test
    public void unsuccessfulLoginTest() {
        logger.info("unsuccessfulLoginTest()");
        loginPage.attemptIncorrectLogin();
        $(loginPage.errorMessage).should(Condition.exist);
        Assert.assertEquals(
                $(loginPage.errorMessage).getText(),
                loginPage.expectedErrorMessage);
    }

    @Test
    public void successfulLoginTest() {
        logger.info("successfulLoginTest");
        loginPage.attemptCorrectLogin();
        $(loginPage.successMessage).should(Condition.exist);
        Assert.assertEquals(
                $(loginPage.successMessage).getText(),
                loginPage.expectedSuccessMessage);
    }
    @Test
    public void loginWithoutPasswordTest() {
        logger.info("loginWithoutPasswordTest");
        loginPage.attemptLoginWithoutPassword();
        $(loginPage.errorMessageWithoutPassword).should(Condition.exist);
        Assert.assertEquals(
                $(loginPage.errorMessageWithoutPassword).getText(),
                loginPage.expectedErrorMessageWithoutPassword);
    }
    @Test
    public void loginWithEmptyFieldsTest() {
        logger.info("loginWithEmptyFieldsTest");
        loginPage.attemptLoginWithEmptyFields();
        $(loginPage.loginLink).should(Condition.exist);
        Assert.assertEquals(
                $(loginPage.loginLink).getText(),
                loginPage.expectedTextOfTheLink);
    }

}
