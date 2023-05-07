package com.sobolev.tests;

import com.sobolev.pages.AvitoMainPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import jdk.jfr.Description;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.sobolev.tests.TestData.login;
import static com.sobolev.tests.TestData.password;
import static io.qameta.allure.Allure.step;

@Description("LoginTests")
@Feature("MainPageTests")
public class LoginTests extends TestBase {

    @Test
    @Disabled
    @Tag("LoginTests")
    @DisplayName("Проверка входа в аккаунт с валидным логином и паролем")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginWithCredentialsTest() {
        step("Открываем главную страницу", () -> {
            AvitoMainPage.openManePage();
        });
        step("Открываем логин форму", () -> {
            avitoHeader.OpenLoginForm();
        });
        step("Вводим логин", () -> {
            loginFormComponent.inputLogin(login);
        });
        step("Вводим пароль", () -> {
            loginFormComponent.inputPassword(password);
        });
        step("Нажимаем кнопку 'Войти'", () -> {
            loginFormComponent.clickSignIn();
        });
        step("Проверям что форма логина закрылась", () -> {
            loginFormComponent.loginForm.shouldBe(disappear);
        });
        step("Проверяем что иконка пользователя присуствует на странице", () -> {
            avitoHeader.profileIcon.shouldBe(visible);
        });
    }
}
