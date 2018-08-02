package homeworkAssignment;

import chapterSix.TestShopScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class DeleteWishListTest extends TestShopScenario {

    @Test
    public void webTableEditing(){

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("freek@ruskus.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement((By.cssSelector("[class='icon-heart']"))).click();

        String wishListName = "Feel the pain";

        //Find elements containing "Feel the pain".
        List<WebElement> wishListRows = driver.findElements(By.xpath("//a[contains(text(),'" + wishListName + "')]"));
        List<String> wishListRowContents = new ArrayList<String>();

        //convert table elements to string array.
        for(int i=0; i<wishListRows.size(); i++){
            wishListRowContents.add(wishListRows.get(i).getText());
        }

        //if "Feel the pain" is found in table.
        if(wishListRowContents.contains(wishListName)) {

            //finds unique ID for row of table.
            WebElement wishListRowSelector = driver.findElement(By.xpath("//a[contains(text(),'" + wishListName + "')]"));
            WebElement parentSelector = wishListRowSelector.findElement((By.xpath("../..")));
            String idSelector = parentSelector.getAttribute("id");

            //finds correct delete button based on unique ID and deletes chosen wishlist.
            driver.findElement(By.xpath("//td[@class='wishlist_delete']/a[contains(@onclick, '" + idSelector + "')]")).click();
            driver.switchTo().alert().accept();

            //waits for table to be updated.
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//a[contains(text(),'" + wishListName + "')]"), wishListName));

            //asserts that wishlist does not contain "Feel the pain".
            assertThat(driver.findElement(By.cssSelector("[id='mywishlist']")).getText()).doesNotContain(wishListName);

            //adds "Feel the pain" back to the list of wishlists.
            driver.findElement(By.cssSelector("[class='inputTxt form-control']")).sendKeys(wishListName);
            driver.findElement(By.cssSelector("[name='submitWishlist']")).click();

            //asserts that wishlist contains "Feel the pain".
            assertThat(driver.findElement(By.cssSelector("[id='mywishlist']")).getText()).contains(wishListName);
        }

    }
}
