package Demoqa.com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class CheckBox {
    public final String checkBoxUrl = "https://demoqa.com/checkbox";
    public WebDriver driver;
    public WebDriverWait wdwait;

    By CheckHome = By.cssSelector("#tree-node > ol > li > span > label > span.rct-checkbox");
    By ExpendArrow = By.cssSelector("#tree-node > ol > li > span > button > svg");
    By ExpendPlus = By.cssSelector("#tree-node > div > button.rct-option.rct-option-expand-all > svg");
    By CollapseMinus = By.cssSelector("#tree-node > div > button.rct-option.rct-option-collapse-all > svg");
    By ExpendDesktop = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > button > svg");
    By ExpendDocuments = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > span > button > svg");
    By ExpendDownloads = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > button > svg");
    By ExpendWorkSpace = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > span > button > svg");
    By ExpendOffice = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > span > button > svg");
    By DesktopBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label");
    By NotesBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > ol > li:nth-child(1) > span > label");
    By CommandsBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > ol > li:nth-child(2) > span > label");
    By DocumentsBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label");
    By WorkSpaceBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(1) > span > label");
    By OfficeBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > span > label");
    By DownloadsBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > span > label");
    By ReactBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(1) > span > label");
    By AngularBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(2) > span > label");
    By VeuBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li.rct-node.rct-node-parent.rct-node-expanded > ol > li:nth-child(3) > span > label");
    By PublicBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > ol > li:nth-child(1) > span > label");
    By PrivateBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > ol > li:nth-child(2) > span > label");
    By ClassifiedBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > ol > li:nth-child(3) > span > label");
    By GeneralBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(2) > ol > li:nth-child(2) > ol > li:nth-child(4) > span > label");
    By WordFileBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > ol > li:nth-child(1) > span > label");
    By ExcelFileBox = By.cssSelector("#tree-node > ol > li > ol > li:nth-child(3) > ol > li:nth-child(2) > span > label");


    public CheckBox(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getCheckMain() {
        return driver.findElement(CheckHome);
    }

    public WebElement getExpendArrow() {
        return driver.findElement(ExpendArrow);
    }

    public WebElement getExpendPlus() {
        return driver.findElement(ExpendPlus);
    }

    public WebElement getCollapseMinus() {
        return driver.findElement(CollapseMinus);
    }

    public WebElement getExpandDesktop() {
        return driver.findElement(ExpendDesktop);
    }

    public WebElement getExpandDocuments() {
        return driver.findElement(ExpendDocuments);
    }

    public WebElement getExpandDownloads() {
        return driver.findElement(ExpendDownloads);
    }

    public WebElement getExpandWorkSpace() {
        return driver.findElement(ExpendWorkSpace);
    }

    public WebElement getExpandOffice() {
        return driver.findElement(ExpendOffice);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }


    public void CheckMain() {
        getCheckMain().click();
    }

    public void ArrowButtonHome() {
        getExpendArrow().click();
    }

    public void PlusButton() {
        getExpendPlus().click();
    }

    public void MinusButton() {
        getCollapseMinus().click();
    }

    public void ArrowButtonDesktop() {
        if (getExpendArrow().isEnabled()) {
            getExpandDesktop().click();
        } else {
            getExpendArrow().click();
            getExpandDesktop().click();
        }
    }

    public void ArrowButtonDownloads() {
        if (getExpendArrow().isEnabled()) {
            getExpandDownloads().click();
        }
    }

    public void ArrowButtonDocuments() {
        if (getExpendArrow().isEnabled()) {
            getExpandDocuments().click();
        }
    }

    public void ArrowButtonWorkSpace() {
        if (getExpendArrow().isEnabled()) {
            getExpandWorkSpace().click();
        }
    }

    public void ArrowButtonOffice() {
        if (getExpandDocuments().isEnabled()) {
            scrollDown();
            getExpandOffice().click();
        }
    }
    public ArrayList<WebElement> numberElements (){
        ArrayList<WebElement> number = new ArrayList<>(driver.findElements(By.className("rct-title")));
        return number;
    }
}
