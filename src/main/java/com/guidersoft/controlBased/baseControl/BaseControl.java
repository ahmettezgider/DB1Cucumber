package com.guidersoft.controlBased.baseControl;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseControl {

    protected By locator;
    protected WebElement element;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final  String ATTRIBUTE = "//*[@*[.='%s']]";

    protected BaseControl(By locator){
        this.locator = locator;
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void click(){
        wait.until(driver->{
            try {
                element.click();
                return true;
            }catch (Exception e){
                try {
                    new Actions(driver).moveToElement(element).click().perform();
                    return true;
                }catch (Exception e2){
                    return false;
                }
            }
        });

    }

}
