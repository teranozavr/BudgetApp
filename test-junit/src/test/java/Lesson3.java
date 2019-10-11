import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static teranozavr.helpers.Colors.verifyColor;
import static teranozavr.helpers.WebElementWaiter.waitAndClick;
/**
 * Created by alg_adm on 25.06.2019.
 */
public class Lesson3 {

    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;
    @Before


    public void createTestcase(String suiteName, String name, int stepsCount) throws Exception
    {
        Thread.sleep(5000);
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

    @After
    public void tearDown() {
        if(driver != null)
        {
            driver.quit();
        }
    }

    @Test
    public void createTestCases() throws Throwable
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
    public void testProjectManagement() throws Throwable {
        //открываем тестлинк и логинимся
        String name = "My project "+System.currentTimeMillis();
        String prefix = "MP"+System.currentTimeMillis();
        String description = "Это мой первый проект"+System.currentTimeMillis();

        driver.get("http://localhost/testlink/index.php");
        driver.findElement(By.cssSelector("#tl_login")).sendKeys("admin");
        driver.findElement(By.cssSelector("#tl_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#login > div:nth-child(7) > input[type=submit]")).click();
        Thread.sleep(1000);
        driver.switchTo().parentFrame().switchTo().frame("mainframe");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/a[1]")).click();
        Thread.sleep(1000);
        driver.switchTo().parentFrame().switchTo().frame("mainframe");
        driver.findElement(By.id("create")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr[2]/td[2]/input")).click();
        new Actions(driver).sendKeys(name).perform();
        driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr[3]/td[2]/input")).click();
        new Actions(driver).sendKeys(prefix).perform();
        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe")).click();
        new Actions(driver).sendKeys(description).perform();
        driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr[17]/td/div/input[3]")).click();
        Thread.sleep(5000);

        WebElement table = driver.findElement(By.xpath("//*[@id=\"item_view\"]"));
        List<WebElement> aList = table.findElements(By.tagName("a"));
        WebElement project = null;
        for (WebElement a: aList
                ) {
            if(a.getText().equals(name)) project = a;
        }

        String xPathOfProject = getElementXPath(driver, project);
        String tr = xPathOfProject.substring(28,29);
        Assert.assertTrue(project.getText().equals(name));
        WebElement projectDescription = driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr["+tr+"]/td[2]/p"));
        Assert.assertTrue(projectDescription.getText().equals(description));
        WebElement projectStatus = driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr["+tr+"]/td[8]/img"));
        Assert.assertTrue(projectStatus.getAttribute("Title").equals("Public"));
    }

    @Test
    public void addTestCases() throws Throwable {
        //открываем тестлинк и логинимся
        driver.get("http://localhost/testlink/index.php");
        driver.findElement(By.cssSelector("#tl_login")).sendKeys("admin");
        driver.findElement(By.cssSelector("#tl_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#login > div:nth-child(7) > input[type=submit]")).click();
        Thread.sleep(5000);
        driver.switchTo().parentFrame().switchTo().frame("mainframe");
        driver.findElement(By.linkText("Add / Remove Test Cases")).click();

        //Нажимаем Expand Tree
        driver.switchTo().parentFrame().switchTo().frame("mainframe").switchTo().frame("treeframe");
        driver.findElement(By.id("expand_tree")).click();
        //Коллекция тесткейсов
        Thread.sleep(5000);
        driver.switchTo().parentFrame().switchTo().frame("treeframe");

        //Находим элемент - дерево с тессетами
        WebElement el = driver.findElement(By.cssSelector("#ext-gen14"));

        List<WebElement> a = el.findElements(By.tagName("a"));
        List<WebElement> tcElements = new ArrayList<>();
        for (WebElement a1 : a
                ) {
            if (a1.getAttribute("href").contains("javascript:ETS")) tcElements.add(a1);
        }

        //Выбираем тестсет и кликаем на него
        if (tcElements.size() > 0) {
            System.out.println(tcElements.size());

            for (int i=0; i< tcElements.size(); i++) {

                driver.switchTo().parentFrame().switchTo().frame("treeframe");
                waitAndClick(findTestSuitesByOrderNumber(i));

                driver.switchTo().parentFrame();
                driver.switchTo().frame("workframe");

                //Добавляем тестсеты в тестран
                driver.findElement(By.xpath("//*[@id=\"header-wrap\"]/div[2]/div/button[1]")).click();
                driver.findElement(By.xpath("//*[@id=\"header-wrap\"]/div[2]/input[2]")).click();
                Thread.sleep(5000);
            }
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
        Thread.sleep(5000);
        driver.switchTo().parentFrame().switchTo().frame("treeframe");

        //Находим элемент - дерево с тестами
        WebElement el =
                driver.findElement(By.cssSelector("#ext-gen14"));
        //Получаем список тесткейсов из дерева тесткейсов
        List<WebElement> a = el.findElements(By.tagName("a"));
        List<WebElement> tcElements = new ArrayList<>();
        for (WebElement a1: a
                ) {
            if (a1.getAttribute("href").contains("javascript:ST")) tcElements.add(a1);
        }

        //Выбираем тест и кликаем на него
        if(tcElements.size()>0){
            System.out.println(tcElements.size());

            for (int i=0; i<tcElements.size(); i++)// e: tcElements)
            {
                boolean isBlack = false;
                WebElement testCase = findTestCaseByOrderNumber(i);
                //if(testCase!=null) tcName = testCase.getText();
                //Выбрать любой тест, кликнуть на него
                driver.switchTo().parentFrame().switchTo().frame("treeframe");
                waitAndClick(testCase);

                //Получаем цвет заголовка
                driver.switchTo().parentFrame();
                driver.switchTo().frame("workframe");
                try {
                    el = driver.findElement(By.xpath("//*[@id=\"execution_history\"]/div[2]"));
                    if (el!=null) {
                        String elColor = el.getCssValue("background");
                        isBlack = verifyColor(elColor, "black");
                    }
                    else System.out.println("el is NULL");
                }
                catch (RuntimeException ex){};

                if(isBlack)
                {
                    System.out.println("Проставить \"Пройден\" во всех шагах");
                    //Проставить "Пройден" во всех шагах
                    driver.switchTo().parentFrame();
                    driver.switchTo().frame("workframe");
                    List<WebElement> statusList = driver.findElements(By.className("step_status"));
                    changeStatus(statusList, "passed");

                    //Нажать на "passed"
                    System.out.println("Нажать на \"passed\"");
                    WebElement resultBox = driver.findElement(By.xpath("//*[@id=\"execSetResults\"]/div[10]/table[1]/tbody/tr/td[2]/div[2]"));
                    setTestResult(resultBox, "passed");

                    //Проверить что цвет в заголовке теста поменялся на зеленый
                    System.out.println("Проверить что цвет в заголовке теста поменялся на зеленый");
                    WebElement exHist = driver.findElement(By.xpath("//*[@id=\"execution_history\"]"));
                    String background = exHist.findElement(By.className("passed")).getCssValue("background");
                    Assert.assertTrue(verifyColor(background, "green"));

                    //Проверить что цвет в дереве тестов поменялся на зеленый
                    driver.switchTo().parentFrame().switchTo().frame("treeframe");
                    WebElement currentTestCaseInTree = findTestCaseByOrderNumber(i);
                    String testColor = currentTestCaseInTree.findElement(By.tagName("span")).findElement(By.tagName("span")).getCssValue("background-color");
                    Assert.assertTrue(verifyColor(testColor, "lightGreen"))          ;
                    System.out.println("lightGreen");

                    //"Провалить" тест
                    System.out.println("\"Провалить\" тест");
                    driver.switchTo().parentFrame();
                    driver.switchTo().frame("workframe");
                    statusList = driver.findElements(By.className("step_status"));
                    changeStatus(statusList, "failed");
                    resultBox = driver.findElement(By.xpath("//*[@id=\"execSetResults\"]/div[10]/table[1]/tbody/tr/td[2]/div[2]"));
                    setTestResult(resultBox, "failed");

                    //9, 10 Проверить что цвет стал красным
                    System.out.println("\"Провалить\" тест");

                    //Проверить что цвет в заголовке теста поменялся на зеленый
                    System.out.println("Проверить что цвет в заголовке теста поменялся на красный");
                    exHist = driver.findElement(By.xpath("//*[@id=\"execution_history\"]"));
                    background = exHist.findElement(By.className("failed")).getCssValue("background");
                    Assert.assertTrue(verifyColor(background, "red"));

                    //Проверить что цвет в дереве тестов поменялся на красный
                    driver.switchTo().parentFrame().switchTo().frame("treeframe");
                    currentTestCaseInTree = findTestCaseByOrderNumber(i);
                    testColor = currentTestCaseInTree.findElement(By.tagName("span")).findElement(By.tagName("span")).getCssValue("background-color");
                    Assert.assertTrue(verifyColor(testColor, "lightRed"))          ;
                    System.out.println("lightGreen");

                }
            }
        }
    }

    public String getElementXPath(WebDriver driver, WebElement element) {
        return (String)((JavascriptExecutor)driver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
    }

    private void changeStatus(List<WebElement> statusList, String status){
        for (WebElement e1: statusList
                ) {
            //Просставляем статусы Passed
            Actions action = new Actions(driver);
            action.moveToElement(e1).build().perform();
            action.clickAndHold(e1).build().perform();
            switch (status.toLowerCase()){
                case("passed"): {
                    action.sendKeys(Keys.ARROW_DOWN).build().perform();
                    break;
                }
                case("failed"):{
                    action.sendKeys(Keys.ARROW_DOWN).build().perform();
                    action.sendKeys(Keys.ARROW_DOWN).build().perform();
                    break;
                }
            }

        }
    }

    private static void setTestResult(WebElement resultBox, String status)
    {
        List<WebElement> resultBoxElements = resultBox.findElements(By.tagName("img"));

        switch(status.toLowerCase()){
            case("passed"):{
                clickToElementWithTag(resultBoxElements, "Click to set to passed");
                break;
            }
            case("failed"): {
                clickToElementWithTag(resultBoxElements, "Click to set to failed");
                break;
            }
            case("blocked"): {
                clickToElementWithTag(resultBoxElements, "Click to set to blocked");
                break;
            }
        }
    }

    private static void clickToElementWithTag(List<WebElement> resultBoxElements, String tag)
    {
        for (WebElement el: resultBoxElements
                ) {
                    try{
                        if(el.getAttribute("title").equals(tag)){
                            el.click();
                        }
                    }
                    catch (RuntimeException ex) {
                        System.out.println("У элемента нет title");
                    }
        }
    }

    private static WebElement findTestCaseByOrderNumber(int number)
    {
        return findTreeSetElementsByOrderNumber(number,"javascript:ST");
    }

    private static WebElement findTestSuitesByOrderNumber(int number)
    {
        return findTreeSetElementsByOrderNumber(number,"javascript:ETS");
    }

    private static WebElement findTreeSetElementsByOrderNumber(int number, String attribute){
        driver.switchTo().parentFrame();

        driver.switchTo().frame("treeframe");
        //Находим элемент - дерево с тестами
        WebElement el = driver.findElement(By.cssSelector("#ext-gen14"));
        //Получаем список тесткейсов из дерева тесткейсов
        List<WebElement> a = el.findElements(By.tagName("a"));
        List<WebElement> tcElements = new ArrayList<>();
        for (WebElement a1: a
                ) {
            if (a1.getAttribute("href").contains(attribute)) tcElements.add(a1);
        }

        //Выбираем тест и кликаем на него
        if(tcElements.size()>0) {
            System.out.println(tcElements.size());
            return tcElements.get(number);
        }
        System.out.println("Тесткейс не найден!");
        return null;
    }

}





