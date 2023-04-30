package com.sobolev.pages.navigations;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AvitoSearchForm {

    public  SelenideElement location = $(byAttribute("data-marker", "search-form/change-location"));
    SelenideElement searchField = $(byAttribute("data-marker", "search-form/suggest"));
    SelenideElement searchButton = $(byAttribute("data-marker", "search-form/submit-button"));
    ElementsCollection searchItems = $$(byAttribute("data-marker", "suggest/list/item"));


    public void openLocationForm() {
        location.click();
    }

    public void fillSearchField(String searchValue) {
        searchField.setValue(searchValue);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public void clickOnSearchItem(String searchItemName) {
        searchItems.findBy(Condition.exactText(searchItemName)).click();
    }
}
