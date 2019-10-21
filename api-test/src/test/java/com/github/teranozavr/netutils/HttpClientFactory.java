package com.github.teranozavr.netutils;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

public class HttpClientFactory {
    private static CloseableHttpClient client;

    public static HttpClient getHttpsClient() throws Exception {

        if (client != null) {
            return client;
        }
        //TODO реализовать HTTPS клиент
        return null;
    }

    public static HttpClient getHttpClient() throws Exception {

        if (client != null) {
            return client;
        }
        return new DefaultHttpClient();
    }

    public static void releaseInstance() {
        client = null;
    }
}
