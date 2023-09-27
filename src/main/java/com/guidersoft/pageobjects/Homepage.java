package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Utils;

import java.time.Duration;


public class Homepage extends BaseTest {


    public void gotoPage(){
        TestConfig config = TestConfigReader.instance().getConfig();
        driver.get(config.getApplication().getUrl());

        try {
            new WebDriverWait(driver, Duration.ofSeconds(4), Duration.ofMillis(300))
                    .until(ExpectedConditions.numberOfWindowsToBe(2));

            String win = driver.getWindowHandle();
            String newWin = driver.getWindowHandles()
                    .stream()
                    .filter(wh -> !wh.equals(win))
                    .findFirst().get();
            driver.switchTo().window(newWin).close();
            driver.switchTo().window(win);
        }catch (Exception ignored){
        }

    }



}
