package com.guidersoft.runners;

import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import org.junit.runner.JUnitCore;

public class TestRunner {

    public static void main(String[] args) {

        configureCucumber();
        runTest();

    }

    public static void configureCucumber(){
        System.setProperty("cucumber.publish.quite", "true");
        TestConfig config = TestConfigReader.instance().getConfig();

        System.setProperty("cucumber.features", config.getTests().getFeatures());

    }

    public static void runTest(){
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.run(Tests.class);

    }
}
