package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static helpers.WebElementWaiter.*;

/**
 * Created by Admin on 29.09.2019.
 */
public class OtusLK extends AbstractPage {

    @FindBy (xpath = "/html/body/div[1]/div/div[4]/div[3]/div[2]/div[2]/div/form")
    private WebElement personalForm;

    @FindBy(className = "js-custom-select-options-container")
    private WebElement linkTypeChooseForm;

    @FindBy(className = "lk-cv-block__input_fake lk-cv-block__input_select-fake js-custom-select-presentation")
    private WebElement linkTypeDropDown;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[2]/input")
    private WebElement emailBox;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[3]/div[2]/div[2]/form/div[3]/input")
    private WebElement passwordBox;

    @FindBy( className = "lk-cv-block__action lk-cv-block__action_md-no-spacing js-formset-add js-lk-cv-custom-select-add")
    private WebElement addButton;

    @FindBy( xpath = "/html/body/div[1]/div/div[2]/div/div/div/a[6]")
    private WebElement aboutMeButton;

    @FindBy( name = "continue")
    private WebElement saveAndContinueButton;

    @FindBy(name = "fname")
    private WebElement fnameBox;

    @FindBy(name = "fname_latin")
    private WebElement fnameLatinBox;

    @FindBy(name = "lname")
    private WebElement lnameBox;

    @FindBy(name = "lname_latin")
    private WebElement lnameLatinBox;

    @FindBy(name = "blog_name")
    private WebElement blogNameBox;

    @FindBy(name = "date_of_birth")
    private WebElement birthDateBox;

    @FindBy(name = "company")
    private WebElement companyBox;

    @FindBy(name = "work")
    private WebElement workBox;

    public OtusLK(WebDriver driver){
        super(driver);
        driver.get("https://otus.ru/lk");
    }

    public void navigateToAboutMe()
    {
        driver.get("https://otus.ru/lk/biography/personal/");
    }

    private void fill(WebElement el, String text){
        waitAndGetElement(el).clear();
        waitAndGetElement(el).sendKeys(text);
    }

    private void clean(WebElement el){
        waitAndGetElement(el).clear();
    }

    private boolean validate(WebElement el, String text){
        System.out.println("Recieved value: "+el.getAttribute("value")+" Expected value:"+text);
        return waitAndGetElement(el).getAttribute("value").equals(text);
    }

    private void fillContact (String type, String text, int num)
    {
        WebElement e = waitAndGetElement(By.tagName("span"), null, "Способ связи");
        clickElement(e);
        //Это костыль из-за динамически появляющихся новых объектов
        while (true) {
            try {
                List<WebElement> buttons = waitAndGetElements(By.tagName("button"), "title", type);
                System.out.println(waitAndGetElements(By.tagName("button"), "title", type).size());
                if(buttons.size()>1)
                {
                    for (WebElement el: buttons){
                        if(waitAndGetElement(el)!=null&&waitAndGetElement(el).isDisplayed()) clickElement(el);
                    }
                }
                else {
                    WebElement button = waitAndGetElement(By.tagName("button"), "title", type);
                    clickElement(button);
                }
                waitAndGetElement(By.id("id_contact-" + num + "-value")).sendKeys(text);
                break;
            } catch (Exception e1) {
            }
        }
    }

    private void clickElement(WebElement el)
    {
        new Actions(driver).moveToElement(waitAndGetElement(el)).click().build().perform();
    }

    private void addContact(){
        waitAndGetElement(personalForm);
        System.out.println("addContact");
        waitAndClickElement(By.tagName("button"), null, "Добавить");
    }

    public void fillData(){
        fill(fnameBox, "Илья");
        fill(fnameLatinBox,"Ilya");
        fill(lnameBox, "Козырев");
        fill(lnameLatinBox,"Kozyrev");
        fill(blogNameBox, "Илья");
        fill(birthDateBox,"10.07.1987");
        fill(companyBox,"Сбертех");
        fill(workBox,"Ведущий ИТ-инженер");
        fillContact("Skype", "SUBCASTLE", 0);
        addContact();
        fillContact("VK", "thestadowhideyou", 1);
    }

    public void cleanData(){
        cleanContacts();
        clean(fnameBox);
        clean(fnameLatinBox);
        clean(lnameBox);
        clean(lnameLatinBox);
        clean(blogNameBox);
        clean(birthDateBox);
        clean(companyBox);
        clean(workBox);
    }

    public void cleanContacts(){
        List<WebElement> contactList = waitAndGetElements(By.tagName("button"), null,"Удалить");
        for(WebElement el : contactList)
        {
           waitAndClick(el);
        }

        save();
        navigateToAboutMe();
    }


    public boolean validateData(){
        return
        validate(fnameBox, "Илья")&&
        validate(fnameLatinBox,"Ilya")&&
        validate(lnameBox, "Козырев")&&
        validate(lnameLatinBox,"Kozyrev")&&
        validate(blogNameBox, "Илья")&&
        validate(birthDateBox,"10.07.1987")&&
        validate(companyBox,"Сбертех")&&
        validate(workBox,"Ведущий ИТ-инженер")&&
        validate(waitAndGetElement(By.id("id_contact-0-value")),"SUBCASTLE")&&
        validate(waitAndGetElement(By.id("id_contact-1-value")),"thestadowhideyou");
    }

    public void save(){
        saveAndContinueButton.click();
        waitAndGetElement(By.tagName("span"),null, "Данные успешно сохранены");
    }
}
