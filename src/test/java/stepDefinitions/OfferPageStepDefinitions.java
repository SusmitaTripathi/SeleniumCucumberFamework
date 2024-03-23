package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinitions {
    public String offerPageProductName;
    TestContextSetup testContextSetup;
    public OfferPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }

    @Then("^User searches for (.+) shortname in offer page$")
    public void user_searches_for_same_shortname_in_offer_page(String shortName) throws Exception {
        testContextSetup.pageObjectManager.getLandingPage().clickOnTopDeals();
        testContextSetup.genericUtils.switchToChildWindow();
        testContextSetup.pageObjectManager.getOffersPage().searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = testContextSetup.pageObjectManager.getOffersPage().getProductName();
        System.out.println("Product Name from offer page: " + offerPageProductName);
    }

    @Then("User verifies if product exists")
    public void user_verifies_if_product_exists() {
        Assert.assertEquals(testContextSetup.landingPageProductName, offerPageProductName);
    }

}
