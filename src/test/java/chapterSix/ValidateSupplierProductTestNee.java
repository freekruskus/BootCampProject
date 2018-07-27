package chapterSix;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateSupplierProductTestNee extends TestShopScenario{

    @Test
    public void ValidateSupplierProduct() {

        driver.findElement(By.cssSelector("[name='supplier_list']")).click();
        driver.findElement(By.cssSelector("[value='https://techblog.polteq.com/testshop/index.php?id_supplier=1&controller=supplier']")).click();

        String ProductCheck = driver.findElement(By.cssSelector("[class='center_column col-xs-12 col-sm-6']")).getText();

        assertThat(ProductCheck).contains("MacBook Air");
    }

}
