package pages.user_account_pages;

import config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HelperMethods;

import java.time.Duration;

public class User_Address {

    WebDriver driver;
    WebDriverWait wait;
    public String AddressURL = "https://dev.marche.dailyobjects.com/uap/map";

    public User_Address(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.WAIT_TIMEOUT));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='cdk-overlay-pane desktop-screen-dialog-add-address']")
    private WebElement addAddressPopUp;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane desktop-screen-dialog-add-address']//input[@data-placeholder='Full Name']")
    private WebElement fullNameField;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane desktop-screen-dialog-add-address']//input[@data-placeholder='Email Address']")
    private WebElement emailAddressField;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane desktop-screen-dialog-add-address']//input[@data-placeholder='Pincode']")
    private WebElement pincodeField;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane desktop-screen-dialog-add-address']//input[@data-placeholder='Flat No/Building, Street Name']")
    private WebElement addressField1;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane desktop-screen-dialog-add-address']//input[@data-placeholder='Area/Locality']")
    private WebElement addressField2;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane desktop-screen-dialog-add-address']//input[@data-placeholder='Landmark']")
    private WebElement landmarkField;

    @FindBy(xpath = "//div[@class='cdk-overlay-pane desktop-screen-dialog-add-address']//button//span[contains(.,'ADD ADDRESS')]")
    private WebElement addAddressButton;

    @FindBy(xpath = "//div[@class='options']/button[contains(.,'Delete')]")
    private WebElement deleteAddressButton;

    @FindBy(xpath = "//button/span[contains(.,'DELETE')]")
    private WebElement confirmDeleteAddressButton;

    @FindBy(xpath = "//p[contains(.,'NO ADDRESS')]")
    private WebElement noAddressMessage;

    public void enterShippingDetails(String fullName, String email, String pincode, String address1, String address2, String landmark) throws InterruptedException {
        HelperMethods.waitForElementToBeVisible(driver, addAddressPopUp);
        HelperMethods.clickElement(addAddressPopUp);
        HelperMethods.enterText(fullNameField, fullName);
        HelperMethods.enterText(emailAddressField, email);
        HelperMethods.enterText(pincodeField, String.valueOf(pincode));
        Thread.sleep(2000);
        HelperMethods.enterText(addressField1, address1);
        HelperMethods.enterText(addressField2, address2);
        HelperMethods.enterText(landmarkField, landmark);
        HelperMethods.clickElement(addAddressButton);
    }

    public void deleteAddress() {
            HelperMethods.clickElement(deleteAddressButton);
            HelperMethods.waitForElementToBeClickable(driver, confirmDeleteAddressButton);
            HelperMethods.clickElement(confirmDeleteAddressButton);
    }

    public boolean isAddressEmpty() {
        try {
            return HelperMethods.isElementDisplayed(noAddressMessage);
        }
        catch (Exception e) {
            return false;
        }

    }


}
