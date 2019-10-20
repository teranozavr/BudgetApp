package com.github.teranozavr.pages.budgetapp.DashBoardPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class DropdownMenu extends DashBoardPage {
    @FindBy(className = "dropdown-menu")
    public WebElement rootElement;

    @FindBy(xpath = "/html/body/header/nav/div/ul/li/ul/li[2]/div[1]/a")
    public WebElement profileButton;

    @FindBy(xpath = "/html/body/header/nav/div/ul/li/ul/li[2]/div[2]/a")
    public WebElement signOutButton;

}
