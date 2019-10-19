package com.github.teranozavr.pages.budgetapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class SignUpPage extends AbstractPage {


    @FindBy(id = "username")
    public WebElement emailField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(className = "btn-primary")
    public WebElement loginButton;

    @FindBy(xpath = "/html/body/div/aside[2]/div/section/div/div/div/div[2]/form/a")
    public WebElement signUpLink;

    @FindBy(className = "panel-title")
    public WebElement panelTitle;


    public void open() {
        open(this);
    }


}
