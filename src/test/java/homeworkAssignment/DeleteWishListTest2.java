package homeworkAssignment;

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

        String wishListName = "Feel the pain";
        String headerName = "Delete";

        List<WebElement> rowCollection = driver.findElements(By.xpath("//*[@class='table table-bordered']/tbody/tr"));
        List<WebElement> headerCollection = driver.findElements(By.xpath("//*[@class='table table-bordered']/thead/tr/th"));

        //Looks for header "Delete".
        int header_position=0;
        for (int i = 0; i < headerCollection.size(); i++) {
            if (headerName.equals(headerCollection.get(i).getText())) {
                header_position = i + 1;
                //System.out.println(header_position);
                break;
            }
        }

        //Looks for row containing "Feel the pain", keeping track of cell position.
        int row_position=0;
        int col_position=0;
        boolean jobDone = false;

        for (WebElement rowElement : rowCollection) {
            row_position++;
            List<WebElement> colCollection = rowElement.findElements(By.xpath("td"));

            for (WebElement colContents : colCollection) {
                col_position++;
                if (colContents.getText().equals(wishListName)) {
                    /*System.out.println(col_position);
                    System.out.println(row_position);*/
                    driver.findElement(By.xpath("//tr[" + row_position + "]  //td[" + header_position + "] //a")).click();
                    driver.switchTo().alert().accept();
                    jobDone = true;
                    break;
                }
            }
            if(jobDone){
                break;
            }

            col_position=0;
        }

        if(jobDone) {
            //waits for table to be updated.
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//a[contains(text(),'" + wishListName + "')]"), wishListName));

            //asserts that previously checked row no longer contains "Feel the pain".

            if (driver.findElements(By.xpath("//tr[" + row_position + "] //td[" + col_position + "]")).size() > 0) {
                assertThat(driver.findElement(By.xpath("//tr[" + row_position + "] //td[" + col_position + "]")).getText()).doesNotMatch(wishListName);
            } else {
                assertThat(driver.findElement(By.xpath("//tr[" + (row_position - 1) + "] //td[" + col_position + "]")).getText()).doesNotMatch(wishListName);
            }

            //adds "Feel the pain" back to the list of wishlists.
            driver.findElement(By.cssSelector("[class='inputTxt form-control']")).sendKeys(wishListName);
            driver.findElement(By.cssSelector("[name='submitWishlist']")).click();

            //asserts that wishlist contains "Feel the pain".
            assertThat(driver.findElement(By.cssSelector("[class='table table-bordered']")).getText()).contains(wishListName);
        }
        else{
            System.out.println("Wishlist not found.");
        }
    }
}