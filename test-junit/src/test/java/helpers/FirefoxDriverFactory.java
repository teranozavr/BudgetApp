package helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by alg_adm on 20.06.2019.
 */
public class FirefoxDriverFactory extends DriverFactory {
    @Override
    public WebDriver createNewDriver(){
        return new FirefoxDriver();
    }
}
