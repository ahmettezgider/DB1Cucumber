package com.guidersoft.controlBased.runners;

import org.junit.runner.JUnitCore;

public class HRMRunner {

    public static void main(String[] args) {
        JUnitCore jUnitCore = new JUnitCore();
        jUnitCore.run(HRMRunnerMain.class);
    }
}
