package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {

	TestContextSetup testContextSetup;
	LandingPage landingPage;

	//dependency injection
	public LandingPageStepDefinitions(TestContextSetup testContextSetup){
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}

	@Given("User is on greencart landing page")
	public void user_is_on_greencart_landing_page() {
		Assert.assertTrue(landingPage.getLandingPageTitle().contains("GreenKart"));
	}

	@When("^User searches with shortname (.+) and extracts actual name of product$")
	public void user_searches_with_shortname_and_extracts_actual_name_of_product(String shortName) throws Exception {
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println("Product Name from landing page: " + testContextSetup.landingPageProductName);
	}

	@When("User added {string} items of selected product to cart")
	public void userAddedItemsOfSelectedProductToCart(String quantity) {
		landingPage.incrementItems(quantity);
		landingPage.addProductsToCart();
	}
}
