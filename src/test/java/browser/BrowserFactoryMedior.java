package browser;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactoryMedior {

    public static WebDriver getDriver(String browser){

        switch(browser.toLowerCase()){
            case "firefox":
                return createFirefoxBrowser();
            case "ie":
                return createIEBrowser();
            case "chrome":
                return createChromeBrowser();
            case "edge":
                return createEdgeBrowser();
            default:
                return createChromeBrowser();
        }
    }

    private static WebDriver createEdgeBrowser() {
        System.out.println("We doen hier niet aan Edge automatiseren.");
        return createChromeBrowser();
    }

    private static WebDriver createIEBrowser() {
        System.out.println("We doen hier niet aan IE automatiseren.");
        return createChromeBrowser();
    }

    private static WebDriver createFirefoxBrowser() {
        //Chrome options are Chrome specific
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-infobars");
        options.setCapability("firefox-switches", "--verbose");
        //Capabilities can be used for Webdriver capabilities ie: proxy
        FirefoxDriverManager.getInstance().setup();
        return new FirefoxDriver(options);
    }

    private static WebDriver createChromeBrowser() {
        //Chrome options are Chrome specific
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("disable-infobars");
        options.setCapability("chrome-switches", "--verbose");
        //Capabilities can be used for Webdriver capabilities ie: proxy
        ChromeDriverManager.getInstance().setup();
        return new ChromeDriver(options);
    }

}