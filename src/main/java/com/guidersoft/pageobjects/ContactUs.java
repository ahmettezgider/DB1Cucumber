package com.guidersoft.pageobjects;

import com.guidersoft.base.BaseTest;
import com.guidersoft.utils.Utils;
import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Map;

public class ContactUs extends BaseTest {

    public ContactUs(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.=\"Contact Us\"]")
    public WebElement title;

    @FindBy(css = "input[name=\"name\"]")
    public WebElement name;

    @FindBy(css = "input[name=\"email\"]")
    public WebElement email;

    @FindBy(css = "input[name=\"subject\"]")
    public WebElement subject;

    @FindBy(id = "message")
    public WebElement message;

    @FindBy(css = "input[name=\"submit\"]")
    public WebElement submit;

    @FindBy(css = "input[name=\"upload_file\"]")
    public WebElement upload_file;


    public void pageIsVisible(){
        wait.until(ExpectedConditions.visibilityOf(title));
    }

    public void fillTheFormAndSubmit(Map<String, String> map){
        sendKeys(name, map.get("name"));
        sendKeys(email, map.get("email"));
        sendKeys(subject, map.get("subject"));
        sendKeys(message, map.get("message"));

        //sendKeys(upload_file, map.get("file"));
        scrollIntoView(upload_file);
        click(upload_file);

        // Clipboard
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        StringSelection str = new StringSelection(map.get("file"));
        clipboard.setContents(str, null);
        // Clipboard


        try {
            Robot robot;
            robot = new Robot();
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        click(submit);
    }




}
