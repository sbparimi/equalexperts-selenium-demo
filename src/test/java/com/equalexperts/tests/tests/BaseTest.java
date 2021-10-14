package com.equalexperts.tests.tests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;


public class BaseTest {
        protected WebDriver driver;
        @BeforeTest
        public void setupDriver(){
            System.setProperty("webdriver.chrome.driver","/Users/sp/Desktop/EqualExperts/chromedriver" );
            this.driver = new ChromeDriver();
            driver.manage().window().maximize();
            }

    @AfterTest
    public void  quitDriver(){
        this.driver.quit();

    }


}