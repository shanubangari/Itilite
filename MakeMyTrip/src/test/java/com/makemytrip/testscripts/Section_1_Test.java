package com.makemytrip.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.makemytrip.GeneriUtils.BaseClass;
import com.makemytrip.GeneriUtils.ExcelUtility;
import com.makemytrip.GeneriUtils.WebDriverUtility;
import com.makemytrip.POMRepository.Add_Travellers_Info_Page;
import com.makemytrip.POMRepository.UserHomePage;

@Listeners(com.makemytrip.GeneriUtils.ListnerImplementation.class)
public class Section_1_Test extends BaseClass{
	/**
	 * @author Jyoti H M.
	 * Sign up using gmail and add travellers details.
	 */
	
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	SoftAssert sa=new SoftAssert();
	@Test
	public void loginTest() throws InterruptedException, AWTException, EncryptedDocumentException, IOException {
		
		Thread.sleep(3000);
		//Step1: ●	Go to “My Profile” from the drop down at the top right corner of the page (your name).
		UserHomePage user=new UserHomePage(driver);
		user.moveToHiJyoti(driver);
		user.clickOnMyProfile(driver);
		user.clickOnSaveTravellers(driver);
		user.clickOnAddTraveller(driver);
		Thread.sleep(5000);
		
		//Step2: ●	Add a new traveller under “Save Traveller(s)” section and save details
		Add_Travellers_Info_Page infoPage=new Add_Travellers_Info_Page(driver);
		
		//Step3: Enter name.
		//String name="Jyoti";
		String name = elib.getExcelDataFromSheet("Section_1", 1, 1);
		infoPage.enterFullName(driver, name);
		
		//Step4: Enter select Gender.
		infoPage.selectGender(driver);
		
		//Step5: Enter mobile number.
		//String phonenum="6363281558";
		String  phonenum= elib.getExcelDataFromSheet("Section_1", 1, 2);
		infoPage.enterPhoneNo(driver, phonenum);
		
		//Ste6: Enter the email id.
		String email=elib.getExcelDataFromSheet("Section_1", 1, 3);
		infoPage.enterEmail(email);
		
		//infoPage.scrollToBar(driver);
		wlib.scrollToElement(driver, infoPage.getPhoneNo());
		infoPage.enterBirthday(driver);
		
		//Step7: Click on Save Button.
		Thread.sleep(5000);
		infoPage.clickOnSaveBtn();	
		
		//Step8: Verify using SoftAssert.
		String expValue=elib.getExcelDataFromSheet("Section_1", 1, 4);
		sa.assertTrue(user.getAddMessage().getText().contains(expValue));
		System.out.println("**** Travelleres details added Successfully...! ****");
		Thread.sleep(5000);	
		
		//Step: Scroll to MakeMyTrip Logo.
		wlib.scrollToElement(driver, user.getFlights());
		sa.assertAll();
	}	
	
}
