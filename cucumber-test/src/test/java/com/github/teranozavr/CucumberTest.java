package com.github.teranozavr;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber/html", "json:target/cucumber/json/cucumber.json", "pretty"},
        monochrome = true,
        features = "src/test/resources/features/BudgetApp/",
        glue = {"com.github.teranozavr"},
        tags = "@3"
)
public class CucumberTest {

}



