package com.makemytrip.testscripts;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.makemytrip.GeneriUtils.BaseClass;
import com.makemytrip.GeneriUtils.ExcelUtility;
import com.makemytrip.GeneriUtils.JavaUtility;
import com.makemytrip.GeneriUtils.WebDriverUtility;
import com.makemytrip.POMRepository.CompleteYourBookingPage;
import com.makemytrip.POMRepository.FaresDetailsPage;
import com.makemytrip.POMRepository.UserHomePage;
@Listeners(com.makemytrip.GeneriUtils.ListnerImplementation.class)
public class Section_3_Test extends BaseClass {
	/**
	 * @author Jyoti H M
	 * Book flight for round trip from Bangalore to Mumbai and print the FareCharge.
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	ExcelUtility elib=new ExcelUtility();
	SoftAssert sa=new SoftAssert();


	@Test(groups = "SmokeTest")
	public void flightBookTest() throws InterruptedException, IOException {
		Thread.sleep(3000);
		//Step1: Search for Flights with below filter criteria
		//Round Trip 
		UserHomePage user=new UserHomePage(driver);
		wlib.mouseHover(driver, user.getRoundTrip());
		user.getRoundTrip().click();

		//Step2: Select From: Bangalore To:Mumbai
		user.clickOnFrom();
		user.clickOnBangaloreIndia(driver);
		user.clickOnToBtn(driver);
		user.clickOnMumbaiIndia(driver);

		//Step3:Departure - 1st Oct 2021, Return - 10th Oct 2021
		Thread.sleep(5000);
		user.clickOnDepartureDate(driver);
		Thread.sleep(5000);
		user.clickOnReturnDate(driver);

		//Step4: Select TravellerClass as Business class.
		user.clickOnTravellerClass(driver);
		user.clickOnBusinessClass(driver);
		user.clickOnApplyBusinessClass(driver);
		
		//Step5: Click on Search button and select NON-Stop flights for filter the flights..
		user.clickOnSearchBtn(driver);
		user.clickOnMoreBtn(driver);
		user.clickOnNonStop(driver);

		//Step6: Click on Book Now.
		wlib.awaitForElement(driver, user.getBookFlightButton());
		user.getBookFlightButton().click();
		wlib.waitForElement(driver);
		Thread.sleep(5000);

		
		//Step7: Take screen shots of fare charges and print the Fare Charges in console and select Business Standard for return journey.
		FaresDetailsPage fares=new FaresDetailsPage(driver);
		Thread.sleep(3000);
		wlib.scrollToElement(driver, fares.getReturn());
		fares.clickOnBusinessStd(driver);
		fares.screenshotOfFaresCharge(driver);
		fares.fareCharge(driver);
		
		//Step8: Store the fare charge amount in excel sheet.
		elib.writeExcelDataInSheet("Section_3_"+JavaUtility.getRandomNum(), 0, 0, fares.getFareAmount().getText());
		wlib.waitForElement(driver);

		//Step9: Click on Continue.
		fares.clickOnContinueBtn(driver);
		Thread.sleep(5000);

		//Step10: Click on non secure trip in Travel Insurance.
		CompleteYourBookingPage bookpg=new CompleteYourBookingPage(driver);
		bookpg.moveToChildWindow(driver);
		Thread.sleep(5000);
		
		//Step11: Scroll down and Verify the "non secure trip" option is displayed or not.
		//wlib.scrollToElement(driver, bookpg.getTravellersInsurance());
		sa.assertTrue(bookpg.getTravellersInsurance().isDisplayed());
		wlib.scrollToElement(driver, bookpg.getTravellersInsurance());
		
		//Step12:Click on non secure trip.
		bookpg.clickOnDoNotSecureTrip(driver);
		Thread.sleep(5000);
		sa.assertTrue(bookpg.getTripElement().getText().contains("Get your trip Insured."));
		Thread.sleep(3000);
		System.out.println("--->User selected non secured trip..! "+bookpg.getTripElement().getText());
				
		//Step13: Scroll to MakeMyTrip Logo.
		wlib.scrollToElement(driver, user.getFlights());
		sa.assertAll();
	}

}
