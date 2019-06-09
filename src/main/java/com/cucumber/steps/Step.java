package com.cucumber.steps;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * Created by sergey on 14.03.15.
 */
@ContextConfiguration("classpath:cucumber.xml")
public class Step {

    @Autowired
    protected WebDriver driver1;

}
