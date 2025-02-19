package pages.user_account_pages;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishList {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(.,' MOVE TO CART')]")
    private WebElement moveToCartButton; // Move to Cart button on Wish List Page

    @FindBy(xpath = "//span[contains(.,'Go To Cart')]")
    private WebElement goToCartButton; // Go To Cart button on Wish List Page

    @FindBy(xpath = "//*[@id=\"uapRight\"]/app-wishlist-page/div/div[1]/div/div/div[1]/p[1]")
    private WebElement productTitles; //  Product Titles on Wish List Page

    @FindBy(xpath = "//div[@class='move-to-cart']//img")
    private WebElement removeProductButton; // Remove Product button on Wish List Page

    @FindBy(xpath = "//p[@class='error-page__heading']")
    private WebElement emptyWishListMessage; // Empty Wish List Message

    public WishList(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    public String getProductTitlesWishlist() {
        wait.until(ExpectedConditions.visibilityOf(productTitles));
        return productTitles.getText();
    }

    public WebElement getMoveToCartButton() {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(moveToCartButton));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to wait for element to appear: " + moveToCartButton, e);
        }
    }

    public WebElement getRemoveProductButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(removeProductButton));
    }

    public WebElement getGoToCartButton() {
        wait.until(ExpectedConditions.visibilityOf(goToCartButton));
        return goToCartButton;
    }

    public String getEmptyWishListMessage() {
        wait.until(ExpectedConditions.visibilityOf(emptyWishListMessage));
        return emptyWishListMessage.getText();
    }
}
