package com.cucumber.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

@Component
public class OtusPage{

    @Autowired
    Environment env;

    @Autowired
    WebDriver driver;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
        // driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void open()
    {
        //String URL=PropertiesReader.getInstance().getURLProperty("Otus.main.page");
        String url = env.getProperty("Otus.main.page");
        driver.get(url);
    }
}
