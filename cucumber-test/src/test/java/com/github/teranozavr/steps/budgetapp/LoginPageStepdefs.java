package com.github.teranozavr.steps.budgetapp;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;

public class LoginPageStepdefs extends BaseStepdefs {

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
        webElementWaiter.waitAndGetElement(loginPage.emailField).clear();
        webElementWaiter.waitAndGetElement(loginPage.emailField).sendKeys(login);
    }

    @Дано("пользователь ввел пароль {string}")
    public void пользовательВвелПароль(String password) {
        webElementWaiter.waitAndGetElement(loginPage.passwordField).clear();
        webElementWaiter.waitAndGetElement(loginPage.passwordField).sendKeys(password);
    }

    @Тогда("появилось сообщение {string}")
    public void появилосьСообщениеInvalidUsernameAndPasswordCombination(String arg0) {
            loginPage.checkAllert(arg0);
    }

    @Дано("пользователь нажал ссылку SignUp")
    public void пользовательНажалСсылкуSignUp() {
            loginPage.signUpLink.click();
    }

    @Дано("пользователь дождался открытия страницы Авторизации")
    public void пользовательДождалсяОткрытияСтраницыАвторизации() {
            loginPage.chechSignUpPageOpen();
    }

    @Тогда("появилось сообщение об успешной авторизации {string}")
    public void появилосьСообщениеОбУспешнойАвторизации(String expectedMessage) {
        String actuelMessage = webElementWaiter.waitAndGetElement(loginPage.successMessage).getText();
        Assert.assertEquals(expectedMessage,actuelMessage);
    }

    @Когда("пользователь ввел логин и пароль")
    public void пользовательВвелЛогинИПароль() {

        String login = testData.stringMap.get("login");
        String password = testData.stringMap.get("password");
        пользовательВвелЛогинLogin(login);
        пользовательВвелПароль(password);
    }

    @Тогда("открылась страница {string}")
    public void открыласьСтраница(String arg0) {
        loginPage.checkPageUrl(arg0);
    }
}
