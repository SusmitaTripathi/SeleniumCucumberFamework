package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class OffersPage {


    By search = By.xpath("//input[@type='search']");
    By productName = By.xpath("//tbody/tr/td[1]");


    WebDriver driver;

    public OffersPage(WebDriver driver){
        this.driver = driver;
    }

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
}
