package com.github.teranozavr.pages.budgetapp;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class SignUpPage extends AbstractPage {


    @FindBy(id = "mobileOrEmail")
    private WebElement mobileOrEmailField;

    public void open() {
        open(this);
    }

}
