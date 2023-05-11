package com.example.selenidecodelab.utils;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();

    static Config readConfig(){
        return ConfigFactory.load("config.conf");
    }

    String BASE_URL = config.getString("base_url");

}
