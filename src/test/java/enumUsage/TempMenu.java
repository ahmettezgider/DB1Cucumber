package enumUsage;

import com.guidersoft.webdriver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TempMenu {

    public static final TempMenu HOME = new TempMenu(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Home')]"));
    public static final TempMenu LOGIN = new TempMenu(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Signup / Login')]"));
    public static final TempMenu CART = new TempMenu(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Cart')]"));
    public static final TempMenu PRODUCTS = new TempMenu(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Products')]"));
    public static final TempMenu CONTACTUS = new TempMenu(By.xpath("//ul[@class='nav navbar-nav']//a[contains(., 'Contact us')]"));
    public static final TempMenu AA = new TempMenu();

    private By locator;

    public TempMenu() {

    }
    public TempMenu(By locator) {
        this.locator = locator;
    }

    public void click(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }
}
