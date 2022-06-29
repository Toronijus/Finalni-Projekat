package Demoqa.com.tests;

import Demoqa.com.base.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import static org.testng.Assert.assertFalse;

public class ElementsTest extends BasePage {


    @BeforeMethod
    public void setUp() {
        driver.navigate().to(site);

   /* JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("document.body.style.zoom = '0.5'");*/
    }

    @Test
    public void TextBox() {
        homePage.goToElements();
        elements.goToTextBox();
        wdwait.until(ExpectedConditions.visibilityOf(textBox.getSubmitButton()));
        textBox.addFullname("Slobodan Bogdanovic");
        textBox.addEmailFieldEmail("slowride90@gmail.com");
        textBox.addCurAddress("97 SeanConnery Street");
        textBox.addPerAddress("221b Bakers Street");
        textBox.Submit();
        forms.scrollDown(textBox.getOutput());
        Assert.assertTrue(textBox.getOutput().isDisplayed());
        ArrayList<String> provera = new ArrayList<>(Arrays.asList("Name:Slobodan Bogdanovic", "Email:slowride90@gmail.com", "Current Address :97 SeanConnery Street", "Permananet Address :221b Bakers Street"));
        Assert.assertTrue(textBox.outputList().toString().contentEquals(provera.toString()));

    }

    @Test
    public void RadioButton() {
        homePage.goToElements();
        elements.goToRadioButton();
        radioButton.yesButton().click();
        Assert.assertTrue(radioButton.output().isDisplayed());
        Assert.assertTrue(radioButton.output().getText().contains("Yes"));
        System.out.println(radioButton.output().getText());
        radioButton.impressiveButton().click();
        Assert.assertTrue(radioButton.output().isDisplayed());
        Assert.assertTrue(radioButton.output().getText().contains("Impressive"));
        System.out.println(radioButton.output().getText());

    }

    @Test
    public void Buttons() {
        homePage.goToElements();
        elements.goToButtons();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        buttons.doDoubleClick(buttons.getDoubleClickButton());
        wdwait.until(ExpectedConditions.visibilityOf(buttons.doubleClickMessage()));
        Assert.assertTrue(buttons.doubleClickMessage().isDisplayed());
        buttons.doRightClick(buttons.getRightClickButton());
        wdwait.until(ExpectedConditions.visibilityOf(buttons.rightClickMessage()));
        Assert.assertTrue(buttons.rightClickMessage().isDisplayed());
        buttons.doClick(buttons.getClickButton());
        wdwait.until(ExpectedConditions.visibilityOf(buttons.dynamicClickMessage()));
        Assert.assertTrue(buttons.dynamicClickMessage().isDisplayed());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @Test
    public void HomeLinks() throws InterruptedException {
        homePage.goToElements();
        elements.goToLinks();
        links.getHomeLink().click();
        ArrayList<String> tabovi = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabovi.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), homePage.site);
        driver.switchTo().window(tabovi.get(0));
        driver.navigate().refresh();
        links.getHomeDynamic().click();
        ArrayList<String> tabovi1 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabovi1.get(1));
        Assert.assertEquals(driver.getCurrentUrl(), homePage.site);
        Thread.sleep(5000);

    }

    @Test
    public void linkResponse() throws InterruptedException {
        homePage.goToElements();
        elements.goToLinks();
        Thread.sleep(3000);
        links.getCreatedLink().click();
        Thread.sleep(3000);
        Assert.assertEquals(links.getLinkResponse().getText(), "Link has responded with staus 201 and status text Created");
        links.getNoContentLink().click();
        Thread.sleep(3000);
        Assert.assertEquals(links.getLinkResponse().getText(), "Link has responded with staus 204 and status text No Content");
        links.getMovedLink().click();
        Thread.sleep(3000);
        Assert.assertEquals(links.getLinkResponse().getText(), "Link has responded with staus 301 and status text Moved Permanently");
        links.getBadRequestLink().click();
        Thread.sleep(3000);
        Assert.assertEquals(links.getLinkResponse().getText(), "Link has responded with staus 400 and status text Bad Request");
        links.getUnauthorizedLink().click();
        Thread.sleep(3000);
        Assert.assertEquals(links.getLinkResponse().getText(), "Link has responded with staus 401 and status text Unauthorized");
        links.getForbiddenLink().click();
        Thread.sleep(3000);
        Assert.assertEquals(links.getLinkResponse().getText(), "Link has responded with staus 403 and status text Forbidden");
        links.getNotFoundLink().click();
        Thread.sleep(3000);
        Assert.assertEquals(links.getLinkResponse().getText(), "Link has responded with staus 404 and status text Not Found");
    }

   /* @Test
    public void dynamic() throws InterruptedException {
        homePage.goToElements();
        elements.scrollDown();
        elements.goToDynamic();
        wdwait.until(ExpectedConditions.visibilityOf(dynamic.getVisibleButton()));
        Assert.assertTrue(dynamic.getVisibleButton().isDisplayed());
        Thread.sleep(2000);
        wdwait.until(ExpectedConditions.visibilityOf(dynamic.getEnableButton()));
        Assert.assertFalse(dynamic.getEnableButton().isDisplayed());
    }*/

    @Test
    public void brokenLinks() {
        homePage.goToElements();
        elements.goToBrokenLinks();
        brokenLinks.getValidLink().click();
        Assert.assertEquals(driver.getCurrentUrl(), homePage.site);
        homePage.goToElements();
        elements.goToBrokenLinks();
        brokenLinks.getBrokenLink().click();
        Assert.assertNotEquals(driver.getCurrentUrl(),homePage.site);
    }

    @Test
    public void uploadDownload() throws InterruptedException {
        homePage.goToElements();
        Thread.sleep(3000);
        elements.goToUploadDownload();
        Thread.sleep(5000);
        uploadDownload.uploadFile().sendKeys("C:\\Users\\WINDOWS 10\\Downloads\\sampleFile.jpeg");
        Thread.sleep(2000);
        Assert.assertTrue(uploadDownload.uploadMessage().isDisplayed());
        uploadDownload.getDownloadButton().click();
        Thread.sleep(5000);

    }

    @Test
    public void checkBoxArrowsExpands() throws InterruptedException {
        homePage.goToElements();
        Thread.sleep(3000);
        elements.goCheckBox();
        checkBox.ArrowButtonHome();
        Assert.assertEquals(checkBox.numberElements().size(),4);
        checkBox.ArrowButtonDesktop();
        Assert.assertEquals(checkBox.numberElements().size(),6);
        checkBox.ArrowButtonDocuments();
        Assert.assertEquals(checkBox.numberElements().size(),8);
        checkBox.ArrowButtonDownloads();
        Assert.assertEquals(checkBox.numberElements().size(),10);
        checkBox.ArrowButtonWorkSpace();
        Assert.assertEquals(checkBox.numberElements().size(),13);
        checkBox.ArrowButtonOffice();
        Assert.assertEquals(checkBox.numberElements().size(),17);
        checkBox.MinusButton();
        Assert.assertEquals(checkBox.numberElements().size(),1);
    }
}