package teranozavr.Lesson15.pages.gosuslugi;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import teranozavr.Lesson15.helpers.WebElementWaiter;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class GosUslugiMainPage {

    private final Map<String, WebElement> buttons = new HashMap<>();

    @Autowired
    private WebDriver driver;

    // =] теперь он на спринге
    @Autowired
    private WebElementWaiter webElementWaiter;

    @Autowired
    private Environment env;

    @FindBy(id = "auth")
    private WebElement authButton;

    @FindBy(id = "login-name")
    private WebElement loginName;

    @FindBy(id = "md-h-title-14-big")
    private WebElement dropDown;

    @FindBy(className = "dashboard-menu-link-logout")
    private WebElement logOut;

    @FindBy(css = "#login-name > div > a")
    private WebElement avatar;

    @FindBy(className = "dashboard-menu-link")
    private WebElement lkButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[3]/div[2]/a")
    private WebElement allNotoficationButton;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[4]/section/div[2]/div[2]/div/div/a")
    private WebElement allServicesButton;

    @FindBy(className = "dashboard-menu")
    private WebElement dashboardMenu;


    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    public void open() {
        String url = env.getProperty("gosuslugi.url");
        driver.get(url);
        buttons.put("войти", authButton);
        buttons.put("личный кабинет", lkButton);
        buttons.put("все услуги", allServicesButton);
        buttons.put("все уведомления", allNotoficationButton);
    }

    public void click(String buttonName)
    {
        webElementWaiter.waitAndClick(buttons.get(buttonName.toLowerCase()));
    }

    public boolean isAuthorized(){
        try {
            if(loginName.isDisplayed())
            {
                return true;
            }
        }
        catch (RuntimeException ex){};
        return false;
    }

    public void logOut(){
        if (isAuthorized()){
            loginName.click();
            logOut.click();
        }
    }

    public  void clickAvatar(){
        if (isAuthorized()){
            webElementWaiter.waitAndClick(avatar);
        }
    }

    public void checkUrl(String url) {
        Assert.assertEquals(driver.getCurrentUrl(),url);
    }

    public void fioClick() {
        loginName.click();
    }

    public boolean isDashboardMenuVisible() {
        try {
            if(dashboardMenu.isDisplayed())
            {
                return true;
            }
        }
        catch (RuntimeException ex){};
        return false;
    }

    public void checkDashboardMenuVisibility(boolean expectedVisibility){
        Assert.assertEquals(isDashboardMenuVisible(),expectedVisibility);
    }

    private boolean isTabOnDashboardMenuVisible(String tabName){
        try {
            WebElement tab = webElementWaiter.waitAndGetElement(By.tagName("span"),null, tabName );
            if(tab.isDisplayed())
            {
                return true;
            }
        }
        catch (RuntimeException ex){};
        return false;
    }

    public void chechTabVisibility(String tab) {
        Assert.assertTrue(isTabOnDashboardMenuVisible(tab));
    }

    public void clickTabWithName(String tabName) {
        WebElement el = webElementWaiter.waitAndGetElement(By.tagName("span"),null, tabName);
        el.click();
    }

    private boolean isElementOnDashboardMenuVisible(String elName){
        try {
            WebElement tab = webElementWaiter.waitAndGetElement(By.tagName("div"),null, elName );
            if(tab.isDisplayed())
            {
                return true;
            }
        }
        catch (RuntimeException ex){};
        return false;
    }

    public void chechComponentVisibility(String componentName) {
        Assert.assertTrue(isElementOnDashboardMenuVisible(componentName));
    }


}

