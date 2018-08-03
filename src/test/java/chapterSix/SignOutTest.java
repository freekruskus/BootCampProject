package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignOutTest extends TestShopScenario{

    @Test
    public void SignInAndSignOut(){

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("freek.ruskus@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("bootcamptest");
        driver.findElement(By.id("SubmitLogin")).click();

        WebElement HeaderValue = driver.findElement(By.className("page-heading"));
        WebElement AccountName = driver.findElement(By.className("account"));
        boolean SignOutPresent = driver.findElements(By.className("logout")).size() > 0;

        Assert.assertEquals(HeaderValue.getText(),"MY ACCOUNT");
        Assert.assertEquals(AccountName.getText(), "Freek Ruskus");
        Assert.assertTrue(SignOutPresent);

        driver.findElement(By.className("logout")).click();

        boolean SignInPresent = driver.findElements(By.className("login")).size() > 0;
        Assert.assertTrue(SignInPresent);
    }
}
