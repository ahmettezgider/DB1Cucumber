package com.guidersoft.controlBased.steps;

import com.guidersoft.controlBased.actions.ButtonActions;
import io.cucumber.java.en.And;

public class ButtonSteps {

    @And("orangehrm user clicks the {int}.nt {string} button")
    public void orangehrmUserClicksNthTheButton(int index, String label) {
        ButtonActions.click(label, index);
    }

    @And("orangehrm user clicks the {string} button")
    public void orangehrmUserClicksTheButton(String label) {
        ButtonActions.click(label);
    }
}
