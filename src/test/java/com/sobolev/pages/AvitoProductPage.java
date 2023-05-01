package com.sobolev.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AvitoProductPage {

    public SelenideElement productTitle =
            $(byAttribute("data-marker", "item-view/title-info"));
    public void closeWindowAndReturnToMainWindow(){
        Selenide.closeWindow();
        switchTo().window(0);
    }
}
