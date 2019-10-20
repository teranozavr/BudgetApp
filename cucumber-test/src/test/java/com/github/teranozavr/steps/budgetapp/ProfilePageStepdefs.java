package com.github.teranozavr.steps.budgetapp;

import com.github.teranozavr.pages.budgetapp.DashBoardPage.TopMenu;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Component;

public class ProfilePageStepdefs extends BaseStepdefs {

    @Когда("пользователь открыл страницу {string}")
    public void пользовательОткрылСтраницу(String arg0) {
        profilePage.open();
        //webElementWaiter.waitWhileElementExist(profilePage.busyIndicator);
    }

    @Дано("пользователь открыл вкладку Profile")
    public void пользовательОткрылВкладкуProfile() {
        profilePage.profileTab.click();
    }

    @Дано("запомнил имя и символ валюты")
    public void запомнилИмяИСимволВалюты() {
        String oldName = profilePage.nameField.getAttribute("value");
        String oldCurrency = profilePage.currencyField.getAttribute("value");
        testData.stringMap.put("oldName", oldName);
        testData.stringMap.put("oldCurrency",oldCurrency);
    }

    @Дано("ввел новое имя")
    public void ввелНовоеИмя() {
        Long ms = System.currentTimeMillis();
        String newName = ms.toString();
        testData.stringMap.put("newName", newName);
        profilePage.nameField.clear();
        profilePage.nameField.sendKeys(newName);
    }

    @Дано("сохранил изменения")
    public void сохранилИзменения() {
        profilePage.updateButton.click();
    }

    @Тогда("появилось сообщение об успешном изменении данных {string}")
    public void появилосьСообщениеОбУспешномСохраненииПрофиля(String arg0) {
        System.out.println("Пароль изменен на "+testData.stringMap.get("newPassword"));
        String successMessage = webElementWaiter.waitAndGetElement(profilePage.successAllert).getText();
        Assert.assertEquals(successMessage, arg0);
    }

    @Тогда("в поле Name содержится новое имя")
    public void вПолеNameСодержитсяНовоеИмя() {
        String actualName = webElementWaiter.waitAndGetElement(profilePage.nameField).getAttribute("value");
        String expectedName = testData.stringMap.get("newName");
        Assert.assertEquals(actualName, expectedName);
    }

    @Дано("ввел новый символ валюты")
    public void ввелНовыйСимволВалюты() {
        Long ms = System.currentTimeMillis();
        String newCurrency = (ms.toString()).substring(0,9);
        testData.stringMap.put("newCurrency", newCurrency);
        profilePage.currencyField.clear();
        profilePage.currencyField.sendKeys(newCurrency);
    }

    @Тогда("в поле Currency Symbol содержится новый символ валюты")
    public void вПолеCurrencySymbolСодержитсяНовыйСимволВалюты() {
        String actualCurrency = webElementWaiter.waitAndGetElement(profilePage.currencyField).getAttribute("value");
        String expectedCurrency = testData.stringMap.get("newCurrency");
        Assert.assertEquals(actualCurrency, expectedCurrency);
    }

    @Дано("пользователь открыл вкладку Change Password")
    public void пользовательОткрылВкладкуChangePassword() {
        profilePage.changePasswordTab.click();
    }

    @Дано("ввел текущий пароль")
    public void ввелТекущийПароль() {
        String currentPassword = env.getProperty("validPassword");
        profilePage.currentPasswordField.clear();
        profilePage.currentPasswordField.sendKeys(currentPassword);
    }
    @Дано("вернул старый пароль")
    public void вернулСтарыйПароль() {
        String currentPassword = testData.stringMap.get("newPassword");
        String oldPassword = env.getProperty("validPassword");
        profilePage.currentPasswordField.clear();
        profilePage.currentPasswordField.sendKeys(currentPassword);
        profilePage.mewPasswordField.clear();
        profilePage.mewPasswordField.sendKeys(oldPassword);
        profilePage.confirmNewPasswordField.clear();
        profilePage.confirmNewPasswordField.sendKeys(oldPassword);
    }

    @Дано("сгенерировал и ввел новый пароль")
    public void сгенерировалИВвелНовыйПароль() {
        Long ms = System.currentTimeMillis();
        String newPassword = ms.toString();
        testData.stringMap.put("newPassword", newPassword);
        profilePage.mewPasswordField.clear();
        profilePage.mewPasswordField.sendKeys(newPassword);
        profilePage.confirmNewPasswordField.clear();
        profilePage.confirmNewPasswordField.sendKeys(newPassword);        
    }

    @Дано("нажал кнопку 'Change password'")
    public void нажалКнопкуChangePassword() {
        profilePage.changePasswordButton.click();
        webElementWaiter.waitAndGetElement(profilePage.successAllert);
    }

    @Тогда("появилось сообщение об успешном изменении пароля {string}")
    public void появилосьСообщениеОбУспешномИзмененииПароля(String arg0) {
        String actualMessage = webElementWaiter.waitAndGetElement(profilePage.successAllert).getText();
        Assert.assertEquals(actualMessage,arg0);
    }

    @Дано("пользователь разлогинился")
    public void пользовательРазлогинился() {
        webElementWaiter.waitAndGetElement(topMenu.dropDown).click();
        webElementWaiter.waitAndGetElement(dropdownMenu.rootElement);
        dropdownMenu.signOutButton.click();
    }


}
