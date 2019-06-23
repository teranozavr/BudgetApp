import helpers.ChromeDriverFactory;
import helpers.DriverFactory;
import helpers.FirefoxDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


/**
 * Created by alg_adm on 18.06.2019.
 */
public class TestLinkUITests {

    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static DriverFactory drFac;
    public static WebDriver driver;
    private Browser browserName;

    private void getParameter(String name) {
        String value = System.getProperty(name);
        if (value == null)
            throw new RuntimeException(name + " is not a parameter!");

        if (value.isEmpty())
            throw new RuntimeException(name + " is empty!");

        if(driver != null)
        {
            driver.quit();
        }

        System.out.println("*************************** value:"+value);
        System.out.println("*************************** lower case value:"+value.toLowerCase());

        switch (value.toLowerCase())
        {
            case("chrome"):
            {
                this.browserName=Browser.CHROME;
                break;
            }
            case("firefox"):
            {
                this.browserName=Browser.FIREFOX;
                break;
            }
            default:
                System.out.println("****************Browser name error: "+value);
        }
    }

    public enum Browser
    {
        CHROME, FIREFOX
    }

    @Before
    public void setUp() {
        getParameter("browser");
        switch (browserName) {
            case CHROME:
            {
                drFac = new ChromeDriverFactory();
                driver = drFac.createNewDriver();
                System.out.println("*****************************browser = Chrome");
                break;
            }
            case FIREFOX:
            {
                drFac = new FirefoxDriverFactory();
                driver = drFac.createNewDriver();
                System.out.println("*****************************browser = FireFox");
                break;
            }
        }
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
