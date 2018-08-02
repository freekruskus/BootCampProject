package frameworkExercises;

import chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LogInTest extends TestShopScenario{

    @Test
    public void LogIntoPage(){
        LogInPage goToLogInPage = new LogInPage(driver);
        goToLogInPage.LogIn("bootcamper@feelthepain.com", "1qazxsw2");
    }
}
