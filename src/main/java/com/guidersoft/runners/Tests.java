package com.guidersoft.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features/01Login.feature"}
        ,glue = {"com/guidersoft/stepdefs"}
        //,tags = ""
        ,plugin = {"pretty",
            "html:target/cucumber/cucumber.html",
            "json:target/cucumber/cucumber.json",
            "testng:target/cucumber/cucumber.xml",
            "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
            "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        }
)

public class Tests {

}
