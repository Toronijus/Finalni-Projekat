package Demoqa.com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButton {
    public final String RadioButtonUrl = "https://demoqa.com/radio-button";
    public WebDriver driver;
    public WebDriverWait wdwait;
    By YesButton = By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div:nth-child(2) div.custom-control.custom-radio.custom-control-inline:nth-child(2) > label.custom-control-label");
    By ImpressiveButton = By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div:nth-child(2) div.custom-control.custom-radio.custom-control-inline:nth-child(3) > label.custom-control-label");
    By NoButton = By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div:nth-child(2) > div.custom-control.disabled.custom-radio.custom-control-inline:nth-child(4)");

    By output = By.cssSelector("div.body-height:nth-child(2) div.container.playgound-body div.row div.col-12.mt-4.col-md-6:nth-child(2) div:nth-child(2) > p.mt-3:nth-child(5)");

    public RadioButton(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void doClick(WebElement webElement) {
        Actions action = new Actions(driver);
        action.click(webElement).build().perform();
    }

    public WebElement yesButton() {
        return driver.findElement(YesButton);
    }

    public WebElement impressiveButton() {
        return driver.findElement(ImpressiveButton);
    }

    public WebElement noButton() {
        return driver.findElement(NoButton);
    }

    public WebElement output() {
        return driver.findElement(output);
    }

    public void enableButton(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled','disabled','disabled','disabled')", webElement);


    }
}
