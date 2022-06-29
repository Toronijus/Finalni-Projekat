package Demoqa.com.pages.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {
    public final String site = "https://demoqa.com/elements";
    public WebDriver driver;
    public WebDriverWait wdwait;

    By textBox = By.id("item-0");
    By checkBox = By.id("item-1");
    By radioButton = By.id("item-2");
    By webTables = By.id("item-3");
    By buttons = By.id("item-4");
    By links = By.id("item-5");
    By brokenLinks = By.id("item-6");
    By uploadDownload = By.id("item-7");
    By dynamic = By.id("item-8");


    public Elements(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getTextBox() {
        return driver.findElement(textBox);
    }

    public WebElement getCheckBox() {
        return driver.findElement(checkBox);
    }

    public WebElement getRadioButton() {
        return driver.findElement(radioButton);
    }

    public WebElement getWebTables() {
        return driver.findElement(webTables);
    }

    public WebElement getButtons() {
        return driver.findElement(buttons);
    }

    public WebElement getLinks() {
        return driver.findElement(links);
    }

    public WebElement getBrokenLinks() {
        return driver.findElement(brokenLinks);
    }

    public WebElement getUploadDownload() {scrollDown();
        return driver.findElement(uploadDownload);
    }

    public WebElement getDynamic() {
        return driver.findElement(dynamic);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void goToTextBox() {
        getTextBox().click();
    }

    public void goCheckBox() {
        getCheckBox().click();
    }

    public void goToRadioButton() {
        getRadioButton().click();
    }

    public void goToWebTables() {
        getWebTables().click();
    }

    public void goToButtons() {
        scrollDown();
        getButtons().click();
    }

    public void goToLinks() {
        scrollDown();
        getLinks().click();
    }

    public void goToBrokenLinks() {
        scrollDown();
        getBrokenLinks().click();
    }

    public void goToUploadDownload() {
        scrollDown();
        getUploadDownload().click();
    }

    public void goToDynamic() {
        scrollDown();
        getDynamic().click();
    }


}

