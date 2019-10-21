package com.github.teranozavr.steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.apache.http.HttpResponse;
import com.github.teranozavr.log.CustomLogger;
import com.github.teranozavr.requestUtil.RequestUtil;

import java.io.IOException;

public class Then {

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
}
