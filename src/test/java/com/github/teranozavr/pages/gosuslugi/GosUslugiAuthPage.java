package com.github.teranozavr.pages.gosuslugi;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import com.github.teranozavr.helpers.WebElementWaiter;


import javax.annotation.PostConstruct;

@Component
public class GosUslugiAuthPage{

    @Autowired
    private WebDriver driver;

    @Autowired
    private Environment env;

    // =] теперь он на спринге
    @Autowired
    private WebElementWaiter webElementWaiter;

    @FindBy(id = "mobileOrEmail")
    private WebElement mobileOrEmailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "loginByPwdButton")
    private WebElement loginByPwdButton;

    @FindBy(xpath = "/html/head/title")
    private WebElement pageTitle;

    @FindBy(className = "ui-message-error-detail")
    private WebElement notAuthorizeMessage;

    @FindBy(className = "another-user")
    private WebElement anotherUser;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    public void authorize(String login, String password){
        webElementWaiter.waitAndClick(anotherUser);
        mobileOrEmailField.sendKeys(login);
        passwordField.sendKeys(password);
        loginByPwdButton.click();
    }

    public void checkTitle(String arg0) {
        webElementWaiter.waitAndGetElement(pageTitle);
        String title = driver.getTitle();
        Assert.assertEquals(title, arg0);
    }

    public void checkUrl() {
        String url = env.getProperty("gosuslugi.auth.url");
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    public void open() {
        String url = env.getProperty("gosuslugi.url");
        driver.get(url);
    }

    public void chechFailAuthMessage() {
        String message = webElementWaiter.waitAndGetElement(notAuthorizeMessage).getText();
        System.out.println(message);
    }
}
