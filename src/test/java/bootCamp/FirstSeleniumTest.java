package bootCamp;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    @Test
    public void logInSuccesFull(){
        ChromeDriverManager.getInstance().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://techblog.polteq.com/testshop/index.php");
        driver.manage().window().maximize();

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

        driver.quit();
    }

}
