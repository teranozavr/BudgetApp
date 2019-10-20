package com.github.teranozavr.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.github.teranozavr.config.Config;

@ContextConfiguration(classes = Config.class)
public class CommonStepdefs {
    @Autowired
    WebDriver webDriver;

    @Before
    public void beforeHook(Scenario scenario) {
        System.out.println("Подготовка к сценарию: " + scenario.getName());
        //ProfilePageStepdefs profilePageStepdefs = baseStepdefs.getProfilePageStepdefs();
    }

    @After//(value = "@3.3")
    public void after(Scenario scenario) {
        System.out.println("Действия после сценария: " + scenario.getName());
        webDriver.manage().deleteAllCookies();
        prepareTestData(scenario);
    }

    private void prepareTestData(Scenario scenario){
        String scenarioName = scenario.getName();
        switch (scenarioName){
            case ("Изменение пароля"):{
                //Возвращаем старый пароль на место
                //Это жесть
                //Environment env = baseStepdefs.getEnvironment();
//                LoginPageStepdefs lps = new LoginPageStepdefs();
//                lps.пользователВвелЛогинИНовыйПароль();
//                baseStepdefs.getProfilePageStepdefs().пользовательРазлогинился();
//                String login = env.getProperty("validLogin");
//                String password = testData.stringMap.get("newPassword");
//                baseStepdefs.getProfilePageStepdefs().пользовательРазлогинился();
//                baseStepdefs.getLoginPageStepdefs().пользователВвелЛогинИНовыйПароль(login, password);
//                baseStepdefs.getLoginPageStepdefs().пользовательНажалКнопкуLogin();
//                baseStepdefs.getLoginPageStepdefs().открыласьСтраницаDashboard();
//                baseStepdefs.getProfilePageStepdefs().пользовательОткрылВкладкуChangePassword();
//                baseStepdefs.getProfilePageStepdefs().вернулСтарыйПароль();
//                baseStepdefs.getProfilePageStepdefs().нажалКнопкуChangePassword();
                break;
            }
        }
    }
}
