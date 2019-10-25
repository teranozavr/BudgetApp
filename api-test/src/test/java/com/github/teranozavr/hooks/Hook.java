package com.github.teranozavr.hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.github.teranozavr.log.CustomLogger;
import com.github.teranozavr.requestUtil.RequestUtil;
import java.io.IOException;

public class Hook {

    @Before
    public void initRequestEntity(Scenario scenario) throws IOException {
        CustomLogger.logInfo("Выполение запроса " + scenario.getName());
        RequestUtil.createRequest(scenario.getName());
    }

    @After
    public void finish() throws IOException {
        CustomLogger.checkResponse();
        RequestUtil.deleteRequest();
        RequestUtil.deleteResponse();
        CustomLogger.clear();
    }
}
