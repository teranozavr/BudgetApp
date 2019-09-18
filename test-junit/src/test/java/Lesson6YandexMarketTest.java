import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.*;
import static helpers.DriverFactory.createNewDriver;
import static helpers.browserPropetry.browserPropetry;
import static helpers.options.ChromeOpt.ChromeOpt;
import static helpers.options.FirefoxOpt.FirefoxOpt;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static helpers.WebElementWaiter.*;

public class Lesson6YandexMarketTest {
    private static final Logger logger = LogManager.getLogger(Lesson6YandexMarketTest.class);
    public static WebDriver driver;

    @Before
    public void setup() {

        System.setProperty("browser", "chrome");
        switch (browserPropetry()) {
            case (CHROME): {
                ChromeOptions opt = ChromeOpt();
                driver = createNewDriver(CHROME, opt);
                WebElementWaiter(driver, 6000, 10);
                return;
            }
            case (FIREFOX): {
                FirefoxOptions opt = FirefoxOpt();
                driver = createNewDriver(FIREFOX, opt);
                WebElementWaiter(driver, 10, 2);
                return;
            }
            default: {
                System.out.println("Wrong browser name");
            }
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void test10() throws Throwable {
        System.out.println("******************************Run test10");
        logger.info("Открыть в Chrome сайт Яндекс.Маркет - раздел \"Мобильные телефоны\"");
        //Открыть в Chrome сайт Яндекс.Маркет - раздел "Мобильные телефоны"
        driver.get("https://market.yandex.ru");

        //Нажимаем в Popup сообщении подтверждение выбора региона
        logger.info("Нажимаем в Popup сообщении подтверждение выбора региона");
        waitAndClick(By.cssSelector("body > div.popup2.popup2_autoclosable_yes.popup2_adaptive_yes.popup2_animate_yes.popup2_target_anchor.popup2_theme_normal.popup2_region_notification.i-bem.popup2_js_inited.popup2_direction_bottom-center.popup2_visible_yes > div.popup2__content > div > div > div.n-region-notification__actions.layout.layout_display_flex > div:nth-child(1) > span"));

        //Нажимаем "Все категории"
        logger.info("Нажимаем \"Все категории\"");
        waitAndClick(By.cssSelector("body > div.main > div > span > div.n-w-tabs.n-w-tabs_flex_row.b-zone.i-bem.n-w-tabs_js_inited.n-w-tabs_content-shown_no > noindex > div.n-w-tabs__horizontal-tabs-container > div > div > div.n-w-tabs__horizontal-tabs > div.n-w-tab.n-w-tab_interaction_click-navigation-menu.n-w-tab_type_navigation-menu-grouping.i-bem.n-w-tab_js_inited.n-w-tab_interaction-active_no > div"));
        //Нажимаем "Смартфоны"
        logger.info("Нажимаем \"Смартфоны\"");
        waitAndClick(By.cssSelector("body > div.main > div > span > div.n-w-tabs.n-w-tabs_flex_row.b-zone.i-bem.n-w-tabs_js_inited.n-w-tabs_content-shown_yes.b-zone_js_inited > noindex > div.n-w-tabs__horizontal-tabs-content > div > div > div > div > div > div > div.n-w-tabs__content-column > div > div.n-w-tab__content-container.n-w-tab__content-container_interaction_hover-navigation-menu.b-zone.b-spy-visible.i-bem.n-w-tab__content-container_uid_39889744.n-w-tab__content-container_js_inited.b-spy-visible_js_inited.n-w-tab__content-container_shown_yes.b-zone_js_inited > div > div > div:nth-child(1) > div > div > div:nth-child(1) > a:nth-child(2)"));

        //Отфильтровать список товаров по производителю: RedMi и Xiaomi
        logger.info("Отфильтровать список товаров по производителю: RedMi и Xiaomi");
        WebElement search = waitAndGetElement(By.id("search-prepack"));
        List<WebElement> elements = waitAndGetElements(search, By.tagName("span"));
        WebElement honor;
        WebElement xiaomi;

        WebElement sortMenu = waitAndGetElement(By.xpath("/html/body/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]"));
        for (WebElement el : elements) {
            if (el.getText().equals("Honor")) {
                honor = el;
                waitAndClick(honor);
                System.out.println(el.getText());
            }
            if (el.getText().equals("Xiaomi")) {
                xiaomi = el;
                waitAndClick(xiaomi);
                System.out.println(el.getText());
            }
        }
        //Отсортировать список товаров по цене (от меньшей к большей)
        logger.info("Отсортировать список товаров по цене (от меньшей к большей)");
        List<WebElement> sortElements;
        sortElements = waitAndGetElements(sortMenu, By.tagName("div"));

        for (WebElement el: sortElements
             ) {
            if (el.getText().equals("по цене"))
            waitAndClick(el);
        }

        //Контейнер, содержащий элементы
        //Ждем пока исзечнет бизи-индикатор
        waitWhileElementExist(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div/div[6]"));
        WebElement phonesContainer = waitAndGetElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[1]/div[2]/div/div[1]"));
        List<WebElement> divList = phonesContainer.findElements(By.tagName("div"));
        List<WebElement> phoneList = new ArrayList<>();

        //Выбираем элементы, относящиеся к телефонам
        logger.info("");
        for (WebElement e: divList ) {
            if(e.getAttribute("class").contains("n-snippet-cell")){
                phoneList.add(e);
            }
        }
        System.out.println("Найдено телефонов "+phoneList.size());

        //Добавить первый в списке Xiaomi
        logger.info("Добавить первый в списке Xiaomi");
        //Находим телефон Xiaomi
        xiaomi = findPhone(phoneList, "Xiaomi");

        WebElement xiaomiCompareTool = findCompareToolbar(xiaomi);
        Actions builder = new Actions(driver);
        builder.moveToElement(xiaomiCompareTool).build().perform();

        waitAndClick(xiaomiCompareTool);

        //Проверить, что отобразилась плашка "Товар {имя товара} добавлен к сравнению"
        logger.info("Проверить, что отобразилась плашка \"Товар {имя товара} добавлен к сравнению\"");
        WebElement comparePopup = waitAndGetElement(By.xpath("/html/body/div[5]"));
        Assert.assertTrue(comparePopup!=null);
        Assert.assertTrue(comparePopup.findElement(By.className("popup-informer__text")).getText().contains("Товар "+getPhoneName(xiaomi)+" добавлен к сравнению"));

        honor = findPhone(phoneList, "Honor");
        WebElement honorCompareTool = findCompareToolbar(honor);
        builder.moveToElement(honorCompareTool).build().perform();
        waitAndClick(honorCompareTool);

        //Проверить, что отобразилась плашка "Товар {имя товара} добавлен к сравнению"
        logger.info("Проверить, что отобразилась плашка \"Товар {имя товара} добавлен к сравнению\"");
        comparePopup = waitAndGetElement(By.xpath("/html/body/div[6]/div/div/div[2]/div[1]"));
        Assert.assertTrue(comparePopup!=null);
        Assert.assertTrue(comparePopup.getText().contains("Товар "+getPhoneName(honor)+" добавлен к сравнению"));

        //Перейти в раздел Сравнение
        logger.info("Перейти в раздел Сравнение");
        waitAndClick(By.xpath("/html/body/div[6]/div/div/div[3]/a"));
        //Проверить, что в списке товаров 2 позиции
        logger.info("Проверить, что в списке товаров 2 позиции");
        phoneList.clear();
        WebElement compareContainer = waitAndGetElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[4]/div/div/div"));
        phoneList = waitAndGetElements(compareContainer, By.className("n-compare-head__image"));
        Assert.assertEquals(phoneList.size(),2);
        System.out.println("Выбрано телефонов для сравнения: "+phoneList.size());

        //Нажать на опцию "все характеристики"
        logger.info("Нажать на опцию \"все характеристики\"");
        waitAndClick(By.xpath("/html/body/div[1]/div[5]/div[1]/div[2]/div[1]/span[3]/span"));

        //Проверить, что в списке характеристик появилась позиция "Операционная система"
        logger.info("Проверить, что в списке характеристик появилась позиция \"Операционная система\"");
        WebElement specificationList = waitAndGetElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[6]"));
        WebElement paramsContainer = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[6]"));//className("n-compare-group n-compare-group_state_opened"));
        List<WebElement> paramsList = paramsContainer.findElements(By.tagName("div"));
        for (WebElement e: paramsList) {
            if (e.getText().contains("ОПЕРАЦИОННАЯ СИСТЕМА")) {
            Assert.assertTrue(e.getText().contains("ОПЕРАЦИОННАЯ СИСТЕМА"));
            }
        }

        //Нажать на опцию "различающиеся характеристики"
        logger.info("Нажать на опцию \"различающиеся характеристики\"");
        waitAndClick(By.xpath("/html/body/div[1]/div[5]/div[1]/div[2]/div[1]/span[2]/span"));

        //Проверить, что позиция "Операционная система" не отображается в списке характеристик
        logger.info("Проверить, что позиция \"Операционная система\" не отображается в списке характеристик");
        paramsContainer = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[2]/div[6]"));
        paramsList = paramsContainer.findElements(By.tagName("div"));
        for (WebElement e: paramsList) {
                Assert.assertFalse(e.getText().contains("ОПЕРАЦИОННАЯ СИСТЕМА"));
        }
    }

    private String getPhoneName(WebElement phone){
        return phone.findElement(By.className("n-snippet-cell2__title")).findElement(By.tagName("a")).getAttribute("text");

    }
    private WebElement findPhone(List<WebElement> lst, String phoneName)
    {
        for (WebElement e: lst ) {
            try{
                e.findElement(By.xpath("a"));
                if(waitAndGetElement(e, By.xpath("a")).getAttribute("title")!=null){//java.lang.reflect.InvocationTargetException.class
                    //e.findElement(By.className("n-snippet-cell2__title")).findElement(By.tagName("a")).getAttribute("text").contains(phoneName)
                    if (waitAndGetElement(e, By.xpath("a")).getAttribute("title").contains(phoneName)){
                        return e;
                    }
                }
            }
            catch (RuntimeException ex) {
            }

        }
        return null;
    }

    private WebElement findCompareToolbar(WebElement ancestorElement)
    {
        List<WebElement> divList = ancestorElement.findElements(By.tagName("div"));
        divList.size();
        if (divList.size()>0){
            for (WebElement e: divList ) {
                if(e.getAttribute("class").contains("lists_type_compare_in")){
                    return e;
                }
            }
        }
        return null;
    }
}
