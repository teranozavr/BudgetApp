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
  "name": "пользователь получает токен доступа",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.пользовательПолучаетТокенДоступа()"
});
formatter.result({
  "error_message": "java.lang.IllegalStateException: Target host is null\r\n\tat org.apache.http.util.Asserts.notNull(Asserts.java:46)\r\n\tat org.apache.http.impl.conn.DefaultHttpRoutePlanner.determineRoute(DefaultHttpRoutePlanner.java:98)\r\n\tat org.apache.http.impl.client.DefaultRequestDirector.determineRoute(DefaultRequestDirector.java:762)\r\n\tat org.apache.http.impl.client.DefaultRequestDirector.execute(DefaultRequestDirector.java:381)\r\n\tat org.apache.http.impl.client.AbstractHttpClient.doExecute(AbstractHttpClient.java:863)\r\n\tat org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:82)\r\n\tat org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:106)\r\n\tat org.apache.http.impl.client.CloseableHttpClient.execute(CloseableHttpClient.java:57)\r\n\tat com.github.teranozavr.netutils.HttpInvoker.invokeGet(HttpInvoker.java:129)\r\n\tat com.github.teranozavr.netutils.HttpInvoker.invoke(HttpInvoker.java:37)\r\n\tat com.github.teranozavr.netutils.HttpInvoker.invoke(HttpInvoker.java:26)\r\n\tat com.github.teranozavr.requestUtil.RequestUtil.invoke(RequestUtil.java:82)\r\n\tat com.github.teranozavr.steps.Given.пользовательПолучаетТокенДоступа(Given.java:35)\r\n\tat ✽.пользователь получает токен доступа(file:src/test/resources/features/UserData.feature:6)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "пользователь отправляет запрос на апи по адресу http://otus-test-budget-app.herokuapp.com",
  "keyword": "Дано "
});
formatter.match({
  "location": "Given.userSendRequest(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Успешная авторизация /api/users/auth",
  "description": "",
  "keyword": "Сценарий",
  "tags": [
    {
      "name": "@2.1"
    }
  ]
});
formatter.step({
  "name": "пользователь отправляет POST запрос на /api/users/auth",
  "keyword": "Когда "
});
formatter.match({
  "location": "When.пользователь_отправляет_запрос(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "передает application/json:",
  "rows": [
    {
      "cells": [
        "header Accept",
        "application/json, text/plain, */*"
      ]
    },
    {
      "cells": [
        "header Accept-Encoding",
        "gzip, deflate"
      ]
    },
    {
      "cells": [
        "header Accept-Language",
        "ru-RU,ru;q\u003d0.9,en-US;q\u003d0.8,en;q\u003d0.7"
      ]
    },
    {
      "cells": [
        "header Authorization",
        "Basic undefined"
      ]
    },
    {
      "cells": [
        "header Connection",
        "keep-alive"
      ]
    },
    {
      "cells": [
        "header Host",
        "otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Origin",
        "http://otus-test-budget-app.herokuapp.com"
      ]
    },
    {
      "cells": [
        "header Referer",
        "http://otus-test-budget-app.herokuapp.com/"
      ]
    },
    {
      "cells": [
        "User-Agent",
        "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.120 Safari/537.36"
      ]
    },
    {
      "cells": [
        "header Content-Type",
        "application/json;charset\u003dUTF-8"
      ]
    },
    {
      "cells": [
        "template",
        "api_user_auth_success.json"
      ]
    }
  ],
  "keyword": "И "
});
formatter.match({
  "location": "When.передает(String,String,String\u003e)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "пользователь получает ответ со статусом 200",
  "keyword": "Тогда "
});
formatter.match({
  "location": "Then.пользователь_получает_ответ_со_статусом(Integer)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "error_message": "java.lang.NullPointerException\r\n\tat com.github.teranozavr.log.CustomLogger.checkResponse(CustomLogger.java:75)\r\n\tat com.github.teranozavr.hooks.Hook.finish(Hook.java:20)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)\r\n\tat sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)\r\n\tat sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)\r\n\tat java.lang.reflect.Method.invoke(Method.java:497)\r\n\tat cucumber.runtime.Utils$1.call(Utils.java:26)\r\n\tat cucumber.runtime.Timeout.timeout(Timeout.java:16)\r\n\tat cucumber.runtime.Utils.invoke(Utils.java:20)\r\n\tat cucumber.runtime.java.JavaHookDefinition.execute(JavaHookDefinition.java:60)\r\n\tat cucumber.runner.HookDefinitionMatch.runStep(HookDefinitionMatch.java:16)\r\n\tat cucumber.runner.TestStep.executeStep(TestStep.java:65)\r\n\tat cucumber.runner.TestStep.run(TestStep.java:50)\r\n\tat cucumber.runner.TestCase.run(TestCase.java:50)\r\n\tat cucumber.runner.Runner.runPickle(Runner.java:49)\r\n\tat cucumber.runtime.junit.PickleRunners$NoStepDescriptions.run(PickleRunners.java:146)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:68)\r\n\tat cucumber.runtime.junit.FeatureRunner.runChild(FeatureRunner.java:23)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat cucumber.runtime.junit.FeatureRunner.run(FeatureRunner.java:73)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:123)\r\n\tat cucumber.api.junit.Cucumber.runChild(Cucumber.java:65)\r\n\tat org.junit.runners.ParentRunner$3.run(ParentRunner.java:238)\r\n\tat org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:63)\r\n\tat org.junit.runners.ParentRunner.runChildren(ParentRunner.java:236)\r\n\tat org.junit.runners.ParentRunner.access$000(ParentRunner.java:53)\r\n\tat org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:229)\r\n\tat cucumber.api.junit.Cucumber$RunCucumber.evaluate(Cucumber.java:147)\r\n\tat org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)\r\n\tat org.junit.runners.ParentRunner.run(ParentRunner.java:309)\r\n\tat org.junit.runner.JUnitCore.run(JUnitCore.java:160)\r\n\tat com.intellij.junit4.JUnit4IdeaTestRunner.startRunnerWithArgs(JUnit4IdeaTestRunner.java:68)\r\n\tat com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)\r\n\tat com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)\r\n",
  "status": "failed"
});
});