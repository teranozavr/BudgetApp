package com.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(tags = {},
        plugin = {"html:target/cucumber/html", "json:target/cucumber/json/cucumber.json", "pretty"},
        //format = {"pretty", "json:target/cucumber.json","html:target/cucumber.html"},
        features = {"src/main/java/com/features/"},
        glue = {"com.cucumber.teranozavr.Lesson15.pages",
                "com.cucumber.teranozavr.Lesson15.steps"}
)
public class CucumberRunner {

}
