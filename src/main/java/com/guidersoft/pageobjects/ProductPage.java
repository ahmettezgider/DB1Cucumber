package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BaseTest {


    public ProductPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".product-image-wrapper")
    public List<WebElement> products;

    @FindBy(css = "#cartModal button")
    public WebElement productAddDialog;



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









}
