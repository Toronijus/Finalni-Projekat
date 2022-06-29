package Demoqa.com.base;

import Demoqa.com.pages.HomePage;
import Demoqa.com.pages.bookStore.BookStore;
import Demoqa.com.pages.bookStore.LogIn;
import Demoqa.com.pages.bookStore.Profile;
import Demoqa.com.pages.elements.*;
import Demoqa.com.pages.forms.Forms;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;

public class BasePage {
    public final String site = "https://demoqa.com/";
    public WebDriverManager wdmanager;
    public WebDriver driver;
    public WebDriverWait wdwait;
    public HomePage homePage;

    public Elements elements;
    public TextBox textBox;
    public CheckBox checkBox;
    public RadioButton radioButton;
    public WebTables webTables;
    public Buttons buttons;
    public Links links;
    public BrokenLinks brokenLinks;
    public UploadDownload uploadDownload;
    public Dynamic dynamic;
    public Forms forms;
    public BookStore bookStore;
    public LogIn logIn;
    public Profile profile;

    public BasePage() {
        this.wdmanager = wdmanager;
        this.driver = driver;
    }




    @BeforeClass
    public void beforeClass() throws InterruptedException {
   /*     wdmanager = new ChromeDriverManager();
        wdmanager.setup();
       //driver = new ChromeDriver();
       // wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/main/resources/addblockplus.crx"));
        driver = new ChromeDriver(options);
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(5));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(By.tagName("h1"))));
        driver.close();
        driver.switchTo().window(tabs.get(0));
        driver.manage().window().maximize();*/
        /*homePage = new HomePage(driver, wdwait);
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
        profile = new Profile(driver,wdwait);*/


    }

    /*@AfterClass
    public void afterClass() {
        homePage = null;
        wdwait = null;
        driver.quit();
        driver = null;
        wdmanager = null;
    }*/

}
