package frameworkExercises;

import bootCamp.ContactUsPage;
import chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FillInContactFormTest extends TestShopScenario {

        @Test
        public void fillInForm(){

                if(driver.findElement(By.className("login")).isDisplayed()) {
                        driver.findElement(By.cssSelector("[title='Contact us']")).click();

                        ContactUsPage myContactPage = new ContactUsPage(driver);
                        myContactPage.fillInContactForm("bootcamper@feelthepain.com", "4321234", "Ipod defect while lifting, need new one");

                        assertThat(driver.findElement(By.cssSelector("[class='alert alert-success']")).isDisplayed());
                }
                else{
                        System.out.println("Please log out of your account before contacting Customer Support.");
                }
        }

}
