package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.panels.HeaderPanel;
import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * RegistrationSuccessPage.java - class to verify Registration Success Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class RegistrationSuccessPage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(RegistrationSuccessPage.class);

    private WebElement lblUserNameText;
    private WebElement lblThankYouText;

    /**
     * Initialize Registration Success page elements
     */
    public RegistrationSuccessPage() {

        lblUserNameText = TestBase.driver.findElement(By.xpath("//b[contains(text(),'Note: Your user name is')]"));
        lblThankYouText = TestBase.driver.findElement(By.xpath("//*[contains(text(),'Thank you for registering')]"));

        LOGGER.info("Registration Page loaded and Elements are Initialized");
    }

    /**
     * Verify Registration Success Page Displayed
     *
     * @return Registration Success page object
     */
    public RegistrationSuccessPage Verify_Registration_Success_Page_Displayed() {
        verifyTrue(lblThankYouText.isDisplayed(), "Thank you for Registering text is displayed");
        verifyTrue(lblUserNameText.isDisplayed(), "Registered User Name is displayed");
        checkForVerificationErrors();
        LOGGER.info("Registration Success Page loaded successfully");
        return this;
    }

    /**
     * Verify Registered User Name
     *
     * @return RegistrationSuccessPage object
     */
    public HeaderPanel Verify_Registered_User_Name(String username) {
        verifyTrue(lblUserNameText.getText().contains(username), "Registered User Name is displayed in Note Label");
        checkForVerificationErrors();
        return new HeaderPanel();
    }


}
