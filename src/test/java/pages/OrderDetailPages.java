package pages;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HelperMethods;

import java.time.Duration;
import java.util.List;

// page_url = about:blank
public class OrderDetailPages {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='order-detail-page order-detail-desktop']//button/span[contains(.,'CANCEL')]")
    private WebElement cancelButton;

    @FindBy(xpath = "//mat-checkbox[@id='mat-checkbox-1']")
    private WebElement selectAllCheckbox;

    @FindBy(xpath = "//input[@id='mat-input-0']")
    private WebElement QueryInput;

    @FindBy(xpath = "//p[.='Order Cancellation']")
    private WebElement queryOrderCancellation;

    @FindBy(xpath = "//p[.='Cancel complete order']")
    private WebElement queryCancelCompleteOrder;

    @FindBy(xpath = "//p[contains(.,'Order placed by mistake')]")
    private WebElement queryOrderPlacedByMistake;

    @FindBy(xpath = "//button//span[contains(.,'CANCEL')]")
    private WebElement QueryCancelButton;

    @FindBy(xpath = "//h1[contains(.,'REQUEST SENT SUCCESSFULLY!')]")
    private WebElement requestSentSuccessfully;

    public OrderDetailPages(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public void clickCancelButton() {
        HelperMethods.waitForElementToBeVisible(driver, cancelButton);
        HelperMethods.clickElement(cancelButton);
    }

    public void clickSelectAllCheckbox() {
        HelperMethods.waitForElementToBeVisible(driver, selectAllCheckbox);
        HelperMethods.clickElement(selectAllCheckbox);
    }

    public void submitCancelQueries() {
        HelperMethods.clickElement(selectAllCheckbox);
        HelperMethods.waitForElementToBeVisible(driver, QueryInput);
        HelperMethods.clickElement(QueryInput);
        HelperMethods.clickElement(queryOrderCancellation);
        HelperMethods.clickElement(queryCancelCompleteOrder);
        HelperMethods.clickElement(queryOrderPlacedByMistake);
        try {
            HelperMethods.waitForElementToBeClickable(driver, QueryCancelButton);
            HelperMethods.clickElement(QueryCancelButton);
        } catch (Exception e) {
            System.out.println("Cancel Button is not clickable");
        }
    }

    public String getRequestSentSuccessfullyMessage() {
        HelperMethods.waitForElementToBeVisible(driver, requestSentSuccessfully);
        return HelperMethods.getTextFromElement(requestSentSuccessfully);
    }

}