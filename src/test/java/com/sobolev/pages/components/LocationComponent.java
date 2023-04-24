package com.sobolev.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LocationComponent {
    SelenideElement location = $(byAttribute("data-marker", "search-form/change-location"));

    public void openLocationForm() {
        location.click();
    }
}
