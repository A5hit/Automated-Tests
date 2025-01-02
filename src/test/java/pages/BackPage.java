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

    @FindBy(xpath ="//div[@class='description']/div/p[1]")
    private WebElement productTitlesBP;  // Product Titles on Cart Page

    public BackPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getProductTitleBP() {
        wait.until(ExpectedConditions.visibilityOf(productTitlesBP));
        return productTitlesBP.getText();
    }
}
