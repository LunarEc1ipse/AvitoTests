package com.sobolev.tests;

import com.codeborne.selenide.Condition;
import com.sobolev.pages.AvitoMainPage;
import com.sobolev.pages.AvitoProductPage;
import com.sobolev.pages.components.StoryModalComponent;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.sobolev.pages.AvitoMainPage.URL;
import static io.qameta.allure.Allure.step;

public class MainPageTests {

    AvitoMainPage avitoMainPage = new AvitoMainPage();
    AvitoProductPage avitoProductPage = new AvitoProductPage();
    StoryModalComponent storyModalComponent = new StoryModalComponent();
    String elementTitleName;

    @Test
    @Tag("MainPageTest")
    @DisplayName("Переход на страницу рекомендованного товара")
    @Severity(SeverityLevel.CRITICAL)
    public void OpenRecommendItemTest() {

        step("Открываем главную страницу", () -> {
            open(URL);
        });
        step("Выбираем первый из рекоммендованных товаров с тайтлом " + elementTitleName, () -> {
            avitoMainPage.recommendItems.first().click();
            elementTitleName = avitoMainPage.getFirstRecommendElementTitle(avitoMainPage.recommendItems);
        });
        step("Переключаемся на вкладку с товаром ", () -> {
            switchTo().window(1);
        });
        step("Проверям, что тайтл на странице совпадает с тайтом на карточке товара ", () -> {
            avitoProductPage.productTitle.shouldHave(Condition.exactText(elementTitleName));
        });
    }

    @Test
    @Tag("MainPageTest")
    @DisplayName("Переход на страницу рекомендованного товара")
    @Severity(SeverityLevel.CRITICAL)
    public void OpenFirstStory() {

        step("Открываем главную страницу", () -> {
            open(URL);
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
    @DisplayName("Переход на страницу рекомендованного товара")
    @Severity(SeverityLevel.CRITICAL)
    public void addItemsToFavoriteTest() {

        step("Открываем главную страницу", () -> {
            open(URL);
        });
        step("Выбираем первую историю", () -> {
            avitoMainPage.storyItems.first().click();
        });
        step("Проверяем что открыласось модальное окно с историей", () -> {
            storyModalComponent.storyModal.shouldBe(visible);
        });
    }
}