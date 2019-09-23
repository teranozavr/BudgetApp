import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static helpers.Setuper.setupDriver;


/**
 * Created by alg_adm on 18.06.2019.
 */
public class TestLinkUITests {

    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;

    @Before
    public void setup() {
        driver=setupDriver();
    }

    @After
    public void tearDown() {
        if(driver != null)
        {
            driver.quit();
        }
    }

    @Test
    public void test10() throws Throwable
    {
        System.out.println("******************************Run test10");
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
