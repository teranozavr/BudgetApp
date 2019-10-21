package ru.sber.cucumberTest.netutils;

import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.net.ssl.SSLContext;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

/**
 * Created by SBT-Ovchinnikov-DK on 22.03.2018.
 */
public class HttpClientFactory {
    private static CloseableHttpClient client;

    public static HttpClient getHttpsClient() throws Exception {

        if (client != null) {
            return client;
        }

        KeyStore keyStore = KeyStore.getInstance("PKCS12");

        InputStream keyStoreInput = new FileInputStream("./client.p12");
        keyStore.load(keyStoreInput, "1qA2wS3eD$".toCharArray());
        keyStoreInput.close();

        SSLContext sslcontext = SSLContexts.custom()
                .loadKeyMaterial(keyStore, "1qA2wS3eD$".toCharArray())
                .loadTrustMaterial(keyStore, new TrustSelfSignedStrategy())
                .build();

        SSLConnectionSocketFactory factory = new SSLConnectionSocketFactory(
                sslcontext,
                SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);


        client = HttpClients.custom().setSSLSocketFactory(factory)
               .build();
        return client;
    }

    public static void releaseInstance() {
        client = null;
    }
}
