package frameworkExercises;

import bootCamp.ContactUsPage;
import chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest extends TestShopScenario {

    @Test
    public void fillInForm(){

        if(driver.findElement(By.className("login")).isDisplayed()) {

            LogInPage logInPage = new LogInPage();

            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys("<bootcamper@feelthepain.com");
            driver.findElement(By.id("passwd")).sendKeys("<1qazxsw2");
            driver.findElement(By.id("SubmitLogin")).click();


            ContactUsPage myContactPage = new ContactUsPage(driver);
            myContactPage.fillInContactForm("bootcamper@feelthepain.com", "4321234", "Ipod defect while lifting, need new one");

            assertThat(driver.findElement(By.cssSelector("[class='alert alert-success']")).isDisplayed());
        }
        else{
            System.out.println("Please log out of your account before contacting Customer Support.");
        }
    }
}
