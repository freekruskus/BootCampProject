package frameworkExercises;

import chapterSix.TestShopScenario;
import frameworkExercises.pages.ContactUsPage;
import frameworkExercises.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NOK_FillInContactFormTest extends TestShopScenario {

    @Test
    public void fillInForm(){

        HomePage myHomePage = new HomePage(driver);
        ContactUsPage myContactPage = new ContactUsPage(driver);

        myHomePage.notLoggedInContactPage();
        myContactPage.fillInContactForm("nope", "4321234", "Help!");
        assertThat(driver.findElement(By.cssSelector("[class='alert alert-danger']")).isDisplayed());

    }
}
