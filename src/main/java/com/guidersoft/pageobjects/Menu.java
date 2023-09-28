package com.guidersoft.pageobjects;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public enum Menu {
    // public static final Menu MENU = new Menu(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Home')]"));
    HOME(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Home')]")),
    LOGIN(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Signup / Login')]")),
    SIGNUP(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Signup / Login')]")),
    CART(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Cart')]")),
    PRODUCTS(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Products')]")),
    CONTACTUS(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Contact us')]")),
    LOGOUT(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Logout')]")),
    DELETEACCOUNT(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Delete Account')]"))
    ;

    private By locator;


    Menu(By locator) {
        this.locator = locator;
    }

    public void click(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(20));
        wait.until(driver->{
            try{
                driver.findElement(locator).click();
                return true;
            }catch (Exception e1){
                try{
                    new Actions(driver).moveToElement(driver.findElement(locator)).click().perform();
                    return true;
                }catch (Exception e2){
                    try{
                        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", driver.findElement(locator));
                        return true;
                    }catch (Exception e3){
                        return false;
                    }
                }
            }
        });
    }

    public void shouldBeVisible(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
