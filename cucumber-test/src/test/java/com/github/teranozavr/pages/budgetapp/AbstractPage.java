package com.github.teranozavr.pages.budgetapp;

import com.github.teranozavr.helpers.WebElementWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

public class AbstractPage {
    @Autowired
    public WebDriver driver;

    @Autowired
    public Environment env;

    // =] теперь он на спринге
    @Autowired
    public WebElementWaiter webElementWaiter;

    @PostConstruct
    public void init() {
        PageFactory.initElements(driver, this);
    }
}
