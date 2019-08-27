package helpers;

import com.google.sitebricks.client.Web;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebElementWaiter {

    public static WebDriverWait wait;
    public static WebElement element;
    public static List<WebElement> elementsList;
    public static WebDriver webDriver;

    public static void WebElementWaiter(WebDriver driver, long timeout, long sleep)

    {
        wait = new WebDriverWait(driver, timeout, sleep);
        webDriver = driver;
    }

    public static void waitAndClick(By by)
    {

        try {
            element = wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.presenceOfElementLocated(by));
            element.click();
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+by.toString());
        }
    }

    public static void waitAndClick(WebElement el)
    {

        try {
            element = wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.elementToBeClickable(el));
            element.click();
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+el.toString());
        }
    }

    public static WebElement waitAndGetElement(By by)
    {
        try {
            element = wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+by.toString());
        }
        return element;
    }

    public static List<WebElement> waitAndGetElements(List<WebElement> li)
    {
        try {
            wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.elementToBeClickable(li.get(0)));

        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+li.get(0).toString());
        }
        return li;
    }

    public static List<WebElement> waitAndGetElements(By by)
    {
        List<WebElement> webElements;
        try {
            wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.presenceOfElementLocated(by));
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+by.toString());
        }
        webElements = webDriver.findElements(by);
        return webElements;
    }

    public static List<WebElement> waitAndGetElements(WebElement ancestorElement, By by)
    {
        List<WebElement> webElements;
        try {
            wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.elementToBeClickable(ancestorElement));
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+by.toString());
        }
        webElements = ancestorElement.findElements(by);
        return webElements;
    }

    public static WebElement waitAndGetElement(WebElement ancestorElement, By by)
    {
        WebElement webElement;
        try {
            wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.elementToBeClickable(ancestorElement));
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+by.toString());
        }
        webElement = ancestorElement.findElement(by);
        return webElement;
    }
}
