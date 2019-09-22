import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.ProxyServer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Admin on 22.09.2019.
 */
public class Lesson7 {
    private ProxyServer server = new ProxyServer(4444);
    Proxy proxy = new Proxy();
    ChromeOptions options = new ChromeOptions();
    DesiredCapabilities capabilities = new DesiredCapabilities();
    WebDriver driver ;

    @Before
    public void beforeTestActions() throws Exception{
        server = new ProxyServer(4444);
        server.start();
        System.setProperty("webdriver.chrome.driver", "src\\\\test\\\\resources\\\\Drivers\\\\ChromeDriver\\\\v76\\\\chromedriver.exe");
        server.seleniumProxy();
        proxy.setHttpProxy("localhost:4444");
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        options.addArguments("--start-maximized");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        server.newHar("testlink");
    }

    @Test
    public void proxyTest() throws Exception{
        String name = "My project "+System.currentTimeMillis();
        String prefix = "MP"+System.currentTimeMillis();
        String description = "Это мой первый проект"+System.currentTimeMillis();

        driver.get("http://localhost/testlink/index.php");
        driver.findElement(By.cssSelector("#tl_login")).sendKeys("admin");
        driver.findElement(By.cssSelector("#tl_password")).sendKeys("admin");
        driver.findElement(By.cssSelector("#login > div:nth-child(7) > input[type=submit]")).click();
        Thread.sleep(1000);
        driver.switchTo().parentFrame().switchTo().frame("mainframe");
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/a[1]")).click();
        Thread.sleep(1000);
        driver.switchTo().parentFrame().switchTo().frame("mainframe");
        driver.findElement(By.id("create")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr[2]/td[2]/input")).click();
        new Actions(driver).sendKeys(name).perform();
        driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr[3]/td[2]/input")).click();
        new Actions(driver).sendKeys(prefix).perform();
        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/iframe")).click();
        new Actions(driver).sendKeys(description).perform();
        driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr[17]/td/div/input[3]")).click();
        Thread.sleep(5000);

        WebElement table = driver.findElement(By.xpath("//*[@id=\"item_view\"]"));
        List<WebElement> aList = table.findElements(By.tagName("a"));
        WebElement project = null;
        for (WebElement a: aList
                ) {
            if(a.getText().equals(name)) project = a;
        }

        String xPathOfProject = getElementXPath(driver, project);
        String tr = xPathOfProject.substring(28,29);
        Assert.assertTrue(project.getText().equals(name));
        WebElement projectDescription = driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr["+tr+"]/td[2]/p"));
        Assert.assertTrue(projectDescription.getText().equals(description));
        WebElement projectStatus = driver.findElement(By.xpath("//*[@id=\"item_view\"]/tbody/tr["+tr+"]/td[8]/img"));
        Assert.assertTrue(projectStatus.getAttribute("Title").equals("Public"));
    }

    @After
    public void afterTestActions() throws Exception{
        Har har = server.getHar();

        try {
            File file = new File("C:\\temp\\Test_"+System.nanoTime()+".har");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(file);
            try {
                har.writeTo(fos);
            }
            finally {
                fos.close();
            }
        }
        catch (IOException e) {
            // обработка ошибки
            e.printStackTrace();
        }
        finally {
            driver.quit();
            server.stop();
        }
    }
    public String getElementXPath(WebDriver driver, WebElement element) {
        return (String)((JavascriptExecutor)driver).executeScript("gPt=function(c){if(c.id!==''){return'id(\"'+c.id+'\")'}if(c===document.body){return c.tagName}var a=0;var e=c.parentNode.childNodes;for(var b=0;b<e.length;b++){var d=e[b];if(d===c){return gPt(c.parentNode)+'/'+c.tagName+'['+(a+1)+']'}if(d.nodeType===1&&d.tagName===c.tagName){a++}}};return gPt(arguments[0]).toLowerCase();", element);
    }
}
