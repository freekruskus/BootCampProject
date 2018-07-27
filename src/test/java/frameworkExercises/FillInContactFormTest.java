package frameworkExercises;

import bootCamp.ContactUsPage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FillInContactFormTest extends TestShopScenario{

        @Test
        public void fillInForm(){
                driver.findElement(By.cssSelector("[title='Contact us']")).click();

                ContactUsPage myContactPage = new ContactUsPage(driver);
                myContactPage.fillInContactForm("bootcamper@feelthepain.com", "4321234", "Ipod defect while lifting, need new one");

                assertThat(driver.findElement(By.cssSelector("[class='alert alert-success']")).isDisplayed());
        }

}
