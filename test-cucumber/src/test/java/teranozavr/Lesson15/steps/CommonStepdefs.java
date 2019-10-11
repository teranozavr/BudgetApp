package teranozavr.Lesson15.steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import teranozavr.Lesson15.config.Config;


@ContextConfiguration(classes = Config.class)
public class CommonStepdefs {
    @Autowired
    WebDriver webDriver;

    @Before
    public void before() {
    }

    @After
    public void after() {
        webDriver.manage().deleteAllCookies();
    }
}
