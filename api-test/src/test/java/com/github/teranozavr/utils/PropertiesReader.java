package com.github.teranozavr.utils;

import java.io.*;
import java.util.Properties;

public class PropertiesReader {
    //Класс для чтения пропертей. Реализован как Singletone
    private static PropertiesReader instace;
    private Properties properties = new Properties();

    public static PropertiesReader getInstance() throws IOException {
        if (instace == null) {
            instace = new PropertiesReader();
        }
        return instace;
    }

    public String getReoprtProperty(String propertyKey) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/report.properties")));
        properties.load(reader);
        reader.close();
        return properties.getProperty(propertyKey);
    }
}
