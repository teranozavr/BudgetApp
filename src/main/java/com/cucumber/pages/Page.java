package com.cucumber.pages;

import com.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Page {

    @Autowired
    WebDriver driver;
    @PostConstruct
    public void setUp() {
       // driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void open(String url) throws Throwable{

        //System.setProperty("webdriver.chrome.driver", PropertiesReader.getInstance().getURLProperty("browser.chrome"));
        //WebDriver browser = new ChromeDriver();
        //browser.get("https://www.saucelabs.com");
        driver.get(url);
    }

   /* protected String getUrl()
    {
        return driver.getCurrentUrl();
    }


    protected WebElement $(String xpath, String... args) {
       return driver.findElement(By.xpath(String.format(xpath, args)));
   }


   protected List<WebElement> $$(By by) {
        return driver.findElements(by);
    }

    protected WebElement $(By by) {
        return driver.findElement(by);
    }*/
}


