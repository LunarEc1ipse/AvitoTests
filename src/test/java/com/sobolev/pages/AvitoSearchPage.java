package com.sobolev.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AvitoSearchPage {

    public SelenideElement searchPageTitle = $(byAttribute("data-marker", "page-title/text"));
    public ElementsCollection searchResult = $$(byAttribute("data-marker", "item"));

    public String getFirstSearchElementTitle(ElementsCollection searchResult) {
        return searchResult.first()
                .$(byAttribute("data-marker", "item-title"))
                .$(byAttribute("itemprop", "name")).getText();
    }
}