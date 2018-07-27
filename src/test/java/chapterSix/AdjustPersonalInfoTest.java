package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AdjustPersonalInfoTest extends TestShopScenario{

    @Test
    public void AdjustFirstName() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("freek.ruskus@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("bootcamptest");
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement HeaderValue = driver.findElement(By.className("page-heading"));

        assertThat(HeaderValue.getText()).isEqualTo("MY ACCOUNT");

        driver.findElement(By.cssSelector("[title='Manage my personal information']")).click();

        String name1 = driver.findElement(By.cssSelector("[name='firstname']")).getAttribute("value");

        driver.findElement(By.cssSelector("[name='firstname']")).clear();

        if(name1.equals("Freek")){
            driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("NotFreek");
        }
        else {
            driver.findElement(By.cssSelector("[name='firstname']")).sendKeys("Freek");
        }

        driver.findElement(By.cssSelector("[name='old_passwd']")).sendKeys("bootcamptest");

        String name2 = driver.findElement(By.cssSelector("[name='firstname']")).getText();

        driver.findElement(By.cssSelector("[name='submitIdentity']")).click();

        assertThat(name1).isNotEqualTo(name2).as("Name has to be changed.");
    }
}
