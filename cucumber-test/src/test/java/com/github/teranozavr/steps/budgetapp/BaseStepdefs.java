package com.github.teranozavr.steps.budgetapp;

import com.github.teranozavr.helpers.TestData;
import com.github.teranozavr.helpers.WebElementWaiter;
import com.github.teranozavr.pages.budgetapp.LoginPage;
import com.github.teranozavr.pages.budgetapp.SignUpPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

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

    public Long timeout;

    @PostConstruct
    public void init() {
        timeout = Long.parseLong(env.getProperty("timeout"));
    }

}
