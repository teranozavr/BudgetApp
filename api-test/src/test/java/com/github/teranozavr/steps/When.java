package com.github.teranozavr.steps;

import com.github.teranozavr.helpers.TestData;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Когда;
import com.github.teranozavr.log.CustomLogger;
import com.github.teranozavr.requestUtil.RequestUtil;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.File;
import java.util.Map;

public class When {

    @Autowired
    TestData testData;

    @Autowired
    Environment env;


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
                    String tokenKeyName = entry.getValue().toString();
                    String lowerCaseHeaderName = name[1].toLowerCase();
                    if(lowerCaseHeaderName.equals("authorization") && (tokenKeyName.equals("token")))
                    {
                        String token = getTokenFromTestData(tokenKeyName);
                        String authorizationValue = "Bearer "+token;
                        RequestUtil.addHeader(name[1], authorizationValue);
                    }
                    else RequestUtil.addHeader(name[1], entry.getValue());
                    break;
                case "body":
                    RequestUtil.addBodyParam(name[1], entry.getValue());
                    break;
                case "query":
                    RequestUtil.addQueryParam(name[1], entry.getValue());
                    break;
                case "template":
                {   String body=null;
                    try {
                        body = testData.jsonMap.get(entry.getValue()).toString();
                    }
                    catch (Exception ex){};

                    if (body==null)
                    {
                        RequestUtil.setBody(new File("src/test/resources/data/" + entry.getValue()));
                        break;
                    }
                    else {
                        RequestUtil.setBody(body);
                        break;
                    }
                }
            }
        }
        CustomLogger.logRequest(RequestUtil.getHttpRequestEntity());
        RequestUtil.invoke();
    }

    private String getTokenFromTestData(String tokenKeyName){
        JSONObject json = testData.jsonMap.get("userData");
        String token = json.get("token").toString();
        return token;
    }
}
