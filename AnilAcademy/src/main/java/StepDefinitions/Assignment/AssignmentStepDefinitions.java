package StepDefinitions.Assignment;

import Helpers.helper;
import PageObjects.FacebookLoginPage;
import PageObjects.WalletHubPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AssignmentStepDefinitions {
    public WebDriver driver;
    helper help = new helper();
    FacebookLoginPage facebookLoginPage = new FacebookLoginPage();
    WalletHubPage walletHubPage = new WalletHubPage();

    public AssignmentStepDefinitions() {
        this.driver = help.getWebDriver();
    }

    @Given("User logged into Facebook by providing valid Credentials")
    public void userLoggedIntoFacebookByProvidingValidCredentials() {
        help.launchBrowser(driver, "https://www.facebook.com/");
    }

    @When("user logged in with {string} and {string}")
    public void userLoggedInWithAnd(String username, String password) {
        facebookLoginPage.enterFacebookUserName(driver, username);
        facebookLoginPage.enterFacebookPassword(driver, password);
        facebookLoginPage.clickLogin(driver);
    }

    @Then("Verify user is on Facebook Login Page")
    public void verifyUserIsOnFacebookLoginPage() {
        help.waitForElementToBeDisplayed(driver, "//div[@aria-label='Create a post']//div[@role='button']//span[contains(text(),'on your mind')]", 15);
        Assert.assertTrue(driver.findElement(By.xpath("//div[@aria-label='Create a post']//div[@role='button']//span[contains(text(),'on your mind')]")).isDisplayed());
    }


    @And("Post a Status {string} and Verify message is posted in Timeline")
    public void postAStatusAndVerifyMessageIsPostedInTimeline(String text) {
        facebookLoginPage.createPostAndVerify(driver, text);
//        facebookLoginPage.LogoutFromFacebook();
    }

    @And("Close browser")
    public void closeBrowser() {
        help.afterScenario(driver);
    }

    @Given("user logged into WalletHub Review page")
    public void userLoggedIntoWalletHubReviewPage() {
        help.launchBrowser(driver, "https://wallethub.com/profile/test-insurance-company-13732055i");
    }

    @Given("user logged into WalletHub Review page by Providing {string} and {string}")
    public void userLoggedIntoWalletHubReviewPageByProvidingAnd(String emailId, String password) {
        walletHubPage.loginWithUserNameAndPassword(driver, emailId, password);
    }

    @When("user provides Rating by using {string}")
    public void userProvidesRatingByUsing(String number) {
        walletHubPage.moveToSpecificRatingStarAndClick(driver, Integer.parseInt(number));
    }


    @And("user Selects {string} and write {string} in Review text field")
    public void userSelectsAndWriteInReviewTextField(String value, String reviewText) {
        walletHubPage.selectValueAndWriteReview(driver, value, reviewText);
    }

    @And("Verify Same {string} is Posted in WalletHub Review page")
    public void verifySameIsPostedInWalletHubReviewPage(String reviewText) {
        walletHubPage.verifyTextInReviewPage(driver, reviewText);
    }


}
