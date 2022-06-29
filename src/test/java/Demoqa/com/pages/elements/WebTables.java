package Demoqa.com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class WebTables {
    public final String WebTablesUrl = "https://demoqa.com/text-box";
    public WebDriver driver;
    public WebDriverWait wdwait;
    By addButton = By.id("addNewRecordButton");
    By searchBox = By.id("searchBox");


    public WebTables(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public ArrayList<WebElement> lista() {

        ArrayList<WebElement> lista = new ArrayList<>(driver.findElements(By.cssSelector("tag[title='Edit']")));
        return lista;
    }
}
