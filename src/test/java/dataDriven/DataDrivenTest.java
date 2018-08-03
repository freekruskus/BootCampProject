package dataDriven;

import chapterSix.TestShopScenario;
import org.testng.annotations.Parameters;
import pages.ContactUsPage;
import pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DataDrivenTest extends TestShopScenario {

        @Parameters({"subject", "email", "orderID", "message"})
        @Test
        public void fillInForm(String subject, String email, String orderID, String message){

            HomePage myHomePage = new HomePage(driver);
            myHomePage.notLoggedInContactPage();

            ContactUsPage myContactPage = new ContactUsPage(driver);
            myContactPage.fillInContactForm(subject, email, orderID, message);
            assertThat(driver.findElement(By.cssSelector("[class='alert alert-success']")).isDisplayed());

        }

}
