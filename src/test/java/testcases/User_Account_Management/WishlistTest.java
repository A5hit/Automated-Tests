package testcases.User_Account_Management;

import base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BackPage;
import pages.DetailPage;
import pages.ListingPage;
import pages.WishList;

public class WishlistTest extends BaseTest {
    WishList wishList;
    ListingPage listingPage;
    DetailPage detailPage;
    BackPage backPage;

    @BeforeClass
    public void setup() {
        initializeDriver();
        this.wishList = new WishList(driver);
        this.listingPage = new ListingPage(driver);
        this.detailPage = new DetailPage(driver);
        this.backPage = new BackPage(driver);
    }

    @AfterClass
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
        productTitleWishlist = wishList.getProductTitlesWishlist().getText();
        Assert.assertEquals(productTitleLP,productTitleWishlist,"Product is not added to wishlist");
    }

    // Test case : Remove product from wishlist & Add to cart and verify
    @Test(priority = 2)
    public void testMoveProductToCartAndVerify() {
        wishList.getMoveToCartButton().click();
        driver.get("https://www.dailyobjects.com/bp");
        productTitleBP = backPage.getProductTitleBP().getText();
        Assert.assertEquals(productTitleWishlist,productTitleBP,"Product is not moved to cart");
    }

    // Test case : Remove product from wishlist
    @Test(priority = 3)
    public void testRemoveProductFromWishlist() {
        driver.get("https://www.dailyobjects.com/cable-protector/dp?f=pid~CABLE-PROTECTOR");
        detailPage.getAddToWishListButtonDP().click();
        driver.get("https://www.dailyobjects.com/uap/wlp");
        wishList.getRemoveProductButton().click();
        driver.navigate().refresh();
        Assert.assertFalse(wishList.getRemoveProductButton().isDisplayed(),"Product is not removed from wishlist");
    }
}
