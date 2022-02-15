package com.makemytrip.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.GeneriUtils.WebDriverUtility;

public class CompleteYourBookingPage {
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
	
	
}
