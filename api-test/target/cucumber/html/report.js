$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/UserData.feature");
formatter.feature({
  "name": "Авторизация",
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
  "name": "получены данные пользователя",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.полученыДанныеПользователя()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.userSendRequest(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Изменение имени пользоателя /api/users/auth",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@2.1"
    }
  ]
});
formatter.step({
  "name": "пользователь меняет значение \"key\" поля \"value\"",
  "rows": [
    {
      "cells": [
        "key",
        "value"
      ]
    },
    {
      "cells": [
        "name",
        "Вася"
      ]
    }
  ],
  "keyword": "Когда "
});
formatter.match({
  "location": "Given.пользовательМеняетЗначениеПоля(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь отправляет PUT запрос на /api/users",
  "keyword": "Когда "
});
formatter.match({
  "location": "When.пользователь_отправляет_запрос(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "передает application/json:",
  "rows": [
    {
      "cells": [
        "header Content-Type",
        "application/json;charset\u003dUTF-8"
      ]
    },
    {
      "cells": [
        "template",
        "changedNameUserData"
      ]
    }
  ],
  "keyword": "И "
});
formatter.match({
  "location": "When.передает(String,String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "пользователь получает ответ со статусом 200",
  "keyword": "Тогда "
});
formatter.match({
  "location": "Then.пользователь_получает_ответ_со_статусом(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "error_message": "java.lang.AssertionError: expected:\u003c200\u003e but was:\u003c401\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:743)\r\n\tat org.junit.Assert.assertEquals(Assert.java:118)\r\n\tat org.junit.Assert.assertEquals(Assert.java:555)\r\n\tat org.junit.Assert.assertEquals(Assert.java:542)\r\n\tat com.github.teranozavr.log.CustomLogger.checkResponse(CustomLogger.java:81)\r\n\tat com.github.teranozavr.hooks.Hook.finish(Hook.java:19)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:497)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:49)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:123)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat cucumber.api.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:147)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:160)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
});
});