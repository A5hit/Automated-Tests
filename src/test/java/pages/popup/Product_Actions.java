package pages.popup;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HelperMethods;

import java.time.Duration;

public class Product_Actions {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//mat-dialog-container//span[contains(.,'REMOVE')]")
    private WebElement removeButton;

    public Product_Actions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public void removefromCart() {
        HelperMethods.waitForElementToBeVisible(driver, removeButton);
        HelperMethods.clickElement(removeButton);
    }
}
