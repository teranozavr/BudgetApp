package com.github.teranozavr.steps.budgetapp;

import com.github.teranozavr.helpers.WebElementWaiter;
import com.github.teranozavr.pages.budgetapp.LoginPage;
import com.github.teranozavr.pages.budgetapp.SignUpPage;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class SignUpPageStepdefs extends BaseStepdefs {


    @Дано("пользователь открыл страницу SignUp")
    public void пользовательОткрылСтраницуSignUp() {
        signUpPage.open();
    }

    @Дано("пользователь придумал и ввел корректный логин и пароль")
    public void пользовательПридумалИВвелКорректныйЛогинИПароль() {
        Long ms = System.currentTimeMillis();
        String login = ms.toString()+"@mail.ru";
        String password  = ms.toString();
        System.out.println("Логин/пароль: "+login+"/"+password);
        webElementWaiter.waitAndGetElement(signUpPage.emailField);
        testData.stringMap.put("login", login);
        testData.stringMap.put("password", password);
        loginPage.emailField.clear();
        signUpPage.emailField.sendKeys(login);
        loginPage.passwordField.clear();
        signUpPage.passwordField.sendKeys(password);
    }

    @Когда("пользователь нажал кнопку SignUp")
    public void пользовательНажалКнопкуSignUp() {
        signUpPage.loginButton.click();
    }

    @Тогда("появилось предупреждение о неверном e-mail {string}")
    public void появилосьПредупреждениеОНеверномEMail(String arg0) {
        webElementWaiter.waitWhilePropertyOfElementChanged(signUpPage.loginAllert, timeout);
        String loginAllertMessage = signUpPage.loginAllert.getText();
        Assert.assertEquals(arg0,loginAllertMessage);
    }

    @Тогда("появилось предупреждение о неверном пароле {string}")
    public void появилосьПредупреждениеОНеверномПароле(String arg0) {
        String passwordAllertMessage = signUpPage.passwordAllert.getText();
        Assert.assertEquals(arg0,passwordAllertMessage);
    }
}
