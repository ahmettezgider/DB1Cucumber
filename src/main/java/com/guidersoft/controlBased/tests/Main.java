package com.guidersoft.controlBased.tests;

import com.guidersoft.base.BaseTest;
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
        TextFieldControl.fromText("Username").sendKeys("Admin");
        TextFieldControl.fromText("Password").sendKeys("admin123");
        ButtonControl.fromText("Login").click();

        ButtonControl.fromText("Admin").click();
        TextFieldControl.fromText("Username").sendKeys("Anthony.Nolan");
        TextFieldControl.fromText("Employee Name").sendKeys("Lisa  Andrews");
        ButtonControl.fromText("Search", 2).click();

    }

}
