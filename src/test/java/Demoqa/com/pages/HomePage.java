package Demoqa.com.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    public final String site = "https://demoqa.com/";
    public WebDriver driver;
    public WebDriverWait wdwait;

    public By logo = By.cssSelector("#app > header > a > img");
    public By card = By.className("card-up");
    public By elements = By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(1)");
    public By forms = By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(2) > div > div.card-up");
    public By alerts = By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards > div.card.mt-4.top-card:nth-child(3)");
    public By widgets = By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards > div.card.mt-4.top-card:nth-child(4)");
    public By interaction = By.cssSelector("div.body-height:nth-child(2) div.home-content div.home-body div.category-cards > div.card.mt-4.top-card:nth-child(5)");
    public By bookStore = By.cssSelector("#app > div > div > div.home-body > div > div:nth-child(6) > div");

    public HomePage(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
    }

    public WebElement getLogo() {
        return driver.findElement(By.cssSelector("#app > header > a > img"));
    }

    public WebElement getCard() {
        return driver.findElement(By.className("category-cards"));
    }

    public WebElement getElements() {
        return driver.findElement(elements);
    }

    public WebElement getForms() {
        return driver.findElement(forms);
    }

    public WebElement getAlerts() {
        return driver.findElement(alerts);
    }

    public WebElement getWidgets() {
        return driver.findElement(widgets);
    }

    public WebElement getInteraction() {
        return driver.findElement(interaction);
    }

    public WebElement getBookStore(WebDriver driver) {
        return driver.findElement(bookStore);
    }

    public List<WebElement> getAllCards() {
        return driver.findElements(card);
    }

    public void goToTheCard(int i) {
        if (i < 7 && i > 0) {
            getAllCards().get(i - 1).click();
        }
    }


    public void goToElements() {
        getElements().click();
    }

    public void goToForms() {
        getForms().click();
    }

    public void goToAlerts() {
        getAlerts().click();
    }

    public void goToWidgets() {
        getWidgets().click();
    }

    public void goToInteraction() {
        getInteraction().click();
    }

    public void goToBookStore() {
        //scrollDown();
        getBookStore(driver).click();
    }

    public void goToHomePage() {
        getLogo().click();
    }

    public void changeTab(int i) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(i - 1));
    }
}
