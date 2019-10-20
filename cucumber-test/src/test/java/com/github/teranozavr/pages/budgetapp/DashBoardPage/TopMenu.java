package com.github.teranozavr.pages.budgetapp.DashBoardPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class TopMenu extends DashBoardPage {
    @FindBy(className = "caret")
    public WebElement dropDown;
}
