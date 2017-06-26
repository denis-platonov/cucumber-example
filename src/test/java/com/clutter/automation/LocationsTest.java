package com.clutter.automation;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(Cucumber.class)
@CucumberOptions(format = {"pretty", "html:target/cucumber"})

public class LocationsTest{

    private static final String USERNAME = "test13342";
    private static final String AUTOMATE_KEY = "jtZSbTtY7mQhQBKzjtCs";
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    private static WebDriver driver;

    @BeforeClass
    public static void setup() throws MalformedURLException {
        setDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    static void setDriver() throws MalformedURLException {
        String env = System.getProperty("env");
        if(env != null){
            setRemoteDriver();
        }
        else {
            setLocalDriver();
        }
    }

    static void setLocalDriver() throws MalformedURLException {
        driver = new ChromeDriver();
    }

    static void setRemoteDriver() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("device", "iPad Air 2");
        caps.setCapability("browser", "iPad");
        caps.setCapability("os", "ios");
        caps.setCapability("browserstack.debug", "true");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }
}
