package Demoqa.com.pages.bookStore;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Profile {
    public final String site = "https://demoqa.com/profile";
    public WebDriver driver;
    public WebDriverWait wdwait;
    By username = By.id("userName-value");
    By bookList = By.className("mr-2");
    By rows = By.cssSelector("#app > div > div > div.row > div.col-12.mt-4.col-md-6 > div.profile-wrapper > div.ReactTable.-striped.-highlight > div.pagination-bottom > div > div.-center > span.select-wrap.-pageSizeOptions > select");
    By bookRows = By.className("rt-tr -odd");

    public Profile(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getUsername() {
        return driver.findElement(username);
    }
    public WebElement getBookRows(){return driver.findElement(bookRows);}
    public ArrayList<WebElement> BookList(){
        ArrayList <WebElement> bookLists = new ArrayList<>(driver.findElements(bookList));
        return bookLists;
    }
    public void numberOfRows(int i){

        Select lista = new Select(driver.findElement(rows));
        lista.selectByIndex(i);

    }
    public ArrayList<WebElement> bookProfile(){
        ArrayList<WebElement> bookProfile = new ArrayList<>(driver.findElements(bookRows));
        return bookProfile;
        }
    }


