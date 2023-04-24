package com.sobolev.pages.navigations;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class AvitoHeader {

    public SelenideElement profileIcon = $(byAttribute("data-marker", "header/username-button"));

    public void OpenLoginForm() {
        $(byAttribute("data-marker", "header/login-button")).click();
    }

    public void OpenFavoritesPage() {
        $(byAttribute("data-marker", "header/favorites")).click();
    }

    public void OpenProfilePage() {
        profileIcon.click();
    }
}
