package com.github.teranozavr.steps.budgetapp;

import com.github.teranozavr.pages.budgetapp.LoginPage;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class LoginPageStepdefs {
    @Autowired
    private LoginPage loginPage;

    @Autowired
    private Environment env;


        @Дано("пользователь открыл страницу")
        public void пользовательОткрылСтраницу() {
            loginPage.open();
        }

    @Когда("пользователь нажал кнопку войти")
    public void пользовательНажалКнопкуВойти() {
        System.out.println("трололол");
    }


    @Дано("пользователь ввел существующий логин и пароль")
    public void пользовательВвелСуществующийЛогинИПароль() {
        String login = env.getProperty("validLogin");
        String password = env.getProperty("validPassword");
        loginPage.emailField.clear();
        loginPage.emailField.sendKeys(login);
        loginPage.passwordField.clear();
        loginPage.passwordField.sendKeys(password);
    }

    @Когда("пользователь нажал кнопку Login")
    public void пользовательНажалКнопкуLogin() {
            loginPage.loginButton.click();
    }

    @Тогда("открылась страница Dashboard")
    public void открыласьСтраницаDashboard() {
            loginPage.checkSuccessLogin();
    }

    @Дано("пользователь ввел логин {string}")
    public void пользовательВвелЛогинLogin(String login) {
            loginPage.emailField.clear();
            loginPage.emailField.sendKeys(login);
    }

    @Дано("пользователь ввел пароль {string}")
    public void пользовательВвелПароль(String password) {
            loginPage.passwordField.clear();
            loginPage.passwordField.sendKeys(password);
    }

    @Тогда("появилось сообщение {string}")
    public void появилосьСообщениеInvalidUsernameAndPasswordCombination(String arg0) {
            loginPage.checkAllert(arg0);
    }
}
