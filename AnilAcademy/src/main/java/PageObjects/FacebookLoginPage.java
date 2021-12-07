package PageObjects;

import Helpers.helper;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPage extends helper {
    public WebDriver driver;
    helper help = new helper();


    /**
     * This Method is used to enter a value in Facebook username in Login Page
     *
     * @param userName
     */
    public void enterFacebookUserName(WebDriver driver, String userName) {
        help.waitForElementToBeDisplayed(driver, "//input[@id='email']", 15);
        help.enterText(driver, "//input[@id='email']", userName);
    }

    /**
     * This Method is used to enter a value in Facebook password in Login Page
     *
     * @param password
     */
    public void enterFacebookPassword(WebDriver driver, String password) {
        help.waitForElementToBeDisplayed(driver, "//input[@id='pass']", 15);
        help.enterText(driver, "//input[@id='pass']", password);
    }

    /**
     * This Method is used to Click on Facebook Login Page
     */
    public void clickLogin(WebDriver driver) {
        help.clickWebElement(driver, "//button[@name='login']");
    }

    /**
     * This Method is used to create post and verify
     *
     * @param driver
     * @param text
     */
    public void createPostAndVerify(WebDriver driver, String text) {
        help.waitForElementToBeDisplayed(driver, "//div[@aria-label='Create a post']//div[@role='button']//span[contains(text(),'on your mind')]", 15);
        help.clickWebElement(driver, "//div[@aria-label='Create a post']//div[@role='button']//span[contains(text(),'on your mind')]");
        help.waitForElementToBeDisplayed(driver, "//div[contains(@aria-label,'on your mind')]", 15);
        help.clickWebElement(driver, "//div[contains(@aria-label,'on your mind')]");
        help.enterText(driver, "//div[contains(@aria-label,'on your mind')]", text);
        help.clickWebElement(driver, "//form[@method='POST']//span[contains(text(),'Post')]");
        help.waitForElementToBeDisplayed(driver, "//div[@role='feed']//div[contains(text(),'" + text + "')]", 15);
        help.verifyElementIsDisplayed(driver, "//div[@role='feed']//div[contains(text(),'" + text + "')]");
    }


}
