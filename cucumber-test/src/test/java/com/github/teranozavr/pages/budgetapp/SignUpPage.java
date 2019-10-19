package com.github.teranozavr.pages.budgetapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class SignUpPage extends BasePage {


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

    @FindBy(xpath = "/html/body/div/aside[2]/div/section/div/div/div/div[2]/form/div[1]/span")
    public WebElement loginAllert;

    @FindBy(xpath = "/html/body/div/aside[2]/div/section/div/div/div/div[2]/form/div[2]/span")
    public WebElement passwordAllert;

    public void open() {
        open(this);
    }
}
