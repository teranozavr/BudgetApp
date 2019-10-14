package com.github.teranozavr.pages.budgetapp;

import com.github.teranozavr.helpers.WebElementWaiter;
import org.junit.Assert;
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


    @FindBy(id = "mobileOrEmail")
    private WebElement mobileOrEmailField;



    public void open() {
        String url = env.getProperty("budgetapp.host.url");
        driver.get(url);
    }

}
