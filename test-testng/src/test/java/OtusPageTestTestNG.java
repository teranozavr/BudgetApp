/**
 * Created by Admin on 08.06.2019.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OtusPageTestTestNG {
    @Test

    //Попробовал ипользовать TestNG и использовать Firefox
    public void checkURLTest(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://otus.ru/");
        Assert.assertEquals(driver.getCurrentUrl(),"https://otus.ru/");
        driver.close();
    }
}
