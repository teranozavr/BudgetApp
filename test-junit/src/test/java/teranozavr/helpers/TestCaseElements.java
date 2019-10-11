package teranozavr.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.List;

/**
 * Created by Admin on 08.08.2019.
 */
public class TestCaseElements{

    public TestCaseElements(WebElement element){
        testCases = new ArrayList<>();
        findTestcases(element);
    }

    public List<WebElement> getTestCases()
    {
        return this.testCases;
    }

    public int size(){
        return testCases.size();
    }
    private List<WebElement> testCases;

    private void findTestcases(WebElement element)
    {
        findUl(element);
    }

    private void findUl(WebElement rootElement)
    {
        List<WebElement> elementList = rootElement.findElements(By.tagName("ul"));
        if(elementList.size()>0)
        {
            for (WebElement e:elementList)
            {
                if(e.getTagName().equals("li"))
                    findLi(e, rootElement);
            }
        }
    }
    private void findLi(WebElement rootElement, WebElement ancestorElement)
    {
        List<WebElement> elementList = rootElement.findElements(By.tagName("li"));
        if(elementList.size()>0)
        {
            for (WebElement e:elementList)
            {
               if(e.getTagName().equals("ul"))
                   findUl(e);
            }
        }
        else
        if(ancestorElement!=null)
        {
            addTestcase(ancestorElement);
        }
    }

    private void addTestcase(WebElement element)
    {
        boolean _isElementExist = false;
        if (testCases.size()>0)
        {
            for (WebElement e : testCases)
            {
                if(e.getAttribute("id").equals(element.getAttribute("id")))
                {
                    _isElementExist=true;
                }
            }
        }
        if(!_isElementExist) {
            testCases.add(element);
        }
    }
}
