package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * RegistrationPage.java - class to verify Registration Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class RegistrationPage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(RegistrationPage.class);

    private WebElement imgRegisterHeader;
    private WebElement txtFirstName;
    private WebElement txtLastName;
    private WebElement txtPhone;
    private WebElement txtEmail;
    private WebElement txtAddress1;
    private WebElement txtAddress2;
    private WebElement txtCity;
    private WebElement txtState;
    private WebElement txtPostalCode;
    private Select drpDwnCountry;
    private WebElement txtUserName;
    private WebElement txtPassword;
    private WebElement txtConfirmPassword;
    private WebElement btnSubmit;

    /**
     * Initialize Registration page elements
     *
     */
    public RegistrationPage() {
        imgRegisterHeader = TestBase.driver.findElement(By.xpath("//img[@src='/images/masts/mast_register.gif']"));
        txtFirstName = TestBase.driver.findElement(By.xpath("//input[@name='firstName']"));
        txtLastName = TestBase.driver.findElement(By.xpath("//input[@name='lastName']"));
        txtPhone = TestBase.driver.findElement(By.xpath("//input[@name='phone']"));
        txtEmail = TestBase.driver.findElement(By.xpath("//*[@id='userName']"));
        txtAddress1 = TestBase.driver.findElement(By.xpath("//input[@name='address1']"));
        txtAddress2 = TestBase.driver.findElement(By.xpath("//input[@name='address2']"));
        txtCity = TestBase.driver.findElement(By.xpath("//input[@name='city']"));
        txtState = TestBase.driver.findElement(By.xpath("//input[@name='state']"));
        txtPostalCode = TestBase.driver.findElement(By.xpath("//input[@name='postalCode']"));
        drpDwnCountry = new Select(TestBase.driver.findElement(By.xpath("//select[@name='country']")));
        txtUserName = TestBase.driver.findElement(By.xpath("//*[@id='email']"));
        txtPassword = TestBase.driver.findElement(By.xpath("//input[@name='password']"));
        txtConfirmPassword = TestBase.driver.findElement(By.xpath("//input[@name='confirmPassword']"));
        btnSubmit = TestBase.driver.findElement(By.xpath("//input[@name='register']"));

        LOGGER.info("Registration Page loaded and Elements are Initialized");
    }

    /**
     * Verify Register page elements display
     *
     * @return Registration page object
     */
    public RegistrationPage Verify_Registration_Page_Displayed() {
        verifyTrue(imgRegisterHeader.isDisplayed(), "Register Header Image is displayed");
        verifyTrue(txtFirstName.isDisplayed(), "FirstName txtBox is displayed");
        checkForVerificationErrors();
        LOGGER.info("Register Page loaded successfully");
        return this;
    }

    /**
     * User enter Registration Details
     *
     * @param fName
     * @param lName
     * @param phone
     * @param email
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param postalCode
     * @param country
     * @param uName
     * @param password
     * @param confirmPassword
     * @return Registration Success page object
     */
    public RegistrationSuccessPage Step_User_Enter_Registration_Details(String fName, String lName, String phone, String email, String address1, String address2, String city, String state, String postalCode, String country, String uName, String password, String confirmPassword) {
        waitFor(2000);
        actionEnterContactInformation(fName, lName, phone, email);
        actionEnterMailingInformation(address1, address2, city, state, postalCode, country);
        actionEnterUserInformation(uName, password, confirmPassword);
        btnSubmit.click();
        waitFor(6000);
        LOGGER.info("User enter Registration Page and navigate to Register Success Page");
        return new RegistrationSuccessPage();
    }

    /**
     * Enter Contact Information
     *
     * @param fName
     * @param lName
     * @param phone
     * @param email
     * @return Registration page object
     */
    private RegistrationPage actionEnterContactInformation(String fName, String lName, String phone, String email) {
        verifyTrue(txtFirstName.isDisplayed(), "FirstName txtBox is displayed");
        txtFirstName.sendKeys(fName);
        txtLastName.sendKeys(lName);
        txtPhone.sendKeys(phone);
        txtEmail.sendKeys(email);
        waitFor(1000);
        return this;
    }

    /**
     * Enter Mailing Information
     *
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param postalCode
     * @param country
     * @return Registration page object
     */
    private RegistrationPage actionEnterMailingInformation(String address1, String address2, String city, String state, String postalCode, String country) {
        verifyTrue(txtAddress1.isDisplayed(), "Address textBox is displayed");
        txtAddress1.sendKeys(address1);
        txtAddress2.sendKeys(address2);
        txtCity.sendKeys(city);
        txtState.sendKeys(state);
        txtPostalCode.sendKeys(postalCode);
        drpDwnCountry.selectByVisibleText(country);
        waitFor(1000);
        return this;
    }

    /**
     * Enter User Login Information
     *
     * @param uName
     * @param password
     * @param confirmPassword
     * @return Registration page object
     */
    private RegistrationPage actionEnterUserInformation(String uName, String password, String confirmPassword) {
        verifyTrue(txtUserName.isDisplayed(), "UserName textBox is displayed");
        txtUserName.sendKeys(uName);
        txtPassword.sendKeys(password);
        txtConfirmPassword.sendKeys(confirmPassword);
        waitFor(1000);
        return this;
    }

}
