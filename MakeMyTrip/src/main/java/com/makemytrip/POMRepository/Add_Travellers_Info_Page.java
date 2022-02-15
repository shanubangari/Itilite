package com.makemytrip.POMRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.makemytrip.GeneriUtils.WebDriverUtility;

public class Add_Travellers_Info_Page {
	/**
	 * @author Jyoti H M
	 * Implemented Encapsulation OOP's concept.
	 * Collection of WebElements, Business Logic's and access given to the user using getters methods.
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	public Add_Travellers_Info_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@class='font14 blackText cap txtFild__textInput' and @id='travellerFirstName']")
	private WebElement FullName;

	@FindBy(xpath = "//div[@class='font14 blackText dropDown__valueBox']")
	private WebElement Gender;

	public WebElement getFullName() {
		return FullName;
	}

	public WebElement getGender() {
		return Gender;
	}

	public void enterFullName(WebDriver driver, String name) {
		wlib.waitForElement(driver);
		FullName.sendKeys(name);
	}

	public void selectGender(WebDriver driver) throws InterruptedException {
		wlib.waitForElement(driver);
		Gender.click();
		Thread.sleep(2000);
		Female.click();
	}

	@FindBy(xpath = "//ul[@class='dropDown__optionsLst']/descendant::li[text()='FEMALE' and @class='dropDown__optionsItm']")
	private WebElement Female;

	public WebElement getFemale() {
		return Female;
	}

	@FindBy(xpath = "//input[@class='font14 blackText cap txtFild__textInput' and @id='travellerPhoneNum']")
	private WebElement PhoneNo;

	public WebElement getPhoneNo() {
		return PhoneNo;
	}

	public void enterPhoneNo(WebDriver driver, String phonenum) {
		wlib.waitForElement(driver);
		PhoneNo.sendKeys(phonenum);
	}

	@FindBy(xpath = "//div[text()='Birthday']/ancestor::div[@id='dateOfBirth']/descendant::div[@class='font14 blackText dropDown__valueBox']")
	private WebElement DOB;

	public WebElement getDOB() {
		return DOB;
	}
	public void enterBirthday(WebDriver driver) throws InterruptedException{
		Thread.sleep(5000);

		Thread.sleep(5000);
		int click=0;
		while(click<=20) {
			try {
				//System.out.println("element clicked");
				DOB.click();
				//DOB.sendKeys("08/23/1996");
				break;
			}
			catch (Exception e) {
				//System.out.println("retrying for element interaction");
				click++;
			}
		}
		Thread.sleep(5000);
		WebElement years = driver.findElement(By.xpath("//div[@class='makeFlex vrtlCenter']/descendant::select[@name='year']"));
		Select s=new Select(years);
		s.selectByValue("1996");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='DayPicker-Day' and @aria-label='Fri Feb 16 1996']")).click();

		//				WebElement month = driver.findElement(By.xpath("//div[@class='makeFlex vrtlCenter']/descendant::select[@name='month']"));
		//				Select s1=new Select(month);
		//				s.selectByVisibleText("August");
		//				Thread.sleep(3000);
		//date.click();
	}

	@FindBy(xpath = "//div[@class='DayPicker-Day' and @aria-label='Fri Aug 23 1996']")
	private WebElement date;

	public WebElement getdate() {
		return date;
	}

	@FindBy(xpath = "//input[@id='passportDtailNumbr']")
	private WebElement PassportNum;

	public WebElement getPassportNum() {
		return date;
	}

	public void drag(WebDriver driver) {
		wlib.dragBtn(driver, FullName, PassportNum);
	}

	public void scrollToBar(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		int y = DOB.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")");

	}
	
	@FindBy(xpath = "//button[@class='font16 latoBlack whiteText btn__primry   ']")
	private WebElement SaveBtn;
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public void clickOnSaveBtn() {
		SaveBtn.click();
		System.out.println("**** Travelleres details added Successfully...! ");
	}

	@FindBy(id = "travellerEmailId")
	private WebElement EmailId;
	
	public WebElement getEmailId() {
		return EmailId;
	}
	
	public void enterEmail(String email) {
		EmailId.sendKeys(email);
	
	}
	
	public void passportDetails(String number) {
		PassportNum.sendKeys(number);
			}
	@FindBy(xpath = "//p[text()='You have 1 Traveller(s)']")
	private WebElement userAddMsg;
	
	public WebElement getuserAddMsg() {
		return userAddMsg;
	}
	
	
}
