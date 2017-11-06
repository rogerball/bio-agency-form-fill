package BioAgency;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by rogercode on 06/11/2017.
 */
public class BioAgency {

    @FindBy(css = "#MainContent > div > section > div > div.Wrapper > div > ul > li:nth-child(1) > a > div > span")
    WebElement firstWhitePaper;

    @FindBy(className = "Tiles-item")
    List<WebElement> whitePapers;

    @FindBy(className = "icon-wrapper")
    WebElement icon;

    @FindBy(className = "icon-arrow-right")
    WebElement rightArrow;

    @FindBy(id = "Name")
    WebElement name;

    @FindBy(id = "JobTitle")
    WebElement jobTitle;

    @FindBy(id = "Company")
    WebElement company;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(className = "submit-row")
    WebElement submitButton;


    public void clickOnFirstWhitePaper(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(whitePapers));
        whitePapers.get(0).click();


    }

    public void clickRightArrowThreeTimes(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(icon));
        icon.click();
        rightArrow.click();
        rightArrow.click();
    }

    public void fillOutForm(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(name));
        name.sendKeys("Roger Ball");
        jobTitle.sendKeys("SDEiT");
        company.sendKeys("QA int");
        email.sendKeys("mail@mail.com");
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

    }

    public boolean isDownloadLinkDisplayed(WebDriver webDriver) {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("DOWNLOAD")));
        return true;
    }
}
