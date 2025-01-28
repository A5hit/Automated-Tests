package testcases.Product_Management;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/UserOrderJourney.feature",
        glue = "stepdefinations",
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true
)

public class ProductPurchaseJourneyTest extends AbstractTestNGCucumberTests {
}
