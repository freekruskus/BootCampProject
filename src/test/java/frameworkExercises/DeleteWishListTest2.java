package frameworkExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class DeleteWishListTest2 extends TestShopScenario {

    @Test
    public void webTableEditing() {

        driver.findElement(By.className("login")).click();
        driver.findElement(By.id("email")).sendKeys("freek@ruskus.com");
        driver.findElement(By.id("passwd")).sendKeys("1qazxsw2");
        driver.findElement(By.id("SubmitLogin")).click();
        driver.findElement((By.cssSelector("[class='icon-heart']"))).click();

        String wishListName = "HiiT List";
        String headerName = "Delete";

        List<WebElement> rowCollection = driver.findElements(By.xpath("//*[@class='table table-bordered']/tbody/tr"));
        List<WebElement> headerCollection = driver.findElements(By.xpath("//*[@class='table table-bordered']/thead/tr/th"));

        //Looks for header containing "Delete".
        int header_position=0;
        for (int i = 0; i < headerCollection.size(); i++) {
            if (headerName.equalsIgnoreCase(headerCollection.get(i).getText())) {
                header_position = i + 1;
                System.out.println(header_position);
                break;
            }
        }

        //Looks for row containing "Feel the pain".
        int row_position=1;
        boolean jobDone = false;
        for (WebElement rowElement : rowCollection) {

            List<WebElement> colCollection = rowElement.findElements(By.xpath("td"));

            for (WebElement colContents : colCollection) {

                if (colContents.getText().equals(wishListName)) {
                    System.out.println(row_position);
                    System.out.println("wishlist found.");
                    driver.findElement(By.xpath("//tr[" + row_position + "]  //td[" + header_position + "] //a")).click();
                    driver.switchTo().alert().accept();
                    jobDone = true;
                    break;
                }
            }
            if(jobDone){
                break;
            }
            row_position++;
        }

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

