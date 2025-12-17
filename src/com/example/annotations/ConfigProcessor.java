package com.example.annotations;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class ConfigProcessor {

    public static void loadConfig(Object obj) throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("config.properties"));

        for (Field field : obj.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ConfigValue.class)) {
                String key = field.getAnnotation(ConfigValue.class).key();
                field.setAccessible(true);
                field.set(obj, props.getProperty(key));
            }
        }
    }
}
