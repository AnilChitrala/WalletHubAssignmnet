package PageObjects;

import Helpers.helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WalletHubPage extends helper {
    public WebDriver driver;
    helper help = new helper();

    /**
     * This Method is used to enter a emailID and Password and click on Login button
     *
     * @param driver
     * @param emailId
     * @param password
     */
    public void loginWithUserNameAndPassword(WebDriver driver, String emailId, String password) {
        help.waitForElementToBeDisplayed(driver, "//a[contains(@ng-click,'login')]", 10);
        help.clickWebElement(driver, "//a[contains(@ng-click,'login')]");
        help.waitForElementToBeDisplayed(driver, "//input[@name='em']", 10);
        help.enterText(driver, "//input[@name='em']", emailId);
        help.enterText(driver, "//input[@name='pw1']", password);
        help.clickWebElement(driver, "//span[contains(text(),'Login')]");
    }

    /**
     * This Method is used to move to Specific rating and Click
     *
     * @param driver
     * @param starNumber
     */
    public void moveToSpecificRatingStarAndClick(WebDriver driver, int starNumber) {
        help.waitForElementToBeDisplayed(driver, "//h1[@class='profile-name']", 15);
        for (int i = 1; i <= starNumber; i++) {
            help.moveMouseToSpecificElement(driver, "(//div[*[@class='rvs-star-svg']]//*[@class='rvs-star-svg' and @width='38'])[" + starNumber + "]");
            if (i == starNumber) {
                help.clickWebElement(driver, "(//div[*[@class='rvs-star-svg']]//*[@class='rvs-star-svg' and @width='38'])[" + starNumber + "]");
                break;
            }
        }
    }

    /**
     * This Method is used to write and Submit a review
     *
     * @param driver
     * @param value
     * @param reviewText
     */
    public void selectValueAndWriteReview(WebDriver driver, String value, String reviewText) {
        help.selectValue(driver, "//div[contains(@class,'dropdown second')]", "//div[contains(@class,'dropdown second')]//ul//li", value);
        help.enterText(driver, "//div[@class='android']//textarea", reviewText);
        help.clickWebElement(driver, "//div[contains(text(),'Submit')]");
    }

    /**
     * This Method is used to verify a Text in Review Page
     *
     * @param driver
     * @param reviewText
     */
    public void verifyTextInReviewPage(WebDriver driver, String reviewText) {
        help.moveMouseToSpecificElement(driver, "//div[contains(@class,'brgm-user brgm-list-box')]");
        help.clickWebElement(driver, "//div[contains(@class,'brgm-user-list')]//a[contains(text(),'Profile')]");
        help.waitForElementToBeDisplayed(driver, "//div[contains(@class,'texts-container')]//a[contains(text(),'Test Insurance')]", 15);
        help.clickWebElement(driver, "//div[contains(@class,'texts-container')]//a[contains(text(),'Test Insurance')]");
        help.waitForElementToBeDisplayed(driver, "//article[contains(@class,'rvtab-citem rvtab-item-user')]//div[@itemprop='description']", 20);
        String retrievedText = driver.findElement(By.xpath("//article[contains(@class,'rvtab-citem rvtab-item-user')]//div[@itemprop='description']")).getText();
        Assert.assertEquals(reviewText, retrievedText, "Text is not Same");
    }

}
