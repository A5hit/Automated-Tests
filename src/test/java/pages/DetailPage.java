package pages;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//img[@alt='wishlist_black.png']")
    private WebElement addToWishListButton; // Add to Wish List button on Detail Page

    @FindBy(xpath = "//div[@class='desc']/h1")
    private WebElement productTitleDP;

    @FindBy(xpath = "//div[@class='dp-content']/div[@class='ng-star-inserted']/button")
    private WebElement addToCartListButton; // Product Add-to-cart button on Detail Page

    @FindBy(xpath = "//div[@class='cdk-overlay-container']//app-cros-selling-page//mat-dialog-actions//mat-card//button")
    private WebElement overlayGoToCartButton; // Go to Cart button on Overlay


    public DetailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddToWishListButtonDP() {
        wait.until(ExpectedConditions.elementToBeClickable(addToWishListButton));
        return addToWishListButton;
    }

    public WebElement getAddToCartButtonDP() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartListButton));
        return addToCartListButton;
    }

    public WebElement getOverlayGoToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(overlayGoToCartButton));
        return overlayGoToCartButton;
    }

    public void getProductAddedToCart() {
        getAddToCartButtonDP().click();
        try {
            if (getOverlayGoToCartButton().isDisplayed()) {
                getAddToCartButtonDP().click();
            } else {
                getOverlayGoToCartButton().click();
            }
        } catch (Exception ignored) {
            getAddToCartButtonDP().click();
        }
    }

    public String getProductTitleDP() {
        wait.until(ExpectedConditions.visibilityOf(productTitleDP));
        return productTitleDP.getText();
    }


}
