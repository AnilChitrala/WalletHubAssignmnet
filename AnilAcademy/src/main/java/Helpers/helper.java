package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class helper {
    public WebDriver wd;
    Properties prop = new Properties();


    public WebDriver getWebDriver() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/ObjectRepository/File.properties");
            prop.load(fis);
            String browserName = prop.getProperty("browser");
            System.out.println(browserName);
            if(browserName.equalsIgnoreCase(prop.getProperty("browser")))
            {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/Drivers/chromedriver.exe");
                wd = new ChromeDriver();
            }
            wd.manage().window().maximize();
            wd.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
        return wd;
    }

    public void launchBrowser(WebDriver wd){
        wd.get(prop.getProperty("url"));
    }
}