package Demoqa.com.pages.forms;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.awt.SystemColor.control;

public class Forms {
    public final String site = "https://demoqa.com/forms";
    public WebDriver driver;
    public WebDriverWait wdwait;
    By practiceForm = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]");

    By firstNameField = By.id("firstName");
    By lastNameField = By.id("lastName");
    By emailField = By.id("userEmail");
    By mobilePhone = By.id("userNumber");
    By subjectField = By.id("subjectsInput");
    By currentAddress = By.id("currentAddress");
    By country = By.id("state");
    By city = By.id("city");
    By date = By.id("dateOfBirthInput");
    By uploadPic = By.id("uploadPicture");

    By submit = By.id("submit");

    public Forms(WebDriver driver, WebDriverWait wdwait) {
        this.driver = driver;
        this.wdwait = wdwait;
    }

    public WebElement getPracticeForm() {
        return driver.findElement(practiceForm);
    }

    public WebElement getFirstName() {
        return driver.findElement(firstNameField);
    }

    public WebElement getLastName() {
        return driver.findElement(lastNameField);
    }

    public WebElement getEmail() {
        return driver.findElement(emailField);
    }

    public WebElement getMobile() {
        return driver.findElement(mobilePhone);
    }

    public WebElement getSubject() {
        return driver.findElement(subjectField);
    }

    public WebElement getAddress() {
        return driver.findElement(currentAddress);
    }

    public WebElement countrySelect() {
        return driver.findElement(country);
    }

    public WebElement citySelect() {
        return driver.findElement(city);
    }

    public WebElement getSubmitButton() {
        return driver.findElement(submit);
    }

    public WebElement dateSelect() {
        return driver.findElement(date);
    }

    public WebElement getuploadPic(){return driver.findElement(uploadPic);}

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void scrollDown(WebElement Element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    public void clickAction(WebElement webElement) {
        Actions action = new Actions(driver);
        action.click(webElement).build().perform();
    }
    public void submit(){
        getSubmitButton().submit();
    }

    public void goToPracticeForm() {
        scrollDown();
        clickAction(getPracticeForm());
    }

    public void addFirstName(String firstName) {
        getFirstName().sendKeys(firstName);
    }

    public void addLastName(String lastName) {
        getLastName().sendKeys(lastName);
    }

    public void addEmail(String email) {
        getEmail().sendKeys(email);
    }

    public void addMobile(String mobile) {
        getMobile().sendKeys(mobile);
    }

    public void addSubject(String subject) {
        Actions action = new Actions(driver);
        action.click(getSubject()).sendKeys(subject).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
    }

    public void addAddress(String address) {
        scrollDown();
        getAddress().sendKeys(address);
    }

    public void selectCountry(String string) {
        Actions action = new Actions(driver);
        action.click(countrySelect()).sendKeys(string).sendKeys(Keys.ENTER).build().perform();
    }

    public void selectCity(String string) {
        Actions action = new Actions(driver);
        action.click(citySelect()).sendKeys(string).sendKeys(Keys.ENTER).build().perform();

    }

    public void addDate(String dateMonthYear) {
        Actions action = new Actions(driver);
        action.click(getMobile()).sendKeys(Keys.TAB).build().perform();
        action.sendKeys(dateMonthYear).sendKeys(Keys.TAB).build().perform();
    }


    public void addGender(String gender) {
        gender = gender.toLowerCase();
        switch (gender) {
            case ("male") ->
                    driver.findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1)")).click();
            case ("female") ->
                    driver.findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)")).click();
            case ("other") ->
                    driver.findElement(By.cssSelector("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(3)")).click();
        }
    }

    public void addHobbies(String hobbies) {
        hobbies = hobbies.toLowerCase();
        switch (hobbies) {
            case ("sports") ->
                    driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(1)")).click();
            case ("reading") ->
                    driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)")).click();
            case ("music") ->
                    driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(3)")).click();
        }

    }
}
