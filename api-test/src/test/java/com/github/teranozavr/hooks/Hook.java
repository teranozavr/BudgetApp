package ru.sber.cucumberTest.hooks;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import ru.sber.cucumberTest.log.CustomLogger;
import ru.sber.cucumberTest.requestUtil.RequestUtil;
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
