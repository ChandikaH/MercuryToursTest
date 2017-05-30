package com.test.qa.pageobjects.panels;

import com.test.qa.pageobjects.pages.LoginPage;
import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * HeaderPanel.java - class to verify Home Page - Header panel functions
 * Created by ChandikaH on 5/20/2017.
 */
public class HeaderPanel extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(HeaderPanel.class);

    private WebElement imgHomeLogo;
    private WebElement lnkRegister;
    private WebElement lnkSignOn;
    private WebElement lnkSignOff;

    /**
     * Initialize Header Panel elements and wait for page load
     */
    public HeaderPanel() {
        imgHomeLogo = TestBase.driver.findElement(By.xpath("//img[@alt='Mercury Tours']"));
        lnkRegister = TestBase.driver.findElement(By.xpath("//a[text()='REGISTER']"));

        LOGGER.info("Panel loaded and Elements are Initialized");
    }

    /**
     * Verify Home Page Header Panel
     *
     * @return Header Panel page object
     */
    public HeaderPanel Verify_Home_Page_Header_Panel() {
        verifyTrue(imgHomeLogo.isDisplayed(), "Home Logo Image display");
        verifyTrue(lnkRegister.isDisplayed(), "Register Link display");
        checkForVerificationErrors();
        return this;
    }

    /**
     * Step User Click Register Link
     *
     * @return Header Panel page object
     */
    public HeaderPanel Step_User_Click_Register_Link() {
        lnkRegister.click();
        return this;
    }

    /**
     * Step User Click SignOn Link
     *
     * @return Header Panel page object
     */
    public HeaderPanel Step_User_Click_SignOn_Link() {
        lnkSignOn = TestBase.driver.findElement(By.xpath("//a[text()='SIGN-ON']"));
        lnkSignOn.click();
        return this;
    }

    /**
     * Verify User sign off from Account
     *
     * @return LoginPage object
     */
    public LoginPage Step_User_SignOff_From_Account() {
        lnkSignOff = TestBase.driver.findElement(By.xpath("//a[text()='SIGN-OFF']"));
        verifyTrue(lnkSignOff.isDisplayed(), "link SignOff display");
        lnkSignOff.click();
        waitFor(2000);
        LOGGER.info("User click Sign Off Button successfully");
        return new LoginPage();
    }

}
