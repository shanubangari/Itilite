package com.makemytrip.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.makemytrip.GeneriUtils.BaseClass;
import com.makemytrip.GeneriUtils.ExcelUtility;
import com.makemytrip.GeneriUtils.WebDriverUtility;
import com.makemytrip.POMRepository.UserHomePage;
@Listeners(com.makemytrip.GeneriUtils.ListnerImplementation.class)
public class Section_2_Test extends BaseClass {
	/**
	 * @author Jyoti H M
	 * search for the flight Bangalore to Mumbai.
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	ExcelUtility elib=new ExcelUtility();
	SoftAssert sa=new SoftAssert();
	
	@Test
	public void flightSearchTest() throws InterruptedException, EncryptedDocumentException, IOException {
		logger.info("Step1: Search for Flights with below filter criteria for Round Trip.");
		//Step1: Search for Flights with below filter criteria for Round Trip.
		Thread.sleep(3000);
		UserHomePage user=new UserHomePage(driver);
		wlib.mouseHover(driver, user.getRoundTrip());
		user.getRoundTrip().click();

		logger.info("Step2: Select From: Bangalore To:Mumbai.");
		//Step2: Select From: Bangalore To:Mumbai.
		user.clickOnFrom();
		user.clickOnBangaloreIndia(driver);
		user.clickOnToBtn(driver);
		user.clickOnMumbaiIndia(driver);

		logger.info("Step3:  Departure and Return date");
		//Step3:  Departure - 1st Oct 2021, Return - 10th Oct 2021.
		Thread.sleep(5000);
		user.clickOnDepartureDate(driver);
		Thread.sleep(3000);
		user.clickOnReturnDate(driver);

		logger.info("Step4: Select TravellerClass class.");
		//Step4: Select TravellerClass class.
		user.clickOnTravellerClass(driver);
		user.clickOnBusinessClass(driver);
		user.clickOnApplyBusinessClass(driver);
		
		logger.info("Step5: Click on Search button.");
		//Step5: Click on Search button.
		user.clickOnSearchBtn(driver);
		wlib.waitForElement(driver);
		
		logger.info("Step6: For further filter, click on \"Non-stop\" under \"Popular filters\".");
		//Step6: For further filter, click on "Non-stop" under "Popular filters".
		user.clickOnMoreBtn(driver);
		user.clickOnNonStop(driver);
		Thread.sleep(3000);
		
		logger.info("Step7: Verify using SoftAssert.");
		//Step7: Verify using SoftAssert.
		String filter = elib.getExcelDataFromSheet("Section_2", 1, 0);
		sa.assertEquals(user.getAppliedNonStop().getText(), filter );
		System.out.println("Non-stop flights are filtered..");
		System.out.println("Applied "+user.getAppliedNonStop().getText()+" Filter.");
		Thread.sleep(3000);
		
		logger.info("Step8: Scroll to MakeMyTrip Logo.");
		//Step8: Scroll to MakeMyTrip Logo.
		wlib.scrollToElement(driver, user.getFlights());
		sa.assertAll();
		
	}

}
