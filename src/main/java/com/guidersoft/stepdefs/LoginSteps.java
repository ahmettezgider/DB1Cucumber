package com.guidersoft.stepdefs;

import com.guidersoft.base.BaseTest;
import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import com.guidersoft.pageobjects.Homepage;
import com.guidersoft.pageobjects.LoginSignup;
import com.guidersoft.pageobjects.Menu;
import com.guidersoft.pageobjects.MenuObjects;
import com.guidersoft.webdriver.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class LoginSteps extends BaseTest {

    Homepage home = new Homepage();
    MenuObjects menu = new MenuObjects();

    LoginSignup loginSignup = new LoginSignup();

    @Given("user on homepage")
    public void userOnHomepage() {
        home.gotoPage();
    }


    @When("^user clicks (LOGIN|SIGNUP|HOME|CART|PRODUCTS|CONTACTUS) on menu$")
    public void userClicksSignupLoginOnMenu(String menuText) {

        switch (menuText){
            case "LOGIN":
            case "SIGNUP":
                menu.signupLogin.click();
                break;
            case "HOME":
                menu.home.click();
                break;
            case "CART":
                menu.cart.click();
                break;
            case "PRODUCTS":
                menu.products.click();
                break;
            case "CONTACTUS":
                menu.contactUs.click();
        }

        /*
        String locatorStr = "//ul[@class='nav navbar-nav']//a[contains(., '%s')]";
        By locator = null;
        switch (menuText){
            case "LOGIN":
            case "SIGNUP":
                locatorStr = String.format(locatorStr, "Signup / Login");
                locator = By.xpath(locatorStr);
                break;
            case "HOME":

                break;

        }
         */



    }

    @When("^user clicks (LOGIN|SIGNUP|HOME|CART|PRODUCTS|CONTACTUS|DELETEACCOUNT) on menu with Enum$")
    public void userClicksSignupLoginOnMenuWithEnum(String menuText) {

        Menu.valueOf(menuText).click();

        /*
        switch (menuText){
            case "LOGIN":
            case "SIGNUP":
                Menu.LOGIN.click();
                break;
            case "HOME":
                Menu.HOME.click();
                break;
            case "CART":
                Menu.CART.click();
                break;
            case "PRODUCTS":
                Menu.PRODUCTS.click();
                break;
            case "CONTACTUS":
                Menu.CONTACTUS.click();
        }
         */

    }

    @And("user login as {string}")
    public void userFillsTheLoginFormAs(String userType) {
        /*
        TestConfig.User user = TestConfigReader.instance().getConfig()
                .getUsers().stream().filter(u -> u.getType().equals(userType))
                .findFirst().get();
        */

        /*
        TestConfig.User user = TestConfigReader.instance().getConfig().getUser(userType);

        loginSignup.login(user.getUsername(), user.getPassword());
         */

        loginSignup.login(userType);

    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
        Menu.LOGOUT.shouldBeVisible();
    }

    @And("user login email as {string} and password as {string}")
    public void userLoginEmailAsAndPasswordAs(String email, String password) {
        loginSignup.login(email, password);
    }

    @And("user login with following credentials")
    public void userLoginWithFollowingCredentials(DataTable table) {
        Map<String, String> data = table.asMap();
        String email = data.get("email");
        String password = data.get("password");
        loginSignup.login(email, password);
    }

    @And("user fills the New User Signup form as follows then clicks signup")
    public void userFillsTheNewUserSignupFormAsFollows(DataTable table) {
        Map<String, String> data = table.asMap();

        String name = data.get("name");
        String email = data.get("email");
        loginSignup.signup(name, email);

    }

    Properties properties = new Properties();
    @When("user save {string} as {string}")
    public void userSaveAs(String value, String variable) {
        properties.setProperty(variable, value);
    }

    @Then("{string} degeri {string} olmali")
    public void degeriOlmali(String variable, String value) {
        String val = properties.getProperty(variable);
        Assert.assertEquals(val, value);
    }

    @When("user fill the input {string} as {string}")
    public void userFillTheInputAs(String labelOrAttribute, String value) {
        sendKeys(getInput(labelOrAttribute), value);

    }



    @When("user fill the {int}.th input {string} as {string}")
    public void userFillTheThInputAs(int index, String labelOrAttribute, String value) {
        sendKeys(getInput(labelOrAttribute, index), value);
    }

    @And("user clicks the button {string}")
    public void userClicksTheButton(String labelOrAttribute) {
        click(getButton(labelOrAttribute));
    }

    @Given("title should be {string}")
    public void titleShouldBe(String title) {
        //Assert.assertTrue(driver.getTitle().contains(title));
        wait.until(ExpectedConditions.titleContains(title));
    }

    @Given("the text {string} is visible")
    public void theTextIsVisible(String text) {

        By locator = By.xpath("//*[contains(text(), '" + text + "')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        //String body = driver.findElement(By.cssSelector("body")).getText();
        //Assert.assertTrue(body.contains(text));
    }

    @Given("the text {string} is not visible")
    public void theTextInVisible(String text) {
        By locator = By.xpath("//*[contains(text(), '" + text + "')]");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));

        //String body = driver.findElement(By.cssSelector("body")).getText();
        //Assert.assertFalse(body.contains(text));
    }

    @And("user select {string} as Day, {string} as Month, {string} as Year")
    public void userSelectAsDayAsMonthAsYear(String day, String month, String year) {
        Select selectDay = new Select(loginSignup.registerDayOfBirth);
        selectDay.selectByVisibleText(day);

        Select selectMonth = new Select(loginSignup.registerMonthOfBirth);
        selectMonth.selectByVisibleText(month);

        Select selectYear = new Select(loginSignup.registerYearOfBirth);
        selectYear.selectByVisibleText(year);

    }

    @When("user fill the registerform as follows")
    public void userFillTheRegisterformAsFollows(DataTable table) {
        Map<String, String> data = table.asMap();

        //sendKeys(loginSignup.registerPassword, data.get("Password"));
        sendKeys(getInput("Password"), data.get("Password"));
        select("days", data.get("days"));
        select("months", data.get("months"));
        select("years", data.get("years"));
        sendKeys(getInput("First name"), data.get("First name"));
        sendKeys(getInput("Last name"), data.get("Last name"));
        sendKeys(getInput("Company"), data.get("Company"));
        sendKeys(getInput("Address *"), data.get("Address *"));
        sendKeys(getInput("Address 2"), data.get("Address 2"));
        select("country", data.get("country"));
        sendKeys(getInput("State"), data.get("State"));
        sendKeys(getInput("City"), data.get("City"));
        sendKeys(getInput("Zipcode"), data.get("Zipcode"));
        sendKeys(getInput("Mobile Number"), data.get("Mobile Number"));


    }

    @When("user fill the general form as follows")
    public void userFillTheRegisterformAsFollowsWithList(DataTable table) {
        List<List<String>> data = table.asLists();
        for (List<String> row : data) {
            switch (row.get(0)){
                case "input":
                    sendKeys(getInput(row.get(1)), row.get(2));
                    break;
                case "select":
                    select(row.get(1), row.get(2));
                    break;
                case "button":
                    click(getButton(row.get(1)));
                    break;
                case "upload":
                    click(getButton(row.get(1)));
                    // Clipboard
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    StringSelection str = new StringSelection(row.get(2));
                    clipboard.setContents(str, null);
                    // Clipboard

                    try {
                        Robot robot;
                        robot = new Robot();
                        Thread.sleep(2000);
                        robot.keyPress(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_V);
                        robot.keyRelease(KeyEvent.VK_CONTROL);
                        robot.keyPress(KeyEvent.VK_ENTER);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "checkbox":
                    break;
                case "radio":
                    break;
            }
        }


    }
}
