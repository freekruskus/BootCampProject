package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage{

    private WebDriver driver;
    String headerName;

    public LogInPage(WebDriver driver){

        this.driver = driver;
    }

    public void fillInLogin(String login){
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys(login);
    }
    public void fillInPassword(String password){
        driver.findElement(By.id("passwd")).clear();
        driver.findElement(By.id("passwd")).sendKeys(password);
    }
    public void submitLogin() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    public void LogIn(String loginName, String password){

        if(driver.findElement(By.className("login")).isDisplayed()) {
            driver.findElement(By.className("login")).click();
            fillInLogin(loginName);
            fillInPassword(password);
            submitLogin();
        }
    }

    public String checkLogInHeaderName(){
        return headerName = driver.findElement(By.cssSelector("[class='page-heading']")).getText();
    }

    public void WrongLogIn(String loginName, String password){

        if(driver.findElement(By.className("login")).isDisplayed()) {

            fillInLogin(password);
            fillInPassword(loginName);
            submitLogin();
        }
    }
}
