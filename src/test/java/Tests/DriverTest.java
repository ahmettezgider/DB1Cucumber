package Tests;

import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import com.guidersoft.webdriver.Driver;
import com.guidersoft.webdriver.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverTest {

    @Test
    public void testDriver() throws InterruptedException {
        TestConfig config = TestConfigReader.instance().getConfig();

        WebDriver driver = Driver.getDriver();

        driver.get(config.getApplication().getUrl());
        Thread.sleep(5000);
        Driver.quit();
    }
}
