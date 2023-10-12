package com.guidersoft.controlBased.steps;

import com.guidersoft.controlBased.actions.ApplicationActions;
import io.cucumber.java.en.Given;

public class ApplicationSteps {

    @Given("orangehrm user on {string}")
    public void orangehrmUserOnHomepage(String url) {

        new ApplicationActions().gotoUrl(url);

    }

    @Given("orangehrm login")
    public void login() {

        ApplicationActions.login();

    }


}
