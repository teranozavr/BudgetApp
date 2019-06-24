import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.SystemClock;
import org.apache.logging.log4j.core.util.SystemNanoClock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import static helpers.DriverFactory.createNewDriver;

/**
 * Created by alg_adm on 25.06.2019.
 */
public class Lesson3 {

    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("browser","chrome");
        String sysProp = System.getProperty("browser");
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
        //открываем тестлинк и логинимся
        driver.get("http://localhost/testlink/index.php");
        driver.findElement(By.cssSelector("#tl_login")).sendKeys("admin");
        driver.findElement(By.cssSelector("#tl_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#login > div:nth-child(7) > input[type=submit]")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("/html/body/div[2]/div[4]/a[1]")).click();
        driver.findElement(By.xpath("/html/body/div/img")).click();
        driver.findElement(By.xpath("//*[@id=\"new_testsuite\"]")).click();
        //Заполняем поля
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Test suits "+ Timestamp.valueOf(LocalDateTime.now()).toString());
        driver.findElement(By.xpath("/html/body/p")).sendKeys(Timestamp.valueOf(LocalDateTime.now()).toString());
    }
}
