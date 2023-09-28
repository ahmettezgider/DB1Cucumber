package com.guidersoft.base;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;


    protected BaseTest(){
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void click(By locator){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }


    public void click(WebElement element){
        //wait.until(ExpectedConditions.elementToBeClickable(element)).click();

        wait.until(driver -> {
            try {
                //scrollIntoView(element);
                element.click();
                return true;
            }catch (StaleElementReferenceException e){
                return false;
            }catch (Exception e){
                return false;
            }
        });
    }

    public void scrollIntoView(WebElement element){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void sendKeys(By locator, CharSequence...texts){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, texts);
    }

    public void sendKeys(WebElement element, CharSequence...texts){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(texts);
    }


    public static final String ATTRIBUTE = "//*[@*[.='%s']]";
    public static final String INPUT1 = "//*[starts-with(.,'%s')]/parent::*//input";
    public static final String BUTTON1 = "//button[starts-with(.,'%s')]";
    public static final String SELECT1 = "//*[starts-with(.,'%s')]/parent::*//select";

    public WebElement getInput(String text){
        return getInput(text, 1);
    }

    public WebElement getInput(String text, int index){
        String input1 = String.format(INPUT1, text);
        String attribute = String.format(ATTRIBUTE, text);

        String xpath = "(" +  input1 + " | " + attribute + ")[" + index + "]";
        By locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public WebElement getButton(String text){
        return getButton(text, 1);
    }

    public WebElement getButton(String text, int index){
        String button1 = String.format(BUTTON1, text);
        String attribute = String.format(ATTRIBUTE, text);

        String xpath = "(" +  button1 + " | " + attribute + ")[" + index + "]";
        By locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void select(String labelOrAttribute, String text){
        select(labelOrAttribute, text, 1);
    }

    public void select(String labelOrAttribute, String text, int index){
        String select1 = String.format(SELECT1, labelOrAttribute);
        String attribute = String.format(ATTRIBUTE, labelOrAttribute);

        String xpath = "(" +  select1 + " | " + attribute + ")[" + index + "]";
        By locator = By.xpath(xpath);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    public static final String productWrapper = "//div[@class='product-image-wrapper' and .//p[text()='%s']]";


}
