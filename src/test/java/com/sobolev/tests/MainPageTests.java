package com.sobolev.tests;

import com.codeborne.selenide.Condition;
import com.sobolev.pages.AvitoMainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static io.qameta.allure.Allure.step;

@Description("MainPageTests")
@Feature("MainPageTests")
public class MainPageTests extends TestBase {
    String elementTitleName;

    @Test
    @Tag("MainPageTest")
    @DisplayName("Переход на страницу рекомендованного товара")
    @Severity(SeverityLevel.CRITICAL)
    public void OpenRecommendItemTest() {

        step("Открываем главную страницу", () -> {
            AvitoMainPage.openManePage();
        });
        step("Выбираем первый из рекоммендованных товаров с тайтлом " + elementTitleName, () -> {
            avitoMainPage.recommendItems.first().click();
            elementTitleName = avitoMainPage.getFirstRecommendElementTitle(avitoMainPage.recommendItems);
        });
        step("Переключаемся на вкладку с товаром ", () -> {
            switchWindow(1);
        });
        step("Проверям, что тайтл на странице совпадает с тайтом на карточке товара ", () -> {
            avitoProductPage.productTitle.shouldHave(Condition.exactText(elementTitleName));
            closeWindowAndReturnToMainWindow();
        });
    }

    @Test
    @Tag("MainPageTest")
    @DisplayName("Просмотр историй")
    @Severity(SeverityLevel.CRITICAL)
    public void OpenFirstStory() {
        step("Открываем главную страницу", () -> {
            AvitoMainPage.openManePage();
        });
        step("Выбираем первую историю", () -> {
            avitoMainPage.storyItems.first().click();
        });
        step("Проверяем что открыласось модальное окно с историей", () -> {
            storyModalComponent.storyModal.shouldBe(visible);
        });
    }

    @Test
    @Tag("MainPageTest")
    @DisplayName("Добавление товара в избранное")
    @Severity(SeverityLevel.NORMAL)
    public void addItemToFavoriteTest() {
        step("Открываем главную страницу", () -> {
            AvitoMainPage.openManePage();
        });
        step("Добавляем первый из рекоммендованных товаров в избранное", () -> {
            avitoMainPage.clickOnFavoriteButton();
            elementTitleName = avitoMainPage.getFirstRecommendElementTitle(avitoMainPage.recommendItems);
        });
        step("Открываем страницу с избранными товарами", () -> {
            avitoHeader.OpenFavoritesPage();
        });
        step("Проверяем что товар добавлен в избранное", () -> {
            avitoFavoritePage.findFavoriteElementByTitle(elementTitleName);
        });
    }
}
