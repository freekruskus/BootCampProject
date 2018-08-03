package frameworkExercises;

import chapterSix.TestShopScenario;
import pages.ContactUsPage;
import pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class FillInContactFormTest extends TestShopScenario {

        @Test
        public void fillInForm(){

            HomePage myHomePage = new HomePage(driver);
            ContactUsPage myContactPage = new ContactUsPage(driver);

            myHomePage.notLoggedInContactPage();
            myContactPage.fillInContactForm("Customer service","bootcamper@feelthepain.com", "4321234", "Ipod defect while lifting, need new one");
            assertThat(driver.findElement(By.cssSelector("[class='alert alert-success']")).isDisplayed());
        }

}
