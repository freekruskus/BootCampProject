package frameworkExercises;

import chapterSix.TestShopScenario;
import frameworkExercises.pages.ContactUsPage;
import frameworkExercises.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {

    @Test
    public void fillInForm(){

        HomePage myHomePage = new HomePage(driver);
        ContactUsPage myContactPage = new ContactUsPage(driver);

        myHomePage.notLoggedInContactPage();
        myContactPage.fillInNameInContactForm("nope");
        assertThat(driver.findElement(By.cssSelector("[class='form-control grey validate']")).isDisplayed());
        myContactPage.fillInNameInContactForm("nope@correct.com");
        assertThat(!driver.findElement(By.cssSelector("[class='form-control grey validate']")).isDisplayed());
    }
}
