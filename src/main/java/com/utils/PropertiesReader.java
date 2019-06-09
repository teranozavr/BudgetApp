package com.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by sbt-vazim-ko on 03.07.2017.
 */
public class PropertiesReader {
//Класс для чтения пропертей. Реализован как Singletone, за вопросы "Что такое Singletone у меня на районе убивают нахуй". Используйте гугл.
    private static PropertiesReader instace;
    private Properties properties = new Properties();

    public static PropertiesReader getInstance() throws IOException {
        if (instace == null) {
            instace = new PropertiesReader();
        }
        return instace;
    }

    public String getURLProperty(String propertyKey) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resourses/properties/URL.properties")));
        properties.load(reader);
        reader.close();
        return properties.getProperty(propertyKey);
    }

    public String getTestDataProperty(String propertyKey) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resourses/properties/testData.properties")));
        properties.load(reader);
        reader.close();
        return properties.getProperty(propertyKey);
    }

    public String getALMProperty(String propertyKey) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resourses/properties/alm.properties")));
        properties.load(reader);
        reader.close();
        return properties.getProperty(propertyKey);
    }
}
