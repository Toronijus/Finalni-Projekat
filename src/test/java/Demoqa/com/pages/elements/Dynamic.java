package Demoqa.com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Dynamic {
    public WebDriver driver;
    public WebDriverWait wdwait;
    By enableButton = By.linkText("Will enable 5 seconds");
    By colorButton = By.id("colorChange");
    By visibleButton = By.cssSelector("#visibleAfter");

    public Dynamic(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getEnableButton() {
        return driver.findElement(enableButton);
    }

    public WebElement getColorButton() {
        return driver.findElement(colorButton);
    }

    public WebElement getVisibleButton() {
        return driver.findElement(visibleButton);
    }

    public void clickVisible() {
        getVisibleButton().click();
    }

    public boolean booleanClickVisible() {
        getVisibleButton().click();
        return true;
    }

    public void clickEnable() {
        getEnableButton().click();
    }

    public boolean booleanClickEnable() {
        getEnableButton().click();
        return true;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }


}
