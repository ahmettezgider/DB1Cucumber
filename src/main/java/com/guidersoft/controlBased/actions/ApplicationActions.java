package com.guidersoft.controlBased.actions;

import com.guidersoft.webdriver.Driver;

public class ApplicationActions {

    public void gotoUrl(String url){
        Driver.getDriver().get(url);
    }

    public static void login(){
        TextFieldActions.sendKey("Username","Admin");
        TextFieldActions.sendKey("Password","admin123");
        ButtonActions.click("Login");
    }



}
