import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static teranozavr.helpers.DriverFactory.createNewDriver;

public class Lesson8Drive2 {
    private static final Logger logger = LogManager.getLogger(FirstTest.class);
    public static WebDriver driver;
  /*  private Drive2CarsPage drive2CarsPage;

    public Lesson8Drive2(){
        this.drive2CarsPage = new Drive2CarsPage();
    }*/
    @Before
    public void setUp() {
        System.setProperty("browser","chrome");
        String sysProp = System.getProperty("browser");
        driver = createNewDriver(sysProp);
    }

    @After
    public void tearDown() {
        if(driver != null)
        {
            driver.quit();
        }
    }

    @Test
    public void test10() throws Throwable
    {
        //открываем тестлинк и логинимся
        driver.get("https://www.drive2.ru/cars/audi/a8/g3353/");
        //Thread.sleep(10000);
        //driver.findElement(By.partialLinkText("https://www.drive2.ru/cars/audi/a8/m29/")).click();
        //driver.findElement(By.cssSelector("body > div.l-body > main > div > div.yXqjN0HMA.js-page > div.yXqjN0HMAaAilwRY.yVaje3ngQKAvp3xG9BA > div.yUajf3XsGLg.yUajf3XsGLg--content > nav > div:nth-child(5) > span:nth-child(3) > a")).click();
        String currentPageSource = driver.getPageSource();
        String newPageSource = "";
        int i=0;
        while (!currentPageSource.equals(newPageSource)) {
            currentPageSource = newPageSource;
            new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(10000);
            newPageSource = driver.getPageSource();
            System.out.println(i++);
        }
        List<WebElement> els = driver.findElements(By.className("c-car-card-sa__caption"));
        for(int j=0;i<els.size();i++)
        {
            System.out.println("Car "+j+" name:"+els.get(i).toString());
        }
/*
        for(WebElement el : els){
            System.out.println(el.getAttribute("text"));

        }
*/
    }
}
