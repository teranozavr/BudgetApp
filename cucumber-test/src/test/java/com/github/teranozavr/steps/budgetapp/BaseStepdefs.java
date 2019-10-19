package com.github.teranozavr.steps.budgetapp;

import com.github.teranozavr.helpers.TestData;
import com.github.teranozavr.helpers.WebElementWaiter;
import com.github.teranozavr.pages.budgetapp.AbstractPage;
import com.github.teranozavr.pages.budgetapp.LoginPage;
import com.github.teranozavr.pages.budgetapp.SignUpPage;
import cucumber.api.java.ru.Тогда;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.util.HashMap;
import java.util.Map;

public class BaseStepdefs {

    @Autowired
    public TestData testData;

    @Autowired
    protected LoginPage loginPage;

    @Autowired
    protected SignUpPage signUpPage;

    @Autowired
    protected WebElementWaiter webElementWaiter;

    @Autowired
    protected Environment env;

}
