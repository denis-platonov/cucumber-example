package com.clutter.automation.pages;

import com.clutter.automation.Page;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LocationsPage extends Page {

    private static final String URL = "https://www.clutter.com/locations";
    private static final String PAGE_TITLE = "Clutter | LocationsPage";

    private SelenideElement zipField = $(By.name("zip"));
    private SelenideElement zipSearchButton = $(".zip-search-button");
    private SelenideElement mapMarker = $(".map-marker-launcher");
    private SelenideElement message = $("#map-form > div[style='display: block;']");
    private SelenideElement h2 = $("h2");

    @Override
    public void goTo(){
        open(URL);
        h2.waitUntil(Condition.appear, 5000);
    }

    @Override
    public boolean isOpened() {
        return title().equals(PAGE_TITLE);
    }

    public void search(int zipCode) {
        zipField.clear();
        zipField.setValue(String.valueOf(zipCode));
        zipSearchButton.click();
        h2.waitUntil(Condition.disappear, 5000);
    }

    public boolean getCheckButtonDisplayed() {
        return mapMarker.isDisplayed();
    }

    public String getMessage() {
        return message.getText();
    }

}