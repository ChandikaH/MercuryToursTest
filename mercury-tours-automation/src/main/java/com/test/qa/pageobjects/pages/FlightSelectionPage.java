package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * FlightSelectionPage.java - class to verify Flight Selection Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class FlightSelectionPage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(FlightSelectionPage.class);

    private WebElement imgFlightSelectionHeader;
    private WebElement lblUnifiedAirlines;
    private WebElement lblTicketPrice;
    private WebElement btnReserveFlights;
    private WebElement radioUnifiedAirlines;


    /**
     * Initialize page elements
     */
    public FlightSelectionPage() {

        imgFlightSelectionHeader = TestBase.driver.findElement(By.xpath("//img[@src='/images/masts/mast_selectflight.gif']"));
        lblUnifiedAirlines = TestBase.driver.findElement(By.xpath("//*[contains(text(),'Unified Airlines 363')]"));
        lblTicketPrice = TestBase.driver.findElement(By.xpath("//table[1]/tbody/tr[10]/td/font/font/b"));
        btnReserveFlights = TestBase.driver.findElement(By.xpath("//input[@name='reserveFlights']"));
        radioUnifiedAirlines = TestBase.driver.findElement(By.xpath("//b[contains(text(),'Unified Airlines 363')]/ancestor::td/preceding-sibling::td//input"));

        LOGGER.info("Flight Selection Page loaded and Elements are Initialized");
    }

    /**
     * Verify Flight Selection Page Displayed
     *
     * @return FlightSelectionPage object
     */
    public FlightSelectionPage Verify_Flight_Selection_Page_Displayed() {
        verifyTrue(imgFlightSelectionHeader.isDisplayed(), "Flight Selection Header Image is displayed");
        checkForVerificationErrors();
        LOGGER.info("Flight Selection Page loaded successfully");
        return this;
    }

    /**
     * Verify Unified Airline Information Displayed
     *
     * @return FlightSelectionPage object
     */
    public FlightSelectionPage Verify_Airline_Information_Displayed(String flightProvider) {
        verifyTrue(lblUnifiedAirlines.isDisplayed(), "Unified Airlines 363 label is displayed");
        verifyTrue(lblUnifiedAirlines.getText().contains(flightProvider), "Unified Airlines 363 label is displayed");
        checkForVerificationErrors();
        LOGGER.info("Unified Airlines 363 label is correctly displayed");
        return this;
    }

    /**
     * Verify Flight Price Displayed
     *
     * @param Price
     * @return FlightSelectionPage object
     */
    public FlightSelectionPage Verify_Flight_Price_Is_Displayed(String Price) {
        String ticketPrice = lblTicketPrice.getText();
        String ticketPriceText = ticketPrice.substring(ticketPrice.lastIndexOf("$"));
        verifyEquals(ticketPriceText, Price, "Unified Airlines 363 Price is correctly displayed");
        checkForVerificationErrors();
        LOGGER.info("Unified Airlines 363 Price is correctly displayed");
        return this;
    }

    /**
     * Navigate to Book a Flight Page by clicking continue button
     *
     * @return FlightBookingPage object
     */
    public FlightBookingPage Step_User_Click_Continue_And_Navigate_To_Flight_Booking_Page() {
        actionSelectFlightAirline();
        btnReserveFlights.isDisplayed();
        btnReserveFlights.click();
        waitFor(2000);
        LOGGER.info("Click Continue button and navigated to Flight Booking Page");
        return new FlightBookingPage();
    }

    /**
     * action Select Flight Airline
     *
     * @return FlightSelectionPage object
     */
    private FlightSelectionPage actionSelectFlightAirline() {
        radioUnifiedAirlines.click();
        return this;
    }
}
