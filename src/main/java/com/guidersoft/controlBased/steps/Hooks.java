package com.guidersoft.controlBased.steps;

import com.guidersoft.utils.Utils;
import com.guidersoft.webdriver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void before(){
        Driver.getDriver();
    }

    @After
    public void after(){
        Utils.sleep(3);
        Driver.quit();
    }
}
