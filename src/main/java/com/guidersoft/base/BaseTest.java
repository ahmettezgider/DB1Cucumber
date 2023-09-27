package com.guidersoft.base;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
                element.click();
                return true;
            }catch (StaleElementReferenceException e){
                return false;
            }catch (Exception e){
                return false;
            }
        });
    }


    public void sendKeys(By locator, CharSequence...texts){
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, texts);
    }

    public void sendKeys(WebElement element, CharSequence...texts){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(texts);
    }


    public static final String INPUT1 = "//*[starts-with(.,'%s')]/parent::p//input";
    public static final String INPUT2 = "//*[@*[.='%s']]";


    public WebElement getInput(String text){
        return getInput(text, 1);
    }

    public WebElement getInput(String text, int index){
        String input1 = String.format(INPUT1, text);
        String input2 = String.format(INPUT2, text);

        String xpath = "(" +  input1 + " | " + input2 + ")[" + index + "]";
        By locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }


    public static final String BUTTON1 = "//button[starts-with(.,'%s')]";
    public static final String BUTTON2 = "//*[@*[.='%s']]";

    public WebElement getButton(String text){
        return getButton(text, 1);
    }

    public WebElement getButton(String text, int index){
        String button1 = String.format(BUTTON1, text);
        String button2 = String.format(BUTTON2, text);

        String xpath = "(" +  button1 + " | " + button2 + ")[" + index + "]";
        By locator = By.xpath(xpath);
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

}
