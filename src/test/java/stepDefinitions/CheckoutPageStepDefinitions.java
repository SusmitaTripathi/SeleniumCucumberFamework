package stepDefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {

    TestContextSetup testContextSetup;
    CheckoutPage checkoutPage;
    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
        this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
    }

    @Then("^User proceeds to checkout and validates the (.+) items in checkout page$")
    public void userProceedsToCheckoutAndValidatesTheItemsInCheckoutPage(String productName) throws Exception {
        checkoutPage.checkoutItems();
        System.out.println(checkoutPage.getProductName());
        Assert.assertTrue(checkoutPage.getProductName().contains(productName));
    }

    @Then("User enters promo code and proceeds to place order")
    public void userEntersPromoCodeAndProceedsToPlaceOrder() throws Exception{
        Assert.assertTrue(checkoutPage.verifyPromoButton());
        Assert.assertTrue(checkoutPage.verifyPlaceOrder());
    }

}
