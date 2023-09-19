package com.guidersoft;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigInnerClass;
import com.guidersoft.config.TestConfigReader;
import com.guidersoft.config.User;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        TestConfig config = TestConfigReader.instance().getConfig();
        System.out.println("config.getApplication().getName() = " + config.getApplication().getName());

    }

    public static void main1(String[] args) throws IOException {

        File file = new File("testconfig.yml");

        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TestConfig config1 = mapper.readValue(file, TestConfig.class);

        System.out.println("config1.getApplication().getName() = " + config1.getApplication().getName());

        String pass = "";
        /*
        pass = config1.getUsers().stream()
                .filter(user -> user.getName().equalsIgnoreCase("admin"))
                .findFirst()
                .get()
                .getPassword();
         */

        for (User user : config1.getUsers()) {
            if (user.getName().equalsIgnoreCase("admin")){
                pass = user.getPassword();
                break;
            }
        }


        System.out.println("pass = " + pass);

        System.out.println("config1.getVariables().get(\"ali.veli.deli\") = " + config1.getVariables().get("ali.veli.deli"));

    }
}