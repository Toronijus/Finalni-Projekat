package Demoqa.com.pages.bookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogIn {

    public final String site = "https://demoqa.com/login";
    public WebDriver driver;
    public WebDriverWait wdwait;
    By usernameField = By.id("userName");
    By passwordField = By.id("password");
    By logInButton = By.id("login");

    public LogIn(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;


    }

    public WebElement getUserName() {
        return driver.findElement(usernameField);
    }

    public WebElement getPassword() {
        return driver.findElement(passwordField);
    }

    public WebElement getLoginButton() {
        return driver.findElement(logInButton);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void addUserName(String user) {
        getUserName().sendKeys(user);
    }

    public void addPassword(String pass) {
        getPassword().sendKeys(pass);
    }


}
