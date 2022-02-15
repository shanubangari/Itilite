package com.makemytrip.POMRepository;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.makemytrip.GeneriUtils.JavaUtility;
import com.makemytrip.GeneriUtils.WebDriverUtility;

public class FaresDetailsPage {
		WebDriverUtility wlib=new WebDriverUtility();
		
		public FaresDetailsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//div[@class='appendRight15 make_relative makeRelative']/descendant::p[@class='blackFont font24']")
		private WebElement FareAmount;

		public WebElement getFareAmount() {
			return FareAmount;
		}
		
		public void fareCharge(WebDriver driver) {
			String amount = FareAmount.getText();
			System.out.println("For 1 Adult Fare charge is ="+amount);
		}
		
		@FindBy(xpath = "//div[@class='multifareFooter']/descendant::button[.='Continue']")
		private WebElement ContinueBtn;

		public WebElement getContinueBtn() {
			return ContinueBtn;
		}
		
		public void clickOnContinueBtn(WebDriver driver) {
			wlib.waitForElement(driver);
			ContinueBtn.click();
		}
		
		public void screenshotOfFaresCharge(WebDriver driver) throws IOException {
			wlib.waitForElement(driver);
			String name="FareCharge"+JavaUtility.getCurrentDate();
			TakesScreenshot screenshot=(TakesScreenshot)driver;
			File src = screenshot.getScreenshotAs(OutputType.FILE);
			File dest=new File("./FaresCharges/"+name+".png");
			FileUtils.copyFile(src, dest);
		}
		
		@FindBy(xpath = "//div[@class='multifareContent appendBottom10']/descendant::span[text()='RETURN']")
		private WebElement Return;
		
		public WebElement getReturn() {
			return Return;
		}
		
}
