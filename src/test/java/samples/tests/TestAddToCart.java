package samples.tests;

import com.guidersoft.base.BaseTest;
import com.guidersoft.pageobjects.Homepage;
import com.guidersoft.pageobjects.Menu;
import com.guidersoft.pageobjects.MenuObjects;
import com.guidersoft.pageobjects.ProductPage;
import org.junit.Test;
import com.guidersoft.utils.Utils;
import org.openqa.selenium.By;

public class TestAddToCart extends BaseTest {

    ProductPage productPage;
    Homepage homepage;

    MenuObjects menu;

    public TestAddToCart() {
        productPage = new ProductPage();
        homepage = new Homepage();
        menu = new MenuObjects();
    }


    @Test
    public void addToCart() {

        homepage.gotoPage();

        String body = driver.findElement(By.cssSelector("body")).getText();
        System.out.println(body);
        //Menu.PRODUCTS.click();

        //productPage.addProductToCart("Blue Top");

    }

    @Test
    public void addToCart1() {
        homepage.gotoPage();
        Utils.sleep(1);
        Utils.sleep(1);
        Menu.HOME.click();
        Utils.sleep(1);
        Menu.LOGIN.click();
        Utils.sleep(1);
        Menu.CART.click();
        Utils.sleep(1);
        Menu.CONTACTUS.click();
        Utils.sleep(1);
        Menu.PRODUCTS.click();
    }

    //button[@class='close']
}
