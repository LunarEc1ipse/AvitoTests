package com.sobolev.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$$;

public class AvitoMainPage {

    public ElementsCollection recommendItems =
            $$(byAttribute("data-marker", "bx-recommendations-block-item"));
    public ElementsCollection storyItems =
            $$(byAttribute("data-marker", "story-previewer/block-preview"));
    public static String URL = "https://www.avito.ru/";

    public String getFirstRecommendElementTitle(ElementsCollection recommendItems) {
        return recommendItems.first()
                .$(byAttribute("data-marker", "title"))
                .$(byAttribute("itemprop", "name")).getText();
    }
}