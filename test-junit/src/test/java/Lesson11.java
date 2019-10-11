import teranozavr.helpers.AuthData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import teranozavr.pages.MainPage;
import teranozavr.pages.OtusLK;

import static teranozavr.helpers.Setuper.setupDriver;

/**
 * Created by Admin on 28.09.2019.
 */
public class Lesson11 {
    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;

    @Before
    public void setup() {
        driver=setupDriver();
    }

    @Test
    public void search() {

        //Открыть https://otus.ru
        logger.info("Открыть https://otus.ru");
        MainPage mainPage = new MainPage(driver);
        //Авторизоваться на сайте
        AuthData auth = new AuthData();
        mainPage.authorize(auth.getLogin(),auth.getPassword());
        //Подсказка: для запуска используй команду: clean teranozavr.Lesson15.test -Dbrowser=chrome -Dtest=Lesson11 -Dlogin=Логин -Dpassword=Пароль
        logger.info("Подсказка: для запуска используй команду: clean teranozavr.Lesson15.test -Dbrowser=chrome -Dtest=Lesson11 -Dlogin=Логин -Dpassword=Пароль");

        //Войти в личный кабинет
        logger.info("Войти в личный кабинет");
        OtusLK lkPage = new OtusLK(driver);
        //В разделе "О себе" заполнить все поля "Личные данные" и добавить не менее двух контактов
        logger.info("В разделе \"О себе\" заполнить все поля \"Личные данные\" и добавить не менее двух контактов");
        lkPage.navigateToAboutMe();
        lkPage.cleanData();
        lkPage.fillData();
        //Нажать сохранить
        logger.info("Нажать сохранить");
        lkPage.save();
        tearDown();
        //Открыть https://otus.ru в "чистом браузере"
        logger.info("Открыть https://otus.ru в \"чистом браузере\"");
        setup();
        mainPage = new MainPage(driver);
        //Авторизоваться на сайе
        logger.info("Авторизоваться на сайе");
        mainPage.authorize(auth.getLogin(),auth.getPassword());
        //Войти в личный кабинет
        logger.info("Войти в личный кабинет");
        lkPage = new OtusLK(driver);
        lkPage.navigateToAboutMe();
        //Проверить, что в разделе "О себе" отображаются указанные ранее данные
        logger.info("Проверить, что в разделе \"О себе\" отображаются указанные ранее данные");
        Assert.assertTrue(lkPage.validateData());
    }

    @After
    public void tearDown() {
        if(driver != null)
        {
            driver.quit();
        }
    }
}
