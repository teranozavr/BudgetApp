package com.github.teranozavr.steps;

import com.github.teranozavr.helpers.TestData;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.apache.http.HttpResponse;
import com.github.teranozavr.log.CustomLogger;
import com.github.teranozavr.requestUtil.RequestUtil;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

public class Then {
    @Autowired
    TestData testData;

    @Autowired
    Environment env;

    @Тогда("пользователь получает ответ со статусом {int}")
    public void пользователь_получает_ответ_со_статусом(Integer statusCode) throws IOException {
        HttpResponse httpResponse = RequestUtil.getHttpResponse();
        CustomLogger.logResponse(httpResponse);
        CustomLogger.logResponseCode(statusCode);
    }

    @И("текстом: {}")
    public void текстом(String statusText) {
        CustomLogger.logResponseText(statusText);
    }

    @Тогда("ответ содержит значение \"key\" поля \"value\"")
    public void ответСодержитЗначениеПоля(Map<String, String> map) throws IOException {
        JSONObject userData = new JSONObject(RequestUtil.getHttpRequestEntity().getBody());

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] key = entry.getKey().split(" ");
            String value = entry.getValue();
            Assert.assertEquals(value, userData.get(key[0]));
        }
    }
}
