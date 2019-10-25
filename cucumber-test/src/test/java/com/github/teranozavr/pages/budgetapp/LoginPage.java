package com.github.teranozavr.pages.budgetapp;

import com.github.teranozavr.pages.BasePage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

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

    @FindBy(xpath = "/html/body/div/aside[2]/div/section/div/div/section/div[1]")
    public WebElement successMessage;


    public void open() {
        open(this);
    }

    public void checkSuccessLogin() {
        checkPageUrl("DashboardPage");
    }

    public void checkAllert(String expectedText) {
        String text = webElementWaiter.waitAndGetElement(allert).getText();
        Assert.assertEquals(text, expectedText);
    }

    public void chechSignUpPageOpen() {
        webElementWaiter.waitWhileUrlChanged(getUrl(this), timeout);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = env.getProperty("endPoint") + env.getProperty("SignUpPage");
        Assert.assertEquals(expectedURL, currentURL);
    }
}
