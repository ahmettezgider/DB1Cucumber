package com.guidersoft.webdriver;

import com.guidersoft.config.TestConfig;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {


    public ChromeDriver createChrome(TestConfig config){
        ChromeOptions options = new ChromeOptions();
        for (String option : config.getChrome().getOptions()) {
            options.addArguments(option);
        }
        return new ChromeDriver(options);
    }


    public EdgeDriver createEdgeDriver(TestConfig config){
        EdgeOptions options = new EdgeOptions();
        for (String option : config.getEdge().getOptions()) {
            options.addArguments(option);
        }
        return new EdgeDriver(options);
    }


    public FirefoxDriver createFirefox(TestConfig config){
        FirefoxOptions options = new FirefoxOptions();
        for (String option : config.getFirefox().getOptions()) {
            options.addArguments(option);
        }
        return new FirefoxDriver(options);
    }


}
