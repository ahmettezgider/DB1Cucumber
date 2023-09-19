package com.guidersoft.webdriver;

import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    private static ChromeDriver createChrome(TestConfig config){
        ChromeOptions options = new ChromeOptions();
        for (String option : config.getChrome().getOptions()) {
            if (option.length()>0)
                options.addArguments(option);
        }
        return new ChromeDriver(options);
    }


    private static EdgeDriver createEdgeDriver(TestConfig config){
        EdgeOptions options = new EdgeOptions();
        for (String option : config.getEdge().getOptions()) {
            if (option.length()>0)
                options.addArguments(option);
        }
        return new EdgeDriver(options);
    }


    private static FirefoxDriver createFirefox(TestConfig config){
        FirefoxOptions options = new FirefoxOptions();
        for (String option : config.getFirefox().getOptions()) {
            if (option.length()>0)
                options.addArguments(option);
        }
        return new FirefoxDriver(options);
    }


    static WebDriver createDriver(TestConfig config){
        switch (config.getTests().getBrowser()){
            case CHROME:
                return createChrome(config);
            case EDGE:
                return createEdgeDriver(config);
            case FIREFOX:
                return createFirefox(config);
            default:
                throw new RuntimeException(config.getTests().getBrowser() + " is undefined");
        }
    }

}
