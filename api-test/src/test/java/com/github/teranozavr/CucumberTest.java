package ru.sber.cucumberTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.util.Arrays;
import static ru.sber.cucumberTest.log.HtmlReporter.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features")
public class CucumberTest {
    @BeforeClass
    public static void writeHeadHtml()throws Exception{
        copyTemplateToReport();
        writeTestResultTable(Arrays.asList("Тест", "RqUID", "Результат"));
    }
}


