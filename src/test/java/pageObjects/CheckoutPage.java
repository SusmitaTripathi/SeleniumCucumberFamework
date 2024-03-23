package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CheckoutPage {

    public WebDriver driver;

    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }

    By checkoutPage_btnCart = By.xpath("//a[@class='cart-icon']");

    By checkoutPage_btnProceedToCheckout = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

    By checkoutPage_btnApply = By.xpath("//button[text()='Apply']");

    By checkoutPage_btnPlaceOrder = By.xpath("//button[text()='Place Order']");

    By checkoutPage_txtProductName = By.xpath("//p[@class='product-name']");

    public void checkoutItems(){
        driver.findElement(checkoutPage_btnCart).click();
        driver.findElement(checkoutPage_btnProceedToCheckout).click();
    }

    public boolean verifyPromoButton(){
        return driver.findElement(checkoutPage_btnApply).isDisplayed();
    }

    public boolean verifyPlaceOrder(){
        return driver.findElement(checkoutPage_btnPlaceOrder).isDisplayed();
    }

    public String getProductName(){
        return driver.findElement(checkoutPage_txtProductName).getText();
    }

}
