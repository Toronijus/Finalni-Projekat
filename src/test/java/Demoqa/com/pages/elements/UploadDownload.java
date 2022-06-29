package Demoqa.com.pages.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UploadDownload {
    public final String UploadDownloadUrl = "https://demoqa.com/upload-download";

    public WebDriver driver;
    public WebDriverWait wdwait;
    By downloadButton = By.xpath("//a[@id='downloadButton']");
    By uploadFile = By.cssSelector("#uploadFile");
    By uploadMessage = By.id("uploadedFilePath");

    public UploadDownload(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }
    public WebElement getDownloadButton(){return driver.findElement(downloadButton);}
    public WebElement uploadFile(){return driver.findElement(uploadFile);}
    public WebElement uploadMessage(){return driver.findElement(uploadMessage);}
}
