package chapterSix;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EmptyCartTest extends TestShopScenario {

    @Test
    public void EmptyCart(){

        WebElement cartStatus = driver.findElement(By.className("ajax_cart_no_product"));

        if(cartStatus.isDisplayed() == true) {


            driver.findElement(By.className("first_item")).click();
            driver.findElement(By.cssSelector("[class=\"product-name\"][title=\"iPod shuffle\"]")).click();
            driver.findElement(By.cssSelector("[class=\"buttons_bottom_block no-print\"] [type=\"submit\"]")).click();

            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class=\"continue btn btn-default button exclusive-medium\"]")));

            driver.findElement(By.cssSelector("[class=\"continue btn btn-default button exclusive-medium\"]")).click();

            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[title=\"View my shopping cart\"]")));

            driver.findElement(By.cssSelector("[title=\"View my shopping cart\"]")).click();
            driver.findElement(By.cssSelector("[class=\"icon-trash\"]")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ajax_cart_no_product")));

            assertThat(cartStatus.isDisplayed()).isTrue().as("Cart has to be empty.");
        }
    }
}
