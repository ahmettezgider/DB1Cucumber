package com.guidersoft.stepdefs;

import com.guidersoft.webdriver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

    // before scenario
    @Before
    public void beforeScenario(){
        Driver.getDriver();
    }


    // after scenario
    @After
    public void afterScenario(){
        Driver.quit();
    }
}
