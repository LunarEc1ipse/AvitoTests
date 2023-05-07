package com.sobolev.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class AvitoProductPage {

    public SelenideElement productTitle =
            $(byAttribute("data-marker", "item-view/title-info"));

}
