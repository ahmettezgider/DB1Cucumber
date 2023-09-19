package com.guidersoft.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class TestConfigReader {
    private static final String CONFIG_FILE = "testconfig.yml";
    private static TestConfigReader instance;
    private TestConfig config;

    private TestConfigReader(){
        File file = new File(CONFIG_FILE);
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            config = mapper.readValue(file, TestConfig.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static TestConfigReader instance(){
        instance = (instance == null) ? new TestConfigReader() : instance;
        return instance;
    }

    public TestConfig getConfig(){
        return config;
    }
}
