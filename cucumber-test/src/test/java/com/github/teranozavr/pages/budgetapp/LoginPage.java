package com.github.teranozavr.pages.budgetapp;

import com.github.teranozavr.helpers.WebElementWaiter;
import org.junit.Assert;
import org.omg.CORBA.StringHolder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LoginPage extends AbstractPage {

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

    @FindBy(xpath = "/html/body/div/aside[2]/div/section/div/div/section/div[2]/ul/li")
    public WebElement allert;


    public void open() {
        open(this);
    }

    public void checkSuccessLogin() {
        webElementWaiter.waitWhileUrlChanged(getUrl(this), timeout);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = env.getProperty("Host")+env.getProperty("DashboardPage");
        Assert.assertEquals(expectedURL,currentURL);
    }

    public void checkAllert(String expectedText) {
        String text = webElementWaiter.waitAndGetElement(allert).getText();
        Assert.assertEquals(text, expectedText);
    }

    public void chechSignUpPageOpen() {
        webElementWaiter.waitWhileUrlChanged(getUrl(this), timeout);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = env.getProperty("Host") + env.getProperty("SignUpPage");
        Assert.assertEquals(expectedURL, currentURL);
    }
}
