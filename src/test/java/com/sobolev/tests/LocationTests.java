package com.sobolev.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.sobolev.pages.AvitoMainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static io.qameta.allure.Allure.step;

@Description("LocationTests")
@Feature("LocationTests")
public class LocationTests extends TestBase {
    String selectedLocationName;
    SelenideElement selectedLocation;

    @Test
    @Tag("LocationTests")
    @DisplayName("Изменение локации поиска обьявлений при выборе из списка предложенных")
    @Severity(SeverityLevel.NORMAL)
    public void ChangeLocationWithSelectNameTest() {
        step("Открываем главную страницу", () -> {
            AvitoMainPage.openManePage();
        });
        step("Открываем окно выбора лоакции", () -> {
            avitoSearchForm.openLocationForm();
        });
        step("Очищаем форму с названием локации", () -> {
            locationComponent.clearButton.click();
        });
        step("Выбираем локацию из списка", () -> {
            sleep(1000);
            selectedLocation = locationComponent.getRandomLocation();
            selectedLocationName = locationComponent.getSelectedLocationName(selectedLocation);
            selectedLocation.click();
        });
        step("Кликаем на кнопку \"Показать объявления \"", () -> {
            locationComponent.clickSaveLocation();
        });
        step("Проверям что локация изменилась", () -> {
            avitoSearchForm.location.shouldHave(Condition.text(selectedLocationName));
        });
    }

    @Test
    @Tag("LocationTests")
    @DisplayName("Изменение локации поиска обьявлений при вводе названия в поле поиска локации")
    @Severity(SeverityLevel.NORMAL)
    public void ChangeLocationWithInputNameTest() {
        step("Открываем главную страницу", () -> {
            AvitoMainPage.openManePage();
        });
        step("Открываем окно выбора лоакции", () -> {
            avitoSearchForm.openLocationForm();
        });
        step("Очищаем форму с названием локации", () -> {
            locationComponent.clearButton.click();
        });
        step("Вводим название локации", () -> {
            selectedLocation = locationComponent.getRandomLocation();
            selectedLocationName = locationComponent.getSelectedLocationName(selectedLocation);
            locationComponent.locationFormInput.setValue("Москва");
            sleep(1000);
            locationComponent.locationFormInput.pressEnter();
        });
        step("Кликаем на кнопку \"Показать объявления \"", () -> {
            locationComponent.clickSaveLocation();
        });
        step("Проверям что локация изменилась", () -> {
            avitoSearchForm.location.shouldHave(Condition.text("Москва"));
        });
    }
}