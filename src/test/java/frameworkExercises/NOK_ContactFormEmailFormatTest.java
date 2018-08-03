package frameworkExercises;

import chapterSix.TestShopScenario;
import pages.ContactUsPage;
import pages.HomePage;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class NOK_ContactFormEmailFormatTest extends TestShopScenario {

    @Test
    public void fillInForm(){

        HomePage myHomePage = new HomePage(driver);
        ContactUsPage myContactPage = new ContactUsPage(driver);

        myHomePage.notLoggedInContactPage();

        assertThat(myContactPage.fillInNameInContactForm("nope"));
        assertThat(!myContactPage.fillInNameInContactForm("nope@correct.com"));
    }
}
