package pages;

import config.ConfigReader;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //web elements
    @FindBy(xpath = "//a[@class='site-logo']")
    protected WebElement logo;

    @FindBy(xpath = "//nav[@id='block-mainnavigation']//a[normalize-space()='About Railinc']")
    protected WebElement aboutUs;


    protected String expectedUrl = "https://public.railinc.com/about-railinc";
    @FindBy(xpath = "//span[@class='field field--name-title field--type-string field--label-hidden']")
    protected WebElement titleAbout;

    protected String expectedTitle = "About Railinc";

    public void navigateToHomePage(){
        driver.get(ConfigReader.getProperty("URL"));
    }

    public void verifyPageLogo() {
        assertTrue("Logo is not displayed",logo.isDisplayed());

    }

    public void clickOnAboutUsLink() {
        aboutUs.click();
    }

    public void verifyAboutUsPage() {
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl);
    }
    public void verifyAboutUsPageTitle() {
        String actualTitle = titleAbout.getText();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


}
