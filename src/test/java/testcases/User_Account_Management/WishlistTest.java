package testcases.User_Account_Management;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BackPage;
import pages.DetailPage;
import pages.ListingPage;
import pages.WishList;

public class WishlistTest extends BaseTest {
    WishList wishList;
    ListingPage listingPage;
    DetailPage detailPage;
    BackPage backPage;

    @BeforeTest
    public void setup() {
        initializeDriver();
        this.wishList = new WishList(driver);
        this.listingPage = new ListingPage(driver);
        this.detailPage = new DetailPage(driver);
        this.backPage = new BackPage(driver);
    }

    @AfterTest
    public void tearDown() {
        quitDriver();
    }

    // Test case : Add product to wishlist and verify the product is added
    @Test(priority = 1)
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
    public void testRemoveProductFromWishlist() {
        driver.get("https://www.dailyobjects.com/cable-protector/dp?f=pid~CABLE-PROTECTOR");
        detailPage.getAddToWishListButtonDP().click();
        driver.get("https://www.dailyobjects.com/uap/wlp");
        wishList.getRemoveProductButton().click();
        driver.navigate().refresh();
        Assert.assertTrue(wishList.getEmptyWishListMessage().equals("YOUR WISHLIST IS EMPTY"), "Product is not removed from wishlist");
    }
}
