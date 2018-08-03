package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    private final WebDriver driver;

    private By subjectSelection = By.cssSelector("[name='id_contact']");

    private By emailTextField = By.cssSelector("input#email");

    private By orderIdTextField = By.cssSelector("input#id_order");

    private By messageTextField = By.cssSelector("[id='message']");

    private By sendButton = By.cssSelector("[id='submitMessage']");

    private By invalidEmailElement = By.cssSelector(".alert.alert-danger>ol>li");


    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    public void fillInEmail(String email){
        driver.findElement(emailTextField).clear();
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void fillInOrderId(String OrderID){
        driver.findElement(orderIdTextField).clear();
        driver.findElement(orderIdTextField).sendKeys(OrderID);
    }

    public void fillInMessage(String message){
        driver.findElement(messageTextField).clear();
        driver.findElement(messageTextField).sendKeys(message);
    }

    public void fillInContactForm(String subject, String email, String OrderID, String message){

        Select dropdown = new Select(driver.findElement(subjectSelection));
        dropdown.selectByVisibleText(subject);
        fillInEmail(email);
        fillInOrderId(OrderID);
        fillInMessage(message);
        driver.findElement(sendButton).click();
    }

    public boolean fillInNameInContactForm(String email){
        fillInEmail(email);
        driver.findElement(orderIdTextField).click();
        return driver.findElement(By.cssSelector("[class='form-control grey validate']")).isDisplayed();
    }
}
