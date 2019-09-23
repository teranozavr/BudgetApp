package helpers;

import org.openqa.selenium.WebDriver;

import static helpers.DriverFactory.createNewDriver;

public class Setuper {


    public static WebDriver setupDriver()
    {
        String driverName = System.getProperty("browser");
        return driverName != null ? createNewDriver(driverName) : createNewDriver("chrome");
    }
}
