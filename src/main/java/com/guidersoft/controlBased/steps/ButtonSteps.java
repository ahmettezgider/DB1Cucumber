package com.guidersoft.controlBased.steps;

import com.guidersoft.controlBased.actions.ButtonActions;
import io.cucumber.java.en.And;

public class ButtonSteps {

    @And("orangehrm user clicks the button {string}")
    public void orangehrmUserClicksTheButton(String label) {
        ButtonActions.click(label);
    }
}
