package driverInit;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;


public class BaseTest {

    DriverFactory driverFactory = new DriverFactory();
    protected WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = driverFactory.initializeDriver();
    }

    @AfterTest
    public void tearDown() {
       driverFactory.quitDriver();
       driver = null;
    }


}
