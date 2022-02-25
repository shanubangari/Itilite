package com.makemytrip.POMRepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.GeneriUtils.WebDriverUtility;

public class UserHomePage {
	/**
	 * @author Jyoti H M
	 * Implemented Encapsulation OOP's concept.
	 * Collection of WebElements,locator & locators value, Business Logic's and access given to the user using getters methods.
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	String pwind;
	public UserHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='loginTrigger']/descendant::span[text()='Hi Jyoti']")
	private WebElement UserName;

	@FindBy(xpath = "//p[text()='My Profile']")
	private WebElement MyProfile;

	@FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedIn']/descendant::p[text()='Hi Jyoti']")
	private WebElement HiJyoti;

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getMyProfile() {
		return MyProfile;
	}

	public WebElement getHiJyoti() {
		return HiJyoti;
	}

	public void moveToHiJyoti(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		wlib.mouseHover(driver, HiJyoti);
		Thread.sleep(5000);

	}
	public void clickOnMyProfile(WebDriver driver) throws AWTException, InterruptedException {
		wlib.waitForElement(driver);
		MyProfile.click();
	}

	//- Round Trip – Bangalore to Mumbai
	@FindBy(xpath = "//ul[@class='fswTabs latoBlack greyText']/descendant::li[@data-cy='roundTrip']")
	private WebElement RoundTrip;

	public WebElement getRoundTrip() {
		return RoundTrip;
	}

	public void clickOnRoundTrip() {
		RoundTrip.click();
	}
	//click on From
	@FindBy(xpath = "//div[@class='fsw_inputBox searchCity inactiveWidget ']")
	private WebElement FromTextBox;

	public WebElement getFromTextBox() {
		return FromTextBox;
	}

	public void clickOnFrom() {
		FromTextBox.click();
	}

	@FindBy(xpath = "//li[@class='font14 darkGreyText latoBold sdeBarNav__navItm']/descendant::span[@class='myPrfilSprit myPrfilSprit__traveller']")
	private WebElement SaveTravellers;

	public WebElement getSaveTravellers() {
		return SaveTravellers;
	}

	public void clickOnSaveTravellers(WebDriver driver) {
		wlib.waitForElement(driver);
		SaveTravellers.click();
	}

	@FindBy(xpath = "//button[@class='font16 latoBold blueText btn__dtailAdEdt' and text()='Add Traveller']")
	private WebElement AddTraveller;

	public WebElement getAddTraveller() {
		return AddTraveller;
	}
	public void clickOnAddTraveller(WebDriver driver) {
		wlib.waitForElement(driver);
		AddTraveller.click();
	}

	@FindBy(xpath = "//li[@class='font14 darkGreyText latoBold sdeBarNav__navItm']/descendant::span[@class='myPrfilSprit myPrfilSprit__logout']")
	private WebElement Logout;

	public WebElement getLogout() {
		return Logout;
	}
	public void clickOnLogout(WebDriver driver) {
		wlib.waitForElement(driver);
		Logout.click();
	}

	@FindBy(xpath = "//div[@class='makeFlex hrtlCenter']/descendant::p[text()='Mumbai, India']")
	private WebElement MumbaiIndia;

	public WebElement getMumbaiIndia() {
		return MumbaiIndia;
	}
	public void clickOnMumbaiIndia(WebDriver driver) {
		wlib.waitForElement(driver);
		MumbaiIndia.click();
	}

	@FindBy(xpath = "//div[@class='makeFlex hrtlCenter']/descendant::p[text()='Bangalore, India' and @class='font14 appendBottom5 blackText']")
	private WebElement BangaloreIndia;

	public WebElement getBangaloreIndia() {
		return BangaloreIndia;
	}
	public void clickOnBangaloreIndia(WebDriver driver) {
		wlib.waitForElement(driver);
		BangaloreIndia.click();
	}
	@FindBy(xpath = "//div[@class='fsw_inputBox searchToCity inactiveWidget ']")
	private WebElement ToBtn;

	public WebElement getToBtn() {
		return ToBtn;
	}
	public void clickOnToBtn(WebDriver driver) {
		wlib.waitForElement(driver);
		ToBtn.click();
	}
	@FindBy(xpath = "//div[text()='February']/ancestor::div[@class='DayPicker-Month']/descendant::div[@aria-label='Mon Feb 21 2022']")
	private WebElement DepartureDate;

	public WebElement getDepartureDate() {
		return DepartureDate;
	}
	public void clickOnDepartureDate(WebDriver driver) {
		wlib.waitForElement(driver);
		DepartureDate.click();
	}

	@FindBy(xpath = "//div[text()='March']/ancestor::div[@class='DayPicker-Month']/descendant::div[@aria-label='Thu Mar 03 2022']")
	private WebElement ReturnDate;

	public WebElement getReturnDate() {
		return ReturnDate;
	}
	public void clickOnReturnDate(WebDriver driver) {
		wlib.waitForElement(driver);
		ReturnDate.click();
	}

	@FindBy(xpath = "//div[@class='fsw_inputBox flightTravllers inactiveWidget ']")
	private WebElement TravellerClass;

	public WebElement getTravellerClass() {
		return TravellerClass;
	}
	public void clickOnTravellerClass(WebDriver driver) {
		wlib.waitForElement(driver);
		TravellerClass.click();
	}

	@FindBy(xpath = "//ul[@class='guestCounter classSelect font12 darkText']/descendant::li[text()='Business']")
	private WebElement BusinessClass;

	public WebElement getBusinessClass() {
		return BusinessClass;
	}
	public void clickOnBusinessClass(WebDriver driver) {
		wlib.waitForElement(driver);
		BusinessClass.click();
	}

	@FindBy(xpath = "//button[@class='primaryBtn btnApply pushRight' and text()='APPLY']")
	private WebElement ApplyBusinessClass;

	public WebElement getApplyBusinessClass() {
		return ApplyBusinessClass;
	}
	public void clickOnApplyBusinessClass(WebDriver driver) {
		wlib.waitForElement(driver);
		ApplyBusinessClass.click();
	}

	@FindBy(xpath = "//a[@class='primaryBtn font24 latoBold widgetSearchBtn ' and .='Search']")
	private WebElement SearchBtn;

	public WebElement getSearchBtn() {
		return SearchBtn;
	}
	public void clickOnSearchBtn(WebDriver driver) {
		wlib.waitForElement(driver);
		SearchBtn.click();
	}
	@FindBy(xpath = "//p[.='Popular Filters']/ancestor::div[@class='filtersOuter']/descendant::span[.='Non Stop' and @class='truncate']")
	private WebElement NonStop;
	//p[text()='Applied Filters']/parent::div[@class='filtersOuter']/descendant::li[text()='Non Stop']

	public WebElement getNonStop() {
		return NonStop;
	}
	public void clickOnNonStop(WebDriver driver) {
		wlib.waitForElement(driver);
		NonStop.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> itr = windows.iterator();
		String pwind = itr.next();
	}

	@FindBy(xpath = "//div[@id='loginTrigger' and @class='makeFlex cursorPointer']/descendant::span[.='Hi Jyoti']")
	private WebElement JyotiName;

	public WebElement getJyotiName() {
		return JyotiName;
	}
	public void clickOnJyotiName(WebDriver driver) {
		wlib.waitForElement(driver);
		JyotiName.click();
	}


	@FindBy(xpath="//button[text()='Book Now']") private WebElement bookFlightButton;
	public WebDriverUtility getWlib() {
		return wlib;
	}

	public WebElement getBookFlightButton() {
		return bookFlightButton;
	}

	@FindBy(xpath = "//span[@class='linkText pointer']")
	private WebElement MoreBtn;

	public WebElement getMoreBtn() {
		return MoreBtn;
	}
	public void clickOnMoreBtn(WebDriver driver) {
		wlib.waitForElement(driver);
		MoreBtn.click();
	}

	public void switchToWin(WebDriver driver) {
		driver.switchTo().window(pwind);

	}

	@FindBy(xpath = "//div[@id='profilePageComponent2']/descendant::p[@class='font18 darkGreyText appendTop10']")
	private WebElement AddMessage;

	public WebElement getAddMessage() {
		return AddMessage;
	}

	@FindBy(xpath = "//p[text()='Applied Filters']/parent::div[@class='filtersOuter']/descendant::li[text()='Non Stop']")
	private WebElement AppliedNonStop;

	public WebElement getAppliedNonStop() {
		return AppliedNonStop;
	}
	
	@FindBy(xpath = "//li[@data-cy='menu_Flights']/descendant::span[text()='Flights']")
	private WebElement Flights;
	
	public WebElement getFlights() {
		return Flights;
	}
	
	public void clickOnFlights(WebDriver driver) {
		wlib.waitForElement(driver);
		Flights.click();
	}
@FindBy(xpath = "//a[@class='chMmtLogo']/img")
private WebElement Logo;

public WebElement getLogo() {
	return Logo;
}
}
