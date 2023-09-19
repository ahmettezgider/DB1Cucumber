package com.guidersoft.config;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * testconfig.yml dosyasinin pojo'su
 *
 */

@Data
public class TestConfigInnerClass {

    private Application application;
    private List<User> users = new ArrayList<>();
    private Tests tests;
    private Browser chrome;
    private Browser edge;
    private Browser firefox;
    private Map<String, String> variables;


    @Data
    public static class Application {
        private String name;
        private String url;
    }

    @Data
    public static class Browser {
        private Integer version;
        private List<String> options = new ArrayList<>();
    }

    @Data
    public static class Tests {
        private String browser;
        private String features;
        private String tags;
    }

    @Data
    public static class User {
        private String name;
        private String username;
        private String password;
    }

}

