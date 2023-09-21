package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginSignup extends BaseTest {

    public LoginSignup(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".login-form [name='email']")
    public WebElement inputLoginEmail;

    @FindBy(css = ".login-form [name='password']")
    public WebElement inputLoginPassword;

    @FindBy(css = ".login-form button")
    public WebElement buttonLogin;

    @FindBy(css = ".signup-form [name='email']")
    public WebElement inputSignupEmail;

    @FindBy(css = ".signup-form [name='name']")
    public WebElement inputSignupName;

    @FindBy(css = ".signup-form button")
    public WebElement buttonSignup;


    public void login(String email, String password){
        sendKeys(inputLoginEmail, email);
        sendKeys(inputLoginPassword,password);
        click(buttonLogin);
    }


}
