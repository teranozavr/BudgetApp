package helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import okio.Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

/**
 * Created by alg_adm on 20.06.2019.
 */
public class DriverFactory {

    public static WebDriver createNewDriver(String browserName, ChromeOptions options) {

        if (browserName == null)
            throw new RuntimeException(browserName + " is not a parameter!");

        if (browserName.isEmpty())
            throw new RuntimeException(browserName + " is empty!");

        if (options == null) createNewDriver(browserName);

        switch (browserName.toLowerCase()) {
            case CHROME: {
                WebDriverManager.chromedriver().setup();
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
                return new ChromeDriver(options);
            }
            default: {
                System.out.println("****************Browser name error: " + browserName);
                throw new RuntimeException(browserName + " must be Chrome");
            }
        }
    }

    public static WebDriver createNewDriver(String browserName) {
//        some magic

        if (browserName == null)
            throw new RuntimeException(browserName + " is not a parameter!");

        if (browserName.isEmpty())
            throw new RuntimeException(browserName + " is empty!");

        switch (browserName.toLowerCase()) {
            case CHROME: {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
                return new ChromeDriver();
            }
            case FIREFOX: {
                return new FirefoxDriver();
            }
            default: {
                System.out.println("****************Browser name error: " + browserName);
                throw new RuntimeException(browserName + " must be Chrome or Firefox");
            }
        }
    }
}
