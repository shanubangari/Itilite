package com.makemytrip.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
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
	 * @author Jyoti H M
	 */
	
	ExcelUtility elib=new ExcelUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	SoftAssert softassert=new SoftAssert();
	
	@Test
	public void loginTest() throws InterruptedException, AWTException, EncryptedDocumentException, IOException {
		
		Thread.sleep(3000);
		//Step1: ●	Go to “My Profile” from the drop down at the top right corner of the page (your name)
		UserHomePage user=new UserHomePage(driver);
		user.clickOnMyProfile(driver);
		user.clickOnSaveTravellers(driver);
		user.clickOnAddTraveller(driver);
		
		//Step2: ●	Add a new traveller under “Save Traveller(s)” section and save details
		Add_Travellers_Info_Page infoPage=new Add_Travellers_Info_Page(driver);
		//Enter name.
		//String name="Jyoti";
		String name = elib.getExcelDataFromSheet("Section_1", 1, 1);
		infoPage.enterFullName(driver, name);
		
		//Enter select Gender.
		infoPage.selectGender(driver);
		
		//Enter mobile number.
		//String phonenum="6363281558";
		String  phonenum= elib.getExcelDataFromSheet("Section_1", 1, 2);
		infoPage.enterPhoneNo(driver, phonenum);
		
		//infoPage.scrollToBar(driver);
		wlib.scrollToElement(driver, infoPage.getDOB());
		infoPage.enterBirthday(driver);
		
		//Click on Save Button.
		Thread.sleep(3000);
		infoPage.clickOnSaveBtn();
		
		//click on Logout
		user.clickOnLogout(driver);

		
		softassert.assertAll();
	}	
	
}
