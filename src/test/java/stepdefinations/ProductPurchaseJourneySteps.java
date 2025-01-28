package stepdefinations;

import config.ConfigReader;
import driverInit.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import pages.*;

public class ProductPurchaseJourneySteps extends BaseTest {

    DetailPage detailPage;
    BackPage backPage;
    PopUps popUps;
    CheckoutPage checkoutPage;
    CheckoutStatus checkoutStatus;
    OrderDetailPages orderDetailPages;
    String productTitleDP;
    String productTitleBP;
    String OrderNumber;

    @Before("User have blank cart & blank Address")
    public void User_have_blank_cart_n_blank_Address() {
        setup();
        driver.get(ConfigReader.BackPageURL);
        try {
            backPage.removeProductFromCart();
            popUps.removefromCart();
            Assert.assertTrue(backPage.isCartEmpty(), "Cart is not empty");
        } catch (Exception e) {
            System.out.println("Cart is already empty");
        }
    }


    @Given("User is on Product Page <product_url>")
    public void user_is_on_the_product_page(String url) {
        driver.get(url);
    }

    @When("User Add Product to Cart and Proceed to Checkout")
    public void user_add_product_to_cart_and_proceed_to_checkout() {
        productTitleDP = detailPage.getProductTitleDP();
        detailPage.getProductAddedToCart();
        productTitleBP = backPage.getProductTitleBP();
        Assert.assertEquals(productTitleDP, productTitleBP, "Product Title does not match");
        backPage.clickProceedToCheckoutButton();
    }

    @And("User Enter Shipping Details <{string}> <{string}> <{string}> <{string}> <{string}> <{string}>")
    public void userEnterShippingDetails(String fullName, String email, Integer pincode, String address1, String address2, String landmark) {
        Assert.assertTrue(fullName != null && !fullName.isEmpty(), "Full Name is invalid");
        Assert.assertTrue(email != null && email.contains("@"), "Email is invalid");
        Assert.assertTrue(pincode != null && pincode > 0, "Pincode is invalid");
        Assert.assertTrue(address1 != null && !address1.isEmpty(), "Address1 is invalid");
        Assert.assertTrue(address2 != null && !address2.isEmpty(), "Address2 is invalid");
        Assert.assertTrue(landmark != null && !landmark.isEmpty(), "Landmark is invalid");
        popUps.enterShippingDetails(fullName, email, pincode, address1, address2, landmark);
    }

    @And("User Enter Payment Details")
    public void user_enter_payment_details() {
        checkoutPage.clickContinueButton();
        checkoutPage.selectCODPaymentOption();
    }

    @And("User Place the Order")
    public void user_place_the_order() {
        checkoutPage.clickPlaceOrderButton();
    }

    @Then("Message displayed Order Placed Successfully")
    public void message_displayed_order_placed_successfully() {
        String OrderNumber = checkoutStatus.getOrderNumber();
        Assert.assertEquals(checkoutStatus.getOrderPlacedSuccessfullyMessage(), "ORDER RECEIVED", "Order Placed Successfully message is not displayed");
    }

    @Given("User is on Order Page")
    public void user_is_on_order_page() {
        driver.get("https://www.dailyobjects.com/uap/odp?f=oid~" + OrderNumber);
    }

    @When("User Click on Cancel Order")
    public void user_click_on_cancel_order() {
        orderDetailPages.clickCancelButton();
    }

    @Then("Message displayed Order Cancelled Successfully")
    public void message_displayed_order_cancelled_successfully() {
        orderDetailPages.submitCancelQueries();
        Assert.assertEquals(orderDetailPages.getRequestSentSuccessfullyMessage(), "REQUEST SENT SUCCESSFULLY!", "Request Sent Successfully message is not displayed");
    }


}
