package com.guidersoft.pageobjects;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuObjects {

    public MenuObjects(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(., 'Home')]")
    public WebElement home;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(., 'Products')]")
    public WebElement products;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(., 'Cart')]")
    public WebElement cart;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(., 'Signup / Login')]")
    public WebElement signupLogin;

    @FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(., 'Contact us')]")
    public WebElement  contactUs;
}
