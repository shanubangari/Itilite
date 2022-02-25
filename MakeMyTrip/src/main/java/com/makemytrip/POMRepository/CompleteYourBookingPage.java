package com.makemytrip.POMRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.GeneriUtils.WebDriverUtility;

public class CompleteYourBookingPage {
	/**
	 * @author Jyoti H M
	 * Implemented Encapsulation OOP's concept.
	 * Collection of WebElements, Business Logic's and access given to the user using getters methods.
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	public CompleteYourBookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='insBottomSection']/descendant::span[@class='darkText lightFont fontSize14 appendLeft10' and text()='I do not wish to secure my trip']")
	private WebElement DoNotSecureTrip;

	public WebElement getDoNotSecureTrip() {
		return DoNotSecureTrip;
	}

	public void clickOnDoNotSecureTrip(WebDriver driver) {
		wlib.waitForElement(driver);
		DoNotSecureTrip.click();
	}

	public void moveToChildWindow(WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String pwind=itr.next();
		String cwind=itr.next();
		driver.switchTo().window(cwind);
	}
	@FindBy(xpath = "//div[@id='TRAVELLER_DETAIL']/descendant::h2[text()='Traveller Details']")
	private WebElement TravellersDetails;

	public WebElement getTravellersDetails() {
		return TravellersDetails;
	}

	@FindBy(xpath = "//div[@id='INSURANCE']/descendant::h2[@class='fontSize18 blackFont makeFlex perfectCenter']")
	private WebElement TravellersInsurance;

	public WebElement getTravellersInsurance() {
		return TravellersInsurance;
	}
	
	@FindBy(xpath = "//div[@id='INSURANCE']/descendant::p[@class='darkText fontSize12 boldFont']")
	private WebElement TripMessage;
	
	public WebElement getTripElement() {
		return TripMessage;
	}

}
