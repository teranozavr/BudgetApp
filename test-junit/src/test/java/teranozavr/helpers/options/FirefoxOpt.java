package teranozavr.helpers.options;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirefoxOpt {
    public static MutableCapabilities FirefoxOpt(){
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\Geckodriver\\geckodriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        FirefoxOptions options = new FirefoxOptions();
        try {
            options.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        }
        catch (Exception ex){
            System.err.println("Настройте путь к firefox.exe в классе FirefoxOpt");
        }
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        return capabilities;
    }
}
