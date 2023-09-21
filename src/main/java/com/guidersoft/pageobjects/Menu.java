package com.guidersoft.pageobjects;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.By;
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
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    Menu(By locator) {
        this.locator = locator;
    }

    public void click(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void shouldBeVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
