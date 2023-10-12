package samples.samples;

import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import com.guidersoft.webdriver.Driver;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class DriverTest {

    @Test
    public void testDriver() throws InterruptedException {
        TestConfig config = TestConfigReader.instance().getConfig();

        WebDriver driver = Driver.getDriver();

        driver.get(config.getApplication().getUrl());
        Thread.sleep(5000);
        Driver.quit();
    }

    @Test
    public void testFizBuzz(){
        /*
            1-100 arasinda sayi
                3 nin kati ise FIZZ
                5 nin kati ise BUZZ
                15 nin kati ise FIZZBUZZ
         */

        for (int i = 1; i < 101; i++) {
            if (i % 15 == 0)
                System.out.println("FIZZBUZZ");
            else if (i % 3 == 0)
                System.out.println("FIZZ");
            else if (i % 5 == 0)
                System.out.println("BUZZ");
            else
                System.out.println(i);
        }
    }
}
