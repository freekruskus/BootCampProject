package chapterSix;

import browser.BrowserFactoryBasic;
import browser.BrowserFactoryAdvanced;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestShopScenario {


        protected WebDriver driver;

        @BeforeMethod
        public void setUp() {
            driver = BrowserFactoryAdvanced.getDriver(BrowserFactoryAdvanced.BrowserEnums.CHROME);
            driver.get("https://techblog.polteq.com/testshop/index.php");
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
}
