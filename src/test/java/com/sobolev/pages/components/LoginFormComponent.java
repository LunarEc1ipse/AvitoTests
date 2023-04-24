package com.sobolev.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LoginFormComponent {
    public SelenideElement loginForm = $(byAttribute("data-marker", "auth-app-root"));

    public void inputLogin(String login) {
        $(byAttribute("data-marker", "login-form/login/input")).setValue(login);
    }

    public void inputPassword(String password) {
        $(byAttribute("data-marker", "login-form/password/input")).setValue(password);
    }

    public void clickSignIn() {
        $(byAttribute("data-marker", "login-form/submit")).click();
    }

    public void chooseRememberPassword() {
        $(byAttribute("data-marker", "login-form/remember/toggle")).click();
    }

    public void openRestorePasswordPage() {
        $(byAttribute("data-marker", "login-form/restore")).click();
    }

    public void openRegistrationFrom() {
        $(byAttribute("data-marker", "registration-link")).click();
    }
}
