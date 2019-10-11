package teranozavr.helpers.options;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeOpt {
    public static MutableCapabilities ChromeOpt()
    {
        System.setProperty("webdriver.chrome.driver", "src\\teranozavr.Lesson15.test\\resources\\Drivers\\ChromeDriver\\v76\\chromedriver.exe");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        try {
            options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        }
        catch (Exception ex) {
            System.err.println("Настройте путь к chrome.exe в классе ChromeOpt");
        }
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        return capabilities;
    }

}
