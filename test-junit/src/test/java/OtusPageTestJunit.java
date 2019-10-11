/**
 * Created by Admin on 08.06.2019.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static teranozavr.helpers.Setuper.setupDriver;


public class OtusPageTestJunit {
    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger(FirstTest.class);

    @Before
    public void setup() {
        driver=setupDriver();
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
