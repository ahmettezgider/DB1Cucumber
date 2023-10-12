package com.guidersoft.controlBased.actions;

import com.guidersoft.controlBased.controls.TextFieldControl;

public class TextFieldActions {

    public static void sendKey(String label, CharSequence...sequences){
        TextFieldControl.fromText(label).sendKeys(sequences);
    }

    public static void select(String label, String search, String select){
        TextFieldControl.fromText(label).select(search, select);
    }
}
