package helpers.options;

import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxOpt {
    public static FirefoxOptions FirefoxOpt(){
        System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\Geckodriver\\geckodriver.exe");
        FirefoxOptions opt = new FirefoxOptions();
        opt.setBinary("C:\\Users\\14500611\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
        return opt;
    }
}
