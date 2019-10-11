package com.cucumber.steps;

import com.cucumber.pages.OtusPage;


//import com.utils.PropertiesReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.openqa.selenium.chrome.ChromeDriver;


public class OtusSteps {

    @Autowired
    OtusPage otusPage;

    @When("^I open otus page$")
    public void shouldOpenOtusPage() throws Throwable{
        otusPage.open();
    }

    @Then("^I should see page url \\\"https://otus.ru/\\\"$")
        public void shouldBeOtusPageURL() throws Throwable {
        System.out.println("todo");
        //String otusPageURL = PropertiesReader.getInstance().getURLProperty("Otus.main.page");
        //String openedPageURL = otusPage.getUrl();
        //assertThat(otusPageURL, equalTo(openedPageURL));
    }
}
