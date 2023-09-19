package com.guidersoft.webdriver;

import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    static TestConfig config = TestConfigReader.instance().getConfig();

    public static WebDriver getDriver(){
        if (drivers.get() == null) {
            drivers.set(DriverFactory.createDriver(config));
        }
        return drivers.get();
    }

    public static void quit(){
        if (drivers.get() != null){
            drivers.get().quit();
            drivers.set(null);
        }
    }

}
