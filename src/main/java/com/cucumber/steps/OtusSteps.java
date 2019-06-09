package com.cucumber.steps;

import com.cucumber.pages.OtusPage;
import com.utils.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class OtusSteps extends Step {

    @Autowired
    OtusPage otusPage;

    @When("^I open otus page$")
    public void shouldOpenOtusPage() throws Throwable{
        //otusPage.open();
    }

    @Then("^I should see page url \\\"https://otus.ru/\\\"$")
        public void shouldBeOtusPageURL() throws Throwable {
        //String otusPageURL = PropertiesReader.getInstance().getURLProperty("Otus.main.page");
        //String openedPageURL = otusPage.getUrl();
        //assertThat(otusPageURL, equalTo(openedPageURL));
    }

    @Given("Init Chrome Driver")
        public void initChromeDriver() throws Throwable {
        System.setProperty("webdriver.chrome.driver",PropertiesReader.getInstance().getURLProperty("browser.chrome"));
        WebDriver browser = new ChromeDriver();
        browser.get("https://www.saucelabs.com");
        //WebElement href = browser.findElement(By.xpath("//a[@href='/beta/login']"));
    }



}
