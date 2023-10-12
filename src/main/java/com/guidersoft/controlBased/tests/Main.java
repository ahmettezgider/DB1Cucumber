package com.guidersoft.controlBased.tests;

import com.guidersoft.base.BaseTest;
import com.guidersoft.controlBased.actions.ButtonActions;
import com.guidersoft.controlBased.actions.TextFieldActions;
import com.guidersoft.controlBased.controls.ButtonControl;
import com.guidersoft.controlBased.controls.TextFieldControl;
import com.guidersoft.webdriver.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {

    WebDriver driver;
    WebDriverWait wait;

    public Main(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    @Test
    public void test1(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        TextFieldActions.sendKey("Username", "Admin");
        TextFieldActions.sendKey("Password", "admin123");
        ButtonActions.click("Login");

        ButtonActions.click("Admin");
        TextFieldActions.sendKey("Username","Anthony.Nolan");
        TextFieldActions.select("Employee Name","Anthony", "Anthony Nolan");

        ButtonActions.click("Search",2);

    }

}
