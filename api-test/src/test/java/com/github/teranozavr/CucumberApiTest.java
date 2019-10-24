package com.github.teranozavr;

import com.github.teranozavr.helpers.TestData;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.Arrays;
import static com.github.teranozavr.log.HtmlReporter.*;



@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber/html", "json:target/cucumber/json/cucumber.json", "pretty"},
        monochrome = true,
        features = "src/test/resources/features/UserData.feature",
        tags = " @2.1",
        glue = {"com.github.teranozavr"}
)


public class CucumberApiTest {
    @BeforeClass
    public static void writeHeadHtml()throws Exception{
        copyTemplateToReport();
        writeTestResultTable(Arrays.asList("Тест", "Результат"));


    }
}


