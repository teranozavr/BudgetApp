package com.github.teranozavr.pages;

import com.github.teranozavr.helpers.WebElementWaiter;
import com.github.teranozavr.service.DriverInitService;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.testng.IClass;
import org.apache.logging.log4j.Logger;

import javax.annotation.PostConstruct;
import java.util.logging.LogManager;

public class BasePage {

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
        timeout = Long.parseLong(env.getProperty("timeout"));
    }

    public Long timeout;

    public String getUrl(Object page){
        String shortClassName = page.getClass().getSimpleName();
        String url =  env.getProperty("Host")+env.getProperty(shortClassName);
        return url;
    }

    public void checkPageUrl(String url){
        webElementWaiter.waitWhileUrlChanged(driver.getCurrentUrl(), timeout);
        String currentURL = driver.getCurrentUrl();
        String expectedURL = env.getProperty("Host")+env.getProperty(url);
        Assert.assertEquals(expectedURL,currentURL);
    }

    protected void open(Object page) {
        System.out.println("Открыта страница "+page.getClass().getSimpleName()+" по адресу "+getUrl(page));
        driver.get(getUrl(page));
     }
}
