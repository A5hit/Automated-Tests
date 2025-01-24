package pages;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BackPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//div[@class='description']/div/p[1]")
    private WebElement productTitlesBP;  // Product Titles on Cart Page

    @FindBy(xpath = "//app-price-display[@class='d-price-display']//mat-card//button")
    private WebElement proceedToCheckoutButton; // Proceed to Checkout button on Cart Page

    public BackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public String getProductTitleBP() {
        wait.until(ExpectedConditions.visibilityOf(productTitlesBP));
        return productTitlesBP.getText();
    }

    public void clickProceedToCheckoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
    }


}
