package teranozavr.pages;

import teranozavr.helpers.WebElementWaiter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static teranozavr.helpers.WebElementWaiter.waitAndClick;


/**
 * Created by Admin on 28.09.2019.
 */
public class MainPage extends AbstractPage {

    @FindBy(xpath = "/html/body/div[1]/div/header/div/div[3]/div[1]/button")
    private WebElement loginButton;

    public MainPage(WebDriver driver){
        super(driver);
        driver.get("https://otus.ru");

        if (!"OTUS - Онлайн-образование".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not otus.ru page");
        }
    }

    public void authorize(String login, String password){
        WebElementWaiter.waitAndClick(loginButton);
        OtusAuthorizePage otusAuthPage = new OtusAuthorizePage(driver);
        otusAuthPage.authorize(login,password);
        WebElementWaiter.waitWhileElementExist (loginButton);
    }

}
