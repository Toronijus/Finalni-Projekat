package Demoqa.com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrokenLinks {
    public final String brokenLinkUrl = "https://demoqa.com/broken";
    public WebDriver driver;
    public WebDriverWait wdwait;

    By imageTools = By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > img:nth-child(2)");
    By brokenImage = By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > img:nth-child(6)");
    By validLink = By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > a:nth-child(10)");
    By brokenLink = By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div:nth-child(2) > a:nth-child(14)");

    public BrokenLinks(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getImage() {
        return driver.findElement(imageTools);
    }

    public WebElement getBrokenImage() {
        return driver.findElement(brokenImage);
    }

    public WebElement getValidLink() {
        return driver.findElement(validLink);
    }

    public WebElement getBrokenLink() {
        return driver.findElement(brokenLink);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void returnToPreviousPage() {
        driver.navigate().back();
    }

    public void clickValidLink() {
        scrollDown();
        getValidLink().click();
    }

    public void clickBrokenLink() {
        scrollDown();
        getBrokenLink().click();
    }
}
