package driverInit;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;
    private WebDriverWait wait;
    private String isheadless = ConfigReader.HEADLESS;
    private String browser = ConfigReader.BROWSER;
    private String profile = ConfigReader.PROFILE;
    private Integer waitTimeout = Integer.valueOf(ConfigReader.WAIT_TIMEOUT);



    public WebDriver initializeDriver() {
        try {
            driver = setDriver(browser);
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    private WebDriver setDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "ie":
                driver = initIEDriver(isheadless, profile, waitTimeout);
                break;
            case "firefox":
                driver = initFirefoxDriver(isheadless, profile, waitTimeout);
                break;
            default:
                driver = initChromeDriver(isheadless, profile, waitTimeout);
        }
        return driver;
    }

    private WebDriver initChromeDriver(String isheadless, String profile, Integer waitTimeout) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        if (isheadless.equalsIgnoreCase("true")) {
            options.addArguments("--headless");
        }
        if (profile.equalsIgnoreCase("true")) {
            options.addArguments("user-data-dir=C:\\Users\\sh4d0\\AquaProjects\\Automated-Tests\\ChromeProfiles\\Profile 2");
        }
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeout));
        return driver;
    }

    private WebDriver initIEDriver(String isheadless, String profile, Integer waitTimeout) {
        return null;
    }

    private WebDriver initFirefoxDriver(String isheadless, String profile, Integer waitTimeout) {
        return null;
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


}
