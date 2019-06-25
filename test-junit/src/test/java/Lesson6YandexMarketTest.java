import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static helpers.DriverFactory.createNewDriver;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Lesson6YandexMarketTest {
    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;

    @Before
    public void setUp() {
        //String sysProp = System.getProperty("browser");
        String sysProp = "chrome";
        driver = createNewDriver(sysProp);
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
        //Открыть в Chrome сайт Яндекс.Маркет - раздел "Мобильные телефоны"
        driver.get("https://market.yandex.ru");
                //driver.manage().timeouts().implicitlyWait(4, SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10, 125);

        //driver.findElement(By.className("n-w-tab__control-hamburger")).click();
        wait.until(driver -> driver.findElements(By.className("n-w-tab__control-hamburger")).size() > 0);
        driver.findElement(By.className("n-w-tab__control-hamburger")).click();
        driver.findElement(By.className("n-w-tab__control-hamburger")).click();
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
