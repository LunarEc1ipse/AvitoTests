package com.sobolev.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selenide.$;

public class StoryModalComponent {

    public SelenideElement storyModal = $(byAttribute("data-marker", "stories-viewer/block-preview"));
}
