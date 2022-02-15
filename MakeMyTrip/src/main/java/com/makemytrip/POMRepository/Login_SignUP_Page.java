package com.makemytrip.POMRepository;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.GeneriUtils.WebDriverUtility;

public class Login_SignUP_Page {
	
	WebDriverUtility wlib=new WebDriverUtility();
	public Login_SignUP_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@class='font14 fullWidth']")
	private WebElement emailOrMobileNoTextBox;
	
	@FindBy(xpath = "//input[@id='password' and @class='font14']")
	private WebElement PwdTextBox;
	
	@FindBy(xpath = "//button[@class='capText font16']")
	private WebElement ContinueBtn;
	
	@FindBy(xpath = "//span[.='Login']")
	private WebElement LoginBtn;
	
	public WebElement getPwdTextBox() {
		return PwdTextBox;
	}
	
	public WebElement getemailOrMobileNo() {
		return emailOrMobileNoTextBox;
	}
	
	public WebElement getLoginBtn() {
		return LoginBtn;
	}
	
	public WebElement getContinueBtn() {
		return ContinueBtn;
	}
	
	public void enterEmailId(String email) {
		emailOrMobileNoTextBox.sendKeys(email);
	}
	
	public void loginWithPassword(String password) {
		PwdTextBox.sendKeys(password);
	}
	
	public void clickOnContinueBtn(WebDriver driver) {
		wlib.waitForElement(driver);
		ContinueBtn.click();
	}
	
	public void clickOnLginBtn() {
		LoginBtn.click();
	}
	
	public void LoginWithCredentials(WebDriver driver, String email, String password) throws InterruptedException {
		wlib.waitForElement(driver);
		emailOrMobileNoTextBox.sendKeys(email);
		ContinueBtn.click();
		Thread.sleep(2000);
		PwdTextBox.sendKeys(password);
		LoginBtn.click();
		System.out.println("****** User Login Successfylly....! ******");
	}
	
}
