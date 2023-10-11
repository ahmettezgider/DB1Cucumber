package com.guidersoft.stepdefs;

import com.guidersoft.pageobjects.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @And("user search {string}")
    public void userSearch(String textToSearch) {
        productPage.searchProduct(textToSearch);
    }

    @And("user add {string} to the Cart")
    public void userAddToTheCart(String productName) {
        productPage.addProductToCart(productName);

    }

    @Then("I click the {string} button")
    public void iClickTheButton(String buttonText) {
        productPage.clickButtonWithText(buttonText);
    }
}
