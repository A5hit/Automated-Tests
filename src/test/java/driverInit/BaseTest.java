package driverInit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


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
