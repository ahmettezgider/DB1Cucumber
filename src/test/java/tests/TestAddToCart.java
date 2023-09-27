package tests;

import com.guidersoft.base.BaseTest;
import com.guidersoft.pageobjects.Homepage;
import com.guidersoft.pageobjects.Menu;
import com.guidersoft.pageobjects.MenuObjects;
import com.guidersoft.pageobjects.ProductPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestAddToCart extends BaseTest {

    ProductPage productPage;
    Homepage homepage;

    MenuObjects menu;

    public TestAddToCart(){
        productPage = new ProductPage();
        homepage = new Homepage();
        menu = new MenuObjects();
    }


    Runnable r = new Runnable() {
        By close = By.id("dismiss-button");
        int i;
        @Override
        public void run() {
            while (true){
                try {
                    driver.switchTo().frame(i++ % 10);
                    driver.findElement(close).click();
                    driver.switchTo().parentFrame();
                }catch (Exception ignored){}
            }
        }
    };

    @Test
    public void addToCart(){
        Thread t = new Thread(r);
        t.start();
        homepage.gotoPage();

        //Menu.PRODUCTS.click();

        productPage.addProductToCart("Blue Top");

        t.interrupt();
    }




    //button[@class='close']
}
