package chapterSix;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateSupplierProductTest extends TestShopScenario{

    @Test
    public void ValidateSupplierProduct() {

        driver.findElement(By.cssSelector("[name='supplier_list']")).click();
        driver.findElement(By.cssSelector("[value='https://techblog.polteq.com/testshop/index.php?id_supplier=1&controller=supplier']")).click();

        List<WebElement> appleProductsList=driver.findElements(By.cssSelector("[id='center_column'] [class='product-name']"));
        List<String> productStringList=new ArrayList<String>();

        for(int i=0; i<appleProductsList.size(); i++){
            productStringList.add(appleProductsList.get(i).getText());
            System.out.println(productStringList);
        }
        assertThat(productStringList).contains("MacBook Air").as("Product list has to contain MacBook Air.");
    }

}
