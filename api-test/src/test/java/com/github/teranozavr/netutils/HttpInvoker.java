package ru.sber.cucumberTest.netutils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ByteArrayEntity;
import ru.sber.cucumberTest.requestUtil.HttpRequestEntity;

import java.io.IOException;
import java.util.Map;


public class HttpInvoker {

    private HttpClient client;

    public HttpInvoker() throws Exception {
        client = HttpClientFactory.getHttpsClient();
    }

    public HttpResponse invoke(HttpRequestEntity httpRequestEntity) {
        String url = httpRequestEntity.getUrl() + httpRequestEntity.getOperationPath();
        url = (httpRequestEntity.getQueryString().length() > 0) ? url + "?" + httpRequestEntity.getQueryString() : url;
        String method = httpRequestEntity.getMethod();
        Map<String, String> headers = httpRequestEntity.getHeaders();
        byte[] body = httpRequestEntity.getBody().getBytes();
        return invoke(url, method, headers, body);
    }

    public HttpResponse invoke(String url, String method, Map<String, String> headers, byte[] body) {
        HttpClientFactory.releaseInstance();
        try {
            client = HttpClientFactory.getHttpsClient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (method.equals("GET")) {
            return invokeGet(url, headers, body);
        }
        if (method.equals("POST")) {
            return invokePost(url, headers, body);
        }
        if (method.equals("PUT")) {
            return invokePut(url, headers, body);
        }
        if (method.equals("DELETE")) {
            return invokeDelete(url, headers, body);
        }
        if (method.equals("HEAD")) {
            return invokeHead(url, headers, body);
        }
        //fail("Unknown method");
        return null;
    }

    private HttpResponse invokePut(String url, Map<String, String> headers, byte[] body) {
        HttpPut put = new HttpPut(url);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            put.addHeader(entry.getKey(), entry.getValue());
        }
        if (body != null) {
            put.setEntity(new ByteArrayEntity(body));
        }
        HttpResponse response = null;
        try {
            response = client.execute(put);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    private HttpResponse invokeHead(String url, Map<String, String> headers, byte[] body) {
        HttpHead head = new HttpHead(url);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            head.addHeader(entry.getKey(), entry.getValue());
        }
        HttpResponse response = null;
        try {
            response = client.execute(head);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private HttpResponse invokeDelete(String url, Map<String, String> headers, byte[] body) {
        HttpDeleteWithBody delete = new HttpDeleteWithBody(url);
        for (Map.Entry<String, String> header : headers.entrySet()) {
            delete.addHeader(header.getKey(), header.getValue());
        }
        if (body != null) {
            delete.setEntity(new ByteArrayEntity(body));
        }
        HttpResponse response = null;
        try {
            response = client.execute(delete);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    private HttpResponse invokePost(String url, Map<String, String> headers, byte[] body) {
        HttpPost post = new HttpPost(url);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            post.addHeader(entry.getKey(), entry.getValue());
        }
        if (body != null) {
            post.setEntity(new ByteArrayEntity(body));
        }
        HttpResponse response = null;
        try {
            response = client.execute(post);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }

    private HttpResponse invokeGet(String url, Map<String, String> headers, byte[] body) {
        HttpGet get = new HttpGet(url);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            get.addHeader(entry.getKey(), entry.getValue());
        }
        HttpResponse response = null;
        try {
            response = client.execute(get);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response;
    }
}
