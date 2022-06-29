package Demoqa.com.tests;

import Demoqa.com.base.BasePage;
import Demoqa.com.pages.HomePage;
import Demoqa.com.pages.bookStore.BookStore;
import Demoqa.com.pages.bookStore.LogIn;
import Demoqa.com.pages.bookStore.Profile;
import Demoqa.com.pages.elements.*;
import Demoqa.com.pages.forms.Forms;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class BookStoreTest extends BasePage {



    public void succesfulLog() throws InterruptedException {
        Thread.sleep(3000);
        homePage.goToBookStore();
        bookStore.goToLogin();
        logIn.addUserName("WolfWarrior");
        logIn.addPassword("Lothbrok#90");
        logIn.getLoginButton().click();
        Thread.sleep(2000);
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        wdmanager = new ChromeDriverManager();
        wdmanager.setup();
        //driver = new ChromeDriver();
        // wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/addblockplus.crx"));
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Thread.sleep(4000);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h1"))));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        homePage = new HomePage(driver, wdwait);
        elements = new Elements(driver, wdwait);
        textBox = new TextBox(driver, wdwait);
        checkBox = new CheckBox(driver, wdwait);
        radioButton = new RadioButton(driver, wdwait);
        webTables = new WebTables(driver, wdwait);
        buttons = new Buttons(driver, wdwait);
        links = new Links(driver, wdwait);
        brokenLinks = new BrokenLinks(driver, wdwait);
        uploadDownload = new UploadDownload(driver, wdwait);
        dynamic = new Dynamic(driver, wdwait);
        forms = new Forms(driver, wdwait);
        bookStore = new BookStore(driver,wdwait);
        logIn = new LogIn(driver,wdwait);
        profile = new Profile(driver,wdwait);
        driver.navigate().to(site);

   /* JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.5'");*/
    }

    @Test
    public void ValidLogIn() throws InterruptedException {

        homePage.goToBookStore();
        Thread.sleep(5000);
        bookStore.goToLogin();
        Thread.sleep(5000);
        logIn.addUserName("WolfWarrior");
        logIn.addPassword("Lothbrok#90");
        logIn.getLoginButton().click();
        Thread.sleep(2000);
        String trenutna = driver.getCurrentUrl();
        Assert.assertEquals(trenutna, profile.site);
        Assert.assertEquals(profile.getUsername().getText(), "WolfWarrior");
    }

    @Test
    public void listSize() throws InterruptedException {
        succesfulLog();
        Thread.sleep(3000);
        bookStore.goToBooks();
        Thread.sleep(3000);
        System.out.println(bookStore.listOfBooks().size());

    }

        @Test
        public void findAndAddBook () throws InterruptedException {
            succesfulLog();
            Thread.sleep(3000);
            bookStore.goToBooks();
            Thread.sleep(3000);
            bookStore.clickBook(3);
            Thread.sleep(5000);
            bookStore.scrollDown();
            bookStore.addBookClick();
            Thread.sleep(5000);
            bookStore.goToProfile();
            Thread.sleep(3000);
            System.out.println(profile.BookList().size());

        }

    @Test
    public void addAllBooks() throws InterruptedException {
        succesfulLog();
        bookStore.goToBooks();
        Thread.sleep(3000);
        int i = 0;
        while (i< bookStore.listOfBooks().size()-1) {
            bookStore.scrollDown();
            Thread.sleep(2000);
            bookStore.clickBook(i);
            bookStore.scrollDown();
            bookStore.addBookClick();
            bookStore.isAlertPresent();
            bookStore.scrollDown();
            bookStore.clickButton();
            i++;
        }
        Thread.sleep(3000);
        bookStore.goToProfile();
        profile.numberOfRows(1);
        System.out.println(profile.bookProfile().size());
        Thread.sleep(10000);

    }

   @AfterMethod
    public void tearDown() {
           homePage = null;
            wdwait = null;
            driver.quit();
            driver = null;
            wdmanager = null;
        }
    }

