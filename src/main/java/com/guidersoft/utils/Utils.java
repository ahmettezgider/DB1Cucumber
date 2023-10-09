package com.guidersoft.utils;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Utils {

    public static void sleep(int sec){
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeWithRobot(Robot robot, String str){

        for (int i = 0; i < str.length(); i++) {
            robot.keyPress(KeyEvent.getExtendedKeyCodeForChar(str.charAt(i)));
        }

    }
}
