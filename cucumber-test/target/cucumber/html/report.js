$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/GosUslugi.feature");
formatter.feature({
  "name": "Операции с gosuslugi",
  "description": "",
  "keyword": "Функция",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "успешная авторизация",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "авторизация прошла успешно",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiStepdefs.авторизацияПрошлаУспешно()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "неуспешная авторизация",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел некорректный логин или пароль",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелНекорректныйЛогинИлиПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "появилось сообщенение об ошибке авторизации",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiStepdefs.появилосьСообщенениеОбОшибкеАвторизации()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "переход в раздел \"Уведомления\" через аватар",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал на аватар",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалНаАватар()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "открылась вкладка \"https://lk.gosuslugi.ru/notifications\"",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.открыласьВкладка(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "переход в раздел \"Уведомления\" по кнопке \"Все уведомления\"",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "* "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "* "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал кнопку \"Все уведомления\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "открылась вкладка \"https://lk.gosuslugi.ru/notifications\"",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.открыласьВкладка(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "открытие дата-формы",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал на ФИО",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалНаФИО()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "открылась дата-форма",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.открыласьДатаФорма()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "закрытие дата-формы",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал на ФИО",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалНаФИО()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "открылась дата-форма",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.открыласьДатаФорма()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал на ФИО",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалНаФИО()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "закрылась дата-форма",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.закрыласьДатаФорма()"
});
formatter.result({
  "error_message": "java.lang.AssertionError: expected:\u003ctrue\u003e but was:\u003cfalse\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\r\n\tat org.junit.Assert.assertEquals(Assert.java:118)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.github.teranozavr.pages.gosuslugi.GosUslugiMainPage.checkDashboardMenuVisibility(GosUslugiMainPage.java:124)\r\n\tat com.github.teranozavr.steps.GosUslugiMainPageStepdefs.закрыласьДатаФорма(GosUslugiMainPageStepdefs.java:57)\r\n\tat ✽.закрылась дата-форма(file:src/test/resources/features/GosUslugi.feature:42)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "проверка вкладок дата-формы",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал на ФИО",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалНаФИО()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "открылась дата-форма",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.открыласьДатаФорма()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "на дата-форме присутствуют вкладки",
  "rows": [
    {
      "cells": [
        "Уведомления",
        "Документы"
      ]
    }
  ],
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.наДатаФормеПрисутствуютВкладки(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "проверка элементов на вкладке \"Документы\" на датаформе",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал на ФИО",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалНаФИО()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "открылась дата-форма",
  "keyword": "* "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.открыласьДатаФорма()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл вкладку \"Документы\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылВкладку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "на дата-форме присутствуют элементы",
  "rows": [
    {
      "cells": [
        "Паспорт",
        "Водительское удостоверение",
        "ИНН",
        "СНИЛС",
        "Загранпаспорт",
        "Полис ОМС"
      ]
    }
  ],
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.наДатаФормеПрисутствуютЭлементы(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "переход в личный кабинет",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал на ФИО",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалНаФИО()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал кнопку \"Личный кабинет\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "открылась вкладка \"https://lk.gosuslugi.ru/info\"",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.открыласьВкладка(String)"
});
formatter.result({
  "error_message": "org.junit.ComparisonFailure: expected:\u003chttps://[www.gosuslugi.ru/]\u003e but was:\u003chttps://[lk.gosuslugi.ru/info]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat org.junit.Assert.assertEquals(Assert.java:144)\r\n\tat com.github.teranozavr.pages.gosuslugi.GosUslugiMainPage.checkUrl(GosUslugiMainPage.java:105)\r\n\tat com.github.teranozavr.steps.GosUslugiMainPageStepdefs.открыласьВкладка(GosUslugiMainPageStepdefs.java:42)\r\n\tat ✽.открылась вкладка \"https://lk.gosuslugi.ru/info\"(file:src/test/resources/features/GosUslugi.feature:66)\r\n",
  "status": "failed"
});
formatter.after({
  "status": "passed"
});
formatter.background({
  "name": "",
  "description": "",
  "keyword": "Предыстория"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "пользователь открыл страницу gosuslugi.ru",
  "keyword": "Дано "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательОткрылСтраницуGosuslugiRu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь залогинен, то он разлогинивается",
  "keyword": "Если "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательЗалогиненТоОнРазлогинивается()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "на страницу с услугами по кнопке \"Все услуги\"",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@data\u003d$Client{validClient}"
    }
  ]
});
formatter.step({
  "name": "пользователь нажал кнопку \"Войти\"",
  "keyword": "* "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь ввел корректный логин и пароль",
  "keyword": "* "
});
formatter.match({
  "location": "GosUslugiStepdefs.пользовательВвелКорректныйЛогинИПароль()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь нажал кнопку \"Все услуги\"",
  "keyword": "Когда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.пользовательНажалКнопку(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "открылась вкладка \"https://www.gosuslugi.ru/category\"",
  "keyword": "Тогда "
});
formatter.match({
  "location": "GosUslugiMainPageStepdefs.открыласьВкладка(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});