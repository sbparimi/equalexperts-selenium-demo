package com.equalexperts.tests;

import com.equalexperts.pages.HotelBookingPage;
import com.equalexperts.tests.tests.BaseTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CreateaBookingTest extends BaseTest {
    private String firstNamedata;
    private String lastNamedata;
    private String pricedata;
    private String checkIndatedata;
    private String checkOutDatedata;

    @Test
    @Parameters({"firstNamedata","lastNamedata","pricedata","checkIndatedata","checkOutDatedata"})
    public void HotelBookingPageTest(String firstNamedata, String lastNamedata,String pricedata, String checkIndatedata,String checkOutDatedata){
        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
        this.firstNamedata = firstNamedata;
        this.lastNamedata = lastNamedata;
        this.pricedata = pricedata;
        this.checkIndatedata = checkIndatedata;
        this.checkOutDatedata = checkOutDatedata;
        hotelBookingPage.goTo();
        hotelBookingPage.createBooking(firstNamedata, lastNamedata,pricedata, checkIndatedata,checkOutDatedata);

    }



}
