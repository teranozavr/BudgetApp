import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.SystemClock;
import org.apache.logging.log4j.core.util.SystemNanoClock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static helpers.DriverFactory.createNewDriver;

/**
 * Created by alg_adm on 25.06.2019.
 */
public class Lesson3 {

    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;

    public void createTestcase(String suiteName, String name, int stepsCount) throws Exception
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Переключаемся на treeframe
        driver.switchTo().parentFrame().switchTo().frame("treeframe");

        List<WebElement> treeNodes = driver.findElements(By.className("x-tree-node-anchor"));

        WebElement el;
        for(WebElement e : treeNodes) {
            String treeNodeText = e.findElement(By.tagName("span")).getText();
            if (treeNodeText.contains(suiteName)) {
                el = e;
                e.click();
                System.out.println(treeNodes);
            }
        }

        //Переключаемся на workFrame
        driver.switchTo().parentFrame();
        driver.switchTo().frame("workframe");

        //Нажимаем Actions
        driver.findElement(By.cssSelector("body > div > img:nth-child(2)")).click();
        //Нажимаем создать тест кейс
        driver.findElement(By.name("create_tc")).click();
        //driver.findElement(By.className("x-tree-node-anchor")).findElement(By.tagName("span")).getText()
        //Ждем
        Thread.sleep(5000);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("workframe");
        List<WebElement> formElements = driver.findElements(By.tagName("iframe"));
        formElements.get(0).click();
        new Actions(driver).sendKeys("Summary").perform();

        //Вводим имя теста
        String testCaseName = name+" "+LocalDateTime.now().getHour()+"-"+LocalDateTime.now().getMinute()+"-"+LocalDateTime.now().getSecond();
        driver.findElement(By.xpath("//*[@id=\"testcase_name\"]")).sendKeys(testCaseName);
        //Устанавливаем курсор в Preconditions
        driver.findElement(By.xpath("/html/body")).click();
        new Actions(driver).sendKeys("Preconditions").perform();
        //Заполняем Duration
        driver.findElement(By.cssSelector("#estimated_execution_duration")).sendKeys("10");
        //Нажимаем Save
        driver.findElement(By.xpath("//*[@id=\"do_create_button_2\"]")).click();
        //Ждем
        Thread.sleep(10000);

        //WebDriverWait wait = new WebDriverWait(driver, 20, 150);
        //WebElement createStepButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"stepsControls\"]/div/input")));
        //Нажимаем Create Step
        driver.findElement(By.xpath("//*[@id=\"stepsControls\"]/div/input")).click();

        for(int i=1; i<=stepsCount;i++) {
            //Ждем
            Thread.sleep(10000);
            //Получаем список эдементов iframe
            List<WebElement> formElements2 = driver.findElements(By.tagName("iframe"));
            //Устанавливаем курсор в Step actions
            formElements2.get(0).click();
            //Вводим текст
            new Actions(driver).sendKeys("Действия на шаге "+i).perform();
            //Устанавливаем курсор в Expected Results
            formElements2.get(1).click();
            //Вводим текст
            new Actions(driver).sendKeys("Ожидаемый результат на шаге "+i).perform();
            //Нажимаем Save
            driver.findElement(By.cssSelector("#do_update_step")).click();
        }
        //Жмем Save и выходим
        driver.findElement(By.cssSelector("#do_update_step_and_exit")).click();
    }

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
        Thread.sleep(5000);

        driver.switchTo().parentFrame().switchTo().frame(1);
        driver.findElement(By.linkText("Test Specification")).click();
        //Переключаемся на workFrame
        driver.switchTo().parentFrame().switchTo().frame("mainframe").switchTo().frame("workframe");
        //Нажимаем Actions
        driver.findElement(By.cssSelector("body > div > img")).click();
        //Нажимаем Create
        driver.findElement(By.cssSelector("#new_testsuite")).click();
        //Пишем название тест сьюта
        String suiteName = "TestSuite "+ LocalDateTime.now().getHour()+"-"+LocalDateTime.now().getMinute()+"-"+LocalDateTime.now().getSecond();
        driver.findElement(By.cssSelector("#name")).sendKeys(suiteName);
        //Заполняем остальные поля
        driver.findElement(By.cssSelector("body")).click();
        new Actions(driver).sendKeys("трололо").perform();
        Thread.sleep(5000);
        //Сохраняем тест сьют
        driver.switchTo().parentFrame().switchTo().frame("workframe").findElement(By.name("add_testsuite_button")).click();
        //Создаем тесткейсы:
        createTestcase(suiteName, "Тест кейс", 3);
    }
}
