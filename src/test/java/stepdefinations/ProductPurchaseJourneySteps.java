package stepdefinations;


import driverInit.DriverFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.*;
import pages.user_account_pages.User_Address;
import pages.popup.Product_Actions;
import pages.user_account_pages.User_Orders_Detail;

public class ProductPurchaseJourneySteps extends DriverFactory {

    WebDriver driver;
    DetailPage detailPage;
    BackPage backPage;
    User_Address userAddress;
    CheckoutPage checkoutPage;
    CheckoutStatusPage checkoutStatusPage;
    User_Orders_Detail userOrdersDetail;
    Product_Actions product_actions;
    String productTitleDP;
    String productTitleBP;
    String orderNumber;

    @Before
    public void setup() {  // User has a blank cart and blank address
        this.driver = initializeDriver();
        backPage = new BackPage(driver);
        userAddress = new User_Address(driver);
        product_actions = new Product_Actions(driver);
        detailPage = new DetailPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutStatusPage = new CheckoutStatusPage(driver);
        userOrdersDetail = new User_Orders_Detail(driver);
    }

    @Given("Given the user's cart and saved address are empty")
    public void userHasABlankCartAndBlankAddress() {
        driver.get(backPage.BackPageURL);
        if (!backPage.isCartEmpty()) {
            backPage.removeProductFromCart();
            product_actions.removefromCart();
        }
        driver.get(userAddress.AddressURL);
        if (!userAddress.isAddressEmpty()) {
            userAddress.deleteAddress();
        }
    }

    @Given("User is on Product Page {string}")
    public void user_is_on_the_product_page(String productUrl) {
        driver.get(productUrl);
    }

    @When("User adds product to cart and proceeds to checkout")
    public void user_add_product_to_cart_and_proceed_to_checkout() {
        productTitleDP = detailPage.getProductTitleDP();
        detailPage.getProductAddedToCart();
        productTitleBP = backPage.getProductTitleBP();
        Assert.assertEquals(productTitleDP, productTitleBP, "Product Title does not match");
        backPage.clickProceedToCheckoutButton();
    }

    @And("User enters shipping details {string} {string} {string} {string} {string} {string}")
    public void userEnterShippingDetails(String fullName, String email, String pincode, String address1, String address2, String landmark) throws InterruptedException {
        /*Assert.assertTrue(fullName != null && !fullName.isEmpty(), "Full Name is invalid");
        Assert.assertTrue(email != null && email.contains("@"), "Email is invalid");
        Assert.assertTrue(pincode != null && pincode.isEmpty(), "Pincode is invalid");
        Assert.assertTrue(address1 != null && !address1.isEmpty(), "Address1 is invalid");
        Assert.assertTrue(address2 != null && !address2.isEmpty(), "Address2 is invalid");
        Assert.assertTrue(landmark != null && !landmark.isEmpty(), "Landmark is invalid");*/
        userAddress.enterShippingDetails(fullName, email, pincode, address1, address2, landmark);
    }

    @And("User enters payment details")
    public void user_enter_payment_details() {
        checkoutPage.clickContinueButton();
        checkoutPage.selectCODPaymentOption();
    }

    @And("User places the order")
    public void user_place_the_order() {
        checkoutPage.clickPlaceOrderButton();
    }

    @Then("the confirmation message 'Order Placed Successfully' should be displayed")
    public void message_displayed_order_placed_successfully() {
        this.orderNumber = checkoutStatusPage.getOrderNumber();
        Assert.assertEquals(checkoutStatusPage.getOrderPlacedSuccessfullyMessage(), "ORDER RECEIVED", "Order Placed Successfully message is not displayed");
    }

    @Given("User is on Order Page")
    public void user_is_on_order_page() {
        driver.get("https://www.dailyobjects.com/uap/odp?f=oid~" + this.orderNumber);
    }

    @When("User clicks on Cancel Order")
    public void user_click_on_cancel_order() {
        userOrdersDetail.clickCancelButton();
    }

    @Then("Message displayed Order Cancelled Successfully")
    public void message_displayed_order_cancelled_successfully() {
        userOrdersDetail.submitCancelQueries();
        Assert.assertEquals(userOrdersDetail.getRequestSentSuccessfullyMessage(), "REQUEST SENT SUCCESSFULLY!", "Request Sent Successfully message is not displayed");
    }


}
