package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class ProductPage extends BaseTest {


    public ProductPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product-image-wrapper")
    public List<WebElement> products;

    @FindBy(css = "#cartModal button")
    public WebElement productAddDialog;

    @FindBy(id = "search_product")
    public WebElement searchBox;

    @FindBy(id = "submit_search")
    public WebElement searchButton;


    //String buttonString = "//button[normalize-space(.)='%s']";
    //String buttonString = "//button[starts-with(normalize-space(.),'%s')]";
    String buttonString = "//button[contains(.,'%s')]";


    public void addProductToCart(String productName){

        WebElement product = null;
        for (WebElement element : products) {
            if (element.getText().contains(productName)){
                product = element;
                break;
            }
        }
        WebElement addToCart = product.findElement(By.xpath(".//a[.='Add to cart']"));
        click(addToCart);
    }


    public void searchProduct(CharSequence...text){
        sendKeys(searchBox, text);
        click(searchButton);
    }

    public void clickButtonWithText(String text){
        By locator = By.xpath(String.format(buttonString, text));
        click(locator);
    }



}
