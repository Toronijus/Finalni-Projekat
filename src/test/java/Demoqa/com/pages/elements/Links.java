package Demoqa.com.pages.elements;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Links {
    public final String linksUrl = "https://demoqa.com/links";
    public WebDriver driver;
    public WebDriverWait wdwait;

    By home = By.id("simpleLink");
    By homeDynamic = By.id("dynamicLink");
    By created = By.id("created");
    By noContent = By.id("no-content");
    By moved = By.id("moved");
    By badRequest = By.id("bad-request");
    By unauthorized = By.id("unauthorized");
    By forbidden = By.id("forbidden");
    By notFound = By.id("invalid-url");

    By linkResponse = By.id("linkResponse");

    public Links(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getHomeLink() {
        return driver.findElement(home);
    }

    public WebElement getHomeDynamic() {
        return driver.findElement(homeDynamic);
    }

    public WebElement getCreatedLink() {
        scrollDown();
        return driver.findElement(created);
    }

    public WebElement getNoContentLink() {
        scrollDown();
        return driver.findElement(noContent);
    }

    public WebElement getMovedLink() {
        scrollDown();
        return driver.findElement(moved);
    }

    public WebElement getBadRequestLink() {
        scrollDown();
        return driver.findElement(badRequest);
    }

    public WebElement getUnauthorizedLink() {
        scrollDown();
        return driver.findElement(unauthorized);
    }

    public WebElement getForbiddenLink() {
        scrollDown();
        return driver.findElement(forbidden);
    }

    public WebElement getNotFoundLink() {
        scrollDown();
        return driver.findElement(notFound);
    }

    public WebElement getLinkResponse() {
        scrollDown();
        return driver.findElement(linkResponse);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
    }


    public void changeTab(int i, WebDriver driver) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i - 1));
    }

    public void moveToNextTab() {
        //switch with the help of actions class
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();

    }
}
