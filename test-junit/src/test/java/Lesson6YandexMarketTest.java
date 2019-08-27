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
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static helpers.DriverFactory.createNewDriver;
import static helpers.browserPropetry.browserPropetry;
import static helpers.options.ChromeOpt.ChromeOpt;
import static helpers.options.FirefoxOpt.FirefoxOpt;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static helpers.WebElementWaiter.*;

public class Lesson6YandexMarketTest {
    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;

    @Before
    public void setup() {

        System.setProperty("browser", "chrome");
        switch (browserPropetry()) {
            case (CHROME): {
                ChromeOptions opt = ChromeOpt();
                driver = createNewDriver(CHROME, opt);
                WebElementWaiter(driver, 10, 2);
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
        //Открыть в Chrome сайт Яндекс.Маркет - раздел "Мобильные телефоны"
        driver.get("https://market.yandex.ru");
        //Нажимаем в Popup сообщении подтверждение выбора региона
        waitAndClick(By.cssSelector("body > div.popup2.popup2_autoclosable_yes.popup2_adaptive_yes.popup2_animate_yes.popup2_target_anchor.popup2_theme_normal.popup2_region_notification.i-bem.popup2_js_inited.popup2_direction_bottom-center.popup2_visible_yes > div.popup2__content > div > div > div.n-region-notification__actions.layout.layout_display_flex > div:nth-child(1) > span"));

        //driver.findElement(By.className("n-w-tab__control-hamburger")).click();
        //wait.until(driver -> driver.findElements(By.className("n-w-tab__control-hamburger")).size() > 0);
        //Нажимаем "Все категории"
        waitAndClick(By.cssSelector("body > div.main > div > span > div.n-w-tabs.n-w-tabs_flex_row.b-zone.i-bem.n-w-tabs_js_inited.n-w-tabs_content-shown_no > noindex > div.n-w-tabs__horizontal-tabs-container > div > div > div.n-w-tabs__horizontal-tabs > div.n-w-tab.n-w-tab_interaction_click-navigation-menu.n-w-tab_type_navigation-menu-grouping.i-bem.n-w-tab_js_inited.n-w-tab_interaction-active_no > div"));
        //Нажимаем "Смартфоны"
        waitAndClick(By.cssSelector("body > div.main > div > span > div.n-w-tabs.n-w-tabs_flex_row.b-zone.i-bem.n-w-tabs_js_inited.n-w-tabs_content-shown_yes.b-zone_js_inited > noindex > div.n-w-tabs__horizontal-tabs-content > div > div > div > div > div > div > div.n-w-tabs__content-column > div > div.n-w-tab__content-container.n-w-tab__content-container_interaction_hover-navigation-menu.b-zone.b-spy-visible.i-bem.n-w-tab__content-container_uid_39889744.n-w-tab__content-container_js_inited.b-spy-visible_js_inited.n-w-tab__content-container_shown_yes.b-zone_js_inited > div > div > div:nth-child(1) > div > div > div:nth-child(1) > a:nth-child(2)"));
        //Отфильтровать список товаров по производителю: RedMi и Xiaomi

        WebElement search = waitAndGetElement(By.id("search-prepack"));
        List<WebElement> elements = waitAndGetElements(search, By.tagName("span"));
        WebElement honor;
        WebElement xiaomi;
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
        WebElement sortMenu = waitAndGetElement(By.cssSelector("body > div.main > div:nth-child(6) > div.n-filter-panel-dropdown.i-bem.n-filter-panel-dropdown_js_inited > div.n-filter-panel-dropdown__main"));
        List<WebElement> sortElements;
        sortElements = waitAndGetElements(sortMenu, By.tagName("div"));

        for (WebElement el: sortElements
             ) {
            if (el.getText().equals("по цене"))
            waitAndClick(el);
        }

        //Добавить первый в списке RedMi
        //Контейнер, содержащий элементы
        WebElement phoneList = waitAndGetElement(By.cssSelector("body > div.main > div:nth-child(6) > div.layout.layout_type_search.i-bem > div.layout__col.i-bem.layout__col_search-results_normal > div.n-filter-applied-results.metrika.b-zone.i-bem.n-filter-applied-results_js_inited.b-zone_js_inited > div > div.n-snippet-list.n-snippet-list_type_grid.snippet-list_size_3.metrika.b-zone.b-spy-init.b-spy-events.i-bem.metrika_js_inited.snippet-list_js_inited.b-spy-init_js_inited.b-zone_js_inited"));
        List<WebElement> li = phoneList.findElements(By.tagName("div"));

        for (WebElement e: li
                ) {

            try{
                waitAndGetElement(e, By.tagName("a")).getAttribute("title");
            }
            catch (Exception ex)
            {

            }
        }
        //Проверить, что отобразилась плашка "Товар {имя товара} добавлен к сравнению"
        //Добавить первый в списке Xiaomi
        //Проверить, что отобразилась плашка "Товар {имя товара} добавлен к сравнению"
        //Перейти в раздел Сравнение
        //Проверить, что в списке товаров 2 позиции
        //Нажать на опцию "все характеристики"
        //Проверить, что в списке характеристик появилась позиция "Операционная система"
        //Нажать на опцию "различающиеся характеристики"
        //Проверить, что позиция "Операционная система" не отображается в списке характеристик
System.out.println();
        /*
        try {
            Assert.assertEquals(driver.getCurrentUrl(), "https://otus.ru/");
            logger.info("checkURLTest - Passed");
        } catch (AssertionError ae) {
            logger.error("checkURLTest - Failed");
            throw new Exception();
        }*/
    }
}
