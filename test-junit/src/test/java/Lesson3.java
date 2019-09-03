import helpers.TestCaseElements;
import junit.framework.TestCase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.SystemClock;
import org.apache.logging.log4j.core.util.SystemNanoClock;
import org.jetbrains.annotations.NotNull;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
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
        Thread.sleep(5000);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
    public void CreateTests() throws Throwable
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
        for(int i=0; i<2; i++)
        {
            createTestcase(suiteName, "Тест кейс", 3);
        }
    }
    @Test
    public void runTestCases() throws Throwable{
        //открываем тестлинк и логинимся
        driver.get("http://localhost/testlink/index.php");
        driver.findElement(By.cssSelector("#tl_login")).sendKeys("admin");
        driver.findElement(By.cssSelector("#tl_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#login > div:nth-child(7) > input[type=submit]")).click();
        Thread.sleep(5000);
        //Открываем Execute Tests
        driver.switchTo().parentFrame().switchTo().frame(1);
        driver.findElement(By.linkText("Execute Tests")).click();
        Thread.sleep(5000);
        //Нажимаем Expand Tree
        driver.switchTo().parentFrame().switchTo().frame("mainframe").switchTo().frame("treeframe");
        driver.findElement(By.id("expand_tree")).click();
        //Коллекция тесткейсов
        //el.findElements(By.tagName("li"));
        Thread.sleep(5000);
        //WebElement el = driver.findElement(By.cssSelector("#ext-gen22"));
        //List<WebElement> els = el.findElements(By.cssSelector(" #ext-gen22 > li"));
        //x-tree-node-anchor
        //for(WebElement elem : els)
        //{
        //    System.out.println(elem.getText());
        //}

        driver.switchTo().parentFrame().switchTo().frame("treeframe");

        //Находим элемент - дерево с тестами
        WebElement el =
                //driver.findElement(By.className("x-panel-body x-panel-body-noheader"));
                driver.findElement(By.cssSelector("#ext-gen14"));
        //Получаем список тесткейсов из дерева тесткейсов
        //TestCaseElements tcElements = new TestCaseElements(el);
        //System.out.println(tcElements.getTestCases().size());
        List<WebElement> tcElements = new TestCaseElements(el).getTestCases();

        //Выбираем тест и кликаем на него
        if(tcElements.size()>0){
            System.out.println(tcElements.size());


            WebElement e0 = tcElements.get(1);
            e0.click();
            Actions action = new Actions(driver);
            action.moveToElement(e0).build().perform();
            action.sendKeys(Keys.ENTER);

            for (WebElement e: tcElements)
            {
                driver.switchTo().parentFrame().switchTo().frame("treeframe");
                System.out.println(e.hashCode());

                e.findElement(By.id("li")).click();
                Thread.sleep(1000);
                //Получаем цвет заголовка
                driver.switchTo().parentFrame();
                el = driver.switchTo().frame("workframe").findElement(By.cssSelector("#execution_history > div.passed"));
                String elColor = el.getCssValue("background");
                boolean isGreen = elColor.contains("rgb(0, 100, 0)");
                System.out.println(elColor);
                Assert.assertTrue(isGreen);
                driver.findElement(By.linkText("Execute Tests")).click();

                //Проверяем, что цвет заголовка зеленый
          //      Point c = tcElements.get(0).getLocation();
     //           Actions action = new Actions(driver);
      //          action.moveToElement(tcElements.get(0), c.getX(), c.getY()).click().build().perform();

                WebElement eDebud = tcElements.get(0);//driver.findElement(By.cssSelector("#ext-gen14"));
                Point c = eDebud.getLocation();
                Coordinates coord;
//coord.

                //Actions action = new Actions(driver);
                //action.moveToElement(eDebud).click().build().perform();// moveToElement( eDebud, c.getX(), c.getY()).click().build().perform();


            }

        }

    }
}
