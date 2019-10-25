package com.github.teranozavr.requestUtil;

import org.apache.http.HttpResponse;
import com.github.teranozavr.netutils.HttpInvoker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RequestUtil {
    private static HttpRequestEntity httpRequestEntity;
    private static HttpResponse httpResponse;

    public static void createRequest() {
        httpRequestEntity = new HttpRequestEntity(null);
    }

    public static void createRequest(String name) {
        httpRequestEntity = new HttpRequestEntity(name);
    }

    public static void deleteRequest() {
        httpRequestEntity = null;
    }

    public static void deleteResponse() {
        httpResponse = null;
    }

    public static void setUrl(String url) {
        httpRequestEntity.setUrl(url);
    }

    public static void setOperationPath(String path) {
        httpRequestEntity.setOperationPath(path);
    }

    public static void setMethod(String method) {
        httpRequestEntity.setMethod(method);
    }

    public static void addHeader(String name, String value) {
        httpRequestEntity.addHeader(name, value);
    }

    public static void addQueryParam(String name, String value) {
        String queryString = httpRequestEntity.getQueryString();
        if (queryString != null && queryString.length() != 0) {
            queryString += "&";
        }
        queryString += name + "=" + value;
        httpRequestEntity.setQueryString(queryString);
    }

    public static void setBody(String body) {
        httpRequestEntity.setBody(body);
    }

    public static void setBody(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String line = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        while (line != null) {
            stringBuilder.append(line).append("\n");
            line = bufferedReader.readLine();
        }

        String fileAsString = stringBuilder.toString();
        setBody(fileAsString);
    }

    public static void addBodyParam(String name, String value) {
        String body = httpRequestEntity.getBody();
        if (body != null && body.length() != 0) {
            body += "&";
        }
        body += name + "=" + value;
        httpRequestEntity.setBody(body);
    }

    public static HttpResponse invoke() throws Exception {
        HttpInvoker invoker = new HttpInvoker();
        httpResponse = invoker.invoke(httpRequestEntity);
        return httpResponse;
    }

    public static HttpResponse getHttpResponse() {
        return httpResponse;
    }

    public static HttpRequestEntity getHttpRequestEntity() {
        return httpRequestEntity;
    }
}
