package teranozavr.Lesson15.config;


import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import org.springframework.test.annotation.DirtiesContext;
import teranozavr.Lesson15.service.DriverInitService;

@Configuration
@ComponentScan("teranozavr.Lesson15")
@PropertySource("classpath:config/lesson15/app.properties")
@PropertySource("classpath:config/lesson15/testData.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class Config {
    @Autowired
    private DriverInitService service;

    @Bean
    public WebDriver getDriver() {
        return service.initDriver();
    }

}
