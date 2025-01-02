package pages;

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

    @FindBy(xpath="//div[@class='desc']/h1")
    private WebElement productTitleDP; // Product Title on Detail Page


    public DetailPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement getAddToWishListButtonDP () {
         wait.until(ExpectedConditions.elementToBeClickable(addToWishListButton));
         return addToWishListButton;
    }

    public WebElement getProductTitleDP() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(productTitleDP));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to wait for element to appear: " + productTitleDP, e);
        }
    }

}
