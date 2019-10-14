package com.github.teranozavr.steps.budgetapp;

import com.github.teranozavr.pages.budgetapp.LoginPage;
import com.github.teranozavr.pages.budgetapp.SignUpPage;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import org.springframework.beans.factory.annotation.Autowired;

public class SignUpPageStepdefs {
    @Autowired
    private SignUpPage signUpPage;

    @Дано("пользователь открыл страницу SignUp")
    public void пользовательОткрылСтраницуSignUp() {
        signUpPage.open();

    }
}
