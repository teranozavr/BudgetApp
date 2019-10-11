package teranozavr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import teranozavr.helpers.WebElementWaiter;

/**
 * Created by Admin on 29.09.2019.
 */
public class OtusAuthorizePage extends AbstractPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[2]/input")
    private WebElement emailBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[3]/input")
    private WebElement passwordBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[4]/button")
    private WebElement loginButton;

    public OtusAuthorizePage(WebDriver driver){
        super(driver);
    }

    public void authorize(String login, String password){
        WebElementWaiter.waitAndGetElement(emailBox).sendKeys(login);
        WebElementWaiter.waitAndGetElement(passwordBox).sendKeys(password);
        WebElementWaiter.waitAndClick(loginButton);
    }
}
