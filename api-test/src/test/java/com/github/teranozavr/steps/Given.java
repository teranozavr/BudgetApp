package com.github.teranozavr.steps;

import com.github.teranozavr.config.ApiConfig;
import com.github.teranozavr.helpers.TestData;
import com.github.teranozavr.log.CustomLogger;
import com.github.teranozavr.requestUtil.RequestUtil;
import cucumber.api.java.ru.Дано;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApiConfig.class)
public class Given {
    @Autowired
    TestData testData;

    @Autowired
    Environment env;

    @Дано("пользователь отправляет запрос на апи по адресу {word}")
    public void userSendRequest(String endPoint) {
        RequestUtil.setUrl(endPoint);
    }

    @Дано("пользователь получает токен доступа")
    public void пользовательПолучаетТокенДоступа() throws Exception {
        RequestUtil.setMethod("GET");
        RequestUtil.setOperationPath("/api/users/auth");
        RequestUtil.addHeader("Content-Type", "application/json;charset=UTF-8");
        String login = env.getProperty("validLogin");
        String password = env.getProperty("validPassword");
        RequestUtil.setBody("{\"username\":\""+login+"\",\"password\":\""+password+"\"}");
        CustomLogger.logRequest(RequestUtil.getHttpRequestEntity());
        RequestUtil.invoke();
        HttpResponse httpResponse = RequestUtil.getHttpResponse();

        CustomLogger.checkResponse();
        RequestUtil.deleteRequest();
        RequestUtil.deleteResponse();
        CustomLogger.clear();

    }
}
