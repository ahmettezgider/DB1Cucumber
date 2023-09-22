package com.guidersoft.stepdefs;

import com.guidersoft.webdriver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CucumberHooks {

    // before scenario
    @Before
    public void beforeScenario(){
        Driver.getDriver();
    }


    @AfterStep
    public void afterStep(Scenario scenario){
        if (scenario.isFailed()){

        }
    }

    // after scenario
    @After
    public void afterScenario(){
        Driver.quit();
    }
}
