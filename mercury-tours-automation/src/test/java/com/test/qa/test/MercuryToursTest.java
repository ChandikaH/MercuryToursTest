package com.test.qa.test;

import com.test.qa.pageobjects.pages.HomePage;
import com.test.qa.pageobjects.utils.TestBase;
import com.test.qa.testdata.UserDetailsDataProvider;
import org.testng.annotations.Test;

/**
 * MercuryToursTest.java - class to execute Tests
 * Created by ChandikaH on 5/20/2017.
 */
public class MercuryToursTest extends TestBase {

    /**
     * Verify Successful User Registration
     */
    @Test(groups = "REGRESSION", priority = 1, dataProvider = "MultipleUserDetails", dataProviderClass = UserDetailsDataProvider.class)
    public void test_Verify_User_Successful_Registration(String firstName, String lastName, String phoneNo, String email, String address1, String address2, String city, String state, String postalCode, String country, String userName, String password, String confirmPassword, String tripType, String travelCity, String fromDate, String toDate, String classType, String cardType, String cardNo, int expMonth, String expYear) {
        new HomePage()
                .Verify_Home_Page_Displayed()
                .Verify_Home_Page_Header_Panel()
                .Step_User_Click_Register_Link()
                .Verify_Registration_Page_Displayed()
                .Step_User_Enter_Registration_Details(firstName, lastName, phoneNo, email, address1, address2, city, state, postalCode, country, userName, password, confirmPassword)
                .Verify_Registration_Success_Page_Displayed()
                .Verify_Registered_User_Name(userName)
                .Step_User_SignOff_From_Account()
                .Verify_Login_Page_Displayed()
        ;
    }

    /**
     * Verify User Successful Flight Reservation
     */
    @Test(groups = "REGRESSION", priority = 2, dataProvider = "MultipleUserDetails", dataProviderClass = UserDetailsDataProvider.class)
    public void test_Verify_User_Successful_Flight_Reservation(String firstName, String lastName, String phoneNo, String email, String address1, String address2, String city, String state, String postalCode, String country, String userName, String password, String confirmPassword, String tripType, String travelCity, String fromDate, String toDate, String classType, String cardType, String cardNo, int expMonth, String expYear) {
        new HomePage()
                .Verify_Home_Page_Displayed()
                .Step_User_Click_SignOn_Link()
                .Verify_Login_Page_Displayed()
                .Step_User_Enter_Login_Details(userName, password)
                .Verify_Flight_Finder_Page_Displayed()
                .Step_User_Enter_Flight_Details_And_Navigate_To_Flight_Selection_Page(tripType, travelCity, fromDate, toDate, classType)
                .Verify_Flight_Selection_Page_Displayed()
                .Verify_Airline_Information_Displayed("Unified Airlines 363")
                .Verify_Flight_Price_Is_Displayed("$281")
                .Step_User_Click_Continue_And_Navigate_To_Flight_Booking_Page()
                .Verify_Flight_Booking_Page_Displayed()
                .Step_User_Enter_Credit_Card_Information(cardType, cardNo, expMonth, expYear)
                .Step_User_Enter_Passenger_Information_And_Navigated_To_Flight_Confirmation_Page(firstName, lastName, address1, city, state, postalCode, country)
                .Verify_Flight_Confirmation_Page_Displayed()
                .Verify_Flight_Confirmation_Information(travelCity)
                .Step_User_Logout_From_Flight_Booking_Application()
                .Verify_Login_Page_Displayed()
        ;
    }

}
