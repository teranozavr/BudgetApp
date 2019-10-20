package com.github.teranozavr.pages.budgetapp;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class ProfilePage extends BasePage {


    //Controls on "Profile" tab

    @FindBy(xpath = "/html/body/div[1]/aside[2]/div/section[2]/div[1]/div/section/div[1]")
    public WebElement successAllert; //Successfully update profile

    @FindBy(className = "loading")
    public WebElement busyIndicator;

    @FindBy(xpath = "/html/body/div/aside[2]/div/section[2]/div[2]/div/div/div[2]/div/ul/li[1]/a")
    public WebElement profileTab;

    @FindBy(xpath = "//*[@id=\"name\"]")
    public WebElement nameField;

    @FindBy(xpath = "//*[@id=\"currency\"]")
    public WebElement currencyField;

    @FindBy(xpath = "/html/body/div/aside[2]/div/section[2]/div[2]/div/div/div[2]/div/div/div[1]/div/form/div[5]/div/button")
    public WebElement updateButton;

    //Controls on "Change Password" tab

    @FindBy(xpath = "/html/body/div/aside[2]/div/section[2]/div[2]/div/div/div[2]/div/ul/li[2]/a")
    public WebElement changePasswordTab;

    @FindBy(xpath = "//*[@id=\"original\"]")
    public WebElement currentPasswordField;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement mewPasswordField;

    @FindBy(xpath = "//*[@id=\"confirm\"]")
    public WebElement confirmNewPasswordField;

    @FindBy(xpath = "/html/body/div/aside[2]/div/section[2]/div[2]/div/div/div[2]/div/div/div[2]/div/form/div[4]/div/button")
    public WebElement changePasswordButton;

    public void open() {
        open(this);
    }

}
