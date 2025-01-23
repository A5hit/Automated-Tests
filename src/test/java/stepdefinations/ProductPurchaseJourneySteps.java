package stepdefinations;

import driverInit.BaseTest;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.BackPage;
import pages.DetailPage;

public class ProductPurchaseJourneySteps extends BaseTest {

    DetailPage detailPage;
    BackPage backPage;
    String productTitleDP;
    String productTitleBP;

    @Given("User is on Product Page <product_url>")
    public void user_is_on_the_product_page(String url) {
        setup();
        this.detailPage = new DetailPage(driver);
        this.backPage = new BackPage(driver);
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

    @And("User Enter Shipping Details")
    public void user_enter_shipping_details() {


    }

    @And("User Enter Payment Details")
    public void user_enter_payment_details() {
        // Write code here that turns the phrase above into concrete actions

    }

    @And("User Place the Order")
    public void user_place_the_order() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("Message displayed Order Placed Successfully")
    public void message_displayed_order_placed_successfully() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("User is on Order Page")
    public void user_is_on_order_page() {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("User Click on Cancel Order")
    public void user_click_on_cancel_order() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("Message displayed Order Cancelled Successfully")
    public void message_displayed_order_cancelled_successfully() {
        // Write code here that turns the phrase above into concrete actions
    }


}
