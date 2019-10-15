package com.github.teranozavr.steps.budgetapp;

import com.github.teranozavr.pages.budgetapp.LoginPage;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginPageStepdefs {
    @Autowired
    private LoginPage loginPage;


        @Дано("пользователь открыл страницу")
        public void пользовательОткрылСтраницу() {
            loginPage.open();
        }

    @Когда("пользователь нажал кнопку войти")
    public void пользовательНажалКнопкуВойти() {
        System.out.println("трололол");
    }


}
