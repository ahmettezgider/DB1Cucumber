package com.guidersoft.base;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    protected BaseTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }


    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        wait.until(driver -> {
            try {
                element.click();
                return true;
            }catch (StaleElementReferenceException e){
                return false;
            }catch (Exception e){
                return false;
            }
        });
    }



}
