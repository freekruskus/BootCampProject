package browserDriven;

import browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class TestShopScenarioBrowserDriven {


        protected WebDriver driver;

        @Parameters("browser")
        @BeforeMethod
        public void setUp(BrowserFactoryAdvanced.BrowserEnums browser) {
            driver = BrowserFactoryAdvanced.getDriver(browser);
            driver.get("https://techblog.polteq.com/testshop/index.php");
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }



}
