$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/BudgetApp/Login.feature");
formatter.feature({
  "name": "Операции с gosuslugi",
  "description": "",
  "keyword": "Функция"
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
  "name": "пользователь открыл страницу",
  "keyword": "Дано "
});
formatter.match({
  "location": "LoginPageStepdefs.пользовательОткрылСтраницу()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "успешная авторизация",
  "description": "",
  "keyword": "Сценарий"
});
formatter.step({
  "name": "пользователь нажал кнопку войти",
  "keyword": "Когда "
});
formatter.match({
  "location": "LoginPageStepdefs.пользовательНажалКнопкуВойти()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});