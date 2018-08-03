package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {

    private WebDriver driver;
    String wishListElement;

    public AccountPage(WebDriver driver){
        this.driver = driver;
    }

    public void createWishList(String wishListName){
        if(driver.findElement(By.cssSelector("[class='icon-heart']")).isDisplayed()){
            driver.findElement(By.cssSelector("[class='icon-heart']")).click();
            driver.findElement(By.cssSelector("[class='inputTxt form-control']")).sendKeys(wishListName);
            driver.findElement(By.cssSelector("[name='submitWishlist']")).click();
        }
    }

    public String checkWishList(){
        return wishListElement = driver.findElement(By.xpath("//td[1]")).getText();
    }
}
