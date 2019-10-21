package ru.sber.cucumberTest.steps;

import cucumber.api.java.ru.Дано;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.json.JSONObject;
import ru.sber.cucumberTest.log.CustomLogger;
import ru.sber.cucumberTest.netutils.HttpInvoker;
import ru.sber.cucumberTest.requestUtil.RequestUtil;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Given {

    @Дано("пользователь отправляет запрос получения токена по адресу {word}")
    public void getToken(String url, Map<String, String> params) throws Exception {
        String scopes = params.get("scope");
        String clientId = params.get("client_id");
        String clientSecret = params.get("client_secret");

        HttpInvoker invoker = new HttpInvoker();
        StringBuilder body = new StringBuilder();
        Map<String, String> tokenHeaders = new HashMap<>();
        body.append("grant_type=client_credentials&scope=");
        if (scopes != null)
            body.append(scopes);
        if (clientId != null) tokenHeaders.put("X-IBM-Client-Id", clientId);
        tokenHeaders.put("Authorization", "Basic " + new String(Base64.encodeBase64((clientId + ":" + clientSecret).getBytes())));
        tokenHeaders.put("Content-Type", "application/x-www-form-urlencoded");
        tokenHeaders.put("RqUID", "12345678901234567890123456789012");
        HttpResponse response = invoker.invoke(url, "POST", tokenHeaders, body.toString().getBytes());
        if(response!=null && response.getStatusLine().getStatusCode()==200) {
            InputStream content = response.getEntity().getContent();
            Scanner scanner = new Scanner(content).useDelimiter("\\A");
            String respString = scanner.hasNext() ? scanner.next() : "";
            JSONObject jsonRs = new JSONObject(respString);
            String accessToken = jsonRs.getString("access_token");
            //Set authorization header
            if (accessToken != null) {
                RequestUtil.addHeader("Authorization", "Bearer " + accessToken);
            }
        } else {
            CustomLogger.logRequestError("Не удалось получить токен");
        }
    }

    @Дано("пользователь отправляет запрос на апи по адресу {word}")
    public void userSendRequest(String endPoint) {
        RequestUtil.setUrl(endPoint);
    }

}
