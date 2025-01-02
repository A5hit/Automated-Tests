package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ListingPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[@ngclass.gt-xs='wishlist-desktop-button']")
    private WebElement addToWishListButtons;  // All Add to Wish List buttons on Listing Page

    @FindBy(xpath = "//p[@class='text ng-star-inserted']")
    private WebElement productTitles;  // All Product Titles on Listing Page

    public ListingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddToWishListButtons() {
        return wait.until(ExpectedConditions.visibilityOf(addToWishListButtons));
    }

    public String getProductTitlesLP() {
        wait.until(ExpectedConditions.visibilityOf(productTitles));
        return productTitles.getText();
    }
}
