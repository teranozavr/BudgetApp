package com.github.teranozavr.steps.budgetapp;

import com.github.teranozavr.helpers.TestData;
import com.github.teranozavr.helpers.WebElementWaiter;
import com.github.teranozavr.pages.budgetapp.DashBoardPage.DashBoardPage;
import com.github.teranozavr.pages.budgetapp.DashBoardPage.DropdownMenu;
import com.github.teranozavr.pages.budgetapp.DashBoardPage.TopMenu;
import com.github.teranozavr.pages.budgetapp.LoginPage;
import com.github.teranozavr.pages.budgetapp.ProfilePage;
import com.github.teranozavr.pages.budgetapp.SignUpPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BaseStepdefs {

    @Autowired
    public TestData testData;

    @Autowired
    protected LoginPage loginPage;

    @Autowired
    protected SignUpPage signUpPage;

    @Autowired
    protected ProfilePage profilePage;

    @Autowired
    protected DashBoardPage dashBoardPage;

    @Autowired
    protected TopMenu topMenu;

    @Autowired
    protected DropdownMenu dropdownMenu;

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
