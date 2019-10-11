package teranozavr.helpers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static teranozavr.helpers.WebElementWaiter.WebElementWaiter;
import static teranozavr.helpers.options.ChromeOpt.ChromeOpt;
import static teranozavr.helpers.options.FirefoxOpt.FirefoxOpt;
import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

/**
 * Created by alg_adm on 20.06.2019.
 */
public class DriverFactory {
    private static WebDriver driver;
    private static MutableCapabilities caps;

    public static WebDriver createNewDriver(String browserName, MutableCapabilities capabilities) {

        if (browserName == null)
            throw new RuntimeException(browserName + " is not a parameter!");

        if (browserName.isEmpty())

            throw new RuntimeException(browserName + " is empty!");

        switch (browserName.toLowerCase()) {
            case CHROME: {
                caps = ChromeOpt();
                driver = capabilities==null ? new ChromeDriver(caps) : new ChromeDriver(capabilities);
                WebElementWaiter(driver, 6, 10);
                return driver;
            }
            case FIREFOX: {
                caps = FirefoxOpt();
                driver = capabilities==null ? new FirefoxDriver(caps) : new FirefoxDriver(capabilities);
                WebElementWaiter(driver, 6, 10);
                return driver;
            }
            default: {
                System.out.println("****************Browser name error: " + browserName);
                throw new RuntimeException(browserName + " must be Chrome or Firefox");
            }
        }
    }

    public static WebDriver createNewDriver(String browserName)
    {
       return createNewDriver(browserName, null);
    }

}
