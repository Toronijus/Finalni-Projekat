package Demoqa.com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class TextBox {
    public final String TextBoxUrl = "https://demoqa.com/text-box";
    public WebDriver driver;
    public WebDriverWait wdwait;

    By fullnameField = By.id("userName");
    By emailField = By.id("userEmail");
    By curAddress = By.id("currentAddress");
    By perAddress = By.id("permanentAddress");
    By submitButton = By.id("submit");
    By output = By.id("output");

    public TextBox(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getFullname() {
        return driver.findElement(fullnameField);
    }

    public WebElement getEmail() {
        return driver.findElement(emailField);
    }

    public WebElement getCurrentAddress() {
        return driver.findElement(curAddress);
    }

    public WebElement getPermanentAddress() {
        return driver.findElement(perAddress);
    }

    public WebElement getSubmitButton() {
        return driver.findElement(submitButton);
    }

    public WebElement getOutput() {
        return driver.findElement(output);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void addFullname(String Name) {
        getFullname().sendKeys(Name);
    }

    public void addEmailFieldEmail(String Email) {
        getEmail().sendKeys(Email);
    }

    public void addCurAddress(String CAddress) {
        getCurrentAddress().sendKeys(CAddress);
    }

    public void addPerAddress(String PAddress) {
        getPermanentAddress().sendKeys(PAddress);
    }

    public void Submit() {
        scrollDown();
        getSubmitButton().click();
    }

    public List<String> outputList() {
        ArrayList<String> output = new ArrayList<>(List.of(getOutput().getText().split("\n")));
        return output;
    }


}
