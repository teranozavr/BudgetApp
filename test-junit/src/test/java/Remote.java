import com.sun.glass.ui.View;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.junit.*;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.Map;

/**
 * Created by Admin on 09.08.2019.
 */
public class Remote {
    @Test
    public void testAlert() throws Exception {

        System.setProperty("webdriver.chrome.driver","C:/GIT/Autotest/test-junit/src/test/resources//Driver/chromedriver.exe");

        Capabilities c1=new Capabilities() {
            @Override
            public Map<String, Object> asMap() {
                return null;
            }

            @Override
            public Object getCapability(String s) {
                return null;
            }
        };

        ChromeOptions cap = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.100.8:4445/wd/hub/"), c1);

        driver.get("https://htmlweb.ru/java/js1.php");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.cssSelector("code"));
        driver.quit();
    }
}
