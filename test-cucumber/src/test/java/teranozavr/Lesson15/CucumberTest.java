package teranozavr.Lesson15;

import cucumber.api.CucumberOptions;
import cucumber.api.java.BeforeStep;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/cucumber/html", "json:target/cucumber/json/cucumber.json", "pretty"},
        monochrome = true,
        features = "src/test/resources/features/Lesson15/GosUslugi.feature",
        glue = {"teranozavr.Lesson15"}
)
public class CucumberTest {

}



