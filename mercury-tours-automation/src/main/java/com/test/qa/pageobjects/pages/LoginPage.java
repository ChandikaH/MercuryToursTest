package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * LoginPage.java - class to verify Login Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class LoginPage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

    private WebElement imgSignOnHeader;
    private WebElement txtUserName;
    private WebElement txtPassword;
    private WebElement btnSubmitLogin;

    /**
     * Initialize Login page elements
     */
    public LoginPage() {
        imgSignOnHeader = TestBase.driver.findElement(By.xpath("//img[@src='/images/masts/mast_signon.gif']"));
        txtUserName = TestBase.driver.findElement(By.xpath("//input[@name='userName']"));
        txtPassword = TestBase.driver.findElement(By.xpath("//input[@name='password']"));
        btnSubmitLogin = TestBase.driver.findElement(By.xpath("//input[@name='login' and @value='Login']"));

        LOGGER.info("LoginPage loaded and Elements are Initialized");
    }

    /**
     * Verify Login Page Displayed
     *
     * @return Login Page object
     */
    public LoginPage Verify_Login_Page_Displayed() {
        verifyTrue(imgSignOnHeader.isDisplayed(), "Sign On Header Image is displayed");
        verifyTrue(txtUserName.isDisplayed(), "User Name textBox is displayed");
        checkForVerificationErrors();
        LOGGER.info("Login Page Displayed");
        return this;
    }

    /**
     * Step User Enter Login Details
     *
     * @param userName
     * @param password
     * @return FlightFinderPage object
     */
    public FlightFinderPage Step_User_Enter_Login_Details(String userName, String password) {
        waitFor(2000);
        actionEnterLoginDetails(userName, password);
        btnSubmitLogin.click();
        waitFor(3000);
        LOGGER.info("User details entered and click Login button");
        return new FlightFinderPage();
    }

    /**
     * Enter Login Details
     *
     * @param userName
     * @param password
     * @return LoginPage
     */
    private LoginPage actionEnterLoginDetails(String userName, String password) {
        txtUserName.sendKeys(userName);
        txtPassword.sendKeys(password);
        LOGGER.info("User details entered");
        return this;
    }
}
