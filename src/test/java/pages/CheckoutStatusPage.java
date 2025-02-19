package pages;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HelperMethods;

import java.time.Duration;


public class CheckoutStatusPage {
    WebDriver driver;
    WebDriverWait wait;

    public CheckoutStatusPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p[@class='error-page__heading']")
    private WebElement errorPageHeading;

    @FindBy(xpath = "//app-checkout-summary-page//h1")
    private WebElement orderPlacedSuccessfullyMessage;

    @FindBy(xpath = "//span[contains(.,'View order details')]")
    private WebElement viewOrderDetailsButton;

    @FindBy(xpath = "//div[@class='order-detail']//span[contains(.,'#')]")
    private WebElement orderNumber;

    public String getOrderPlacedSuccessfullyMessage() {
        return HelperMethods.getTextFromElement(orderPlacedSuccessfullyMessage);
    }

    public String getOrderNumber() {
        HelperMethods.waitForElementToBeVisible(driver, orderNumber);
        return HelperMethods.getTextFromElement(orderNumber);
    }


}