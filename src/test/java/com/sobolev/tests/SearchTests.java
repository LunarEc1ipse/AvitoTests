package com.sobolev.tests;

import com.codeborne.selenide.Condition;
import com.sobolev.pages.AvitoProductPage;
import com.sobolev.pages.AvitoSearchPage;
import com.sobolev.pages.navigations.AvitoSearchForm;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.sobolev.pages.AvitoMainPage.URL;
import static com.sobolev.tests.TestData.searchKey;
import static com.sobolev.tests.TestData.searchValue;
import static io.qameta.allure.Allure.step;

@Description("SearchTests")
public class SearchTests extends TestBase {
    AvitoSearchForm avitoSearchForm = new AvitoSearchForm();
    AvitoSearchPage avitoSearchPage = new AvitoSearchPage();
    AvitoProductPage avitoProductPage = new AvitoProductPage();
    String elementTitleName;

    @Test
    @Tag("SearchTests")
    @DisplayName("Поиск по наименованию товара")
    @Severity(SeverityLevel.BLOCKER)
    public void SearchByNameTest() {
        step("Открываем главную страницу " + URL, () -> {
            open(URL);
        });
        step("Вводим в поле поиска значение - " + searchKey, () -> {
            avitoSearchForm.fillSearchField(searchKey);
        });
        step("Нажимаем кнопку \"Найти\"", () -> {
            avitoSearchForm.clickSearchButton();
        });

        step("Тайтл страницы должен содержать слово - " + searchKey, () -> {
            avitoSearchPage.searchPageTitle.shouldHave(Condition.text(searchKey));
            elementTitleName = avitoSearchPage.getFirstSearchElementTitle(avitoSearchPage.searchResult);
        });
        step("Открываем первый первый найденный товар ", () -> {
            avitoSearchPage.searchResult.first().click();
        });
        step("Переключаемся на вкладку с товаром ", () -> {
            switchTo().window(1);
        });
        step("Проверям, что тайтл на странице совпадает с тайтом на карточке товара ", () -> {
            avitoProductPage.productTitle.shouldHave(Condition.exactText(elementTitleName));
            avitoProductPage.closeWindowAndReturnToMainWindow();
        });
    }

    @Test
    @Tag("SearchTests")
    @DisplayName("Проверка поиска по категории товара")
    @Severity(SeverityLevel.BLOCKER)
    public void SearchByCategoryTest() {
        step("Открываем главную страницу " + URL, () -> {
            open(URL);
        });
        step("Вводим в поле поиска значение - " + searchKey, () -> {
            avitoSearchForm.fillSearchField(searchKey);
        });
        step("В выпадающем списке кликаем на  - " + searchKey, () -> {
            avitoSearchForm.clickOnSearchItem(searchKey);
        });
        step("Тайтл страницы должен содержать название категории - " + searchValue, () -> {
            avitoSearchPage.searchPageTitle.shouldBe(Condition.text(searchValue));
        });
    }
}
