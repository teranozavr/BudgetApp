package teranozavr.helpers;

import org.openqa.selenium.WebDriver;

import static teranozavr.helpers.DriverFactory.createNewDriver;

public class Setuper {

    public static WebDriver setupDriver()
    {
        String driverName = System.getProperty("browser");
        return driverName != null ? DriverFactory.createNewDriver(driverName) : DriverFactory.createNewDriver("chrome");
    }
}
