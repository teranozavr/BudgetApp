package helpers.options;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOpt {
    public static ChromeOptions ChromeOpt()
    {
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary("C:\\Users\\14500611\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe");
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\ChromeDriver\\v76\\chromedriver.exe");
        return opt;
    }

}
