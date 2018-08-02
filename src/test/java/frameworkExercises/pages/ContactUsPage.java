package frameworkExercises.pages;

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

    public void fillInContactForm(String email, String OrderID, String message){

            Select dropdown = new Select(driver.findElement(subjectSelection));
            dropdown.selectByVisibleText("Customer service");
            driver.findElement(emailTextField).sendKeys(email);
            driver.findElement(orderIdTextField).sendKeys(OrderID);
            driver.findElement(messageTextField).sendKeys(message);
            driver.findElement(sendButton).click();

    }
}