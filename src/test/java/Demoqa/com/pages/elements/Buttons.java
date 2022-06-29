package Demoqa.com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Buttons {
    public final String buttonsUrl = "https://demoqa.com/buttons";
    public WebDriver driver;
    public WebDriverWait wdwait;

    By click = By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/button[1]");
    By doubleClick = By.id("doubleClickBtn");
    By rightClick = By.id("rightClickBtn");

    By doubleClickMessage = By.id("doubleClickMessage");
    By dynamicClickMessage = By.id("dynamicClickMessage");
    By rightClickMessage = By.id("rightClickMessage");

    public Buttons(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getClickButton() {
        return driver.findElement(click);
    }

    public WebElement getDoubleClickButton() {
        return driver.findElement(doubleClick);
    }

    public WebElement getRightClickButton() {
        return driver.findElement(rightClick);
    }

    public WebElement rightClickMessage() {
        return driver.findElement(rightClickMessage);
    }

    public WebElement dynamicClickMessage() {
        return driver.findElement(dynamicClickMessage);
    }

    public WebElement doubleClickMessage() {
        return driver.findElement(doubleClickMessage);
    }

    public void doDoubleClick(WebElement webElement) {
        Actions action = new Actions(driver);
        action.doubleClick(webElement).build().perform();
    }

    public void doRightClick(WebElement webElement) {
        Actions action = new Actions(driver);
        action.contextClick(webElement).build().perform();

    }

    public void doClick(WebElement webElement) {
        Actions action = new Actions(driver);
        action.click(webElement).build().perform();

    }

}
