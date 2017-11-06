package BioAgency;

import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by rogercode on 06/11/2017.
 */
public class BioAgencyTest {

    BioAgency bioAgency = new BioAgency();
    WebDriver webDriver;
    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
        webDriver.close();

    }

    @Test
    public void fillOutFormForAWhitePaper(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac-chrome-driver");
        webDriver = new ChromeDriver();
        PageFactory.initElements(webDriver, bioAgency);
        webDriver.get("https://www.thebioagency.com/news-and-views/white-papers/");
        bioAgency.clickOnFirstWhitePaper(webDriver);
        bioAgency.clickRightArrowThreeTimes(webDriver);
        bioAgency.fillOutForm(webDriver);
        assertThat("success message is not displayed", bioAgency.isDownloadLinkDisplayed(webDriver), Is.is(true));
    }



}