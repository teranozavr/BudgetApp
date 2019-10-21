package com.github.teranozavr.steps;

import cucumber.api.java.ru.Дано;
import com.github.teranozavr.requestUtil.RequestUtil;

public class Given {

    @Дано("пользователь отправляет запрос на апи по адресу {word}")
    public void userSendRequest(String endPoint) {
        RequestUtil.setUrl(endPoint);
    }

}
