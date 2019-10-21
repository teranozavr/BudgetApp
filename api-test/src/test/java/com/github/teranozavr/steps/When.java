package ru.sber.cucumberTest.steps;

import cucumber.api.java.ru.Когда;
import ru.sber.cucumberTest.log.CustomLogger;
import ru.sber.cucumberTest.requestUtil.RequestUtil;

import java.io.File;
import java.util.Map;

public class When {

    @Когда("пользователь отправляет {word} запрос на {word}")
    public void пользователь_отправляет_запрос(String method, String operationPath) {
        RequestUtil.setMethod(method);
        RequestUtil.setOperationPath(operationPath);
    }

    @Когда("передает {word}:")
    public void передает(String contentType, Map<String, String> map) throws Exception {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] name = entry.getKey().split(" ");

            switch (name[0]) {
                case "header":
                    RequestUtil.addHeader(name[1], entry.getValue());
                    break;
                case "body":
                    RequestUtil.addBodyParam(name[1], entry.getValue());
                    break;
                case "query":
                    RequestUtil.addQueryParam(name[1], entry.getValue());
                    break;
                case "template":
                    RequestUtil.setBody(new File("data/" + entry.getValue()));
                    break;
            }

        }
        CustomLogger.logRequest(RequestUtil.getHttpRequestEntity());
        RequestUtil.invoke();

    }
}
