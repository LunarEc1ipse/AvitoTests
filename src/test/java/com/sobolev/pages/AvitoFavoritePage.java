package com.sobolev.pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class AvitoFavoritePage {

    public void findFavoriteElementByTitle(String elementTitle) {
        $("p").shouldHave(Condition.text(elementTitle));
    }
}
