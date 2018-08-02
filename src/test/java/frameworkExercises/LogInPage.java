package frameworkExercises;

import chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class LogInPage extends TestShopScenario {

    private WebDriver driver;

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public void LogIn(String loginName, String password){

        if(driver.findElement(By.className("login")).isDisplayed()) {

            driver.findElement(By.className("login")).click();
            driver.findElement(By.id("email")).sendKeys(loginName);
            driver.findElement(By.id("passwd")).sendKeys(password);
            driver.findElement(By.id("SubmitLogin")).click();
        }
    }
}
