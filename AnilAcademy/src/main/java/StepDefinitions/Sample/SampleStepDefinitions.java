package StepDefinitions.Sample;

import Helpers.helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class SampleStepDefinitions {
    public WebDriver wd;
    helper help=new helper();

    @Given("User logged into Sample Website")
    public void userLoggedIntoSampleWebsite() {
        wd=help.getWebDriver();
        help.launchBrowser(wd);
    }

    @When("user logged in with Username and password")
    public void userLoggedInWithUsernameAndPassword() {
    }

    @Then("Verify user is on Sample website")
    public void verifyUserIsOnSampleWebsite() {
    }

    @When("user logged in with {string} and {string}")
    public void userLoggedInWithAnd(String arg0, String arg1) {
    }
}
