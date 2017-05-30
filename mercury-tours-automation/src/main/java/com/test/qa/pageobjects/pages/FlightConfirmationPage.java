package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * FlightConfirmationPage.java - class to verify Flight Confirmation Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class FlightConfirmationPage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(FlightConfirmationPage.class);

    private WebElement imgFlightConfirmationHeader;
    private WebElement imgLogout;
    private WebElement labelDepartingInfoText;
    private WebElement labelReturningInfoText;
    private WebElement labelPassengersText;
    private WebElement labelTotPrice;

    /**
     * Initialize page elements
     */
    public FlightConfirmationPage() {

        imgFlightConfirmationHeader = TestBase.driver.findElement(By.xpath("//img[@src='/images/masts/mast_confirmation.gif']"));
        imgLogout = TestBase.driver.findElement(By.xpath("//img[@src='/images/forms/Logout.gif']"));
        labelDepartingInfoText = TestBase.driver.findElement(By.xpath("//font[text()='Departing']//following::font[1]"));
        labelReturningInfoText = TestBase.driver.findElement(By.xpath("//font[text()='Returning']//following::font[1]"));
        labelPassengersText = TestBase.driver.findElement(By.xpath("//b[text()='Passengers']//following::font[1]"));
        labelTotPrice = TestBase.driver.findElement(By.xpath("//font[contains(text(),'Price (including taxes):')]//following::font[1]"));

        LOGGER.info("Flight Confirmation Page loaded and Elements are Initialized");

    }

    /**
     * Verify Flight Booking Confirmation Page Displayed
     *
     * @return FlightBookingConfirmationPage object
     */
    public FlightConfirmationPage Verify_Flight_Confirmation_Page_Displayed() {
        verifyTrue(imgFlightConfirmationHeader.isDisplayed(), "Flight Booking Confirmation Header Image is displayed");
        checkForVerificationErrors();
        LOGGER.info("Flight Booking Confirmation Page loaded successfully");
        return this;
    }

    /**
     * User Logout From Flight Booking Application
     *
     * @return LoginPage object
     */
    public LoginPage Step_User_Logout_From_Flight_Booking_Application() {
        verifyTrue(imgLogout.isDisplayed(), "Image Logout is displayed");
        imgLogout.click();
        waitFor(2000);
        LOGGER.info("User click Logout Button successfully");
        return new LoginPage();
    }

    /**
     * Verify Flight Confirmation Information
     *
     * @return FlightConfirmationPage object
     */
    public FlightConfirmationPage Verify_Flight_Confirmation_Information(String travelCity) {
        verifyTrue(labelDepartingInfoText.isDisplayed(), "Flight Departing Information is displayed");
        verifyTrue(labelDepartingInfoText.getText().contains(travelCity + " to Acapulco"), "Flight Departing Cities are displayed");
        verifyTrue(labelDepartingInfoText.getText().contains("Unified Airlines 363"), "Flight Departing Airline is displayed");

        verifyTrue(labelReturningInfoText.isDisplayed(), "Flight Returning Information is displayed");
        verifyTrue(labelReturningInfoText.getText().contains("Acapulco to " + travelCity), "Flight Returning Cities are displayed");

        verifyTrue(labelPassengersText.isDisplayed(), "Passenger count displaying");
        String noOfPassengers = labelPassengersText.getText();
        String noOfPassengersText = noOfPassengers.split(" ")[0];
        verifyEquals(noOfPassengersText, "1", "Total Passengers Label contains Given Details");

        verifyTrue(labelTotPrice.isDisplayed(), "Flight Total Price is displayed");
        //Since the expected price not given in the requirement I only have verified whether the price is displayed and price format is correct
        verifyTrue(labelTotPrice.getText().matches("\\$[0-9]*\\s*USD"), "Flight Total Price is displayed");
        String totPrice = labelTotPrice.getText();
        String totPriceText = totPrice.substring(totPrice.lastIndexOf("$"));
        checkForVerificationErrors();
        return this;
    }

}
