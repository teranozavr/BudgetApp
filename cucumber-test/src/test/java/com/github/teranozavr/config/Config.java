package com.github.teranozavr.config;


import com.github.teranozavr.service.DriverInitService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;


@Configuration
@ComponentScan("com.github.teranozavr")
@PropertySource("classpath:config/app.properties")
@PropertySource("classpath:config/testData.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)

public class Config {
    @Autowired
    private DriverInitService service;

    @Bean
    public WebDriver getDriver() {
        return service.initDriver();
    }

}
