package com.github.teranozavr.config;


import com.github.teranozavr.helpers.TestData;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;


@Configuration
@ComponentScan("com.github.teranozavr")
@PropertySource("classpath:url.properties")
@PropertySource("classpath:testData.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)

public class ApiConfig {
    @Bean
    public TestData getTestData(){
        TestData t = new TestData();
        return t;
    }
}
