package com.makemytrip.POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MakeMyTripHomePage {
	/**
	 * @author Jyoti H M
	 * MakeMyTripHomePage POM Class collection of WebElements, Business Logics & Locator with value.
	 * Encapsulation OOP's concept is implemented. 
	 */
	public MakeMyTripHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//p[@class='font14 latoBold blackText appendBottom5 cursorPointer makeRelative']")
	private WebElement loginWithEemailOrPhone;
	
	public WebElement getLoginWithEemailOrPhone() {
		return loginWithEemailOrPhone;
	}
	
	public void clickOnSignUpUsingEmailOrPhone() {
		loginWithEemailOrPhone.click();
	}
	
	
	
}
