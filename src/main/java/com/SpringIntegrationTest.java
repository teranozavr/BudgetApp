package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;

@ContextConfiguration(classes = {SpringIntegrationTest.class})
@Configuration
@TestPropertySource("classpath:properties/test-ebvironment.properties")
@ComponentScan(basePackages = "com")
public class SpringIntegrationTest {
}
