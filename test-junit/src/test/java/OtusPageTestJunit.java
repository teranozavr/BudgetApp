/**
 * Created by Admin on 08.06.2019.
 */

import helpers.options.FirefoxOpt;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import static helpers.DriverFactory.createNewDriver;
import static helpers.options.FirefoxOpt.FirefoxOpt;
import static helpers.options.ChromeOpt.ChromeOpt;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static helpers.browserPropetry.browserPropetry;


public class OtusPageTestJunit {
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger(FirstTest.class);

    @Before
    public void setup(){

        //System.setProperty("browser","chrome");
        switch (browserPropetry()) {
            case (CHROME): {
                ChromeOptions opt = ChromeOpt();
                driver = createNewDriver(CHROME, opt);
                return;
            }
            case (FIREFOX):{
                FirefoxOptions opt = FirefoxOpt();
                driver = createNewDriver(FIREFOX, opt);
                return;
            }
            default: {
                System.out.println("Wrong browser name");
            }
        }

    }

    @After
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    public void checkURLTest() throws Throwable{
        driver.get("https://otus.ru");
        Thread.sleep(10000);
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://otus.ru/");
            logger.info("checkURLTest - Passed");
        }
        catch (AssertionError ae)
        {
            logger.error("checkURLTest - Failed");
            throw new Exception();
        }
    }
}
