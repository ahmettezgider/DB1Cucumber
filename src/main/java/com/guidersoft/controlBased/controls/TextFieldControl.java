package com.guidersoft.controlBased.controls;

import com.guidersoft.controlBased.baseControl.BaseControl;
import org.openqa.selenium.By;

public class TextFieldControl extends BaseControl {

    private static final String TEXTFIELD1 = "//*[normalize-space(text())='%s']//ancestor::div[contains(@class,'oxd-input-group')]//input";

    public static TextFieldControl fromText(String text){
        return fromText(text, 1);
    }

    public static TextFieldControl fromText(String text, int index){
        String locator1 = String.format(ATTRIBUTE, text);
        String locator2 = String.format(TEXTFIELD1, text);
        String xpath =  "(" + locator1 + " | " + locator2 + ")[" + index +"]";

        By locator = By.xpath(xpath);
        return new TextFieldControl(locator);
    }


    private TextFieldControl(By locator){
        super(locator);
    }


    public String getValue(){
        return element.getAttribute("value");
    }

    public void sendKeys(CharSequence...sequences){
        element.sendKeys(sequences);
    }



}
