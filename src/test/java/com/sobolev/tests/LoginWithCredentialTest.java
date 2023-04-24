package com.sobolev.tests;

import com.sobolev.pages.components.LoginFormComponent;
import com.sobolev.pages.navigations.AvitoHeader;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.sobolev.pages.AvitoMainPage.URL;
import static com.sobolev.tests.TestData.login;
import static com.sobolev.tests.TestData.password;
import static io.qameta.allure.Allure.step;

public class LoginWithCredentialTest extends TestBase {

    AvitoHeader avitoHeader = new AvitoHeader();
    LoginFormComponent loginFormComponent = new LoginFormComponent();

    @Test
    @Tag("properties")
    @DisplayName("Проверка входа в аккаунт с валидным логином и паролем")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginWithCredentialsTest() {

        step("Открываем главную страницу", () -> {
            open(URL);
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
