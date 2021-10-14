package com.equalexperts.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingPage {

    private final WebDriver driver;
    @FindBy(id = "firstname")
    private WebElement firstNameTxt;
    @FindBy(xpath = "//div[@class=\"jumbotron\"]//h1[contains(text(), \"Hotel booking form\")]")
    private WebElement hotelBookingHeaderTxt;

    @FindBy(id = "lastname")
    private WebElement lastNameTxt;

    @FindBy(id = "totalprice")
    private WebElement totalpriceTxt;

    @FindBy(id = "checkin")
    private WebElement checkinDate;

    @FindBy(id = "checkout")
    private WebElement checkoutDate;

    @FindBy(xpath = "//select[@id='depositpaid']/option[.]")
    private List<WebElement> depositoptions;

    @FindBy(xpath = "//*[@type='button' and @value=' Save ']")
    private WebElement saveButton;

    @FindBy(xpath = "//div[@id='bookings']//div[@class='row']")
    private WebElement AllBookings;

    @FindBy(xpath = "/html/body/pre")
    private WebElement DeletedBookingText;

    @FindBy(xpath = "//*[@type='button' and @value=' Save ']")
    private WebElement deleteButton;

    public HotelBookingPage(WebDriver driver) {
        this.driver = driver;
        //this.Wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void goTo() {
        this.driver.get("http://hotel-test.equalexperts.io/");
        this.driver.manage().window().maximize();
        String expectedHeading = "Hotel booking form";
        WebDriverWait wait = new WebDriverWait(driver, 60);
        wait.until(ExpectedConditions.visibilityOf(this.hotelBookingHeaderTxt));
        String heading = this.hotelBookingHeaderTxt.getText();
        if (expectedHeading.equalsIgnoreCase(heading))
            System.out.println("The expected heading is same as actual heading --- " + heading);
        else
            System.out.println("The expected heading doesn't match the actual heading --- " + heading);

    }

    // Create the bookings in the application
    public void createBooking(String firstName, String lastName, String price, String checkIndate, String checkoutDate) {
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
        this.totalpriceTxt.sendKeys(price);
        this.checkinDate.sendKeys(checkIndate);
        this.checkoutDate.sendKeys(checkoutDate);
        this.checkoutDate.sendKeys(Keys.ENTER);
        this.saveButton.click();
    }
     // Deletes the booking id exists in the application
    public void deleteBooking() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        List<WebElement> listOfBookings = driver.findElements(By.xpath("//*[@id='bookings']/div[*]"));
        List<String> BookingsList = new ArrayList<String>();
//        List<String> BookingsURLsToBeDeleted = new ArrayList<String>();
        for (WebElement id : listOfBookings) {
            String rowid = id.getAttribute("id");
            BookingsList.add(rowid);
            for (int i = 1; i < BookingsList.size(); i++) {
                String BookingId = BookingsList.get(i);
//                String BookingURL = "http://hotel-test.equalexperts.io/booking/" + BookingId;
//                System.out.println(BookingURL);
                String rowLocator = "//div[@id='bookings']//div[@class='row' and @id=";
                String rowLocator2 = "]//input";
                String bookingIdToBeDeleted = (rowLocator + BookingId + rowLocator2);
//                WebDriverWait shortWait = new WebDriverWait(driver, 3);
                WebDriverWait longWait = new WebDriverWait(driver, 30);
                longWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bookingIdToBeDeleted)));
                WebDriverWait shortWait = new WebDriverWait(driver, 5);
                shortWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(bookingIdToBeDeleted)));
                WebElement deletebtn = this.driver.findElement(By.xpath(bookingIdToBeDeleted));
                deletebtn.click();



            }

        }
    }
}

