package com.github.teranozavr.log;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import com.github.teranozavr.requestUtil.HttpRequestEntity;
import org.junit.Assert;
import java.io.IOException;
import java.util.Map;
import static com.github.teranozavr.log.HtmlReporter.*;


public class CustomLogger {
    private final static Logger LOGGER_REQUEST = Logger.getLogger("REQUEST");
    private final static Logger LOGGER_RESPONSE = Logger.getLogger("RESPONSE");
    private final static Logger LOGGER_INFO = Logger.getLogger("INFO");
    private static StringBuilder stringBuilder;
    private static int statusCode;
    private static String statusText;
    private static int expectedStatusCode;
    private static String expectedStatusText;

    public static void logRequest(HttpRequestEntity httpRequestEntity) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\t").append("name:").append(httpRequestEntity.getName()).append("\n");//TODO: добавить инфу запроса
        stringBuilder.append("\t").append("endpoint:").append(httpRequestEntity.getUrl()).append("\n");
        if (httpRequestEntity.getQueryString() != null && httpRequestEntity.getQueryString().length() != 0)
            stringBuilder.append("\t").append("query:").append(httpRequestEntity.getQueryString()).append("\n");
        if (httpRequestEntity.getHeaders() != null && httpRequestEntity.getHeaders().size() != 0) {
            stringBuilder.append("\t").append("headers:").append("\n");
            for (Map.Entry<String, String> entry : httpRequestEntity.getHeaders().entrySet()) {
                stringBuilder.append("\t\t").append("|").append(entry.getKey()).append("|").append(entry.getValue()).append("|").append("\n");
            }
        }
        if (httpRequestEntity.getBody() != null && httpRequestEntity.getBody().length() != 0) {
            stringBuilder.append("\t").append("body:").append(httpRequestEntity.getBody().replace("\n", ""));
        }
        LOGGER_REQUEST.info(stringBuilder.toString());
    }

    private static String getRqUIDFromRequestEntity(HttpRequestEntity httpRequestEntity) {
        String result = "No RqUID";
        String rquid = httpRequestEntity.getHeader("RqUID");
        String xIntrospectRquid = httpRequestEntity.getHeader("x-Introspect-RqUID");
        return rquid != null ? rquid : (xIntrospectRquid != null ? xIntrospectRquid : result);
    }

    public static void logResponse(HttpResponse response) throws IOException {
        stringBuilder = new StringBuilder();
        StatusLine statusLine = response.getStatusLine();
        statusCode = statusLine.getStatusCode();
        statusText = EntityUtils.toString(response.getEntity(), "UTF-8").replace("\n", "");
        stringBuilder.append("\t").append("statusCode:").append(statusCode).append("\n");
        stringBuilder.append("\t").append("statusMessage:").append(statusText).append("\n");
        statusText = statusText.replace(" ", "");
    }

    public static void logResponseCode(int expectedStatusCode) {
        CustomLogger.expectedStatusCode = expectedStatusCode;
        stringBuilder.append("\t").append("expectedStatusCode:").append(expectedStatusCode);

    }

    public static void logResponseText(String expectedStatusText) {
        System.out.println(expectedStatusText.length());
        if (expectedStatusText != null) {
            CustomLogger.expectedStatusText = expectedStatusText.replace(" ", "");
            stringBuilder.append("\n");
            stringBuilder.append("\t").append("expectedStatusText:").append(expectedStatusText);
        }
    }

    public static void checkResponse() throws IOException {
        if (statusCode == expectedStatusCode && (expectedStatusText == null || statusText.equals(expectedStatusText))) {
            LOGGER_RESPONSE.info(stringBuilder.toString());
            writeTestResult(true);
        } else {
            LOGGER_RESPONSE.error(stringBuilder.toString());
            writeTestResult(false);
        }
        Assert.assertEquals(statusCode,expectedStatusCode);
    }

    public static void logRequestError(String error) {
        LOGGER_REQUEST.error("\t" + error);
    }

    public static void logInfo(String infoMsg) throws IOException {
        LOGGER_INFO.info(infoMsg);
        writeTestName(infoMsg.substring(18, infoMsg.length()));
    }

    public static void clear(){
        stringBuilder = null;
        statusCode = -1;
        statusText = null;
        expectedStatusCode = -1;
        expectedStatusText = null;
    }
}