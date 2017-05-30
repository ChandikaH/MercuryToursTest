package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * FlightFinderPage.java - class to verify Flight Finder Page functions
 * Created by ChandikaH on 5/20/2017.
 */
public class FlightFinderPage extends PageBase {

    private static final Logger LOGGER = Logger.getLogger(FlightFinderPage.class);

    private WebElement imgFlightFinderHeader;
    private WebElement radioOneWayTrip;
    private WebElement radioRoundTrip;
    private Select drpDepartFrom;
    private WebElement radioServiceEconomyClass;
    private WebElement radioServiceBusinessClass;
    private WebElement radioServiceFirstClass;
    private Select drpDwnFromMonth;
    private Select drpDwnFromDay;
    private Select drpDwnToMonth;
    private Select drpDwnToDay;
    private WebElement btnContinue;

    /**
     * Initialize Flight Finder page elements
     */
    public FlightFinderPage() {

        imgFlightFinderHeader = TestBase.driver.findElement(By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']"));
        radioOneWayTrip = TestBase.driver.findElement(By.xpath("//input[@name='tripType' and @value='oneway']"));
        radioRoundTrip = TestBase.driver.findElement(By.xpath("//input[@name='tripType' and @value='roundtrip']"));
        drpDepartFrom = new Select(TestBase.driver.findElement(By.xpath("//select[@name='fromPort']")));
        radioServiceEconomyClass = TestBase.driver.findElement(By.xpath("//input[@name='servClass' and @value='Coach']"));
        radioServiceBusinessClass = TestBase.driver.findElement(By.xpath("//input[@name='servClass' and @value='Business']"));
        radioServiceFirstClass = TestBase.driver.findElement(By.xpath("//input[@name='servClass' and @value='First']"));
        drpDwnFromMonth = new Select(TestBase.driver.findElement(By.xpath("//select[@name='fromMonth']")));
        drpDwnFromDay = new Select(TestBase.driver.findElement(By.xpath("//select[@name='fromDay']")));
        drpDwnToMonth = new Select(TestBase.driver.findElement(By.xpath("//select[@name='toMonth']")));
        drpDwnToDay = new Select(TestBase.driver.findElement(By.xpath("//select[@name='toDay']")));
        btnContinue = TestBase.driver.findElement(By.xpath("//input[@name='findFlights']"));

        LOGGER.info("Flight Finder Page loaded and Elements are Initialized");
    }

    /**
     * Verify Flight Finder Page Displayed
     *
     * @return FlightFinderPage object
     */
    public FlightFinderPage Verify_Flight_Finder_Page_Displayed() {
        verifyTrue(imgFlightFinderHeader.isDisplayed(), "Flight Finder Header Image is displayed");
        verifyTrue(radioOneWayTrip.isDisplayed(), "Radio Button One Way is displayed");
        checkForVerificationErrors();
        LOGGER.info("Flight Finder Page loaded successfully");
        return this;
    }

    /**
     * Step User Enter Flight Details
     *
     * @return FlightSelectionPage object
     */
    public FlightSelectionPage Step_User_Enter_Flight_Details_And_Navigate_To_Flight_Selection_Page(String flightType, String departCity, String fromMonthDay, String toMonthDay, String serviceClass) {
        actionUserSelectFlightType(flightType);
        actionSelectFlightDetails(departCity, fromMonthDay, toMonthDay);
        actionUserSelectFlightServiceClass(serviceClass);
        waitFor(1000);
        btnContinue.click();
        waitFor(2000);
        LOGGER.info("Flight details entered and navigated to Flight Selection Page");
        return new FlightSelectionPage();
    }

    /**
     * action Select Flight Details
     *
     * @param departCity
     * @param fromMonthDay
     * @param toMonthDay
     * @return FlightFinderPage object
     */
    private FlightFinderPage actionSelectFlightDetails(String departCity, String fromMonthDay, String toMonthDay) {
        drpDepartFrom.selectByValue(departCity);

        String fromDate = fromMonthDay;
        String fromMonthText = fromDate.split("/")[0];
        String fromDayText = fromDate.split("/")[1];
        drpDwnFromMonth.selectByValue(fromMonthText);
        drpDwnFromDay.selectByValue(fromDayText);

        String toDate = toMonthDay;
        String toMonthText = toDate.split("/")[0];
        String toDayText = toDate.split("/")[1];

        drpDwnToMonth.selectByValue(toMonthText);
        drpDwnToDay.selectByValue(toDayText);
        waitFor(1000);
        LOGGER.info("Flight details entered");
        return this;
    }

    /**
     * User Select Flight Service Class
     *
     * @param serviceClass
     * @return FlightFinderPage object
     */
    private FlightFinderPage actionUserSelectFlightServiceClass(String serviceClass) {
        waitFor(1000);
        if (serviceClass == "Economy") {
            radioServiceEconomyClass.click();
        } else if (serviceClass == "Business") {
            radioServiceBusinessClass.click();
        } else if (serviceClass == "First") {
            radioServiceFirstClass.click();
        }
        LOGGER.info("Flight Service Class Type Selected");
        return this;
    }

    /**
     * User Select Flight Type
     *
     * @param flightType
     * @return FlightFinderPage object
     */
    private FlightFinderPage actionUserSelectFlightType(String flightType) {
        waitFor(1000);
        if (flightType == "OneWay") {
            radioOneWayTrip.click();
        } else if (flightType == "RoundTrip") {
            radioRoundTrip.click();
        }
        LOGGER.info("Flight Type Selected");
        return this;
    }


}
