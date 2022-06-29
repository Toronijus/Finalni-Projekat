package Demoqa.com.pages.bookStore;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookStore {
    public final String site = "https://demoqa.com/books";
    public WebDriver driver;
    public WebDriverWait wdwait;
    By login = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/ul[1]/li[1]");
    By bookS = By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]");
    By profile = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/ul[1]/li[3]");
    By bookStoreApi = By.id("item-4");
    By message = By.cssSelector("#userForm > div:nth-child(1)");
    By listOfBooks = By.className("mr-2");
    By addBook = By.xpath("//button[contains(text(),'Add To Your Collection')]");
    By removeButton = By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.profile-wrapper > div.ReactTable.-striped.-highlight > div.rt-table > div.rt-tbody > div:nth-child(1) > div > div:nth-child(5) > div");
    By bookStorebutton = By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[1]/button");



    public BookStore(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
    }

    public WebElement getLogin() {
        return driver.findElement(login);
    }

    public WebElement getBooks() {
        scrollDown();
        return driver.findElement(bookS);
    }

    public WebElement getProfile() {
        return driver.findElement(profile);
    }

    public WebElement getBookStoreApi() {
        return driver.findElement(bookStoreApi);
    }

    public WebElement getAddBookButton() {
        return driver.findElement(addBook);
    }

    public WebElement getRemoveButtons() {
        return driver.findElement(removeButton);
    }
    public WebElement getBookStoreButton(){
        return driver.findElement(bookStorebutton);
    }
    public void clickButton(){getBookStoreButton().click();}


    public void goToLogin() {
        scrollDown();
        getLogin().click();
    }

    public void goToBooks() {
        scrollDown();
        getBooks().click();
    }

    public void goToProfile() {
        scrollDown();
        getProfile().click();
    }

    public void goToBookStoreApi() {
        scrollDown();
        getBookStoreApi().click();
    }

    public void addBookClick() {
        scrollDown();
        getAddBookButton().click();
    }

    public void alertAccept(WebDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

    }

    public boolean isAlertPresent() throws InterruptedException {
        Thread.sleep(2000);
        boolean presentFlag = false;
        try {
            Alert alert = driver.switchTo().alert();
            presentFlag = true;
            alert.accept();
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(0));
        } catch (NoAlertPresentException ex) {
            ex.printStackTrace();
        }
        return presentFlag;
    }


    public List<WebElement> listOfBooks() {
        ArrayList<WebElement> books = new ArrayList<>(driver.findElements(listOfBooks));
        return books;

    }

    public void clickBook(int i) {
        if (i >= 5) {
            scrollDown();
            listOfBooks().get(i).click();
        } else {
            listOfBooks().get(i).click();
        }
    }

    public ArrayList<WebElement> removeButtonList() {
        ArrayList<WebElement> remove = new ArrayList<>(driver.findElements(removeButton));
        return remove;
    }


}
