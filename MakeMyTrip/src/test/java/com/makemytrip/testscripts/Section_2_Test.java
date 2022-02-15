package com.makemytrip.testscripts;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.makemytrip.GeneriUtils.BaseClass;
import com.makemytrip.GeneriUtils.WebDriverUtility;
import com.makemytrip.POMRepository.UserHomePage;
@Listeners(com.makemytrip.GeneriUtils.ListnerImplementation.class)
public class Section_2_Test extends BaseClass {
	/**
	 * @author Jyoti H M
	 * search for the flight Bangalore to Mumbai.
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	SoftAssert sa=new SoftAssert();
	@Test
	public void flightSearchTest() throws InterruptedException {
		Thread.sleep(3000);
		//Step1: Search for Flights with below filter criteria
		//Round Trip 
		UserHomePage user=new UserHomePage(driver);
		wlib.mouseHover(driver, user.getRoundTrip());
		user.getRoundTrip().click();

		//Select From: Bangalore To:Mumbai
		user.clickOnFrom();
		user.clickOnBangaloreIndia(driver);
		user.clickOnToBtn(driver);
		user.clickOnMumbaiIndia(driver);

		// Departure - 1st Oct 2021, Return - 10th Oct 2021
		Thread.sleep(5000);
		user.clickOnDepartureDate(driver);
		Thread.sleep(3000);
		user.clickOnReturnDate(driver);

		//select TravellerClass class
		user.clickOnTravellerClass(driver);
		user.clickOnBusinessClass(driver);
		user.clickOnApplyBusinessClass(driver);
		user.clickOnSearchBtn(driver);
		wlib.waitForElement(driver);
		user.clickOnMoreBtn(driver);
		user.clickOnNonStop(driver);
		wlib.waitForElement(driver);
		user.clickOnJyotiName(driver);
		Thread.sleep(5000);
		user.getMyProfile().click();
		Thread.sleep(5000);
		user.clickOnLogout(driver);
		
		sa.assertAll();
	}

}
