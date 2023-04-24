package com.sobolev.tests;

import com.codeborne.selenide.Condition;
import com.sobolev.pages.AvitoProductPage;
import com.sobolev.pages.AvitoSearchPage;
import com.sobolev.pages.navigations.AvitoSearchForm;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.sobolev.pages.AvitoMainPage.URL;
import static com.sobolev.tests.TestData.searchValue;
import static io.qameta.allure.Allure.step;


public class SearchTest extends TestBase {
    AvitoSearchForm avitoSearchForm = new AvitoSearchForm();
    AvitoSearchPage avitoSearchPage = new AvitoSearchPage();
    AvitoProductPage avitoProductPage = new AvitoProductPage();

    @Test
    @Tag("properties")
    @DisplayName("Проверка входа в аккаунт с валидным логином и паролем")
    @Severity(SeverityLevel.BLOCKER)
    public void SearchByNameTest() {
        step("Открываем главную страницу " + URL, () -> {
            open(URL);
        });
        step("Вводим в поле поиска значение - " + searchValue, () -> {
            avitoSearchForm.fillSearchField(searchValue);
        });
        step("Нажимаем кнопку \"Найти\"", () -> {
            avitoSearchForm.clickSearchButton();
        });

        step("Тайтл страницы должен содержать слово - " + searchValue, () -> {
            avitoSearchPage.searchPageTitle.shouldHave(Condition.text(searchValue));
        });
        //Копируем тайтл с каротчки товара
        String elementTitleName = avitoSearchPage.getFirstSearchElementTitle(avitoSearchPage.searchResult);

        step("Открываем первый первый найденный товар ", () -> {
            avitoSearchPage.searchResult.first().click();
        });
        step("Переключаемся на вкладку с товаром ", () -> {
            switchTo().window(1);
        });

        step("Проверям, что тайтл на странице совпадает с тайтом на карточке товара ", () -> {
            avitoProductPage.productTitle.equals(elementTitleName);
        });
    }

}
