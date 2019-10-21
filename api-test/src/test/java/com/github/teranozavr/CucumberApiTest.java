package com.github.teranozavr;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.util.Arrays;
import static com.github.teranozavr.log.HtmlReporter.*;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"html:target/cucumber/html", "json:target/cucumber/json/cucumber.json", "pretty"},
        monochrome = true,
        features = "src/test/resources/features/Auth.feature",
//        tags = "  @1.2",
        glue = {"com.github.teranozavr"}
)
public class CucumberApiTest {
    @BeforeClass
    public static void writeHeadHtml()throws Exception{
        copyTemplateToReport();
        writeTestResultTable(Arrays.asList("Тест", "Результат"));
    }
}


