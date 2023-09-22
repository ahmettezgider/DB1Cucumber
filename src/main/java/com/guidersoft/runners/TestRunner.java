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
        // bu system property cucumber optionlarinin system property den alinacagini gösterir
        System.setProperty("cucumber.publish.quite", "true");
        TestConfig config = TestConfigReader.instance().getConfig();

        String features = config.getTests().getFeatures();
        if (features.trim().length()>0)
            System.setProperty("cucumber.features", config.getTests().getFeatures());

        boolean dryRun = config.getTests().isDryRun();
        if (dryRun)
            System.setProperty("cucumber.execution.dry-run", "true");

        String tags = config.getTests().getTags();
        if (tags.trim().length()>0)
            System.setProperty("cucumber.filter.tags", tags);

    }

    public static void runTest(){
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.run(Tests.class);

    }
}
