package ru.sber.cucumberTest.steps;

import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import org.apache.http.HttpResponse;
import ru.sber.cucumberTest.log.CustomLogger;
import ru.sber.cucumberTest.requestUtil.RequestUtil;

import java.io.IOException;

public class Result {

    @Тогда("пользователь получает ответ со статусом {int}")
    public void пользователь_получает_ответ_со_статусом(Integer statusCode) throws IOException {
        HttpResponse httpResponse = RequestUtil.getHttpResponse();
        //TODO: логировать коды httpResponse.getStatusLine().getStatusCode() и statusCode
        CustomLogger.logResponse(httpResponse);
        CustomLogger.logResponseCode(statusCode);
    }

    @И("текстом: {}")
    public void текстом(String statusText) {
        //TODO: логировать коды httpResponse.getStatusLine().getStatusCode() и statusCode
        CustomLogger.logResponseText(statusText);
    }
}
