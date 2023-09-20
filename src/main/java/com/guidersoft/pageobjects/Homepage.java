package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends BaseTest {

    @FindBy(css = "aa")
    public WebElement aa;

    By home = By.xpath("asdasd");


    public void login(){
        click(aa);
        click(home);

    }



}
