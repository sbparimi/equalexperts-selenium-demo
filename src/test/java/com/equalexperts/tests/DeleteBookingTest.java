package com.equalexperts.tests;
import com.equalexperts.pages.HotelBookingPage;
import com.equalexperts.tests.tests.BaseTest;
import org.testng.annotations.Test;

public class DeleteBookingTest extends BaseTest {
    @Test
    public void HotelBookingPageTest(){
        HotelBookingPage hotelBookingPage = new HotelBookingPage(driver);
        hotelBookingPage.goTo();
        hotelBookingPage.deleteBooking();

    }



}
