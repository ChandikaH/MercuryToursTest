package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * FlightBookingPage.java - class to verify Flight Booking Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class FlightBookingPage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(FlightBookingPage.class);

    private WebElement imgFlightBookingHeader;
    private WebElement btnSecurePurchase;
    private Select drpDwnCardType;
    private Select drpDwnCardExpMonth;
    private Select drpDwnCardExpYear;
    private WebElement txtCreditCardNumber;
    private WebElement txtUserFirstName;
    private WebElement txtUserLastName;
    private WebElement txtCCFirstName;
    private WebElement txtCCLastName;
    private WebElement txtAddress;
    private WebElement txtCity;
    private WebElement txtState;
    private WebElement txtPostalCode;
    private Select drpDwnCountry;
    private WebElement checkSameAsBillingAddress;


    /**
     * Initialize page elements
     */
    FlightBookingPage() {

        imgFlightBookingHeader = TestBase.driver.findElement(By.xpath("//img[@src='/images/masts/mast_book.gif']"));
        btnSecurePurchase = TestBase.driver.findElement(By.xpath("//input[@name='buyFlights']"));
        drpDwnCardType = new Select(TestBase.driver.findElement(By.xpath("//select[@name='creditCard']")));
        drpDwnCardExpMonth = new Select(TestBase.driver.findElement(By.xpath("//select[@name='cc_exp_dt_mn']")));
        drpDwnCardExpYear = new Select(TestBase.driver.findElement(By.xpath("//select[@name='cc_exp_dt_yr']")));
        txtCreditCardNumber = TestBase.driver.findElement(By.xpath("//input[@name='creditnumber']"));
        txtUserFirstName = TestBase.driver.findElement(By.xpath("//input[@name='passFirst0']"));
        txtUserLastName = TestBase.driver.findElement(By.xpath("//input[@name='passLast0']"));
        txtCCFirstName = TestBase.driver.findElement(By.xpath("//input[@name='cc_frst_name']"));
        txtCCLastName = TestBase.driver.findElement(By.xpath("//input[@name='cc_last_name']"));
        txtAddress = TestBase.driver.findElement(By.xpath("//input[@name='billAddress1']"));
        txtCity = TestBase.driver.findElement(By.xpath("//input[@name='billCity']"));
        txtState = TestBase.driver.findElement(By.xpath("//input[@name='billState']"));
        txtPostalCode = TestBase.driver.findElement(By.xpath("//input[@name='billZip']"));
        drpDwnCountry = new Select(TestBase.driver.findElement(By.xpath("//select[@name='billCountry']")));
        checkSameAsBillingAddress = TestBase.driver.findElement(By.xpath("//*[contains(text(),'Same as Billing Address')]/preceding-sibling::input[@type='checkbox']"));

        LOGGER.info("Flight Booking page loaded and Elements are Initialized");

    }

    /**
     * Verify Flight Booking Page Displayed
     *
     * @return FlightBookingPage object
     */
    public FlightBookingPage Verify_Flight_Booking_Page_Displayed() {
        waitFor(1000);
        verifyTrue(imgFlightBookingHeader.isDisplayed(), "Flight Booking Header Image is displayed");
        checkForVerificationErrors();
        LOGGER.info("Flight Booking Page loaded successfully");
        return this;
    }

    /**
     * User Enter Credit Card Information
     *
     * @param creditCardType
     * @param creditCardNo
     * @param expMonth
     * @param expYear
     * @return FlightConfirmationPage object
     */
    public FlightBookingPage Step_User_Enter_Credit_Card_Information(String creditCardType, String creditCardNo, int expMonth, String expYear) {
        waitFor(1000);
        drpDwnCardType.selectByVisibleText(creditCardType);
        txtCreditCardNumber.sendKeys(creditCardNo);
        drpDwnCardExpMonth.selectByIndex(expMonth);
        drpDwnCardExpYear.selectByValue(expYear);
        waitFor(2000);
        LOGGER.info("Passenger Credit Card details are entered");
        return new FlightBookingPage();
    }

    /**
     * User Enter Passenger Information And Navigated To Confirmation Page
     *
     * @param fName
     * @param lName
     * @param address
     * @param city
     * @param state
     * @param postalCode
     * @param country
     * @return FlightConfirmationPage object
     */
    public FlightConfirmationPage Step_User_Enter_Passenger_Information_And_Navigated_To_Flight_Confirmation_Page(String fName, String lName, String address, String city, String state, String postalCode, String country) {
        actionEnterPassengerInformation(fName, lName, address, city, state, postalCode, country);
        waitFor(1000);
        btnSecurePurchase.click();
        waitFor(3000);
        LOGGER.info("Passenger details entered and navigated to Flight Confirmation Page");
        return new FlightConfirmationPage();
    }

    /**
     * action Enter Passenger Information
     *
     * @param fName
     * @param lName
     * @param address
     * @param city
     * @param state
     * @param postalCode
     * @param country
     * @return FlightBookingPage object
     */
    private FlightBookingPage actionEnterPassengerInformation(String fName, String lName, String address, String city, String state, String postalCode, String country) {
        verifyTrue(txtCCFirstName.isDisplayed(), "Passenger First Name textBox is displayed");
        waitFor(1000);
        txtUserFirstName.sendKeys(fName);
        txtUserLastName.sendKeys(lName);
        txtCCFirstName.sendKeys(fName);
        txtCCLastName.sendKeys(lName);
        txtAddress.clear();
        txtAddress.sendKeys(address);
        txtCity.clear();
        txtCity.sendKeys(city);
        txtState.clear();
        txtState.sendKeys(state);
        txtPostalCode.clear();
        txtPostalCode.sendKeys(postalCode);
        drpDwnCountry.selectByVisibleText(country);
        waitFor(1000);
        checkSameAsBillingAddress.click();
        waitFor(1000);
        checkForVerificationErrors();
        LOGGER.info("Passenger details entered");
        return this;
    }


}
