package teranozavr.Lesson15.steps;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import io.cucumber.datatable.DataTable;
import org.springframework.beans.factory.annotation.Autowired;
import teranozavr.Lesson15.pages.gosuslugi.GosUslugiMainPage;

import java.util.List;


public class GosUslugiMainPageStepdefs {

    @Autowired
    private GosUslugiMainPage mainPage;

    @Дано("пользователь открыл страницу gosuslugi.ru")
    public void пользовательОткрылСтраницуGosuslugiRu() {
        mainPage.open();
    }

    @Дано("пользователь нажал кнопку {string}")
    public void пользовательНажалКнопку(String arg0) {
        mainPage.click(arg0);
    }

    @Если("пользователь залогинен, то он разлогинивается")
    public void пользовательЗалогиненТоОнРазлогинивается() {
        mainPage.logOut();

    }

    @Когда("пользователь нажал на аватар")
    public void пользовательНажалНаАватар() {
        mainPage.clickAvatar();
    }

    @Тогда("открылась вкладка {string}")
    public void открыласьВкладка(String arg0) {
        mainPage.checkUrl(arg0);
    }


    @Когда("пользователь нажал на ФИО")
    public void пользовательНажалНаФИО() {
        mainPage.fioClick();
    }

    @Тогда("открылась дата-форма")
    public void открыласьДатаФорма() {
        mainPage.checkDashboardMenuVisibility(true);
    }

    @Тогда("закрылась дата-форма")
    public void закрыласьДатаФорма() {
        mainPage.checkDashboardMenuVisibility(false);
    }

    @Тогда("на дата-форме присутствуют вкладки")
    public void наДатаФормеПрисутствуютВкладки(DataTable dataTable) {
        List<String> tabs = dataTable.asList(String.class);

        for (String tab: tabs) {
            mainPage.chechTabVisibility(tab);
        }
    }

    @Когда("пользователь открыл вкладку {string}")
    public void пользовательОткрылВкладку(String arg0) {
        mainPage.clickTabWithName(arg0);
    }

    @Тогда("на дата-форме присутствуют элементы")
    public void наДатаФормеПрисутствуютЭлементы(DataTable dataTable) {
        List<String> components = dataTable.asList(String.class);

        for (String component: components) {
            mainPage.chechComponentVisibility(component);
        }
    }
}
