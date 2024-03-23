package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LandingPage {
    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//h4[@class='product-name']");

    By topDeals = By.linkText("Top Deals");

    By landingPage_btnAddProducts = By.xpath("//a[@class='increment']");

    By landingPage_btnAddToCart = By.xpath("//button[text()='ADD TO CART']");
    public WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public void getSearchString(){
        driver.findElement(search).getText();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

    public void clickOnTopDeals(){
        driver.findElement(topDeals).click();
    }

    public String getLandingPageTitle() { return driver.getTitle();}

    public void incrementItems(String quantity){
        int itemCount = Integer.parseInt(quantity);
        for (int i = 1; i < itemCount ; i++ ){
            driver.findElement(landingPage_btnAddProducts).click();
        }
    }

    public void addProductsToCart(){
        driver.findElement(landingPage_btnAddToCart).click();
    }
}
