package helpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
/**
 * Created by alg_adm on 20.06.2019.
 */
public class ChromeDriverFactory extends DriverFactory {
    @Override
    public WebDriver createNewDriver(){
        System.out.println("************************ created Chrome driver");
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
        return new ChromeDriver();
    }
}
