package com.test.qa.pageobjects.utils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


/**
 * TestBase.java - class to verify TestBase Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class TestBase {

    public static WebDriver driver = null;
    public String baseUrl = "http://newtours.demoaut.com";
    public String webDriverLocation = "src\\test\\resources\\drivers\\chromedriverWin2_29.exe";

    /**
     * Initialize webdriver, set driver path and maximize chrome browser window
     */
    @BeforeMethod(alwaysRun = true)
    public void initWebDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        //System.setProperty("webdriver.chrome.driver", webDriverLocation);
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Navigate to Base URL
     */
    @BeforeMethod(dependsOnMethods = "initWebDriver", alwaysRun = true)
    public void NavigateToBaseURL() {
        driver.get(baseUrl);
    }

    /**
     * Close web driver instances
     */
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        driver.quit();
    }
}
