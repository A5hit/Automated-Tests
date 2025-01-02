package pages;

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

    @FindBy(css = "body app-root div[class='ng-star-inserted'] div div[class='bag-page-column-desktop'] p:nth-child(1)")
    private WebElement productTitlesBP;  // Product Titles on Cart Page

    public BackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductTitleBP() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(productTitlesBP));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to wait for element to appear: " + productTitlesBP, e);
        }
    }
}
