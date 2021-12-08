package Helpers;

import com.aventstack.extentreports.ExtentTest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class helper {
    public WebDriver driver;
    Properties prop = new Properties();
    private Logger log;


    /**
     * This Method is used to initiate a browser
     *
     * @return -- You will get a driver object
     */
    public WebDriver getWebDriver() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/ObjectRepository/File.properties");
            prop.load(fis);
            String browserName = prop.getProperty("browser");
            System.out.println(browserName);
            if (browserName.equalsIgnoreCase(prop.getProperty("browser"))) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars", "--test-type", "--disable-extensions", "--disable-notifications", "enable-automation",
                        "--disable-popup-blocking", "start-maximized");
                driver = new ChromeDriver(options);
            }
            driver.manage().window().maximize();
            String implicitWaitTime = prop.getProperty("implicitWait");
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(implicitWaitTime), TimeUnit.SECONDS);
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
        return driver;
    }

    /**
     * This Method is used to close a browser
     *
     * @param driver
     */
    public void afterScenario(WebDriver driver) {
        driver.close();
        driver.quit();
    }

    /**
     * This method is used to wait a driver until given element is displayed according to time provided
     *
     * @param driver
     * @param keyValue
     * @param TimeInSeconds
     */
    public void waitForElementToBeDisplayed(WebDriver driver, String keyValue, int TimeInSeconds) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, TimeInSeconds);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(keyValue)));
    }

    /**
     * This method is used to Launch a browser
     *
     * @param driver -- Driver object
     * @param url    -- Url according to requirement
     */
    public void launchBrowser(WebDriver driver, String url) {
        driver.get(url);
    }

    /**
     * This Method is used to click a WebElement
     *
     * @param driver   -- Driver Object
     * @param keyValue -- xpath of Specific Element
     */
    public void clickWebElement(WebDriver driver, String keyValue) {
        driver.findElement(By.xpath(keyValue)).click();
    }

    /**
     * This Method is used to enter a text
     *
     * @param driver   -- Driver Object
     * @param keyValue -- Xpath of specific Element
     * @param text     -- Value you want t enter
     */
    public void enterText(WebDriver driver, String keyValue, String text) {
        driver.findElement(By.xpath(keyValue)).sendKeys(text);
    }

    /**
     * This method is used to verify element
     *
     * @param driver
     * @param keyValue
     */
    public void verifyElementIsDisplayed(WebDriver driver, String keyValue) {
        driver.findElement(By.xpath(keyValue)).isDisplayed();
    }

    /**
     * This Method is used to move a mouse to specified Element
     *
     * @param driver
     * @param keyValue
     */
    public void moveMouseToSpecificElement(WebDriver driver, String keyValue) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath(keyValue))).perform();
    }

    /**
     * This method is used to select a value from dropdown
     *
     * @param driver
     * @param keyValue
     * @param dropKeyValue
     * @param value
     */
    public void selectValue(WebDriver driver, String keyValue, String dropKeyValue, String value) {
        clickWebElement(driver, keyValue);
        List<WebElement> options = driver.findElements(By.xpath(dropKeyValue));
        for (int i = 0; i <= options.size(); i++) {
            if (options.get(i).getText().equalsIgnoreCase(value)) {
                options.get(i).click();
                break;
            }
        }
    }
}