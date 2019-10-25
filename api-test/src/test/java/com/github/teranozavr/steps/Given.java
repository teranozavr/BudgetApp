package com.github.teranozavr.steps;

import com.github.teranozavr.config.ApiConfig;
import com.github.teranozavr.helpers.TestData;
import com.github.teranozavr.log.CustomLogger;
import com.github.teranozavr.requestUtil.RequestUtil;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import org.apache.http.HttpResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

import java.io.InputStream;
import java.util.Map;
import java.util.Scanner;

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

    @Дано("получены данные пользователя")
    public void полученыДанныеПользователя() throws Exception {
        RequestUtil.setMethod("POST");
        RequestUtil.setOperationPath("/api/users/auth");
        RequestUtil.addHeader("Content-Type", "application/json;charset=UTF-8");
        String login = env.getProperty("validLogin");
        String password = env.getProperty("validPassword");
        RequestUtil.setBody("{\"username\":\""+login+"\",\"password\":\""+password+"\"}");
        CustomLogger.logRequest(RequestUtil.getHttpRequestEntity());
        RequestUtil.setUrl(env.getProperty("endPoint"));
        RequestUtil.invoke();
        HttpResponse httpResponse = RequestUtil.getHttpResponse();
        Integer statusCode = httpResponse!=null ? httpResponse.getStatusLine().getStatusCode() : null;
        if(statusCode==200) {
            InputStream content = httpResponse.getEntity().getContent();
            Scanner scanner = new Scanner(content).useDelimiter("\\A");
            String respString = scanner.hasNext() ? scanner.next() : "";
            JSONObject userData = new JSONObject(respString);

            //Set authorization header
            if (userData != null) {
                testData.jsonMap.put("userData",userData);
            }
        } else {
            CustomLogger.logRequestError("Не удалось получить дынные пользователя");
        }
        RequestUtil.deleteRequest();
        RequestUtil.deleteResponse();
        CustomLogger.clear();
        RequestUtil.createRequest();
    }

    @Когда("пользователь меняет значение \"key\" поля \"value\"")
    public void пользовательМеняетЗначениеПоля(Map<String, String> map) {
        JSONObject userData = testData.jsonMap.get("userData");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            userData.put(key,value);
        }
        testData.jsonMap.put("changedNameUserData", userData);
    }
}
