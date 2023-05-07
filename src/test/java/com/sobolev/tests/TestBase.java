package com.sobolev.tests;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.sobolev.helpers.Attach;
import com.sobolev.pages.AvitoFavoritePage;
import com.sobolev.pages.AvitoMainPage;
import com.sobolev.pages.AvitoProductPage;
import com.sobolev.pages.AvitoSearchPage;
import com.sobolev.pages.components.LocationComponent;
import com.sobolev.pages.components.LoginFormComponent;
import com.sobolev.pages.components.StoryModalComponent;
import com.sobolev.pages.navigations.AvitoHeader;
import com.sobolev.pages.navigations.AvitoSearchForm;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.switchTo;


public class TestBase {

    AvitoSearchForm avitoSearchForm = new AvitoSearchForm();
    LocationComponent locationComponent = new LocationComponent();
    AvitoHeader avitoHeader = new AvitoHeader();
    LoginFormComponent loginFormComponent = new LoginFormComponent();
    AvitoMainPage avitoMainPage = new AvitoMainPage();
    AvitoFavoritePage avitoFavoritePage = new AvitoFavoritePage();
    AvitoProductPage avitoProductPage = new AvitoProductPage();
    StoryModalComponent storyModalComponent = new StoryModalComponent();
    AvitoSearchPage avitoSearchPage = new AvitoSearchPage();

    @BeforeAll
    static void setup() {
        String browser = System.getProperty("browser");
        String browserSize = System.getProperty("browserSize");
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        Configuration.remote = URL;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.browser = browser;
        Configuration.browserSize = browserSize;
    }

    @AfterEach
    public void tearDown() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    public void switchWindow(int index) {
        switchTo().window(index);
    }

    public void closeWindowAndReturnToMainWindow() {
        Selenide.closeWindow();
        switchTo().window(0);
    }
}
