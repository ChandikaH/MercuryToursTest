package com.test.qa.testdata;

import org.testng.annotations.DataProvider;

/**
 * UserDetailsDataProvider.java - To Manage User related Data Set
 * Created by ChandikaH on 5/21/2017.
 */
public class UserDetailsDataProvider {

    @DataProvider
    public static Object[][] MultipleUserDetails() {
        return new Object[][]{
                {"Chandika", "Herath", "0711213444", "chandikah@gmail.com", "450,Nawala,Koswatta", "Rajagiriya", "Colombo", "Western Province", "20000", "SRI LANKA ", "chandikaU1", "cha@123", "cha@123", "OneWay", "New York", "6/21/2017", "6/25/2017", "First", "Visa", "4012888888881881", 10, "2010"},
                {"Sridhara", "Bandara", "0711213555", "sridhrah@gmail.com", "144,Ranawana,Katugastota", "Rajagiriya", "Kandy", "Central Province", "20800", "SRI LANKA ", "sridharaU1", "sridhara@123", "sridhara@123", "OneWay", "New York", "6/22/2017", "6/26/2017", "First", "Visa", "40128888233575445", 9, "2009"}
        };
    }


}
