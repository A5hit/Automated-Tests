package testcases.Product_Management;

import base.BaseTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;



public class ProductPurchaseJourneyTest extends BaseTest {


    @BeforeTest
    public void setup() {
        initializeDriver();
    }

    @AfterTest
    public void tearDown() {
        quitDriver();
    }



}
