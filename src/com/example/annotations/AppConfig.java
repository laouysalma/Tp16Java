package com.example.annotations;

public class AppConfig {

    @ConfigValue(key = "app.name")
    public String appName;

    @ConfigValue(key = "app.port")
    public String port;
}
