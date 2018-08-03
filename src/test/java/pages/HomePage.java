package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage{

    private WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void notLoggedInContactPage(){
        if(driver.findElement(By.className("login")).isDisplayed()) {

            driver.findElement(By.cssSelector("[title='Contact us']")).click();
        }
        else{
            System.out.println("Please log out of your account before contacting Customer Support.");
        }
    }

}
