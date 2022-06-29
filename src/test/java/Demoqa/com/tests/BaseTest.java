package Demoqa.com.tests;

import Demoqa.com.base.BasePage;
import Demoqa.com.pages.HomePage;
import Demoqa.com.pages.bookStore.BookStore;
import Demoqa.com.pages.bookStore.LogIn;
import Demoqa.com.pages.bookStore.Profile;
import Demoqa.com.pages.elements.*;
import Demoqa.com.pages.forms.Forms;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.checkerframework.framework.qual.DefaultQualifier;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

public class BaseTest extends BasePage {


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
        bookStore = new BookStore(driver, wdwait);
        logIn = new LogIn(driver, wdwait);
        profile = new Profile(driver, wdwait);
        driver.navigate().to(site);

    }

    @Test
    public void Test() throws InterruptedException {
        Thread.sleep(2000);
        homePage.goToElements();
        Thread.sleep(2000);
        elements.goToWebTables();
        Thread.sleep(5000);
        System.out.println(webTables.lista().size());

        Thread.sleep(10000);

    }

    @Test
    public void Forms() throws InterruptedException {
        homePage.goToForms();
        forms.goToPracticeForm();
        Thread.sleep(3000);
        forms.addFirstName("Slobodan");
        forms.addLastName("Bogdanovic");
        forms.addEmail("lothbrok90@gmail.com");
        Thread.sleep(3000);
        forms.addMobile("0984563223");
        Thread.sleep(3000);
        forms.addSubject("Computer Science");
        Thread.sleep(2000);
        forms.addAddress("27. marta 97");
        Thread.sleep(3000);
        forms.addDate("23 septembar 1990");
        Thread.sleep(3000);
        forms.getuploadPic().sendKeys("C:\\Users\\WINDOWS 10\\Downloads\\sampleFile.jpeg");
        Thread.sleep(3000);
        forms.addGender("other");
        Thread.sleep(3000);
        forms.addHobbies("sports");
        Thread.sleep(3000);
        forms.selectCountry("Rajasthan");
        Thread.sleep(3000);
        forms.selectCity("Jaipur");
        Thread.sleep(3000);
        forms.addHobbies("MUSIc");
        Thread.sleep(3000);
        forms.submit();



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