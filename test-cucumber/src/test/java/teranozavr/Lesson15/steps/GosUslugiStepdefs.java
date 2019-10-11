package teranozavr.Lesson15.steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import teranozavr.Lesson15.pages.gosuslugi.GosUslugiAuthPage;
import ru.sbtqa.tag.datajack.Stash;

import java.util.List;

/**
 * Created by Admin on 07.10.2019.
 */
public class GosUslugiStepdefs {
    
    @Autowired
    private GosUslugiAuthPage authPage;

    @Autowired
    private Environment env;

    @Тогда("авторизация прошла успешно")
    public void авторизацияПрошлаУспешно() {
        authPage.checkTitle("Портал государственных услуг Российской Федерации");
        System.out.println("Троллоло");
    }

    @Дано("пользователь открыл страницу авторизации")
    public void пользовательОткрылСтраницуАвторизации() {
        authPage.open();
    }


    @Тогда("открылась форма авторизации")
    public void открыласьФормаАвторизации() {
        authPage.checkUrl();
    }

    @Когда("пользователь ввел логин и паоль")
       public void пользовательВвелЛогинИПаоль(DataTable dataTable) {
        List<String> authData = dataTable.asList(String.class);
        String login = authData.get(0);
        String password = authData.get(1);
        authPage.authorize(login, password);
    }

    @Тогда("появилось сообщенение об ошибке авторизации")
    public void появилосьСообщенениеОбОшибкеАвторизации() {
        authPage.chechFailAuthMessage();
    }

    @Когда("пользователь ввел корректный логин и пароль")
    public void пользовательВвелКорректныйЛогинИПароль() {
        String login = env.getProperty("valid.login");
        String password = env.getProperty("valid.password");
        authPage.authorize(login, password);
    }

    @Когда("пользователь ввел некорректный логин или пароль")
    public void пользовательВвелНекорректныйЛогинИлиПароль() {
        String login = env.getProperty("valid.login");
        String password = env.getProperty("invalid.password");
        authPage.authorize(login, password);
    }
}

