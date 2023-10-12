package com.guidersoft.controlBased.actions;

import com.guidersoft.controlBased.controls.ButtonControl;

public class ButtonActions {

    public static void click(String text){
        click(text, 1);
    }

    public static void click(String text, int index){
        ButtonControl.fromText(text, index).click();
    }


}
