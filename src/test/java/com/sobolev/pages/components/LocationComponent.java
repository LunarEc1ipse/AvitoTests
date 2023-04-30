package com.sobolev.pages.components;

import com.codeborne.selenide.SelenideElement;

import java.util.Random;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class LocationComponent {

    public SelenideElement clearButton = $(byAttribute("data-marker", "clear-icon"));
    public SelenideElement locationFormInput =
            $(byAttribute("data-marker", "popup-location/region/input"));

//    public ElementsCollection locationList =
//            $(byAttribute("data-marker", "suggest-list")).$$("li");

    public String getSelectedLocationName(SelenideElement location) {
        return location.getText();
    }

    public void clickSaveLocation() {
        $(byAttribute("data-marker", "popup-location/save-button")).click();
    }

    //    public SelenideElement getRandomLocation (){
//        return locationList.get(new Random().nextInt(locationList.size()));
//    }
    public SelenideElement getRandomLocation() {
        String selector = "suggest(" + (new Random().nextInt(10) + ")");
        return $(byAttribute("data-marker", selector));
    }


}
