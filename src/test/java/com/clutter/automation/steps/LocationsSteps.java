package com.clutter.automation.steps;

import com.clutter.automation.pages.LocationsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LocationsSteps {

    private LocationsPage locationsPage;

    @Given("^user is on Locations page$")
    public void userIsOnLocationsPage() throws Throwable {
        locationsPage = new LocationsPage();
        locationsPage.goTo();
    }

    @When("^user searches for a location using (\\d+) zip code$")
    public void userSearchesForALocationUsingZipCode(int zipCode) throws Throwable {
        locationsPage.search(zipCode);
    }

    @Then("^message matches with (.*)$")
    public void messageMatchesWithExpectedResult(String expectedMessage) throws Throwable {
        Assert.assertEquals("Message doesn't match", expectedMessage, locationsPage.getMessage().replace("\n", " "));
    }

    @And("^Check Pricing button should be displayed: (true|false)$")
    public void checkPricingButtonShouldBeDisplayedPricingButtonDisplayed(boolean pricingButtonDisplayed) throws Throwable {
        Assert.assertEquals("Pricing button is displayed", pricingButtonDisplayed, locationsPage.getCheckButtonDisplayed());
    }
}
