package com.cucumber.pages;

import org.springframework.stereotype.Component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.utils.PropertiesReader;
import java.io.IOException;

@Component
public class OtusPage extends Page {

    public void open() throws Throwable
    {
        String URL=PropertiesReader.getInstance().getURLProperty("Otus.main.page");
        //open(URL);
    }

  /*  public String getUrl()
    {
        Page p = new Page();
        String URL = p.getUrl();
        return(URL);
    }

    @FindBy(name = "authorizeURL")
    public WebElement authorizeField;
    */
}
