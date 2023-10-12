package samples.tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestStore {

    WebDriver driver;
    WebDriverWait wait;

    public TestStore(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    Runnable r = new Runnable() {
        By close = By.xpath("//button[@class='close']");
        @Override
        public void run() {
            while (true){
                try {
                    driver.findElements(close).stream()
                            .filter(c -> c.isDisplayed())
                            .findFirst().get().click();

                }catch (Exception ignored){}
            }
        }
    };

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    @Test
    public void addToCart(){

        Thread t = new Thread(r);
        t.start();
        driver.get("https://demoblaze.com/");

        while (true){

        }


    }
}
