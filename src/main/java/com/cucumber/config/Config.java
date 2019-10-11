package com.cucumber.config;


import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import com.cucumber.service.DriverInitService;

@Configuration
@ComponentScan("com.cucumber")
@PropertySource("classpath:properties/test-environment.properties")
@PropertySource("classpath:properties/URL.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class Config {
    @Autowired
    private DriverInitService service;

    @Bean
    public WebDriver getDriver() {
        return service.initDriver();
    }

}
