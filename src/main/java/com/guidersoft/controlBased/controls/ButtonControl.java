package com.guidersoft.controlBased.controls;

import com.guidersoft.controlBased.baseControl.BaseControl;
import org.openqa.selenium.By;


public class ButtonControl extends BaseControl {

    private static final String BUTTON1 = "//button[normalize-space(.)='%s']";
    private static final String LINK = "//a[normalize-space(.)='%s']";

    public static ButtonControl fromText(String text){
        return fromText(text, 1);
    }

    public static ButtonControl fromText(String text, int index){
        String locator1 = String.format(ATTRIBUTE, text);
        String locator2 = String.format(BUTTON1, text);
        String locator3 = String.format(LINK, text);
//      //button[contains(.,'%s')] | //label[text()='%s']//parent::div//input[@type='button'] | //label[text()='%s']//parent::div//button
//      button1 | button2 | button3
        String xpath =  "(" + locator1 + " | " + locator2 + " | " + locator3 + ")[" + index + "]";

        By locator = By.xpath(xpath);
        return new ButtonControl(locator);
    }


    private ButtonControl(By locator){
        super(locator);
    }


    public String getText(){
        return element.getText();
    }


}
