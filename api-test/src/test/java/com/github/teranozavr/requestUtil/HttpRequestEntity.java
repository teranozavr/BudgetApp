package com.github.teranozavr.requestUtil;

import java.util.HashMap;

public class HttpRequestEntity {
    private final String name;
    private String url;
    private String operationPath;
    private String method;
    private HashMap<String, String> headers = new HashMap<>();
    private String queryString = "";
    private String body = "";

    public HttpRequestEntity(String name) {
        this.name = name;
    }

    public String getQueryString() {
        return queryString;
    }

    public String getUrl() {
        return url;
    }

    public String getOperationPath() {
        return operationPath;
    }

    public String getMethod() {
        return method;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public String getHeader(String headerName) {
        return headers.get(headerName);
    }

    public String getBody() {
        return body;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setOperationPath(String path) {
        operationPath = path;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void addHeader(String headerName, String headerValue) {
        headers.put(headerName, headerValue);
    }

    public void deleteHeader(String headerName) {
        headers.remove(headerName);
    }

    public String getName() {
        return name;
    }
}
