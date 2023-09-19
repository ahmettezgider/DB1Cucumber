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
public class TestConfig {

    private Application application;
    private List<User> users = new ArrayList<User>();
    private Tests tests;
    private Browser chrome;
    private Browser edge;
    private Browser firefox;
    private Map<String, String> variables;


}


