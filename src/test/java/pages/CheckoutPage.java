package pages;

import config.ConfigReader;
import driverInit.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HelperMethods;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//app-price-display[@class='d-price-display']//button//span[contains(.,'CONTINUE')]")
    private WebElement continueButton;

    @FindBy(xpath = "//div[@class='payment-button-container']/p[contains(.,'COD')]")
    private WebElement codPaymentOption;

    @FindBy(xpath = "//app-price-display[@class='d-price-display']//button//span[contains(.,'PLACE ORDER')]")
    private WebElement placeOrderButton;

    public void clickContinueButton() {
        HelperMethods.waitForElementToBeVisible(driver, continueButton);
        HelperMethods.clickElement(continueButton);
    }

    public void selectCODPaymentOption() {
        HelperMethods.waitForElementToBeVisible(driver, codPaymentOption);
        HelperMethods.clickElement(codPaymentOption);
    }

    public void clickPlaceOrderButton() {
        HelperMethods.waitForElementToBeVisible(driver, placeOrderButton);
        HelperMethods.clickElement(placeOrderButton);
    }


}
