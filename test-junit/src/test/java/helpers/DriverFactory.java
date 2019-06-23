package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Created by alg_adm on 20.06.2019.
 */
public abstract class DriverFactory {
    public abstract WebDriver createNewDriver();
}
