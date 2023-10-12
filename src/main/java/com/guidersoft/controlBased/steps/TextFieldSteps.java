package com.guidersoft.controlBased.steps;

import com.guidersoft.controlBased.actions.TextFieldActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class TextFieldSteps {

    @When("orangehrm user fill {string} as {string}")
    public void orangehrmUserFillAs(String label, String text) {
        TextFieldActions.sendKey(label, text);
    }

    @And("orangehrm from {string} textbox search {string} then select {string}")
    public void orangehrmFromTextboxSearchThenSelect(String label, String search, String select) {
        TextFieldActions.select(label, search, select);
    }
}
