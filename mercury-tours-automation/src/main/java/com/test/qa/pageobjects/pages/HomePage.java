package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.panels.HeaderPanel;
import com.test.qa.pageobjects.utils.PageBase;
import com.test.qa.pageobjects.utils.TestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * HomePage.java - class to verify Home Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class HomePage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(HomePage.class);

    private WebElement imgFeaturedDestination;
    private WebElement imgFindAFlight;

    private HeaderPanel headerPanel;

    /**
     * Initialize Home page elements
     */
    public HomePage() {
        headerPanel = new HeaderPanel();
        imgFeaturedDestination = TestBase.driver.findElement(By.xpath("//img[@alt='Featured Destination: Aruba']"));
        imgFindAFlight = TestBase.driver.findElement(By.xpath("//img[@alt='Find a Flight']"));
        LOGGER.info("HomePage loaded and Elements are Initialized");
    }

    /**
     * Verify Home Page Displayed
     *
     * @return Home page object
     */
    public HomePage Verify_Home_Page_Displayed() {
        verifyTrue(imgFeaturedDestination.isDisplayed(), "Featured Destination Image is displayed");
        verifyTrue(imgFindAFlight.isDisplayed(), "Find Flight Image is displayed");
        checkForVerificationErrors();
        LOGGER.info("Home Page loaded successfully");
        return this;
    }

    /**
     * Verify Home Page Header Panel Displayed
     *
     * @return Home page object
     */
    public HomePage Verify_Home_Page_Header_Panel() {
        headerPanel.Verify_Home_Page_Header_Panel();
        LOGGER.info("Home Page Header Panel is displayed");
        return this;
    }

    /**
     * User click Register link
     *
     * @return Registration page object
     */
    public RegistrationPage Step_User_Click_Register_Link() {
        headerPanel.Step_User_Click_Register_Link();
        LOGGER.info("Register Link Clicked and navigated to Register Page");
        return new RegistrationPage();
    }

    /**
     * User Click SignOn Link
     *
     * @return LoginPage object
     */
    public LoginPage Step_User_Click_SignOn_Link() {
        headerPanel.Step_User_Click_SignOn_Link();
        LOGGER.info("Click SingOn button and navigated to Login Page");
        return new LoginPage();
    }

}
