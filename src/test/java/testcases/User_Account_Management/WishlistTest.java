package testcases.User_Account_Management;

import driverInit.DriverFactory;
import io.qameta.allure.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BackPage;
import pages.DetailPage;
import pages.ListingPage;
import pages.user_account_pages.WishList;

public class WishlistTest extends DriverFactory {

    WebDriver driver;
    WishList wishList;
    ListingPage listingPage;
    DetailPage detailPage;
    BackPage backPage;


    @BeforeMethod
    public void setup() {
        this.driver = initializeDriver();
        this.wishList = new WishList(driver);
        this.listingPage = new ListingPage(driver);
        this.detailPage = new DetailPage(driver);
        this.backPage = new BackPage(driver);
    }

    // Test case : Add product to wishlist and verify the product is added
    @Test(priority = 1)
    @Epic("Web")
    @Feature("Wishlist")
    @Story("Add product to wishlist and verify the product is added")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Add product to wishlist and verify the product is added")
    public void testAddProductToWishlistAndVerify() {
        driver.get("https://www.dailyobjects.com/lp?f=cid~1707");
        String productTitleLP = listingPage.getProductTitlesLP();
        listingPage.getAddToWishListButtons().click();
        driver.get("https://www.dailyobjects.com/uap/wlp");
        String productTitleWishlist1 = wishList.getProductTitlesWishlist();
        wishList.getRemoveProductButton().click();
        Assert.assertEquals(productTitleLP, productTitleWishlist1, "Product is not added to wishlist");
    }

    // Test case : Remove product from wishlist & Add to cart and verify
    @Test(priority = 2)
    @Severity(SeverityLevel.NORMAL)
    @Epic("Web")
    @Feature("Wishlist")
    @Story("Remove product from wishlist & Add to cart and verify")
    @Description("Remove product from wishlist & Add to cart and verify")
    public void testMoveProductToCartAndVerify() {
        driver.get("https://www.dailyobjects.com/cable-protector/dp?f=pid~CABLE-PROTECTOR");
        detailPage.getAddToWishListButtonDP().click();
        driver.get("https://www.dailyobjects.com/uap/wlp");
        String productTitleWishlist2 = wishList.getProductTitlesWishlist();
        wishList.getMoveToCartButton().click();
        wishList.getGoToCartButton().click();
        driver.get("https://www.dailyobjects.com/bp");
        String productTitleBP = backPage.getProductTitleBP();
        Assert.assertEquals(productTitleWishlist2, productTitleBP, "Product is not moved to cart");
    }

    // Test case : Remove product from wishlist
    @Test(priority = 3)
    @Severity(SeverityLevel.NORMAL)
    @Epic("Web")
    @Feature("Wishlist")
    @Story("Remove product from wishlist")
    @Description("Remove product from wishlist")
    public void testRemoveProductFromWishlist() throws InterruptedException {
        driver.get("https://www.dailyobjects.com/cable-protector/dp?f=pid~CABLE-PROTECTOR");
        detailPage.getAddToWishListButtonDP().click();
        driver.get("https://www.dailyobjects.com/uap/wlp");
        wishList.getRemoveProductButton().click();
        Thread.sleep(2000);
        driver.navigate().refresh();
        Assert.assertEquals(wishList.getEmptyWishListMessage(), "YOUR WISHLIST IS EMPTY", "Product is not removed from wishlist");
    }
}
