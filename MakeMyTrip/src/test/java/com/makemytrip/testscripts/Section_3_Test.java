package com.makemytrip.testscripts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.makemytrip.GeneriUtils.BaseClass;
import com.makemytrip.GeneriUtils.WebDriverUtility;
import com.makemytrip.POMRepository.CompleteYourBookingPage;
import com.makemytrip.POMRepository.FaresDetailsPage;
import com.makemytrip.POMRepository.UserHomePage;
@Listeners(com.makemytrip.GeneriUtils.ListnerImplementation.class)
public class Section_3_Test extends BaseClass {
	/**
	 * @author Jyoti H M
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	
	@Test
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
		Thread.sleep(3000);
		user.clickOnReturnDate(driver);

		//Step4: Select TravellerClass class
		user.clickOnTravellerClass(driver);
		user.clickOnBusinessClass(driver);
		user.clickOnApplyBusinessClass(driver);
		user.clickOnSearchBtn(driver);
		user.clickOnMoreBtn(driver);
		user.clickOnNonStop(driver);
		
		//Step5: Click on Book Now.
		wlib.awaitForElement(driver, user.getBookFlightButton());
		user.getBookFlightButton().click();
		wlib.waitForElement(driver);
		Thread.sleep(5000);
		
		//Step6: Take screen shots of fare charges and print the Fare Charges in console.
		FaresDetailsPage fares=new FaresDetailsPage(driver);
		fares.fareCharge(driver);
		fares.screenshotOfFaresCharge(driver);
		wlib.waitForElement(driver);
		wlib.scrollToElement(driver, fares.getReturn());
		fares.screenshotOfFaresCharge(driver);
		wlib.waitForElement(driver);
		
		//Step7: Click on Continue.
		fares.clickOnContinueBtn(driver);
		CompleteYourBookingPage bookpg=new CompleteYourBookingPage(driver);
		
		//Step8: Click on non secure trip.
		//bookpg.clickOnDoNotSecureTrip(driver);
	
		
	}

}
