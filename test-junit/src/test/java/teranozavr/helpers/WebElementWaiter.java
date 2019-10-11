package teranozavr.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WebElementWaiter {

    public static WebDriverWait wait;
    public static WebElement element;
    public static WebDriver webDriver;

    public static void WebElementWaiter(WebDriver driver, long timeout, long sleep)

    {
        wait = new WebDriverWait(driver, timeout, sleep);
        webDriver = driver;
    }

    public static void waitAndClick(By by)
    {

        try {
            System.out.println("Try to click element "+by.toString());
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
            System.out.println("Try to click element "+el.toString());
            element = wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.elementToBeClickable(el));
            element.click();
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+el.toString());
        }
    }

    public static void waitWhileElementExist(By by) {
        System.out.println("Wait while element exist " + by.toString());
        while (true) {
            try {
                webDriver.findElement(by);
                System.out.println("Waiting...");
                //wait.ignoring(java.lang.NullPointerException.class).withTimeout(Duration.ofMillis(1000));
            } catch (Exception ex) {
                System.out.println("Continue");
                return;
            }
        }
    }

    public static void waitWhileElementExist(WebElement element) {
        System.out.println("Wait while element exist " + element.toString());
        while (true) {
            try {
                element.isDisplayed();
                System.out.println("Waiting...");
                //wait.ignoring(java.lang.NullPointerException.class).withTimeout(Duration.ofMillis(1000));
            } catch (Exception ex) {
                System.out.println("Continue");
                return;
            }
        }
    }

    public static void waitWhileElementNotClicable(By by) {
        System.out.println("Wait while element not clicable " + by.toString());
        try {
                wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.elementToBeClickable(by));
            System.out.println("Continue");
            } catch (Exception ex) {
                return;
            }
    }

    public static WebElement waitAndGetElement(By by)
    {
        try {
            System.out.println("Try to get element "+by.toString());
            element = wait.ignoring(java.lang.NullPointerException.class).until(ExpectedConditions.elementToBeClickable(by));
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
            wait.ignoring(NoSuchElementException.class)
                    .ignoring(java.lang.NullPointerException.class)
                    .until(ExpectedConditions.elementToBeClickable(ancestorElement));
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+by.toString());
        }
        webElement = ancestorElement.findElement(by);
        return webElement;
    }

    //У родительского элемента "ancestorElement" ищет элемент по селектору "by", атрибут "attribute" которого  имеет значение "attributeValue"
    //P.S.: такого нигде не видел, но это очень удобно!

    public static WebElement waitAndGetElement(WebElement ancestorElement, By by, String attribute, String attributeValue)
    {
        List<WebElement> elementList;
        if (ancestorElement!=null) {

            try {
                wait.ignoring(NoSuchElementException.class)
                        .ignoring(java.lang.NullPointerException.class)
                        .until(ExpectedConditions.elementToBeClickable(ancestorElement));
            } catch (Exception ex) {
                System.err.println("Не найден элемент " + by.toString());
            }

            elementList = waitAndGetElements(ancestorElement, by);
        }
        else{
            elementList = waitAndGetElements(by);
        }

        for (WebElement e : elementList
             ) {
            try{
                if (attribute!=null)
                {
                    if(e.getAttribute(attribute).equals(attributeValue))
                    {
                        return e;
                    }
                }
                else
                {
                    if(e.getText().equals(attributeValue))
                    {
                        return e;
                    }
                }
            }
            catch (Exception ex) {
                return null;
            }
        }
        return null;
    }

    public static void waitAndClickElement(WebElement ancestorElement, By by, String attribute, String attributeValue)
    {
        waitAndGetElement(ancestorElement, by, attribute, attributeValue).click();
    }

    public static void waitAndClickElement(By by, String attribute, String attributeValue)
    {
        waitAndClick(waitAndGetElement(by, attribute, attributeValue));
    }

    public static WebElement waitAndGetElement(By by, String attribute, String attributeValue){
        return waitAndGetElement(null, by, attribute, attributeValue);
    }

    public static WebElement waitAndGetElement(WebElement element)
    {
        System.out.println("Try to get element "+element.toString());
        try {
            wait.ignoring(NoSuchElementException.class)
                    .ignoring(java.lang.NullPointerException.class)
                    .until(ExpectedConditions.elementToBeClickable(element));
        }
        catch (Exception ex){
            System.err.println("Не найден элемент "+element.toString());
        }
        return element;
    }

    public static List<WebElement> waitAndGetElements(WebElement ancestorElement, By by, String attribute, String attributeValue)
    {
        List<WebElement> elementList;
        List<WebElement> resultList = new ArrayList<>();

        if (ancestorElement!=null) {
            try {
                wait.ignoring(NoSuchElementException.class)
                        .ignoring(java.lang.NullPointerException.class)
                        .until(ExpectedConditions.elementToBeClickable(ancestorElement));
            } catch (Exception ex) {
                System.err.println("Не найден элемент " + by.toString());
            }

            elementList = waitAndGetElements(ancestorElement, by);
        }
        else{
            elementList = waitAndGetElements(by);
        }

        for (WebElement e : elementList
                ) {
            try{
                if (attribute!=null)
                {
                    if(e.getAttribute(attribute).equals(attributeValue))
                    {
                        resultList.add(e);
                    }
                }
                else
                {
                    if(e.getText().equals(attributeValue))
                    {
                        resultList.add(e);
                    }
                }
            }
            catch (Exception ex) {
                return null;
            }
        }
        return resultList.size()>0 ? resultList : null;
    }

    public static List<WebElement> waitAndGetElements(By by, String attribute, String attributeValue){
        return waitAndGetElements(null, by, attribute, attributeValue);
    }
}
