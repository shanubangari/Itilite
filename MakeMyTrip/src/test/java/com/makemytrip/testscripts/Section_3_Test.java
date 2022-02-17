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
		Thread.sleep(5000);
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
		elib.writeExcelDataInSheet("Section_3_"+JavaUtility.getRandomNum(), 0, 0, fares.getFareAmount().getText());

		wlib.scrollToElement(driver, fares.getReturn());
		fares.screenshotOfFaresCharge(driver);
		wlib.waitForElement(driver);

		//Step7: Click on Continue.
		fares.clickOnContinueBtn(driver);
		Thread.sleep(5000);

		//Step8: Click on non secure trip.
		CompleteYourBookingPage bookpg=new CompleteYourBookingPage(driver);
		bookpg.moveToChildWindow(driver);
		Thread.sleep(5000);



		//Step9: Scroll down 
		//wlib.scrollToElement(driver, bookpg.getTravellersInsurance());
		try {
			sa.assertTrue(bookpg.getTravellersInsurance().isDisplayed());
			wlib.scrollToElement(driver, bookpg.getTravellersInsurance());

			//Step10:Click on non secure trip.
			bookpg.clickOnDoNotSecureTrip(driver);
			Thread.sleep(5000);

		} catch(Throwable e){

			System.out.println("TravellersDetails option is not displayed");

		}
		finally {

			wlib.scrollToElement(driver, bookpg.getTravellersDetails());
			Thread.sleep(5000);			
			user.clickOnJyotiName(driver);
			Thread.sleep(5000);
			user.getMyProfile().click();
			user.clickOnLogout(driver);
			System.out.println("****** User Logout Successfully...! ******");
		}

		//Step10:Click on non secure trip.
		//bookpg.clickOnDoNotSecureTrip(driver);
		//Thread.sleep(5000);

		sa.assertAll();
	}

}
